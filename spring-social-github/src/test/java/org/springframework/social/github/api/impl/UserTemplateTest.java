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

/**
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
public class UserTemplateTest extends AbstractGitHubApiTest {
	
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
