package Model.Review;


import Model.Car.Car;
import Model.Database.BucketManager;
import Model.User.User;

import Model.User.UserDatabase;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class ReviewUnitTest {

    /* @Test
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
    } */
    @Test
    public void testReviewClass(){
        Review review = new Review("Tesla Model X", "John", "This is a review", 4);
        String car = "Tesla Model X";
        String user = "John";
        String reviewTest = "This is a review";
        double rating = 4;
        assertEquals(review.getRating(), 4, 0.01);
        assertEquals("reviewTest does not match with review",reviewTest, review.getReview());
        assertEquals("user does not match",review.getUser(),user);
        assertEquals("car does not match",review.getCar(),car);


    }
    @Test
    public void testReviewDatabaseDownloadReview(){
        BucketManager b = new BucketManager();
        ReviewDatabase reviewDatabase = new ReviewDatabase();
        List<Review> listOfDownloadedReviews = reviewDatabase.downloadReview("placeholder",b.getS3Database(),3);
        assertTrue(listOfDownloadedReviews.size()<=3);
    }
}
