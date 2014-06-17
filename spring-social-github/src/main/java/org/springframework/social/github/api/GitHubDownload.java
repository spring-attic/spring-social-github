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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A GitHub download.
 * 
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 * @author Andy Wilkinson
 */
@SuppressWarnings("serial")
public class GitHubDownload implements Serializable {

	private final long id;

	private final String url;

	private final String htmlUrl;

	private final String name;

	private final String description;

	private final long size;

	private final int downloadCount;

	private final String contentType;

    public GitHubDownload(long id, String url, String htmlUrl, String name, String description, long size,
            int downloadCount, String contentType) {
        this.id = id;
        this.url = url;
        this.htmlUrl = htmlUrl;
        this.name = name;
        this.description = description;
        this.size = size;
        this.downloadCount = downloadCount;
        this.contentType = contentType;
    }

    public long getId() { return id; }

	public String getUrl() { return url; }

	public String getHtmlUrl() { return htmlUrl; }

	public String getName() { return name; }

	public String getDescription() { return description; }

	public long getSize() { return size; }

	public int getDownloadCount() { return downloadCount; }

	public String getContentType() { return contentType; }
}
