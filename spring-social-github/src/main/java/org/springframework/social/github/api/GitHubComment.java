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

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * A GitHub comment.
 * 
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
@SuppressWarnings("serial")
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHubComment implements Serializable {
	private Long id;
	private String url;
	private String body;
	private GitHubUser user;
	private Date createdAt;
	private Date updatedAt;
	
	public Long getId() { return id; }
	
	public void setId(Long id) { this.id = id; }
	
	public String getUrl() { return url; }
	
	public void setUrl(String url) { this.url = url; }
	
	public String getBody() { return body; }
	
	public void setBody(String body) { this.body = body; }
	
	public GitHubUser getUser() { return user; }
	
	public void setUser(GitHubUser user) { this.user = user; }
	
	@JsonProperty("created_at")
	public Date getCreatedAt() { return createdAt; }
	
	public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }
	
	@JsonProperty("updated_at")
	public Date getUpdatedAt() { return updatedAt; }
	
	public void setUpdatedA(Date updatedAt) { this.updatedAt = updatedAt; }
	
}
