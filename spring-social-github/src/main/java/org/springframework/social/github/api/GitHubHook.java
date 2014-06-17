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
 * A GitHub hook. Hooks share commits with other apps, such as Bamboo, Basecamp, e-mail and so forth.
 * 
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 * @author Andy Wilkinson
 */
@SuppressWarnings("serial")
public class GitHubHook implements Serializable {

	private final long id;

	private final String name;

	private final String url;

    private final Date createdAt;

    private final Date updatedAt;

	private boolean active;

    public GitHubHook(long id, String name, String url, Date createdAt, Date updatedAt) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public long getId() { return id; }
	
	public String getName() { return name; }
	
	public String getUrl() { return url; }

	public Date getCreatedAt() { return createdAt; }

	public Date getUpdatedAt() { return updatedAt; }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
