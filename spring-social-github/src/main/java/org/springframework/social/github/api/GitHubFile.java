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
 * A GitHub file.
 * 
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 * @author Andy Wilkinson
 */
@SuppressWarnings("serial")
public class GitHubFile implements Serializable {

    private final String type;

    private final String language;

    private final String rawUrl;

    private final long size;

    private String filename;

    private String content;

    public GitHubFile(String type, String language, String rawUrl, long size) {
        this.type = type;
        this.language = language;
        this.rawUrl = rawUrl;
        this.size = size;
    }

    public String getType() { return type; }

    public String getLanguage() { return language; }

    public String getRawUrl() { return rawUrl; }

    public long getSize() { return size; }

    public String getFilename() { return filename; }

	public void setFilename(String filename) { this.filename = filename; }

	public String getContent() { return content; }

	public void setContent(String content) { this.content = content; }
}
