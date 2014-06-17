/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.github.api.impl.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.social.github.api.GitHubRepo;

/**
 * Annotated mixin to add annotations to {@link GitHubRepo}
 *
 * @author Andy Wilkinson
 */
public class GitHubRepoMixin extends GitHubObjectMixin {

    @JsonProperty("name")
    String name;

    @JsonProperty("description")
    String description;

    GitHubRepoMixin(
            @JsonProperty("id") long id,
            @JsonProperty("url") String url,
            @JsonProperty("html_url") String htmlUrl,
            @JsonProperty("clone_url") String clone_url,
            @JsonProperty("git_url") String gitUrl,
            @JsonProperty("ssh_url") String sshUrl,
            @JsonProperty("svn_url") String svnUrl) {}
}
