package com.githubrepolister.server.models;

public class GitHubRepoOwner {
    private final String login;

    public GitHubRepoOwner(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

}
