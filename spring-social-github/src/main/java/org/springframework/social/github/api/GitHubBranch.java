package org.springframework.social.github.api;

import java.io.Serializable;

/**
 * A GitHub repo branch.
 *
 * @author Boris Yakovito
 */
public class GitHubBranch implements Serializable {

    private String name;

    public GitHubBranch(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
