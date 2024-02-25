package com.githubrepolister.server.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GitHubRepoCommit {
    @JsonProperty("sha")
    private String sha;

    public String getSha() {
        return sha;
    }

    public void setSha(String sha) {
        this.sha = sha;
    }
}
