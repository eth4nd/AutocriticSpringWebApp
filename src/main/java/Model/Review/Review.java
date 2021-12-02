package Model.Review;


import Model.Car.Car;
import Model.User.User;


public class Review {
    private String review;
    private String userName;
    private String carName;
    private double rating;

    /**
     * Constructor to create Review object
     * @param review review for car
     * @param username username of account for review
     * @param carname carname of car being reviewed
     * @param rating rating for the car review
     */
    public Review(String carname, String username,String review, double rating) {
        this.review = review;
        this.userName = username;
        this.carName = carname;
        this.rating = rating % 6.0;
    }

    public Review(){

    }

    @Override
    /**
     * output of the review in String form
     */
    public String toString() {
        return review + "," + userName + "," + carName + "," + rating;
    }

    /**
     * output of car review
     * @return this.review
     */
    public String getReview() {
        return this.review;
    }

    /**
     * getter method of the userName that wrote the review
     * @return this.userName
     */
    public String getUser() {
        return this.userName;
    }

    /**
     * getter method of associated carName with review
     * @return this.car
     */
    public String getCar() {
        return this.carName;
    }

    /**
     * getter method of rating for car review
     * @return this.rating
     */
    public double getRating() {
        return this.rating;
    }

}



