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

import static java.util.Arrays.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.social.github.api.GitHubUser;
import org.springframework.social.github.api.GitHubUserProfile;
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
	
	public String getProfileId() {
		return getUserProfile().getUsername();
	}

	public GitHubUserProfile getUserProfile() {
		@SuppressWarnings("unchecked")
		Map<String, ?> user = restTemplate.getForObject(buildUri("user"), Map.class);		
		Long gitHubId = Long.valueOf(String.valueOf(user.get("id")));
		String username = String.valueOf(user.get("login"));
		String name = String.valueOf(user.get("name"));
		String location = user.get("location") != null ? String.valueOf(user.get("location")) : null;
		String company = user.get("company") != null ? String.valueOf(user.get("company")) : null;
		String blog = user.get("blog") != null ? String.valueOf(user.get("blog")) : null;
		String email = user.get("email") != null ? String.valueOf(user.get("email")) : null;
		Date createdDate = toDate(String.valueOf(user.get("created_at")), dateFormat);
		String gravatarId = (String) user.get("gravatar_id");
		String profileImageUrl = gravatarId != null ? "https://secure.gravatar.com/avatar/" + gravatarId : null;
		return new GitHubUserProfile(gitHubId, username, name, location, company, blog, email, profileImageUrl, createdDate);
	}

	public String getProfileUrl() {
		return "https://github.com/" + getProfileId();
	}

	/**
	 * @param restTemplate
	 * @param isAuthorizedForUser
	 */
	public UserTemplate(RestTemplate restTemplate, boolean isAuthorizedForUser) {
		super(isAuthorizedForUser);
		this.restTemplate = restTemplate;
	}

	public List<GitHubUser> getFollowers(String user) {
		return asList(restTemplate.getForObject(buildUserUri("/followers"), GitHubUser[].class, user));
	}

	public List<GitHubUser> getFollowing(String user) {
		return asList(restTemplate.getForObject(buildUserUri("/following"), GitHubUser[].class, user));
	}

	private String buildUserUri(String path) {
		return buildUri("users/{user}" + path);
	}
	
	private Date toDate(String dateString, DateFormat dateFormat) {
		try {
			return dateFormat.parse(dateString);
		} catch (ParseException e) {
			return null;
		}
	}

	private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss Z", Locale.ENGLISH);
	
}
