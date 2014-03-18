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
import org.springframework.social.github.api.GitHubCommit;
import org.springframework.social.github.api.GitHubUser;

/**
 * Annotated mixin to add annotations to {@link GitHubCommit}
 *
 * @author Andy Wilkinson
 */
abstract class GitHubCommitMixin extends GitHubObjectMixin {

    GitHubCommitMixin(
            @JsonProperty("message") String message,
            @JsonProperty("sha") String sha,
            @JsonProperty("url") String url,
            @JsonProperty("committer") GitHubUser committer,
            @JsonProperty("author") GitHubUser author) {}
}
