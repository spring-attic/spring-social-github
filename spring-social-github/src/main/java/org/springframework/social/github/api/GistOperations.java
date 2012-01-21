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

import java.util.List;

/**
 * Interface defining the operations for working with GitHub gists.
 * 
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
public interface GistOperations {
	
	/**
	 * Public operation to return the given user's public gists.
	 * 
	 * @param user GitHub user
	 * @return list of user's gists
	 */
	List<GitHubGist> getUserGists(String user);
}
