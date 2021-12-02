package RestApi.review;
import Model.Review.Review;
import RestApi.datastore.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReviewDataAccess {

    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewDataAccess(ReviewRepository reviewRepository){
        this.reviewRepository = reviewRepository;
    }
    public List<Review> getReviews(){
        return reviewRepository.getReviews();
    }
}