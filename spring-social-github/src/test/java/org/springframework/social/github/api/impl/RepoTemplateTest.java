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

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.springframework.http.HttpMethod.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.*;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.social.github.api.GitHubDownload;
import org.springframework.social.github.api.GitHubHook;
import org.springframework.social.github.api.GitHubIssue;
import org.springframework.social.github.api.GitHubRepo;

import java.util.Date;
import java.util.List;

/**
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 * @author Greg Turnquist
 * @author Andy Wilkinson
 */
public class RepoTemplateTest extends AbstractGitHubApiTest {
	
	@Test
	public void getRepo() {
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://api.github.com/repos/williewheeler/skybase"))
			.andExpect(method(GET))
			.andRespond(withSuccess(jsonResource("repo"), MediaType.APPLICATION_JSON));
		
		GitHubRepo repo = gitHub.repoOperations().getRepo("williewheeler", "skybase");
		
		// TODO There are other fields that we need to test.
		assertEquals(2811637L, repo.getId());
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
			.andRespond(withSuccess(jsonResource("repo-collaborators"), MediaType.APPLICATION_JSON));
		assertEquals(2, gitHub.repoOperations().getCollaborators("williewheeler", "skybase").size());
	}
	
	@Test
	public void getCommits() {
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://api.github.com/repos/williewheeler/skybase/commits"))
			.andExpect(method(GET))
			.andRespond(withSuccess(jsonResource("repo-commits"), MediaType.APPLICATION_JSON));
		assertEquals(30, gitHub.repoOperations().getCommits("williewheeler", "skybase").size());
	}
	
	@Test
	public void getDownloads() {
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://api.github.com/repos/williewheeler/skybase/downloads"))
			.andExpect(method(GET))
			.andRespond(withSuccess(jsonResource("repo-downloads"), MediaType.APPLICATION_JSON));
		assertEquals(4, gitHub.repoOperations().getDownloads("williewheeler", "skybase").size());
	}
	
	@Test
	public void getDownload() {
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://api.github.com/repos/williewheeler/skybase/downloads/201817"))
			.andExpect(method(GET))
			.andRespond(withSuccess(jsonResource("repo-download"), MediaType.APPLICATION_JSON));
		
		GitHubDownload download = gitHub.repoOperations().getDownload("williewheeler", "skybase", 201817L);
		assertEquals("disconnected.png", download.getName());
		assertEquals(15360L, download.getSize());
        assertEquals("image/png", download.getContentType());
        assertEquals(2, download.getDownloadCount());
        assertEquals("https://github.com/downloads/williewheeler/skybase/disconnected.png", download.getHtmlUrl());
        assertEquals("https://api.github.com/repos/williewheeler/skybase/downloads/201817", download.getUrl());
	}
	
	@Test
	public void getForks() {
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://api.github.com/repos/williewheeler/skybase/forks"))
			.andExpect(method(GET))
			.andRespond(withSuccess(jsonResource("repo-forks"), MediaType.APPLICATION_JSON));
		assertEquals(4, gitHub.repoOperations().getForks("williewheeler", "skybase").size());
	}

	@Test
	public void getIssues() {
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://api.github.com/repos/spring-guides/gs-rest-service/issues"))
				.andExpect(method(GET))
				.andRespond(withSuccess(jsonResource("repo-issues"), MediaType.APPLICATION_JSON));
		List<GitHubIssue> issues = gitHub.repoOperations().getIssues("spring-guides", "gs-rest-service");
		assertEquals(1, issues.size());
        GitHubIssue issue = issues.get(0);
        assertEquals(10, issue.getNumber());
		assertEquals("open", issue.getState());
		assertEquals("Use WAR packaging for rest service", issue.getTitle());
		assertEquals("You can deploy to WTP, build a war, execute it (java -jar) or use mvn exec.",
				issues.get(0).getBody());
		assertEquals("https://api.github.com/repos/spring-guides/gs-rest-service/issues/10",
				issues.get(0).getUrl());
		assertEquals("https://github.com/spring-guides/gs-rest-service/pull/10",
				issues.get(0).getHtmlUrl());
        assertEquals(new Date(1370334590000L), issue.getCreatedAt());
        assertEquals(new Date(1370939025000L), issue.getUpdatedAt());
        assertNull(issue.getClosedAt());
	}

	@Test
	public void getWatchers() {
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://api.github.com/repos/williewheeler/skybase/watchers"))
			.andExpect(method(GET))
			.andRespond(withSuccess(jsonResource("repo-watchers"), MediaType.APPLICATION_JSON));
		assertEquals(15, gitHub.repoOperations().getWatchers("williewheeler", "skybase").size());
	}
	
	@Test
	public void getHooks() {
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        mockServer.expect(requestTo("https://api.github.com/repos/octocat/Hello-World/hooks"))
                .andExpect(method(GET))
                .andRespond(withSuccess(jsonResource("repo-hooks"), MediaType.APPLICATION_JSON));
        List<GitHubHook> hooks = gitHub.repoOperations().getHooks("octocat", "Hello-World");
        assertEquals(1, hooks.size());
        GitHubHook hook = hooks.get(0);
        assertEquals(1, hook.getId());
        assertEquals("https://api.github.com/repos/octocat/Hello-World/hooks/1", hook.getUrl());
        assertEquals("web", hook.getName());
        assertTrue(hook.isActive());
        assertEquals(new Date(1315329987000L), hook.getCreatedAt());
        assertEquals(new Date(1315341563000L), hook.getUpdatedAt());

	}
}
