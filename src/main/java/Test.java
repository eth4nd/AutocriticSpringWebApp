
import com.amazonaws.*;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.AmazonS3;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {
        System.out.println("hello");




        //delcare AWS credentials
        AWSCredentials awsCredentials = new BasicAWSCredentials(
                "AKIAQNUHEPFEGYHK6KU6","46fiA27SLsAU0zp7N6TgmOYJ7hV7xKZXdS/Gx/lP"
        );

        //initiate Amazon s3 client database
        AmazonS3 s3 = AmazonS3ClientBuilder.standard()
                .withRegion("us-west-1")
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();

        //create bucket
        String bucket_name = "test12345234123423523465bnsidlfghjilds";

        try{
            s3.createBucket(bucket_name);
        }
        catch(AmazonS3Exception e){
            System.out.println(e.getErrorMessage());
        }

        //list out buckets
        List<Bucket> buckets = s3.listBuckets();
        for(Bucket b:buckets){
            System.out.println("* " + b.getName());
        }
        //create file and put into bucket
        File f1 = new File("filename.txt");
        f1.createNewFile();
        try{
            s3.putObject(bucket_name, "test1",f1);
        }catch(AmazonServiceException e){
            System.err.println(e.getErrorMessage());
            System.exit(1);
        }


   }
}

