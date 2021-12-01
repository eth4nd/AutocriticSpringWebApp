package Model.User;
import Model.Review.Review;
import interfaces.Model;


import java.util.*;
public class User implements Model {
    private String username;
    private String password;


    /**
     * Constructor to create User object
     * @param username ysers' username
     * @param password users' password
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Getter method for password
     * @return this.password
     */

    public String getPassword() {
        return this.password;
    }

    /**
     * Deep equals method for User object
     * @param o, User object being compared to this instance of the User
     * @return true if object parameters are the same as o
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return username.equals(user.username) && password.equals(user.password);
    }

    /**
     * Generates hashcode for User object
     * @return output of Objects.hash() of User instance variables
     */
    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }

    /**
     * getter method for username
     * @return this.username
     */

    public String getUsername() {
        return this.username;
    }

    @Override
    public String toString(){
        return "USER: " + this.getUsername() + " PASSWORD: " + this.getPassword();
    }
}