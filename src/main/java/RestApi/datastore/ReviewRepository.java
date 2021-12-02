package RestApi.datastore;

import Model.Database.BucketManager;
import Model.Review.Review;
import Model.Review.ReviewDatabase;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class ReviewRepository {

    private List<Review> REVIEWS;
    private ReviewDatabase reviewDatabase;
    private BucketManager bucketManager;

    public ReviewRepository(){
        bucketManager = new BucketManager();
        reviewDatabase = new ReviewDatabase();
        //load reviews into the review repository for frontend
        REVIEWS = reviewDatabase.downloadReview("placeholder", bucketManager.getS3Database(),100);

    }

    public List<Review> getReviews(){
        REVIEWS = reviewDatabase.downloadReview("placeholder", bucketManager.getS3Database(),100);

        return REVIEWS;
    }
}

