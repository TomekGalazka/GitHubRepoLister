package com.githubrepolister.server.controller;

import com.githubrepolister.server.models.GitHubRepo;
import com.githubrepolister.server.service.GitHubObjectNotFoundException;
import com.githubrepolister.server.service.GitHubRepoListerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("/api/github")
@CrossOrigin
public class GitHubRepoListerController {

    private final GitHubRepoListerService gitHubRepoListerService;

    @Autowired
    public GitHubRepoListerController(GitHubRepoListerService gitHubRepoListerService) {
        this.gitHubRepoListerService = gitHubRepoListerService;
    }

    @GetMapping("/userRepos/{username}")
    public ResponseEntity<?> getUserRepos(@PathVariable("username") String username) {
        try {
            List<GitHubRepo> repos = gitHubRepoListerService.getUserRepos(username);
            return ResponseEntity.ok(repos);
        } catch (GitHubObjectNotFoundException exception) {
            return ResponseEntity.status(exception.getStatus()).body(exception.getMessage());
        }
    }
}
