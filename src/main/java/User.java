package userprofile;
import java.util.*;
public class User {
    private UUID userID;
    private String username;
    private int password;

    /**
     * Constructor for User objects
     * @param userID The ID of the User
     * @param username The User's username
     * @param password The User's password
     */
    public User(UUID userID, String username, int password){
        if (password < -1 || password > 999999999) {
            throw new IllegalArgumentException("Password is invalid; not within set boundary");
        }
        this.userID = userID;
        this.password = password;
        this.username = username;
    }

    /**
     * Getter method for password
     * @return password
     */
    public int getPassword() {
        return password;
    }

    /**
     * Getter method for username
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Getter method for userID
     * @return userID
     */
    public UUID getUserID() {
        return userID;
    }

    /**
     * Deep equals method for User objects
     * @param o User object
     * @return True if contains same password, userID, and username
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return password == user.password && Objects.equals(userID, user.userID) && Objects.equals(username, user.username);
    }

    /**
     * HashCode method that generates a hashCode based on userID, username, and password
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(userID, username, password);
    }
}