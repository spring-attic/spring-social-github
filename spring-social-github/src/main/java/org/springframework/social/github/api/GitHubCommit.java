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
package org.springframework.social.github.api;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * A GitHub repository commit.
 * 
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
@SuppressWarnings("serial")
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHubCommit implements Serializable {
	private String message;
	private String sha;
	private String url;
	private GitHubUser committer;
	private GitHubUser author;
	private GitHubCommit commit;
	
	/**
	 * @return commit message
	 */
	public String getMessage() { return message; }
	
	/**
	 * @param message commit message
	 */
	public void setMessage(String message) { this.message = message; }
	
	public String getSha() { return sha; }
	
	public void setSha(String sha) { this.sha = sha; }
	
	public String getUrl() { return url; }
	
	public void setUrl(String url) { this.url = url; }
	
	/**
	 * @return user who committed the patch, perhaps on behalf of a separate
	 *         author (e.g., Willie authors code, issues a pull request, and
	 *         Craig commits it)
	 */
	public GitHubUser getCommitter() { return committer; }
	
	public void setCommitter(GitHubUser committer) { this.committer = committer; }
	
	public GitHubUser getAuthor() { return author; }
	
	/**
	 * @param author user who wrote the patch
	 */
	public void setAuthor(GitHubUser author) { this.author = author; }
	
	public GitHubCommit getCommit() { return commit; }
	
	public void setCommit(GitHubCommit commit) { this.commit = commit; }
}
