package Model.Database;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

import java.io.*;
import java.util.List;

public class FileManager {
    private final AmazonS3 s3;

    public FileManager() {
        AWSCredentials awsCredentials = new BasicAWSCredentials(
                "AKIAQNUHEPFEGYHK6KU6", "46fiA27SLsAU0zp7N6TgmOYJ7hV7xKZXdS/Gx/lP"
        );

        //initiate Amazon s3 client database
        this.s3 = AmazonS3ClientBuilder.standard()
                .withRegion("us-west-1")
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();
    }

    public void insertFileIntoBucket(String bucketName, String filename,File insertFile){
        System.out.println("Inserting file " + insertFile + " from bucket " + bucketName +" as " + filename + "...");
        try{
            this.s3.putObject(bucketName,filename,insertFile);
        }catch(AmazonServiceException e){
            System.out.println("Failed inserting file " + filename + " into bucket " + bucketName);
            System.err.println(e.getErrorMessage());
            System.exit(1);
        }
    }

    public void printFileFromBucket(String bucketName, String fileName){
        System.out.println("Reading from file " + fileName + " from bucket " + bucketName +"...");
        //Read file from bucket
        S3Object object = s3.getObject((new GetObjectRequest(bucketName, fileName)));
        //InputStream objectData = object.getObjectContent(); //???
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(object.getObjectContent())); //create Buffer reader to read from file
            String lineRead;
            while ((lineRead = reader.readLine()) != null) {
                System.out.println(lineRead);
            }
            //objectData.close(); // ???
        } catch (IOException e) {
            System.out.println("Could not read from file");
            e.printStackTrace();
        }
    }

    public void deleteFileFromBucket(String bucketName,String fileName ){
        //delete file within bucket
        try{
            s3.deleteObject(bucketName, fileName);
        }catch(AmazonServiceException e){
            System.out.println("delete failed");
            System.exit(1);
        }
    }
}
