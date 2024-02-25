package com.githubrepolister.server.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GitHubRepoBranch {
    private String name;

    @JsonProperty("commit")
    private GitHubRepoCommit commit;

    public GitHubRepoBranch(String name, GitHubRepoCommit commit) {
        this.name = name;
        this.commit = commit;
    }

    public String getName() {
        return name;
    }

    public GitHubRepoCommit getCommit() {
        return commit;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCommit(GitHubRepoCommit commit) {
        this.commit = commit;
    }
}
