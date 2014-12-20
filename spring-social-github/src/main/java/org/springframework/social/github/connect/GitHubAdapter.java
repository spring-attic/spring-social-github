/*
 * Copyright 2013-2014 the original author or authors.
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
package org.springframework.social.github.connect;

import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;
import org.springframework.social.github.api.GitHub;
import org.springframework.social.github.api.GitHubUserProfile;
import org.springframework.web.client.HttpClientErrorException;

/**
 * Github ApiAdapter implementation.
 * @author Keith Donald
 * @author Andy Wilkinson
 */
public class GitHubAdapter implements ApiAdapter<GitHub> {

	public boolean test(GitHub github) {
		try {
			github.userOperations().getUserProfile();
			return true;
		} catch (HttpClientErrorException e) {
			// TODO : Beef up GitHub's error handling and trigger off of a more specific exception
			return false;
		}
	}

	public void setConnectionValues(GitHub github, ConnectionValues values) {
		GitHubUserProfile profile = github.userOperations().getUserProfile();
		values.setProviderUserId(String.valueOf(profile.getId()));		
		values.setDisplayName(profile.getLogin());
		values.setProfileUrl("https://github.com/" + profile.getLogin()); // TODO: Expose and use HTML URL
		values.setImageUrl(profile.getAvatarUrl());
	}

	public UserProfile fetchUserProfile(GitHub github) {
		GitHubUserProfile profile = github.userOperations().getUserProfile();
		return new UserProfileBuilder().setName(profile.getName()).setEmail(profile.getEmail()).setUsername(profile.getLogin()).build();
	}
	
	public void updateStatus(GitHub github, String message) {
		// not supported
	}
	
}
