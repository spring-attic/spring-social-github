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

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.springframework.social.github.api.GitHub;
import org.springframework.social.github.api.GitHubUserProfile;
import org.springframework.social.github.api.RepoOperations;
import org.springframework.social.github.api.UserOperations;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.OAuth2Version;

/**
 * <p>
 * The central class for interacting with GitHub.
 * </p>
 * @author Craig Walls
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
public class GitHubTemplate extends AbstractOAuth2ApiBinding implements GitHub {
	private RepoOperations repoOperations;
	private UserOperations userOperations;
	
	/**
	 * No-arg constructor to support cases in which you want to call the GitHub
	 * API without requiring authorization. This is useful for public operations,
	 * such as getting the list of watchers for a public repository.
	 */
	public GitHubTemplate() {
		super();
		initSubApis();
	}
	
	/**
	 * Constructs a GitHubTemplate with the minimal amount of information
	 * required to sign requests with an OAuth <code>Authorization</code>
	 * header.
	 * 
	 * @param accessToken
	 *            An access token granted to the application after OAuth
	 *            authentication.
	 */
	public GitHubTemplate(String accessToken) {
		super(accessToken);
		initSubApis();
	}

	@Override
	protected OAuth2Version getOAuth2Version() {
		return OAuth2Version.DRAFT_8;
	}

	public String getProfileId() {
		return getUserProfile().getUsername();
	}

	@SuppressWarnings("unchecked")
	public GitHubUserProfile getUserProfile() {
		Map<String, ?> result = getRestTemplate().getForObject(PROFILE_URL, Map.class);
		Map<String, ?> user = (Map<String, String>) result.get("user");
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
	
	public RepoOperations repoOperations() { return repoOperations; }
	
	public UserOperations userOperations() { return userOperations; }
	
	// internal helpers
	
	private void initSubApis() {
		this.repoOperations = new RepoTemplate(getRestTemplate(), isAuthorized());
		this.userOperations = new UserTemplate(getRestTemplate(), isAuthorized());
	}
	
	private Date toDate(String dateString, DateFormat dateFormat) {
		try {
			return dateFormat.parse(dateString);
		} catch (ParseException e) {
			return null;
		}
	}

	private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss Z", Locale.ENGLISH);
	
	// FIXME Move to UsersTemplate, and update to GitHub API v3 [WLW]
	static final String PROFILE_URL = "https://github.com/api/v2/json/user/show";
}
