/*
 * Copyright 2012-2014 the original author or authors.
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
import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A GitHub gist.
 * 
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 * @author Andy Wilkinson
 */
@SuppressWarnings("serial")
public class GitHubGist implements Serializable {

	private final String id;

	private final String url;

	private final boolean publicGist;

	private final GitHubUser user;

	private final int comments;

	private final String htmlUrl;

    private final String gitPullUrl;

	private final String gitPushUrl;

	private final Date createdAt;

	private final Date updatedAt;

    private String description;

    private Map<String, GitHubFile> files;

    public GitHubGist(String id, String url, boolean publicGist, GitHubUser user, int comments, String htmlUrl,
            String gitPullUrl, String gitPushUrl, Date createdAt, Date updatedAt) {
        this.id = id;
        this.url = url;
        this.publicGist = publicGist;
        this.user = user;
        this.comments = comments;
        this.htmlUrl = htmlUrl;
        this.gitPullUrl = gitPullUrl;
        this.gitPushUrl = gitPushUrl;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

	public String getId() { return id; }
	
	public String getUrl() { return url; }
	
	public String getDescription() { return description; }
	
	public void setDescription(String description) { this.description = description; }
	
	public boolean isPublic() { return publicGist; }
	
	public GitHubUser getUser() { return user; }
	
	public Map<String, GitHubFile> getFiles() { return files; }
	
	public void setFiles(Map<String, GitHubFile> files) { this.files = files; }
	
	public int getComments() { return comments; }

	public String getHtmlUrl() { return htmlUrl; }

	public String getGitPullUrl() { return gitPullUrl; }

	public String getGitPushUrl() { return gitPushUrl; }

	public Date getCreatedAt() { return createdAt; }

	public Date getUpdatedAt() { return updatedAt; }
}
