package RestApi.review;

import Model.Review.Review;
import Model.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;

@RestController
@RequestMapping("api/v1/review")
@CrossOrigin("*")
public class ReviewController {
    private static User user;
//    private final ReviewService reviewService;
//
//    @Autowired
//    public ReviewController(ReviewService reviewService){
//        this.reviewService = reviewService;
//    }
//
//    @GetMapping
//    public List<Review> getReview()
//    {
//        return reviewService.getReviews();
//    }
    public static void setUser(User user){
        ReviewController.user = user;
    }

    //grabs Review data from frontend
    @PostMapping(path="upload",
            consumes = MediaType.APPLICATION_JSON_VALUE, //grabs a datatype from front end and
            produces = MediaType.APPLICATION_JSON_VALUE //produces a datatype in back end
    )
    public void saveReview(@RequestBody LinkedHashMap data){
        LinkedHashMap<String,String> element = data;
        System.out.println(data.getClass());
        System.out.println(data.get("review"));
    }

}
