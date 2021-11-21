package Model.Review;


import Model.Car.Car;
import Model.User.User;


public class Review {
    private String review;
    private User user;
    private Car car;
    private double rating;

    /**
     * Constructor to create Review object
     * @param review review for car
     * @param user user account for review
     * @param car car being reviewed
     * @param rating rating for the car review
     */
    public Review(String review, User user, Car car, double rating) {
        this.review = review;
        this.user = user;
        this.car = car;
        this.rating = rating % 6.0;
    }


    @Override
    /**
     * output of the review in String form
     */
    public String toString() {
        return "Rating: "  + rating + ", Review: " + review + " User: " + user.getUsername();
    }

    /**
     * output of car review
     * @return this.review
     */
    public String getReview() {
        return this.review;
    }

    /**
     * getter method of associated user for car review
     * @return this.user
     */
    public User getUser() {
        return this.user;
    }

    /**
     * getter method of associated car for car review
     * @return this.car
     */
    public Car getCar() {
        return this.car;
    }

    /**
     * getter method of rating for car review
     * @return this.rating
     */
    public double getRating() {
        return this.rating;
    }

}

