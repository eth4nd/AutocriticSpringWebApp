package Model.User;
import Model.Review.Review;


import java.util.*;
public class User {
    private String username;
    private String password;
    private ArrayList<Review> userReviews = new ArrayList<>();


    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return username.equals(user.username) && password.equals(user.password) && userReviews.equals(user.userReviews);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, userReviews);
    }

    public String getUsername() {
        return username;
    }
    //Called when user inputs a review on a particular
    public void storeReview(Review r)
    {
        userReviews.add(r);
    }

    public ArrayList<Review> getReviews()
    {
        return userReviews;
    }
}