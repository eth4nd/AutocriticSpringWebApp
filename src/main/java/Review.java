public class Review {
    private String review;
    private String userID;
    private String carID;
    private double rating;
    private int likes;
    private int dislikes;

    /**
     * Constructor to create a review object, should be called when user creates and posts a review
     * @param review
     * @param userID
     * @param carID
     * @param rating
     */
    public Review(String review, String userID, String carID, double rating) {
        this.review = review;
        this.userID = userID;
        this.carID = carID;
        this.rating = rating;
        this.likes = 0;
        this.dislikes = 0;
    }

    /**
     * Method to be called when user presses the like button once
     */
    public void incrementLikes() {
        ++this.likes;
    }

    /**
     * Method to be called when user presses the like button twice
     */
    public void decrementLikes() {
        --this.likes;
    }

    /**
     * Method to be called when user presses the dislike button once
     */
    public void incrementDislikes() {
        ++this.dislikes;
    }

    /**
     * Method to be called when the user presses the dislike button twice
     */
    public void decrementDislikes() {
        --this.dislikes;
    }
    @Override
    public String toString() {
        return "Review{review='" +
                this.review + "', " +
                "userID='" +
                this.userID + "', " +
                "carID='" +
                this.carID + "', " +
                "rating=" +
                this.rating +
                ", likes=" +
                this.likes +
                ", dislikes=" +
                this.dislikes + "}";
    }

    /**
     * Getter method for review string
     * @return review
     */
    public String getReview() {
        return this.review;
    }

    /**
     * Getter method for userID
     * @return userID
     */
    public String getUserID() {
        return this.userID;
    }

    /**
     * Getter method for carID
     * @return carID
     */
    public String getCarID() {
        return this.carID;
    }

    /**
     * Getter method for rating
     * @return rating
     */
    public double getRating() {
        return this.rating;
    }

    /**
     * Getter method for likes
     * @return likes
     */
    public int getLikes() {
        return this.likes;
    }

    /**
     * Getter method for dislikes
     * @return dislikes
     */
    public int getDislikes() {
        return this.dislikes;
    }
}

