package com.githubrepolister.server.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GitHubRepoListerService {

    private static final Logger logger = LoggerFactory.getLogger(GitHubRepoListerService.class);

    private final RestTemplate restTemplate;

    @Autowired
    public GitHubRepoListerService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}
