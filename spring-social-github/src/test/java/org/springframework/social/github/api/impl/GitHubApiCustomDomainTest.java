/*
 * Copyright 2015 the original author or authors.
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
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.social.github.api.GitHubRepo;
import org.springframework.test.web.client.MockRestServiceServer;

/**
 * <p>
 * Based on <code>AbstractGitHubApiTest</code>.
 * </p>
 * 
 * @author Vinayak Hulawale
 */
public  class GitHubApiCustomDomainTest {
	protected GitHubTemplate gitHub;
	protected GitHubTemplate unauthorizedGitHub;
	protected MockRestServiceServer mockServer;
	protected HttpHeaders responseHeaders;
	
	@Before
	public void setup() {
		this.gitHub = new GitHubTemplate("ACCESS_TOKEN","github.mydomain.com");
		this.mockServer = MockRestServiceServer.createServer(gitHub.getRestTemplate());
		
		this.responseHeaders = new HttpHeaders();
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		
		this.unauthorizedGitHub = new GitHubTemplate("github.mydomain.com");
		
		// Create a mock server just to avoid hitting real GitHub if something gets past the authorization check.
		MockRestServiceServer.createServer(unauthorizedGitHub.getRestTemplate());
	}

	protected Resource jsonResource(String filename) {
		return new ClassPathResource(filename + ".json", getClass());
	}
	
	@Test
    public void getRepo() {
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        mockServer.expect(requestTo("https://github.mydomain.com/api/v3/repos/vinayak/project"))
            .andExpect(method(GET))
            .andRespond(withSuccess(jsonResource("customDomainRepo"), MediaType.APPLICATION_JSON));
        
        GitHubRepo repo = gitHub.repoOperations().getRepo("vinayak", "project");
        
        // TODO There are other fields that we need to test.
        assertEquals(132, repo.getId());
        assertEquals("project", repo.getName());
        assertEquals("My project", repo.getDescription());
        assertEquals("https://github.mydomain.com/api/v3/repos/vinayak/project", repo.getUrl());
        assertEquals("https://github.mydomain.com/vinayak/project", repo.getHtmlUrl());
        assertEquals("https://github.mydomain.com/vinayak/project.git", repo.getCloneUrl());
        assertEquals("git://github.mydomain.com/vinayak/project.git", repo.getGitUrl());
        assertEquals("git@github.mydomain.com:vinayak/project.git", repo.getSshUrl());
        assertEquals("https://github.mydomain.com/vinayak/project", repo.getSvnUrl());
    }
}
