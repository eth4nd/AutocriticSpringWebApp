package Model.Review;


import Model.Car.Car;
import Model.User.User;

import org.junit.jupiter.api.Test;


import static org.junit.Assert.assertEquals;


public class ReviewUnitTest {

    @Test
    public void testReviewPackage()
    {
        User testUser = new User("test_user", "1");
        Car testCar = new Car("Toyota Prius 2021", 12000);
        String review = "nice, reliable, and efficient";
        double rating = 4.65;
        ReviewSystem.inputReview(review, rating, testUser, testCar);
        assertEquals(testCar.getAverageRating(), 4.65, 0.01);
        assertEquals("Review message does not match with user", review, testUser.getReviews().get(0).getReview());
        assertEquals(testUser.getReviews().get(0).getRating(), 4.65, 0.0);
    }


}
