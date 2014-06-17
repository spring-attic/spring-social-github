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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A GitHub repo.
 * 
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 * @author Andy Wilkinson
 */
@SuppressWarnings("serial")
public class GitHubRepo implements Serializable {

	private final long id;

	private final String url;

	private final String htmlUrl;

	private final String cloneUrl;

	private final String gitUrl;

	private final String sshUrl;

	private final String svnUrl;

    public GitHubRepo(long id, String url, String htmlUrl, String cloneUrl, String gitUrl, String sshUrl,
            String svnUrl) {
        this.id = id;
        this.url = url;
        this.htmlUrl = htmlUrl;
        this.cloneUrl = cloneUrl;
        this.gitUrl = gitUrl;
        this.sshUrl = sshUrl;
        this.svnUrl = svnUrl;
    }

    private String name;

    private String description;
	
	public long getId() { return id; }
	
	public String getUrl() { return url; }

	public String getHtmlUrl() { return htmlUrl; }

	public String getCloneUrl() { return cloneUrl; }

	public String getGitUrl() { return gitUrl; }

	public String getSshUrl() { return sshUrl; }

	public String getSvnUrl() { return svnUrl; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }
	
}
