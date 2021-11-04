import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ReviewUnitTest {

    Review userReview = new Review("Good car","username4124","Car3412",4.5);

    /**
     * UnitTest for increment and decrement likes
     */
    @Test
    public void testLikeSystem()
    {

        assertEquals("expected like: 0",0,userReview.getLikes());
        userReview.incrementLikes();
        assertEquals("expected likes: 1", 1,userReview.getLikes());
        userReview.decrementLikes();
        assertEquals("expected likes: 0",0, userReview.getLikes());
    }

    /**
     * UnitTest for increment and decrement dislikes
     */
    @Test
    public void testDislikeSystem()
    {
        assertEquals("expected dislikes: 0", 0, userReview.getDislikes());
        userReview.incrementDislikes();
        assertEquals("expected dislikes: 1", 1, userReview.getDislikes());
        userReview.decrementDislikes();
        assertEquals("expected dislikes: 0", 0, userReview.getDislikes());
    }


}