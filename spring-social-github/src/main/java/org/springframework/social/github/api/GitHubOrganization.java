/*
 * Copyright 2013-2014 the original author or authors.
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

/**
 * A GitHub organization
 * 
 * @author Michał Łoza (michal@mloza.pl)
 */
@SuppressWarnings("serial")
public class GitHubOrganization implements Serializable {

	private final long id;

	private final String url;

	private final String login;

	private final String avatarUrl;

	private final String description;

    public GitHubOrganization(long id, String url, String login, String avatarUrl, String description) {
        this.id = id;
        this.url = url;
        this.login = login;
        this.avatarUrl = avatarUrl;
        this.description = description;
    }

    public long getId() { return id; }
	
	public String getUrl() { return url; }

	public String getLogin() { return login; }

	public String getAvatarUrl() { return avatarUrl; }

	public String getDescription() { return description; }

}
