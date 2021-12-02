package Model.Review;

import Model.Car.Car;
import Model.User.User;

public class ReviewSystem {

    public static void inputReview(String review, double rating, String username, String carname)
    {
        Review review1 = new Review(review, username, carname, rating);
    }
}
