package RestApi.review;

import Model.Database.BucketManager;
import Model.Review.Review;
import Model.Review.ReviewDatabase;
import Model.User.User;
import Model.User.UserDatabase;
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
    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService){
        this.reviewService = reviewService;
    }

    @GetMapping
    public List<Review> getReview()
    {
        return reviewService.getReviews();
    }

    public static void setUser(User user){
        ReviewController.user = user;
    }

    //grabs Review data from frontend
    @PostMapping(path="upload",
            consumes = MediaType.APPLICATION_JSON_VALUE, //grabs a datatype from front end and
            produces = MediaType.APPLICATION_JSON_VALUE //produces a datatype in back end
    )
    public void saveReview(@RequestBody LinkedHashMap data){
        UserDatabase userDatabase = new UserDatabase();
        BucketManager b = new BucketManager();
        LinkedHashMap<String,String> element = data;
        ReviewDatabase reviewDatabase = new ReviewDatabase();

//        System.out.println(data.getClass());
//        System.out.println("Username: " + user.getUsername());
//        System.out.println(data.get("car"));
//        System.out.println(data.get("review"));
        reviewDatabase.append
                ((String)data.get("car"),user.getUsername(),(String)data.get("review"),"placeholder",b.getS3Database());
    }

}


