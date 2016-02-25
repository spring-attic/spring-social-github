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
package org.springframework.social.github.api.impl;

import org.springframework.social.github.api.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * <p>
 * Organization template implementation.
 * </p>
 *
 * @author Michał Łoza (michal@mloza.pl)
 */
public class OrganizationTemplate extends AbstractGitHubOperations implements OrganizationOperations {

	private final RestTemplate restTemplate;

	/**
	 * @param restTemplate A RestTemplate
	 * @param isAuthorizedForUser Boolean indicating whether the RestTemplate is authorized for a user
	 */
	public OrganizationTemplate(RestTemplate restTemplate, boolean isAuthorizedForUser) {
		super(isAuthorizedForUser);
		this.restTemplate = restTemplate;
	}

	public GitHubOrganization getOrganization(String organizationName) {
		return restTemplate.getForObject(buildOrganizationUri(""), GitHubOrganization.class, organizationName);
	}

	public List<GitHubRepo> getOrganizationRepositories(String organizationName) {
		return asList(restTemplate.getForObject(buildOrganizationUri("/repos"), GitHubRepo[].class, organizationName));
	}

	private String buildOrganizationUri(String path) {
		return buildUri("orgs/{organization}" + path);
	}
}
