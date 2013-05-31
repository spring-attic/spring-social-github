/*
 * Copyright 2013 the original author or authors.
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
package org.springframework.social.github.config.xml;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.xml.AbstractProviderConfigBeanDefinitionParser;
import org.springframework.social.config.xml.ApiHelper;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.github.api.GitHub;
import org.springframework.social.github.api.impl.GitHubTemplate;
import org.springframework.social.github.connect.GitHubConnectionFactory;
import org.springframework.social.github.security.GitHubAuthenticationService;
import org.springframework.social.security.provider.SocialAuthenticationService;

/**
 * Implementation of {@link AbstractConnectionFactoryBeanDefinitionParser} that creates a {@link GitHubConnectionFactory}.
 * @author Craig Walls
 */
class GitHubConfigBeanDefinitionParser extends AbstractProviderConfigBeanDefinitionParser {

	public GitHubConfigBeanDefinitionParser() {
		super(GitHubConnectionFactory.class, GitHubApiHelper.class);
	}
	
	@Override
	protected Class<? extends SocialAuthenticationService<?>> getAuthenticationServiceClass() {
		return GitHubAuthenticationService.class;
	}
	
	@Override
	protected BeanDefinition getConnectionFactoryBeanDefinition(String appId, String appSecret, Map<String, Object> allAttributes) {
		BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(GitHubConnectionFactory.class).addConstructorArgValue(appId).addConstructorArgValue(appSecret);
		return builder.getBeanDefinition();
	}

	static class GitHubApiHelper implements ApiHelper<GitHub> {

		private final UsersConnectionRepository usersConnectionRepository;

		private final UserIdSource userIdSource;

		private GitHubApiHelper(UsersConnectionRepository usersConnectionRepository, UserIdSource userIdSource) {
			this.usersConnectionRepository = usersConnectionRepository;
			this.userIdSource = userIdSource;		
		}

		public GitHub getApi() {
			if (logger.isDebugEnabled()) {
				logger.debug("Getting API binding instance for GitHub");
			}
			
			Connection<GitHub> connection = usersConnectionRepository.createConnectionRepository(userIdSource.getUserId()).findPrimaryConnection(GitHub.class);
			if (logger.isDebugEnabled() && connection == null) {
				logger.debug("No current connection; Returning default GitHubTemplate instance.");
			}
			return connection != null ? connection.getApi() : new GitHubTemplate();
		}

		private final static Log logger = LogFactory.getLog(GitHubApiHelper.class);

	}
	
}
