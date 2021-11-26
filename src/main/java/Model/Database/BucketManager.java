package Model.Database;

import Model.User.User;
import Model.User.UserDatabase;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.BucketAccelerateConfiguration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BucketManager {
    public static final String bucketName = "cs151projectautocritictest";
    private final AmazonS3 s3;
    public BucketManager(){
        AWSCredentials awsCredentials = new BasicAWSCredentials(
                "AKIAQNUHEPFEGYHK6KU6", "46fiA27SLsAU0zp7N6TgmOYJ7hV7xKZXdS/Gx/lP"
        );

        //initiate Amazon s3 client database
        this.s3 = AmazonS3ClientBuilder.standard()
                .withRegion("us-west-1")
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();
    }

    public AmazonS3 getS3Database(){
        return s3;
    }

    public void listAllBuckets(){
        List<Bucket> buckets = this.s3.listBuckets();
        System.out.println("Buckets:");
        for(Bucket b: buckets){
            System.out.println("* " + b.getName());
        }
    }
    public void createBucket(String name){
        try{
            s3.createBucket(name);
        }catch(AmazonS3Exception e){
            System.out.println("Bucket failed to create");
            System.err.println(e.getErrorMessage());
        }
    }
    public void deleteBucket(String name){
        try{
            s3.deleteBucket(name);
        }catch(AmazonServiceException e){
            System.out.println("BucketDelete failed");
            System.err.println(e.getErrorMessage());
        }
    }

    //test
    public static void main(String[] args) throws IOException {
        BucketManager b = new BucketManager();
        FileManager f = new FileManager();
        File users = new File(UserDatabase.LocalFilename);
        User user = new User("mary","pass3");
        UserDatabase userDatabase = new UserDatabase();


        b.listAllBuckets();
        //f.deleteFileFromBucket(BucketManager.bucketName,UserDatabase.Filename);
//        b.createBucket("cs151projectautocritictest");
//        b.listAllBuckets();
        //b.deleteBucket("newbucket111111112398471239487123908");
        userDatabase.insert(user,"test",b.getS3Database());
        //f.insertFileIntoBucket(BucketManager.bucketName, UserDatabase.Filename,users);
        f.printFileFromBucket(BucketManager.bucketName,UserDatabase.Filename);
        //userDatabase.downloadUserFile(b.getS3Database());
        List<User> listOfUsers =  userDatabase.downloadUser("placeholder", b.getS3Database(),100);
        for(User u :listOfUsers){
            System.out.println(u);
        }
        System.out.println("done");
    }
}
