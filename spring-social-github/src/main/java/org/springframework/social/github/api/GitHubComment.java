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
 * A GitHub comment.
 * 
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 * @author Andy Wilkinson
 */
@SuppressWarnings("serial")
public class GitHubComment implements Serializable {

    private final long id;

    private final String url;

    private final GitHubUser user;

    private final Date createdAt;

    private final Date updatedAt;

    private volatile String body;

    public GitHubComment(long id, String url, GitHubUser user, Date createdAt, Date updatedAt) {
        this.id = id;
        this.url = url;
        this.user = user;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public long getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public GitHubUser getUser() {
        return user;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
