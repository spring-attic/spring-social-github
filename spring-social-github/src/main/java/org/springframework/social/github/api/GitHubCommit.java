/*
 * Copyright 2013-2014 the original author or authors.
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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * A GitHub repository commit.
 * 
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
@SuppressWarnings("serial")
public class GitHubCommit implements Serializable {

	private final String message;

	private final String sha;

	private final String url;

	private final GitHubUser committer;

	private final GitHubUser author;

    public GitHubCommit(String message, String sha, String url, GitHubUser committer, GitHubUser author) {
        this.message = message;
        this.sha = sha;
        this.url = url;
        this.committer = committer;
        this.author = author;
    }

    /**
	 * @return commit message
	 */
	public String getMessage() { return message; }

	public String getSha() { return sha; }

	public String getUrl() { return url; }

	/**
	 * @return user who committed the patch, perhaps on behalf of a separate
	 *         author (e.g., Willie authors code, issues a pull request, and
	 *         Craig commits it)
	 */
	public GitHubUser getCommitter() { return committer; }

    /**
     * @return user who wrote the patch
     */
    public GitHubUser getAuthor() { return author; }
}
