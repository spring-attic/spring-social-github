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
 * A GitHub file.
 * 
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
@SuppressWarnings("serial")
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHubFile implements Serializable {
	private String filename;
	private String type;
	private String language;
	private String rawUrl;
	private Long size;
	private String content;

	public String getFilename() { return filename; }

	public void setFilename(String filename) { this.filename = filename; }

	public String getType() { return type; }

	public void setType(String type) { this.type = type; }

	public String getLanguage() { return language; }

	public void setLanguage(String language) { this.language = language; }
	
	@JsonProperty("raw_url")
	public String getRawUrl() { return rawUrl; }

	public void setRawUrl(String rawUrl) { this.rawUrl = rawUrl; }

	public Long getSize() { return size; }

	public void setSize(Long size) { this.size = size; }

	public String getContent() { return content; }

	public void setContent(String content) { this.content = content; }

}
