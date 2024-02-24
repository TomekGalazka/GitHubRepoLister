package com.githubrepolister.server.models;

public class GitHubRepoBranch {
    private String name;
    private String lastCommitSha;

    public GitHubRepoBranch(String name, String lastCommitSha) {
        this.name = name;
        this.lastCommitSha = lastCommitSha;
    }

    public String getName() {
        return name;
    }

    public String getLastCommitSha() {
        return lastCommitSha;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastCommitSha(String lastCommitSha) {
        this.lastCommitSha = lastCommitSha;
    }
}
