/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.github.api.impl.json;

import java.util.Date;

import org.springframework.social.github.api.GitHubUserProfile;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Annotated mixin to add annotations to {@link GitHubUserProfile}
 *
 * @author Andy Wilkinson
 */
abstract class GitHubUserProfileMixin extends GitHubObjectMixin {

	@JsonProperty("name")
	String name;

	@JsonProperty("location")
	String location;

	@JsonProperty("company")
	String company;

	@JsonProperty("blog")
	String blog;

	@JsonProperty("email")
	String email;

	GitHubUserProfileMixin(
			@JsonProperty("id") long id,
			@JsonProperty("login") String login,
			@JsonProperty("avatar_url") String avatarUrl,
			@JsonProperty("created_at") Date createdAt) {}
}
