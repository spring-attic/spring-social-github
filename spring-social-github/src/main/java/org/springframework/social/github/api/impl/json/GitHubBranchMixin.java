package org.springframework.social.github.api.impl.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.social.github.api.GitHubBranch;

/**
 * Annotated mixin to add annotations to {@link GitHubBranch}
 *
 * @author Boris Yakovito
 */
public class GitHubBranchMixin extends GitHubObjectMixin {

    GitHubBranchMixin(@JsonProperty("name") String name) {}
}
