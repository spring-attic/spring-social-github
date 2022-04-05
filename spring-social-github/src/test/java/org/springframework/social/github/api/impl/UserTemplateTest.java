/*
 * Copyright 2013-2014 the original author or authors.
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
package org.springframework.social.github.api.impl;

import static org.junit.Assert.*;
import static org.springframework.http.HttpMethod.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.*;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.social.github.api.GitHubOrganization;
import org.springframework.social.github.api.GitHubRepo;
import org.springframework.social.github.api.GitHubUserProfile;

import java.util.List;

/**
 * @author Craig Walls
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 * @author Andy Wilkinson
 * @author Michał Łoza (michal@mloza.pl)
 */
public class UserTemplateTest extends AbstractGitHubApiTest {
	
	@Test
	public void getUserProfile() throws Exception {
		mockServer.expect(requestTo("https://api.github.com/user")).andExpect(method(GET))
				.andExpect(header("Authorization", "Bearer ACCESS_TOKEN"))
				.andRespond(withSuccess(new ClassPathResource("profile.json", getClass()), MediaType.APPLICATION_JSON));
		GitHubUserProfile profile = gitHub.userOperations().getUserProfile();
		assertEquals("habuma", profile.getLogin());
		assertEquals("Craig Walls", profile.getName());
		assertEquals("SpringSource", profile.getCompany());
		assertEquals("https://spring.io/team/cwalls/", profile.getBlog());
		assertEquals("cwalls at vmware.com", profile.getEmail());
		assertEquals(167926, profile.getId());
	}

	@Test
	public void getProfileId() {
		mockServer.expect(requestTo("https://api.github.com/user")).andExpect(method(GET))
				.andExpect(header("Authorization", "Bearer ACCESS_TOKEN"))
				.andRespond(withSuccess(new ClassPathResource("profile.json", getClass()), MediaType.APPLICATION_JSON));
		assertEquals("habuma", gitHub.userOperations().getProfileId());
	}

	@Test
	public void getProfileUrl() {
		mockServer.expect(requestTo("https://api.github.com/user")).andExpect(method(GET))
				.andExpect(header("Authorization", "Bearer ACCESS_TOKEN"))
				.andRespond(withSuccess(new ClassPathResource("profile.json", getClass()), MediaType.APPLICATION_JSON));
		assertEquals("https://github.com/habuma", gitHub.userOperations().getProfileUrl());
	}
	
	@Test
	public void getFollowers() {
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://api.github.com/users/williewheeler/followers"))
			.andExpect(method(GET))
			.andRespond(withSuccess(jsonResource("user-followers"), MediaType.APPLICATION_JSON));
		assertEquals(20, gitHub.userOperations().getFollowers("williewheeler").size());
	}
	
	@Test
	public void getFollowing() {
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://api.github.com/users/williewheeler/following"))
			.andExpect(method(GET))
			.andRespond(withSuccess(jsonResource("user-following"), MediaType.APPLICATION_JSON));
		assertEquals(17, gitHub.userOperations().getFollowing("williewheeler").size());
	}

	@Test
	public void getRepositories() {
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://api.github.com/user/repos"))
				.andExpect(method(GET))
				.andRespond(withSuccess(jsonResource("user-repos"), MediaType.APPLICATION_JSON));

		List<GitHubRepo> repos = gitHub.userOperations().getRepositories();
		validateRepos(repos);
	}

	@Test
	public void getUserRepositories() {
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://api.github.com/users/mloza/repos"))
				.andExpect(method(GET))
				.andRespond(withSuccess(jsonResource("user-repos"), MediaType.APPLICATION_JSON));

		List<GitHubRepo> repos = gitHub.userOperations().getRepositories("mloza");
		validateRepos(repos);
	}

	private void validateRepos(List<GitHubRepo> repos) {
		assertEquals(2, repos.size());

		GitHubRepo repo = repos.get(0);
		assertEquals(52549339L, repo.getId());
		assertEquals("testRepository1", repo.getName());
		assertEquals("TestingRepository", repo.getDescription());
		assertEquals("https://api.github.com/repos/EndlessInfinity/testRepository1", repo.getUrl());
		assertEquals("https://github.com/EndlessInfinity/testRepository1", repo.getHtmlUrl());
		assertEquals("https://github.com/EndlessInfinity/testRepository1.git", repo.getCloneUrl());
		assertEquals("git://github.com/EndlessInfinity/testRepository1.git", repo.getGitUrl());
		assertEquals("git@github.com:EndlessInfinity/testRepository1.git", repo.getSshUrl());
		assertEquals("https://github.com/EndlessInfinity/testRepository1", repo.getSvnUrl());

		repo = repos.get(1);
		assertEquals(52549359L, repo.getId());
		assertEquals("testRepository2", repo.getName());
		assertEquals("Testing repository 2", repo.getDescription());
		assertEquals("https://api.github.com/repos/EndlessInfinity/testRepository2", repo.getUrl());
		assertEquals("https://github.com/EndlessInfinity/testRepository2", repo.getHtmlUrl());
		assertEquals("https://github.com/EndlessInfinity/testRepository2.git", repo.getCloneUrl());
		assertEquals("git://github.com/EndlessInfinity/testRepository2.git", repo.getGitUrl());
		assertEquals("git@github.com:EndlessInfinity/testRepository2.git", repo.getSshUrl());
		assertEquals("https://github.com/EndlessInfinity/testRepository2", repo.getSvnUrl());
	}

	@Test
	public void getOrganizations() {
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://api.github.com/user/orgs"))
				.andExpect(method(GET))
				.andRespond(withSuccess(jsonResource("user-orgs"), MediaType.APPLICATION_JSON));

		List<GitHubOrganization> organizations = gitHub.userOperations().getOrganizations();
		validateOrganizations(organizations);
	}

	@Test
	public void getGivenUserOrganizations() {
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://api.github.com/users/mloza/orgs"))
				.andExpect(method(GET))
				.andRespond(withSuccess(jsonResource("user-orgs"), MediaType.APPLICATION_JSON));

		List<GitHubOrganization> organizations = gitHub.userOperations().getOrganizations("mloza");
		validateOrganizations(organizations);
	}

	private void validateOrganizations(List<GitHubOrganization> organizations) {
		assertEquals(2, organizations.size());

		assertEquals("EndlessInfinity", organizations.get(0).getLogin());
		assertEquals(17481604L, organizations.get(0).getId());
		assertEquals("EndlessInfinity2", organizations.get(1).getLogin());
		assertEquals(17481605L, organizations.get(1).getId());
	}
}
