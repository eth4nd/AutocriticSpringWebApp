package Model.Review;


import Model.Car.Car;
import Model.User.User;


public class Review {
    private String review;
    private User user;
    private Car car;
    private double rating;

    public Review(String review, User user, Car car, double rating) {
        this.review = review;
        this.user = user;
        this.car = car;
        this.rating = rating % 6.0;
    }


    @Override
    public String toString() {
        return "Rating: "  + rating + ", Review: " + review + " User: " + user.getUsername();
    }

    public String getReview() {
        return this.review;
    }


    public User getUser() {
        return this.user;
    }

    public Car getCar() {
        return this.car;
    }

    public double getRating() {
        return this.rating;
    }

}

