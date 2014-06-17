/*
 * Copyright 2013-2012 the original author or authors.
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
package org.springframework.social.github.api.impl;

import static java.util.Arrays.asList;

import java.util.List;

import org.springframework.social.github.api.GistOperations;
import org.springframework.social.github.api.GitHubComment;
import org.springframework.social.github.api.GitHubGist;
import org.springframework.web.client.RestTemplate;

/**
 * <p>
 * Gist template implementation.
 * </p>
 * 
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
public class GistTemplate extends AbstractGitHubOperations implements GistOperations {

	private final RestTemplate restTemplate;
	
	/**
	 * @param restTemplate A RestTemplate
	 * @param isAuthorizedForUser Boolean indicating whether the RestTemplate is authorized for a user
	 */
	public GistTemplate(RestTemplate restTemplate, boolean isAuthorizedForUser) {
		super(isAuthorizedForUser);
		this.restTemplate = restTemplate;
	}

	public List<GitHubGist> getUserGists(String user) {
		return asList(restTemplate.getForObject(buildUri("users/{user}/gists"), GitHubGist[].class, user));
	}

	public List<GitHubGist> getGists() {
		return asList(restTemplate.getForObject(buildUri("gists"), GitHubGist[].class));
	}

	public List<GitHubGist> getPublicGists() {
		return asList(restTemplate.getForObject(buildUri("gists/public"), GitHubGist[].class));
	}

	public List<GitHubGist> getStarredGists() {
		return asList(restTemplate.getForObject(buildUri("gists/starred"), GitHubGist[].class));
	}

	public GitHubGist getGist(String id) {
		return restTemplate.getForObject(buildUri("gists/{id}"), GitHubGist.class, id);
	}

	public List<GitHubComment> getGistComments(String id) {
		return asList(restTemplate.getForObject(buildUri("gists/{id}/comments"), GitHubComment[].class, id));
	}

	public GitHubComment getGistComment(Long id) {
		return restTemplate.getForObject(buildUri("gists/comments/{id}"), GitHubComment.class, id);
	}

}
