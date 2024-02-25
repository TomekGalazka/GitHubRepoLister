package com.githubrepolister.server.models;

import lombok.NoArgsConstructor;

@NoArgsConstructor(force = true)
public class GitHubRepoOwner {
    private final String login;

    public GitHubRepoOwner(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }
}
