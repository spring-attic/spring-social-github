package org.springframework.social.github.api;

import java.util.List;

/**
 * Interface defining the operations for working with GitHub organizations.
 *
 * @author Michał Łoza (michal@mloza.pl)
 */
public interface OrganizationOperations {

    GitHubOrganization getOrganization(String organizationName);

    List<GitHubRepo> getOrganizationRepositories(String organizationName);

}
