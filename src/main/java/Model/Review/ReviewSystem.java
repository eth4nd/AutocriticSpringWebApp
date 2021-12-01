package Model.Review;

import Model.Car.Car;
import Model.User.User;

public class ReviewSystem {

    public static void inputReview(String review, double rating, User user, Car car)
    {
        Review review1 = new Review(review, user, car, rating);
        car.storeReview(review1);
    }
}
