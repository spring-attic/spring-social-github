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
import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * A GitHub repository user.
 * 
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
@SuppressWarnings("serial")
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHubUser implements Serializable {
	private Long id;
	private String url;
	private String login;
	private String avatarUrl;
	private String gravatarId;
	private String name;
	private String email;
	private Date date;
	
	public Long getId() { return id; }
	
	public void setId(Long id) { this.id = id; }
	
	public String getUrl() { return url; }
	
	public void setUrl(String url) { this.url = url; }
	
	/**
	 * @return watcher's GitHub login
	 */
	public String getLogin() { return login; }
	
	public void setLogin(String login) { this.login = login; }
	
	@JsonProperty("avatar_url")
	public String getAvatarUrl() { return avatarUrl; }
	
	public void setAvatarUrl(String avatarUrl) { this.avatarUrl = avatarUrl; }
	
	@JsonProperty("gravatar_id")
	public String getGravatarId() { return gravatarId; }
	
	public void setGravatarId(String gravatarId) { this.gravatarId = gravatarId; }
	
	public String getName() { return name; }
	
	public void setName(String name) { this.name = name; }
	
	public String getEmail() { return email; }
	
	public void setEmail(String email) { this.email = email; }
	
	public Date getDate() { return date; }
	
	public void setDate(Date date) { this.date = date; }
}
