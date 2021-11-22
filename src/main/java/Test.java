
import Model.User.User;
import com.amazonaws.*;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.services.iotevents.model.Input;
import com.amazonaws.services.mq.model.NotFoundException;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;
import com.amazonaws.services.s3.AmazonS3;


import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


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
        /*
        //delete file within bucket
        try{
            s3.deleteObject(bucket_name, fileName);
        }catch(AmazonServiceException e){
            System.out.println("delete failed");
            System.exit(1);
        }

         */

        //write object into file
        String fileName2 = "objectsTest";
        User u1 = new User( "user1", "test1" );
        User u2 = new User("user2", "test1" );
        User u3 = new User("user3", "test1" );
        User u4 = new User("user4", "test1" );
        ArrayList<User> list1 = new ArrayList<>(); //User arraylist created to be written into file
        list1.add(u1);
        list1.add(u2);
        ArrayList<User> list2 = new ArrayList<>(); //User arraylist created to be written into file
        list2.add(u3);
        list2.add(u4);

        //create file contain serializable objects
        File f2 = new File("containObjects.ser");
        f1.createNewFile();
        try{
            FileOutputStream fop = new FileOutputStream(f2);
            ObjectOutputStream oos = new ObjectOutputStream(fop);
            oos.writeObject(list1); //write arraylist object into file
            oos.writeObject(list2); //write arraylist object into file
        }catch(Exception e){
            System.out.println("failed to write object");
            System.err.println("write object into file failed");
            e.printStackTrace();
        }

        //write file into bucket
        String fileName2_1 = "testObjectfile"; //fileName in bucket
        try {
            s3.putObject(bucket_name, fileName2_1, f2);
        } catch (AmazonServiceException e) {
            System.err.println(e.getErrorMessage());
            System.exit(1);
        }

        //Reading all objects from file
        S3Object object2 = s3.getObject((new GetObjectRequest(bucket_name, fileName2_1)));
        File localFile = new File("test1.ser"); //This is a container file used for copying file from the bucket

        try {
            //if container file already exist then skip copying the file
            if(!localFile.exists()){
                try{
                    Files.copy(object2.getObjectContent(),localFile.toPath()); //copy file from bucket into container file
                }catch (FileAlreadyExistsException e){
                    System.err.println("File already existed");
                    e.printStackTrace();
                }
            }

            //read raw data from the file itself
            BufferedReader reader2 = new BufferedReader(new InputStreamReader(object2.getObjectContent())); //create Buffer reader to read from file
            String lineRead;
            System.out.println("Reading raw data....\n");
            while ((lineRead = reader2.readLine()) != null) {
                System.out.println(lineRead);
            }

            //read object from container file/local file
            System.out.println("Reading object....\n");
            FileInputStream fis = new FileInputStream(localFile);
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<User> testList = new ArrayList<>();

            testList = (ArrayList<User>)ois.readObject(); //read next object

            for(User u: testList){
                System.out.println(u.getUsername());
            }
            testList = (ArrayList<User>)ois.readObject(); //read the next object
            for(User u: testList){
                System.out.println(u.getUsername());
            }

        } catch (Exception e) {
            System.out.println("Could not read from file");
            e.printStackTrace();
        }
        System.out.println("end");


    }
}

