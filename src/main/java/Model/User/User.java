package Model.User;
import Model.Review.Review;


import java.util.*;
public class User{
    private String username;
    private String password;
    private ArrayList<Review> userReviews = new ArrayList<>();


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
        return username.equals(user.username) && password.equals(user.password) && userReviews.equals(user.userReviews);
    }

    /**
     * Generates hashcode for User object
     * @return output of Objects.hash() of User instance variables
     */
    @Override
    public int hashCode() {
        return Objects.hash(username, password, userReviews);
    }

    /**
     * getter method for username
     * @return this.username
     */

    public String getUsername() {
        return this.username;
    }

    /**
     * stores users reviews in userReviews arraylist
     * @param r, users' new review on a car
     */
    public void storeReview(Review r)
    {
        userReviews.add(r);
    }

    /**
     * getter method for userReviews arraylist
     * @return userReviews
     */

    public ArrayList<Review> getReviews()
    {
        return this.userReviews;
    }

    @Override
    public String toString(){
        return this.getUsername();
    }
}