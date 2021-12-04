package Model.Review;

import Model.Car.Car;
import Model.User.User;

/**
 * Test for inputting reviews
 */
public class ReviewSystem {

    /**
     * inputs a new review with parameters
     * @param review input review
     * @param rating input rating
     * @param username input username
     * @param carname input car name
     */
    public static void inputReview(String review, double rating, String username, String carname) {
        Review review1 = new Review(review, username, carname, rating);
    }
}
