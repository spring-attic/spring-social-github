/* 
 * GistTemplate.java
 * 
 * Copyright 2011-2012 the original author or authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.github.api.impl;

import static java.util.Arrays.*;

import java.util.List;

import org.springframework.social.github.api.GistOperations;
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
	 * @param restTemplate
	 * @param isAuthorizedForUser
	 */
	public GistTemplate(RestTemplate restTemplate, boolean isAuthorizedForUser) {
		super(isAuthorizedForUser);
		this.restTemplate = restTemplate;
	}

	public List<GitHubGist> getUserGists(String user) {
		String uri = buildUri("users/{user}/gists");
		return asList(restTemplate.getForObject(uri, GitHubGist[].class, user));
	}

}
