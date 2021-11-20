package com.autocritic.autocriticspringbootproj.profile;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public class UserProfile {

    private UUID userProfileId;
    private String username;
    private String userProfileImageLink; // S3 key

    /**
     * Constructor for UserProfile objects
     * @param userProfileId the profileId for the User
     * @param username the username of the User
     * @param userProfileImageLink the User's profile image
     */
    public UserProfile(UUID userProfileId, String username, String userProfileImageLink) {
        this.userProfileId = userProfileId;
        this.username = username;
        this.userProfileImageLink = userProfileImageLink;
    }

    /**
     * Getter method for userProfileID
     * @return userProfileID
     */
    public UUID getUserProfileId() {
        return userProfileId;
    }

    /**
     * Setter method for userProfileID
     */
    public void setUserProfileId(UUID userProfileId) {
        this.userProfileId = userProfileId;
    }

    /**
     * Getter method for username
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setter method for username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Getter method for userProfileImageLink
     * @return Optional<String> userProfileImageLink
     */
    public Optional<String> getUserProfileImageLink() {
        return Optional.ofNullable(userProfileImageLink);
    }

    /**
     * Setter method for userProfileImageLink
     */
    public void setUserProfileImageLink(String userProfileImageLink) {
        this.userProfileImageLink = userProfileImageLink;
    }

    /**
     * Deep equals method for UserProfile objects
     * @return True if userProfileId, username, and userProfileImageLink are the same
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserProfile that = (UserProfile) o;
        //Objects.equals does null check
        return Objects.equals(userProfileId, that.userProfileId) &&
                Objects.equals(username, that.username) &&
                Objects.equals(userProfileImageLink, that.userProfileImageLink);
    }

    /**
     * HashCode method that generates a hashCode based on userProfileId, username, and userProfileImageLink
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(userProfileId, username, userProfileImageLink);
    }
}
