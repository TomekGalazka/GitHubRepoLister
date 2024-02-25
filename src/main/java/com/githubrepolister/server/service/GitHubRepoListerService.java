package com.githubrepolister.server.service;

import com.githubrepolister.server.models.GitHubRepo;
import com.githubrepolister.server.models.GitHubRepoBranch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GitHubRepoListerService {

    private static final Logger logger = LoggerFactory.getLogger(GitHubRepoListerService.class);

    private final RestTemplate restTemplate;

    @Value("${github.api.repos-url}")
    private String GITHUB_API_REPOS_URL;

    @Value("${github.api.branches-url}")
    private String GITHUB_API_BRANCHES_URL;

    @Value("${github.api.token}")
    private String githubApiToken;

    @Autowired
    public GitHubRepoListerService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<GitHubRepo> getUserRepos(String userName) {
        logger.info("Fetching GitHub repositories for user: {}", userName);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token " + githubApiToken);

        ResponseEntity<GitHubRepo[]> response = restTemplate.exchange(GITHUB_API_REPOS_URL, HttpMethod.GET, new HttpEntity<>(headers), GitHubRepo[].class, userName);
        GitHubRepo[] repos = response.getBody();

        if (repos != null && repos.length > 0) {
            List<GitHubRepo> nonForkedRepos = filteredForkedRepos(Arrays.asList(repos));

            // Fetch branches for each non-forked repository
            nonForkedRepos.forEach(repo -> {
                List<GitHubRepoBranch> branches = fetchBranches(repo.getOwner().getLogin(), repo.getName());
                repo.setBranches(branches);
            });
            logger.info("Fetched {} non-forked GitHub repositories for user: {}", nonForkedRepos.size(), userName);
            return nonForkedRepos;
        }
        logger.info("No repositories found for user: {}", userName);
        return Collections.emptyList();
    }

    private List<GitHubRepo> filteredForkedRepos(List<GitHubRepo> repos) {
        return repos.stream()
                .filter(repo -> !repo.isFork())
                .collect(Collectors.toList());
    }

    private List<GitHubRepoBranch> fetchBranches(String owner, String repo) {
        logger.info("Fetching branches for repository: {}/{}", owner, repo);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token " + githubApiToken);
        ResponseEntity<GitHubRepoBranch[]> response = restTemplate.exchange(GITHUB_API_BRANCHES_URL, HttpMethod.GET, new HttpEntity<>(headers), GitHubRepoBranch[].class, owner, repo);
        List<GitHubRepoBranch> branches = Arrays.asList(response.getBody());

        logger.info("Fetched {} branches for repository: {}/{}", branches.size(), owner, repo);
        return branches;
    }
}
