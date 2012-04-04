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
 * A GitHub download.
 * 
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
@SuppressWarnings("serial")
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHubDownload implements Serializable {
	private Long id;
	private String url;
	private String htmlUrl;
	private String name;
	private String description;
	private Long size;
	private Integer downloadCount;
	private String contentType;
	private Date createdAt;

	public Long getId() { return id; }

	public void setId(Long id) { this.id = id; }

	public String getUrl() { return url; }

	public void setUrl(String url) { this.url = url; }
	
	@JsonProperty("html_url")
	public String getHtmlUrl() { return htmlUrl; }

	public void setHtmlUrl(String htmlUrl) { this.htmlUrl = htmlUrl; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public String getDescription() { return description; }

	public void setDescription(String description) { this.description = description; }

	public Long getSize() { return size; }

	public void setSize(Long size) { this.size = size; }
	
	@JsonProperty("download_count")
	public Integer getDownloadCount() { return downloadCount; }

	public void setDownloadCount(Integer downloadCount) { this.downloadCount = downloadCount; }
	
	@JsonProperty("content_type")
	public String getContentType() { return contentType; }

	public void setContentType(String contentType) { this.contentType = contentType; }
	
	@JsonProperty("created_at")
	public Date getCreatedAt() { return createdAt; }
	
	public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }
	
}
