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

import static org.junit.Assert.*;
import static org.springframework.http.HttpMethod.*;
import static org.springframework.social.test.client.RequestMatchers.*;
import static org.springframework.social.test.client.ResponseCreators.*;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.social.github.api.GitHubUserProfile;

/**
 * @author Craig Walls
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
public class UserTemplateTest extends AbstractGitHubApiTest {
	
	@Test
	public void getUserProfile() throws Exception {
		mockServer.expect(requestTo("https://api.github.com/user")).andExpect(method(GET))
				.andExpect(header("Authorization", "BEARER ACCESS_TOKEN"))
				.andRespond(withResponse(new ClassPathResource("profile.json", getClass()), responseHeaders));
		GitHubUserProfile profile = gitHub.userOperations().getUserProfile();
		assertEquals("habuma", profile.getUsername());
		assertEquals("Craig Walls", profile.getName());
		assertEquals("SpringSource", profile.getCompany());
		assertEquals("http://blog.springsource.com/author/cwalls/", profile.getBlog());
		assertEquals("cwalls at vmware.com", profile.getEmail());
		assertEquals(167926, profile.getId());
	}

	@Test
	public void getProfileId() {
		mockServer.expect(requestTo("https://api.github.com/user")).andExpect(method(GET))
				.andExpect(header("Authorization", "BEARER ACCESS_TOKEN"))
				.andRespond(withResponse(new ClassPathResource("profile.json", getClass()), responseHeaders));
		assertEquals("habuma", gitHub.userOperations().getProfileId());
	}

	@Test
	public void getProfileUrl() {
		mockServer.expect(requestTo("https://api.github.com/user")).andExpect(method(GET))
				.andExpect(header("Authorization", "BEARER ACCESS_TOKEN"))
				.andRespond(withResponse(new ClassPathResource("profile.json", getClass()), responseHeaders));
		assertEquals("https://github.com/habuma", gitHub.userOperations().getProfileUrl());
	}
	
	@Test
	public void getFollowers() {
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://api.github.com/users/williewheeler/followers"))
			.andExpect(method(GET))
			.andRespond(withResponse(jsonResource("user-followers"), responseHeaders));
		assertEquals(20, gitHub.userOperations().getFollowers("williewheeler").size());
	}
	
	@Test
	public void getFollowing() {
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://api.github.com/users/williewheeler/following"))
			.andExpect(method(GET))
			.andRespond(withResponse(jsonResource("user-following"), responseHeaders));
		assertEquals(17, gitHub.userOperations().getFollowing("williewheeler").size());
	}

}
