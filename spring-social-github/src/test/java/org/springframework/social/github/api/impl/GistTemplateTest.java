/*
 * Copyright 2011-2012 the original author or authors.
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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.RequestMatchers.requestTo;
import static org.springframework.social.test.client.ResponseCreators.withResponse;

import java.util.List;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.social.github.api.GitHubFile;
import org.springframework.social.github.api.GitHubGist;

/**
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
public class GistTemplateTest extends AbstractGitHubApiTest {

	@Test
	public void getUserGists() {
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://api.github.com/users/kdonald/gists"))
			.andExpect(method(GET))
			.andRespond(withResponse(jsonResource("user-gists"), responseHeaders));
		
		// Verify the list
		List<GitHubGist> gists = gitHub.gistOperations().getUserGists("kdonald");
		assertEquals(4, gists.size());
		
		// Verify the gist
		GitHubGist gist = gists.get(0);
		assertEquals(0, gist.getComments().intValue());
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
		assertEquals(3749L, file.getSize().longValue());
	}
}
