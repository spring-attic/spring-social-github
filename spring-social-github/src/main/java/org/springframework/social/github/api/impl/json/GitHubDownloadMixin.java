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
import org.springframework.social.github.api.GitHubDownload;

/**
 * Annotated mixin to add annotations to {@link GitHubDownload}
 *
 * @author Andy Wilkinson
 */
abstract class GitHubDownloadMixin extends GitHubObjectMixin {

    GitHubDownloadMixin(
        @JsonProperty("id") long id,
        @JsonProperty("url") String url,
        @JsonProperty("html_url") String htmlUrl,
        @JsonProperty("name") String name,
        @JsonProperty("description") String description,
        @JsonProperty("size") long size,
        @JsonProperty("download_count") int downloadCount,
        @JsonProperty("content_type") String contentType) {}
}
