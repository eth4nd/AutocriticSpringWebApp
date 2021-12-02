package RestApi.datastore;

import Model.Database.BucketManager;
import Model.Review.Review;
import Model.Review.ReviewDatabase;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class ReviewRepository {

    private List<Review> REVIEWS;

    public ReviewRepository(){
        BucketManager bucketManager = new BucketManager();
        ReviewDatabase reviewDatabase = new ReviewDatabase();
        //load reviews into the review repository for frontend
        REVIEWS = reviewDatabase.downloadReview("placeholder", bucketManager.getS3Database(),100);

    }

    public List<Review> getReviews(){
        return REVIEWS;
    }
}

