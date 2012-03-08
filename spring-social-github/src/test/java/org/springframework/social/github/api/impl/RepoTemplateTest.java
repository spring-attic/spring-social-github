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

import static org.junit.Assert.assertEquals;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.RequestMatchers.requestTo;
import static org.springframework.social.test.client.ResponseCreators.withResponse;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.social.github.api.GitHubRepo;

/**
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
public class RepoTemplateTest extends AbstractGitHubApiTest {
	
	@Test
	public void getRepo() {
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://api.github.com/repos/williewheeler/skybase"))
			.andExpect(method(GET))
			.andRespond(withResponse(jsonResource("repo"), responseHeaders));
		
		GitHubRepo repo = gitHub.repoOperations().getRepo("williewheeler", "skybase");
		
		// TODO There are other fields that we need to test.
		assertEquals(2811637L, repo.getId().longValue());
		assertEquals("skybase", repo.getName());
		assertEquals("CMDB based on Neo4j", repo.getDescription());
		assertEquals("https://api.github.com/repos/williewheeler/skybase", repo.getUrl());
		assertEquals("https://github.com/williewheeler/skybase", repo.getHtmlUrl());
		assertEquals("https://github.com/williewheeler/skybase.git", repo.getCloneUrl());
		assertEquals("git://github.com/williewheeler/skybase.git", repo.getGitUrl());
		assertEquals("git@github.com:williewheeler/skybase.git", repo.getSshUrl());
		assertEquals("https://github.com/williewheeler/skybase", repo.getSvnUrl());
	}
	
	@Test
	public void getCollaborators() {
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://api.github.com/repos/williewheeler/skybase/collaborators"))
			.andExpect(method(GET))
			.andRespond(withResponse(jsonResource("repo-collaborators"), responseHeaders));
		assertEquals(2, gitHub.repoOperations().getCollaborators("williewheeler", "skybase").size());
	}
	
	@Test
	public void getCommits() {
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://api.github.com/repos/williewheeler/skybase/commits"))
			.andExpect(method(GET))
			.andRespond(withResponse(jsonResource("repo-commits"), responseHeaders));
		assertEquals(30, gitHub.repoOperations().getCommits("williewheeler", "skybase").size());
	}
	
	@Test
	public void getWatchers() {
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://api.github.com/repos/williewheeler/skybase/watchers"))
			.andExpect(method(GET))
			.andRespond(withResponse(jsonResource("repo-watchers"), responseHeaders));
		assertEquals(15, gitHub.repoOperations().getWatchers("williewheeler", "skybase").size());
	}
	
	@Test
	public void getHooks() {
		
	}
}
