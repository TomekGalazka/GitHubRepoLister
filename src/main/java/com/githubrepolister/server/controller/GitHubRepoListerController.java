package com.githubrepolister.server.controller;

import com.githubrepolister.server.service.GitHubRepoListerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/github")
@CrossOrigin
public class GitHubRepoListerController {

    private final GitHubRepoListerService gitHubRepoListerService;

    @Autowired
    public GitHubRepoListerController(GitHubRepoListerService gitHubRepoListerService) {
        this.gitHubRepoListerService = gitHubRepoListerService;
    }



}
