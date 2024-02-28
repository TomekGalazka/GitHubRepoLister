package com.githubrepolister.server.service;

import org.springframework.http.HttpStatus;

public class GitHubObjectNotFoundException extends RuntimeException {

    private final HttpStatus status;

    public GitHubObjectNotFoundException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}