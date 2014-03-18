/*
 * Copyright 2014 the original author or authors.
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
package org.springframework.social.github.api.impl.json;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.social.github.api.*;

/**
 * Jackson module for setting up mixin annotations on GitHub model types.
 *
 * @author Andy Wilkinson
 */
public class GitHubModule extends SimpleModule {

    public GitHubModule() {
        super("GitHubModule");
    }

    @Override
    public void setupModule(SetupContext context) {
        context.setMixInAnnotations(GitHubComment.class, GitHubCommentMixin.class);
        context.setMixInAnnotations(GitHubCommit.class, GitHubCommitMixin.class);
        context.setMixInAnnotations(GitHubDownload.class, GitHubDownloadMixin.class);
        context.setMixInAnnotations(GitHubFile.class, GitHubFileMixin.class);
        context.setMixInAnnotations(GitHubGist.class, GitHubGistMixin.class);
        context.setMixInAnnotations(GitHubHook.class, GitHubHookMixin.class);
        context.setMixInAnnotations(GitHubIssue.class, GitHubIssueMixin.class);
        context.setMixInAnnotations(GitHubRepo.class, GitHubRepoMixin.class);
        context.setMixInAnnotations(GitHubUser.class, GitHubUserMixin.class);
        context.setMixInAnnotations(GitHubUserProfile.class, GitHubUserProfileMixin.class);
    }
}
