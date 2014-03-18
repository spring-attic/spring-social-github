/*
 * Copyright 2012-2014 the original author or authors.
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
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.*;

import java.util.List;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.social.github.api.GitHubComment;
import org.springframework.social.github.api.GitHubFile;
import org.springframework.social.github.api.GitHubGist;

/**
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 * @author Andy Wilkinson
 */
public class GistTemplateTest extends AbstractGitHubApiTest {

	@Test
	public void getUserGists() {
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://api.github.com/users/kdonald/gists"))
			.andExpect(method(GET))
			.andRespond(withSuccess(jsonResource("user-gists"), MediaType.APPLICATION_JSON));
		
		// Verify the list
		List<GitHubGist> gists = gitHub.gistOperations().getUserGists("kdonald");
		assertEquals(4, gists.size());
		
		// Verify the gist
		GitHubGist gist = gists.get(0);
		assertEquals(0, gist.getComments());
		assertTrue(gist.isPublic());
		assertEquals("https://gist.github.com/1603296", gist.getHtmlUrl());
		assertEquals("git@gist.github.com:1603296.git", gist.getGitPushUrl());
		assertEquals("git://gist.github.com/1603296.git", gist.getGitPullUrl());
		assertNotNull(gist.getCreatedAt());
		assertNotNull(gist.getUpdatedAt());
		
		// Verify the file
		GitHubFile file = gist.getFiles().get("jmustache-spring-mvc.java");
		assertNotNull(file);
		assertEquals("jmustache-spring-mvc.java", file.getFilename());
		assertEquals("text/plain", file.getType());
		assertEquals("https://gist.github.com/raw/1603296/18195cefb653c8ed3ecbd0cb3a60a76eb417158e/jmustache-spring-mvc.java", file.getRawUrl());
		assertEquals("Java", file.getLanguage());
		assertEquals(3749L, file.getSize());
        assertNull(file.getContent()); // No content for a file in a list of Gists
	}
	
	@Test
	public void getGists_Anonymous() {
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://api.github.com/gists"))
			.andExpect(method(GET))
			.andRespond(withSuccess(jsonResource("gists-public"), MediaType.APPLICATION_JSON));
		List<GitHubGist> gists = gitHub.gistOperations().getGists();
		assertEquals(30, gists.size());
	}
	
	@Test
	public void getGists_Authenticated() {
		// TODO
	}
	
	@Test
	public void getPublicGists() {
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://api.github.com/gists/public"))
			.andExpect(method(GET))
			.andRespond(withSuccess(jsonResource("gists-public"), MediaType.APPLICATION_JSON));
		List<GitHubGist> gists = gitHub.gistOperations().getPublicGists();
		assertEquals(30, gists.size());
	}
	
	@Test
	public void getStarredGists() {
		// TODO
	}
	
	@Test
	public void getGist() {
		// TODO
	}
	
	@Test
	public void getGistComments() {
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://api.github.com/gists/1651139/comments"))
			.andExpect(method(GET))
			.andRespond(withSuccess(jsonResource("gist-comments"), MediaType.APPLICATION_JSON));
		List<GitHubComment> comments = gitHub.gistOperations().getGistComments("1651139");
		assertEquals(2, comments.size());
		verifyComment(comments.get(0));
	}
	
	@Test
	public void getGistComment() {
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://api.github.com/gists/comments/77557"))
			.andExpect(method(GET))
			.andRespond(withSuccess(jsonResource("gist-comment"), MediaType.APPLICATION_JSON));
		GitHubComment comment = gitHub.gistOperations().getGistComment(77557L);
		verifyComment(comment);
	}
	
	private void verifyComment(GitHubComment comment) {
		assertEquals(77557L, comment.getId());
		assertEquals("https://api.github.com/gists/comments/77557", comment.getUrl());
		assertEquals("This is a comment.", comment.getBody());
		assertEquals("williewheeler", comment.getUser().getLogin());
		assertNotNull(comment.getCreatedAt());
		assertNotNull(comment.getUpdatedAt());
	}
}
