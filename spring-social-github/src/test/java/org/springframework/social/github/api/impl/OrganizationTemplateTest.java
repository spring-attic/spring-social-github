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
package org.springframework.social.github.api.impl;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.social.github.api.*;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

/**
 * @author Michał Łoza (michal@mloza.pl)
 */
public class OrganizationTemplateTest extends AbstractGitHubApiTest {

	@Test
	public void getOrganization() {
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://api.github.com/orgs/EndlessInfinity"))
				.andExpect(method(GET))
				.andRespond(withSuccess(jsonResource("organization"), MediaType.APPLICATION_JSON));

		GitHubOrganization organization = gitHub.organizationOperations().getOrganization("EndlessInfinity");

		assertEquals(17481604L, organization.getId());
		assertEquals("EndlessInfinity", organization.getLogin());
		assertEquals("Test organization", organization.getDescription());
		assertEquals("https://api.github.com/orgs/EndlessInfinity", organization.getUrl());
	}

	@Test
	public void getOrganizationRepos() {
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://api.github.com/orgs/EndlessInfinity/repos"))
			.andExpect(method(GET))
			.andRespond(withSuccess(jsonResource("organization-repos"), MediaType.APPLICATION_JSON));
		
		List<GitHubRepo> repos = gitHub.organizationOperations().getOrganizationRepositories("EndlessInfinity");

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
}
