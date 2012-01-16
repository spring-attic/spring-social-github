/*
 * Copyright 2011 the original author or authors.
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

import org.springframework.social.github.api.GitHubUser;
import org.springframework.social.github.api.UserOperations;
import org.springframework.web.client.RestTemplate;

/**
 * <p>
 * User template implementation.
 * </p>
 * 
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
public class UserTemplate extends AbstractGitHubOperations implements UserOperations {
	private final RestTemplate restTemplate;
	
	/**
	 * @param restTemplate
	 * @param isAuthorizedForUser
	 */
	public UserTemplate(RestTemplate restTemplate, boolean isAuthorizedForUser) {
		super(isAuthorizedForUser);
		this.restTemplate = restTemplate;
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.github.api.UserOperations#getFollowers(java.lang.String)
	 */
	@Override
	public List<GitHubUser> getFollowers(String user) {
		return asList(restTemplate.getForObject(buildUserUri("/followers"), GitHubUser[].class, user));
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.github.api.UserOperations#getFollowing(java.lang.String)
	 */
	@Override
	public List<GitHubUser> getFollowing(String user) {
		return asList(restTemplate.getForObject(buildUserUri("/following"), GitHubUser[].class, user));
	}

	private String buildUserUri(String path) {
		return buildUri("users/{user}" + path);
	}
}
