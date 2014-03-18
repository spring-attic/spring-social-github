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
import org.springframework.social.github.api.GitHubFile;
import org.springframework.social.github.api.GitHubGist;
import org.springframework.social.github.api.GitHubUser;

import java.util.Date;
import java.util.Map;

/**
 * Annotated mixin to add annotations to {@link GitHubGist}
 *
 * @author Andy Wilkinson
 */
abstract class GitHubGistMixin extends GitHubObjectMixin {

    @JsonProperty("files")
    Map<String, GitHubFile> files;

    @JsonProperty("description")
    String description;

    GitHubGistMixin(
            @JsonProperty("id") String id,
            @JsonProperty("url") String url,
            @JsonProperty("public") boolean publicGist,
            @JsonProperty("user") GitHubUser user,
            @JsonProperty("comments") int comments,
            @JsonProperty("html_url") String htmlUrl,
            @JsonProperty("git_pull_url") String gitPullUrl,
            @JsonProperty("git_push_url") String gitPushUrl,
            @JsonProperty("created_at") Date createdAt,
            @JsonProperty("updated_at") Date updatedAt) {}
}
