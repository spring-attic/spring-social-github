/*
 * Copyright 2013-2012 the original author or authors.
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

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.social.github.api.GistOperations;
import org.springframework.social.github.api.GitHub;
import org.springframework.social.github.api.RepoOperations;
import org.springframework.social.github.api.UserOperations;
import org.springframework.social.github.api.impl.json.GitHubModule;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.OAuth2Version;
import org.springframework.web.client.RestOperations;

/**
 * <p>
 * The central class for interacting with GitHub.
 * </p>
 * @author Craig Walls
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 * @author Andy Wilkinson
 */
public class GitHubTemplate extends AbstractOAuth2ApiBinding implements GitHub {
	private GistOperations gistOperations;
	private RepoOperations repoOperations;
	private UserOperations userOperations;
	
	/**
	 * No-arg constructor to support cases in which you want to call the GitHub
	 * API without requiring authorization. This is useful for public operations,
	 * such as getting the list of watchers for a public repository.
	 */
	public GitHubTemplate() {
		super();
		initSubApis();
	}
	
	/**
	 * Constructs a GitHubTemplate with the minimal amount of information
	 * required to sign requests with an OAuth <code>Authorization</code>
	 * header.
	 * 
	 * @param accessToken
	 *            An access token granted to the application after OAuth
	 *            authentication.
	 */
	public GitHubTemplate(String accessToken) {
		super(accessToken);
		initSubApis();
	}

	@Override
	protected OAuth2Version getOAuth2Version() {
		return OAuth2Version.BEARER;
	}
	
	public GistOperations gistOperations() {
		return gistOperations;
	}
	
	public RepoOperations repoOperations() {
		return repoOperations; 
	}
	
	public UserOperations userOperations() { 
		return userOperations; 
	}
	
	public RestOperations restOperations() {
		return getRestTemplate();
	}

    @Override
    protected MappingJackson2HttpMessageConverter getJsonMessageConverter() {
        MappingJackson2HttpMessageConverter converter = super.getJsonMessageConverter();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new GitHubModule());
        converter.setObjectMapper(objectMapper);
        return converter;
    }

    // internal helpers
	
	private void initSubApis() {
		this.gistOperations = new GistTemplate(getRestTemplate(), isAuthorized());
		this.repoOperations = new RepoTemplate(getRestTemplate(), isAuthorized());
		this.userOperations = new UserTemplate(getRestTemplate(), isAuthorized());
	}

}
