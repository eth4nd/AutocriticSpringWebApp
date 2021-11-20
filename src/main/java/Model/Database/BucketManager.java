package Model.Database;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.Bucket;

import java.util.List;

public class BucketManager {
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
    public static void main(String[] args){
        BucketManager b = new BucketManager();
        b.listAllBuckets();
//        b.createBucket("newbucket111111112398471239487123908");
//        b.deleteBucket("newbucket111111112398471239487123908");
    }
}
