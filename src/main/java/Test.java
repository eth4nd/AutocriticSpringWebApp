
import com.amazonaws.*;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

import java.io.*;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {
        System.out.println("hello");


        //delcare AWS credentials
        AWSCredentials awsCredentials = new BasicAWSCredentials(
                "AKIAQNUHEPFEGYHK6KU6", "46fiA27SLsAU0zp7N6TgmOYJ7hV7xKZXdS/Gx/lP"
        );

        //initiate Amazon s3 client database
        AmazonS3 s3 = AmazonS3ClientBuilder.standard()
                .withRegion("us-west-1")
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();

        //create bucket
        String bucket_name = "test12345234123423523465bnsidlfghjilds";

        try {
            s3.createBucket(bucket_name);
        } catch (AmazonS3Exception e) {
            System.out.println(e.getErrorMessage());
        }

        //list out buckets
        List<Bucket> buckets = s3.listBuckets();
        for (Bucket b : buckets) {
            System.out.println("* " + b.getName());
        }
        //create file
        File f1 = new File("filename.txt");
        f1.createNewFile();
        //write file
        try {
            FileWriter myWriter = new FileWriter(f1);
            myWriter.write("successfully written into file.");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("could not write into file!");
            e.printStackTrace();
        }

        //put file into bucket
        String fileName = "test1"; //fileName in bucket
        try {
            s3.putObject(bucket_name, fileName, f1);
        } catch (AmazonServiceException e) {
            System.err.println(e.getErrorMessage());
            System.exit(1);
        }

        //Read file from bucket
        S3Object object = s3.getObject((new GetObjectRequest(bucket_name, fileName)));
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
}

