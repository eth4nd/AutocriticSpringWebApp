package Model.Review;
import Model.Database.BucketManager;
import com.amazonaws.services.s3.model.GetObjectRequest;
import Model.Database.FileManager;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.lookoutequipment.model.S3Object;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import interfaces.Model;
import interfaces.ModelDatabase;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
public class ReviewDatabase implements ModelDatabase{
    public static final String LocalFilename = "Reviews.txt"; //local file name
    public static final String Filename = "REVIEWS"; //file name in s3 bucket database

    private HashMap<String, Review> cache = new HashMap<>();

    // Stores user object with its username as the key value
    // Should be called when user wants to create a new account

    // returns true if the user exists in the database, or false if it doesn't
    // Should be called when user wants to sign in

    public void createLocalFile(){
        File local = new File(ReviewDatabase.LocalFilename);
        try{
            local.createNewFile();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    //download user database
    public void downloadUserFile(AmazonS3 s3){
        s3.getObject(
                new GetObjectRequest(BucketManager.bucketName, ReviewDatabase.Filename),
                new File(ReviewDatabase.LocalFilename)
        );
    }

    @Override
    public void delete(Model user, String Filename,AmazonS3 s3) {

    }

    //insert review into file and store it in AWS database
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
            out.write(review.toString()+"\n");

            //close loose ends
            out.close();
            myWriter.close();

            //insert file back into database
            fm.insertFileIntoBucket(BucketManager.bucketName, ReviewDatabase.Filename,reviews);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void take(Model review, String Filename,AmazonS3 s3) {

    }

    //download a text file of reviews from aws s3 database
    public List<Review> downloadReview(String Filename,AmazonS3 s3,int amount){
        List<Review> listOfReviews = new ArrayList<>();
        System.out.println("Downloading " + amount+ " reviews " +  " from " + ReviewDatabase.LocalFilename);

        try{
            File reviews = new File(ReviewDatabase.LocalFilename);
            Scanner sc = new Scanner(reviews);
            System.out.println(sc.nextLine());
            for(int i = 0;i<amount;i++){
                if(!sc.hasNext()){
                    return listOfReviews;
                }
                listOfReviews.add(new Review(sc.next(),sc.next()));

            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return listOfReviews;
    }


}
