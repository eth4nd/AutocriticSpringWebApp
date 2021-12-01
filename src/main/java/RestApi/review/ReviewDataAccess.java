package RestApi.review;

import Model.Review.Review;
import RestApi.datastore.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReviewDataAccess<ReviewRepository> {

    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewDataAccess(ReviewRepository reviewRepository){
        this.reviewRepository = reviewRepository;
    }
    //List<Review> getReviews(){
        //return reviewRepository.getReviews();
    //}
}