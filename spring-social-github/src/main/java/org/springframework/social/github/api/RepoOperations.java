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
package org.springframework.social.github.api;

import java.util.List;

/**
 * Interface defining the operations for working with GitHub repositories.
 * 
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
public interface RepoOperations {
	
	/**
	 * Public operation to return a repo.
	 * 
	 * @param user GitHub user
	 * @param repo GitHub repo
	 * @return repo
	 */
	GitHubRepo getRepo(String user, String repo);
	
	/**
	 * Public operation to return a list of collaborators for the given repository.
	 * 
	 * @param user GitHub user
	 * @param repo GitHub repository
	 * @return list of collaborators
	 */
	List<GitHubUser> getCollaborators(String user, String repo);
	
	/**
	 * Public operation to return a list of commits for the given repository.
	 * 
	 * @param user GitHub user
	 * @param repo GitHub repository
	 * @return list of commits
	 */
	List<GitHubCommit> getCommits(String user, String repo);
	
	/**
	 * Public operation to return a list of downloads for the given repository.
	 * 
	 * @param user GitHub user
	 * @param repo GitHub repository
	 * @return list of downloads
	 */
	List<GitHubDownload> getDownloads(String user, String repo);
	
	/**
	 * Public operation to return a single download.
	 * 
	 * @param user GitHub user
	 * @param repo GitHub repository
	 * @param id download ID
	 * @return download
	 */
	GitHubDownload getDownload(String user, String repo, Long id);
	
	/**
	 * Public operation to return the forks for the given repository.
	 * 
	 * @param user GitHub user
	 * @param repo GitHub repository
	 * @return list of repository forks
	 */
	List<GitHubRepo> getForks(String user, String repo);


	/**
	 * Public operation to return the forks for the given repository.
	 *
	 * @param user GitHub user
	 * @param repo GitHub repository
	 * @return list of repository issues
	 */
	List<GitHubIssue> getIssues(String user, String repo);

	/**
	 * Public operation to return a list of watchers for the given repository.
	 *  
	 * @param user GitHub user
	 * @param repo GitHub repository
	 * @return list of watchers
	 */
	List<GitHubUser> getWatchers(String user, String repo);
	
	/**
	 * Authorized operation to return a list of hooks for the given repository.
	 * 
	 * @param user GitHub user
	 * @param repo GitHub repository
	 * @return list of hooks
	 */
	List<GitHubHook> getHooks(String user, String repo);
}
