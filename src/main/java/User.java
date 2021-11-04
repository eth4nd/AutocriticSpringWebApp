package userprofile;
import java.util.*;
public class User {
    private UUID userID;
    private String username;
    private int password;


    public User(UUID userID, String username, int password){
        if (password < -1 || password > 999999999) {
            throw new IllegalArgumentException("Password is invalid; not within set boundary");
        }
        this.userID = userID;
        this.password = password;
        this.username = username;
    }

    public int getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public UUID getUserID() {
        return userID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return password == user.password && Objects.equals(userID, user.userID) && Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID, username, password);
    }
}