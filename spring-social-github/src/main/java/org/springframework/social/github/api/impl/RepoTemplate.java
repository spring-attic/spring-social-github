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

import static java.util.Arrays.asList;

import java.util.List;

import org.springframework.social.github.api.GitHubCommit;
import org.springframework.social.github.api.GitHubDownload;
import org.springframework.social.github.api.GitHubHook;
import org.springframework.social.github.api.GitHubIssue;
import org.springframework.social.github.api.GitHubRepo;
import org.springframework.social.github.api.GitHubUser;
import org.springframework.social.github.api.RepoOperations;
import org.springframework.web.client.RestTemplate;

/**
 * <p>
 * Repository template implementation.
 * </p>
 * 
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 * @author Greg Turnquist
 */
public class RepoTemplate extends AbstractGitHubOperations implements RepoOperations {

	private final RestTemplate restTemplate;
	
	/**
	 * @param restTemplate A RestTemplate
	 * @param isAuthorizedForUser Boolean indicating whether the RestTemplate is authorized for a user
	 */
	public RepoTemplate(RestTemplate restTemplate, boolean isAuthorizedForUser) {
		super(isAuthorizedForUser);
		this.restTemplate = restTemplate;
	}
	
	public GitHubRepo getRepo(String user, String repo) {
		return restTemplate.getForObject(buildRepoUri(""), GitHubRepo.class, user, repo);
	}
	
	public List<GitHubUser> getCollaborators(String user, String repo) {
		return asList(restTemplate.getForObject(buildRepoUri("/collaborators"), GitHubUser[].class, user, repo));
	}
	
	public List<GitHubCommit> getCommits(String user, String repo) {
		return asList(restTemplate.getForObject(buildRepoUri("/commits"), GitHubCommit[].class, user, repo));
	}
	
	public List<GitHubDownload> getDownloads(String user, String repo) {
		return asList(restTemplate.getForObject(buildRepoUri("/downloads"), GitHubDownload[].class, user, repo));
	}
	
	public GitHubDownload getDownload(String user, String repo, Long id) {
		String uri = buildUri("repos/{user}/{repo}/downloads/{id}");
		return restTemplate.getForObject(uri, GitHubDownload.class, user, repo, id);
	}
	
	public List<GitHubRepo> getForks(String user, String repo) {
		return asList(restTemplate.getForObject(buildRepoUri("/forks"), GitHubRepo[].class, user, repo));
	}

	public List<GitHubIssue> getIssues(String user, String repo) {
		return asList(restTemplate.getForObject(buildRepoUri("/issues"), GitHubIssue[].class, user, repo));
	}

	public List<GitHubUser> getWatchers(String user, String repo) {
		return asList(restTemplate.getForObject(buildRepoUri("/watchers"), GitHubUser[].class, user, repo));
	}

	public List<GitHubHook> getHooks(String user, String repo) {
		return asList(restTemplate.getForObject(buildRepoUri("/hooks"), GitHubHook[].class, user, repo));
	}
	
	private String buildRepoUri(String path) {
		return buildUri("repos/{user}/{repo}" + path);
	}

}
