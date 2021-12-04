package Model.Review;
import Model.Database.BucketManager;
import com.amazonaws.services.s3.model.GetObjectRequest;
import Model.Database.FileManager;
import com.amazonaws.services.s3.AmazonS3;
import interfaces.Model;
import interfaces.ModelDatabase;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Review database model class that represents a database that stores Review objects
 * There is a local database for demonstration purposes and an AWS database
 * {@value #LocalFilename} name of local file
 * {@value #Filename} name of file in S3 bucket
 */
public class ReviewDatabase implements ModelDatabase{
    public static final String LocalFilename = "Reviews.txt"; //local file name
    public static final String Filename = "REVIEWS"; //file name in s3 bucket database

    private HashMap<String, Review> cache = new HashMap<>();

    // Stores user object with its username as the key value
    // Should be called when user wants to create a new account

    // returns true if the user exists in the database, or false if it doesn't
    // Should be called when user wants to sign in

    /**
     * creates a new local file
     * @return local file
     */
    public File createLocalFile(){
        File local = new File(ReviewDatabase.LocalFilename);
        try{
            local.createNewFile();
        }catch(IOException e){
            e.printStackTrace();
        }
        return local;
    }

    /**
     * downloads the review database from the AWS database
     * @param s3 the AmazonS3 bucket
     */
    public void downloadReviewFile(AmazonS3 s3){
        s3.getObject(
                new GetObjectRequest(BucketManager.bucketName, ReviewDatabase.Filename),
                new File(ReviewDatabase.LocalFilename)
        );
    }

    /**
     * does nothing, but is required by ModelDatabase interface
     * @param user the user
     * @param Filename file to delete
     * @param s3 the AmazonS3 bucket
     */
    @Override
    public void delete(Model user, String Filename,AmazonS3 s3) {

    }

    /**
     * insert review into file and store it in AWS database
     * @param review review object
     * @param Filename the file to insert
     * @param s3 the AmazonS3 bucket
     */
    @Override
    public void insert(Model review, String Filename,AmazonS3 s3) {
        FileManager fm = new FileManager();
        BufferedWriter out = null;
        if(!(review instanceof Review))
        {
            System.out.println("wrong model class");
            return;
        }
        Review r = (Review) review;

        try{
            //reviews.createNewFile();
            File reviews = new File("Reviews.txt");
            FileWriter myWriter = new FileWriter(reviews,true);
            out = new BufferedWriter(myWriter);

            //write review into file


            out.write(String.format("%s|%s|%s|\r\n","carName","username","review"));


            //close loose ends
            out.close();
            myWriter.close();

            //insert file back into database
            fm.insertFileIntoBucket(BucketManager.bucketName, ReviewDatabase.Filename,reviews);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * appends anything into the file
     * @param carName name of the car
     * @param username username of user
     * @param review review for the car
     * @param Filename file that is stored
     * @param s3 the AmazonS3 bucket
     */
    public void append(String carName, String username, String review, String Filename,AmazonS3 s3) {
        FileManager fm = new FileManager();
        BufferedWriter out = null;
        try{
            //reviews.createNewFile();
            File reviews = new File("Reviews.txt");
            FileWriter myWriter = new FileWriter(reviews,true);
            out = new BufferedWriter(myWriter);

            //write review into file

            out.write(String.format(";%s;%s;%s\r\n",carName,username,review));


            //close loose ends
            out.close();
            myWriter.close();

            //insert file back into database
            fm.insertFileIntoBucket(BucketManager.bucketName, ReviewDatabase.Filename,reviews);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * does nothing but is required by ModelDatabase interface
     * @param review the review
     * @param Filename the file to take from
     * @param s3 the AmazonS3 bucket
     */
    @Override
    public void take(Model review, String Filename,AmazonS3 s3) {

    }

    /**
     * downloads a text file of reviews from aws s3 database
     * @param Filename the file to read from
     * @param s3 the AmazonS3 bucket
     * @param amount the total number of review downloaded from the local/AWS database
     * @return an ArrayList of Review objects
     */
    public List<Review> downloadReview(String Filename,AmazonS3 s3,int amount){
        String review = "";
        String user = "";
        String car = "";
        List<Review> listOfReviews = new ArrayList<>();
        System.out.println("Downloading " + amount+ " reviews " +  " from " + ReviewDatabase.LocalFilename);

        try{
            File reviews = new File(ReviewDatabase.LocalFilename);
            Scanner sc = new Scanner(reviews);
            sc.useDelimiter(";");
            System.out.println(sc.nextLine());
            for(int i = 0;i<amount;i++){
                //if there's no more car found in database, return list
                if(!sc.hasNextLine()){
                    System.out.println("End of database spotted. Returning list...");
                    return listOfReviews;
                }
                System.out.println("initializing vars...");
                //initiate values to make review objects
                car = sc.next();
                user = sc.next();
                review = sc.next();
                System.out.println("end of initializing vars...");
//                System.out.println("Car: " +car);
//                System.out.println("User: " +user);
//                System.out.println("Review: " + review);
                System.out.println("Adding car to list...");
                listOfReviews.add(new Review(car,user,review,0));
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("Returning list...");
        return listOfReviews;
    }


}

