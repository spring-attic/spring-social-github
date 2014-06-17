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

import java.util.Date;

/**
 * A GitHub issue
 *
 * @author Greg Turnquist
 * @author Andy Wilkinson
 */
@SuppressWarnings("serial")
public class GitHubIssue {

	private final int number;

	private final String url;

	private final String htmlUrl;

    private final Date closedAt;

    private final Date createdAt;

    private final Date updatedAt;

	private String state;

	private String title;

	private String body;

	private GitHubUser assignee;

    public GitHubIssue(int number, String url, String htmlUrl, Date closedAt, Date createdAt, Date updatedAt) {
        this.number = number;
        this.url = url;
        this.htmlUrl = htmlUrl;
        this.closedAt = closedAt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getNumber() {
		return number;
	}

	public String getUrl() {
		return url;
	}

    public Date getClosedAt() {
        return closedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

	public String getHtmlUrl() {
		return htmlUrl;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public GitHubUser getAssignee() {
		return assignee;
	}

	public void setAssignee(GitHubUser assignee) {
		this.assignee = assignee;
	}
}
