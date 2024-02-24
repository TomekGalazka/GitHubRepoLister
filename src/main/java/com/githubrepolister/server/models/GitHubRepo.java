package com.githubrepolister.server.models;

import java.util.List;

public class GitHubRepo {
    private GitHubRepoOwner owner;
    private List<GitHubRepoBranch> branches;
    private boolean fork;

    public GitHubRepo(GitHubRepoOwner owner, List<GitHubRepoBranch> branches, boolean fork) {
        this.owner = owner;
        this.branches = branches;
        this.fork = fork;
    }

    public GitHubRepoOwner getOwner() {
        return owner;
    }

    public List<GitHubRepoBranch> getBranches() {
        return branches;
    }

    public boolean isFork() {
        return fork;
    }

    public void setOwner(GitHubRepoOwner owner) {
        this.owner = owner;
    }

    public void setBranches(List<GitHubRepoBranch> branches) {
        this.branches = branches;
    }

    public void setFork(boolean fork) {
        this.fork = fork;
    }
}
