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

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * A GitHub repo.
 * 
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
@SuppressWarnings("serial")
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHubRepo implements Serializable {
	private Long id;
	private String name;
	private String description;
	private String url;
	private String htmlUrl;
	private String cloneUrl;
	private String gitUrl;
	private String sshUrl;
	private String svnUrl;
	
	public Long getId() { return id; }
	
	public void setId(Long id) { this.id = id; }
	
	public String getName() { return name; }
	
	public void setName(String name) { this.name = name; }
	
	public String getDescription() { return description; }
	
	public void setDescription(String description) { this.description = description; }
	
	public String getUrl() { return url; }
	
	public void setUrl(String url) { this.url = url; }
	
	@JsonProperty("html_url")
	public String getHtmlUrl() { return htmlUrl; }
	
	public void setHtmlUrl(String htmlUrl) { this.htmlUrl = htmlUrl; }
	
	@JsonProperty("clone_url")
	public String getCloneUrl() { return cloneUrl; }
	
	public void setCloneUrl(String cloneUrl) { this.cloneUrl = cloneUrl; }
	
	@JsonProperty("git_url")
	public String getGitUrl() { return gitUrl; }
	
	public void setGitUrl(String gitUrl) { this.gitUrl = gitUrl; }
	
	@JsonProperty("ssh_url")
	public String getSshUrl() { return sshUrl; }
	
	public void setSshUrl(String sshUrl) { this.sshUrl = sshUrl; }
	
	@JsonProperty("svn_url")
	public String getSvnUrl() { return svnUrl; }
	
	public void setSvnUrl(String svnUrl) { this.svnUrl = svnUrl; }
	
}
