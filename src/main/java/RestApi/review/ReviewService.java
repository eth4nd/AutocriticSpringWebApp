package RestApi.review;

import Model.Review.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private ReviewDataAccess reviewDataAccess;

    @Autowired
    public ReviewService(ReviewDataAccess reviewDataAccess){
        this.reviewDataAccess = reviewDataAccess;
    }
    List<Review> getReviews(){
        return reviewDataAccess.getReviews();
    }

}
