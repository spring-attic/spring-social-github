/**
 * 
 */
package org.springframework.social.github.connect;

import org.springframework.util.StringUtils;

/**
 * @author Vinayak Hulawale
 * 
 */
public final class GitHubHostUtils {

    private static final String GITHUB_API_VERSION = "v3";

    private static final String API = "api";

    private static final String HTTPS_PREFIX = "https://";

    public static final String FORWARD_SLASH = "/";

    public static final String DOT = ".";

    public static final String DEFAULT_GITHUB_HOST = "github.com";

    private GitHubHostUtils() {
    }

    public static String getGitHubHost(String gitHubHost) {

        return new StringBuilder(HTTPS_PREFIX)
                .append(StringUtils.hasText(gitHubHost) ? gitHubHost : DEFAULT_GITHUB_HOST)
                .append(GitHubHostUtils.FORWARD_SLASH).toString();

    }

    //returns v3 API
    public static String getGitHubApi(String gitHubHost) {
        if (StringUtils.hasText(gitHubHost))
            return new StringBuilder(HTTPS_PREFIX).append(gitHubHost).append(GitHubHostUtils.FORWARD_SLASH)
                    .append(API).append(FORWARD_SLASH).append(GITHUB_API_VERSION).append(FORWARD_SLASH).toString();
        return new StringBuilder(HTTPS_PREFIX).append(API).append(DOT).append(DEFAULT_GITHUB_HOST)
                .append(GitHubHostUtils.FORWARD_SLASH).toString();
    }

}
