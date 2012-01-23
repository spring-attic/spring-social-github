/*
 * Copyright 2011-2012 the original author or authors.
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

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * A GitHub gist.
 * 
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
@SuppressWarnings("serial")
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHubGist implements Serializable {
	private String id;
	private String url;
	private String description;
	private boolean publicGist;
	private GitHubUser user;
	private Map<String, GitHubFile> files;
	private Integer comments;
	private String htmlUrl;
	private String gitPullUrl;
	private String gitPushUrl;
	private Date createdAt;
	private Date updatedAt;
	
	// Looks like GitHub is returning a string, even though the IDs appear to be stringified integers.
	public String getId() { return id; }
	
	public void setId(String id) { this.id = id; }
	
	public String getUrl() { return url; }
	
	public void setUrl(String url) { this.url = url; }
	
	public String getDescription() { return description; }
	
	public void setDescription(String description) { this.description = description; }
	
	public boolean isPublic() { return publicGist; }
	
	public void setPublic(boolean publicGist) { this.publicGist = publicGist; }
	
	public GitHubUser getUser() { return user; }
	
	public void setUser(GitHubUser user) { this.user = user; }
	
	public Map<String, GitHubFile> getFiles() { return files; }
	
	public void setFiles(Map<String, GitHubFile> files) { this.files = files; }
	
	public Integer getComments() { return comments; }
	
	public void setComments(Integer comments) { this.comments = comments; }
	
	@JsonProperty("html_url")
	public String getHtmlUrl() { return htmlUrl; }
	
	public void setHtmlUrl(String htmlUrl) { this.htmlUrl = htmlUrl; }
	
	@JsonProperty("git_pull_url")
	public String getGitPullUrl() { return gitPullUrl; }
	
	public void setGitPullUrl(String gitPullUrl) { this.gitPullUrl = gitPullUrl; }
	
	@JsonProperty("git_push_url")
	public String getGitPushUrl() { return gitPushUrl; }
	
	public void setGitPushUrl(String gitPushUrl) { this.gitPushUrl = gitPushUrl; }
	
	@JsonProperty("created_at")
	public Date getCreatedAt() { return createdAt; }
	
	public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }
	
	@JsonProperty("updated_at")
	public Date getUpdatedAt() { return updatedAt; }
	
	public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; }
	
}
