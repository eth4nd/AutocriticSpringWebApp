package Model.User;
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

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.util.HashMap;

public class UserDatabase implements Model {
    public static final String LocalFilename = "Users.txt";
    public static final String Filename = "USERS";

    private HashMap<String, User> cache = new HashMap<>();

    // Stores user object with its username as the key value
    // Should be called when user wants to create a new account

    // returns true if the user exists in the database, or false if it doesn't
    // Should be called when user wants to sign in

    public void createLocalFile(){
        File local = new File(UserDatabase.LocalFilename);
        try{
            local.createNewFile();
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    //download user database
    public void downloadUserFile(AmazonS3 s3){
        s3.getObject(
                new GetObjectRequest(BucketManager.bucketName, UserDatabase.Filename),
                new File(UserDatabase.LocalFilename)
        );
    }

    @Override
    public void delete(User u, String Filename,AmazonS3 s3) {

    }

    //insert user into file and store it in AWS database
    @Override
    public void insert(User u, String Filename,AmazonS3 s3) {
        FileManager fm = new FileManager();
        BufferedWriter out = null;
        String username = u.getUsername();
        String password = u.getPassword();

        try{
            //users.createNewFile();
            File users = new File("Users.txt");
            FileWriter myWriter = new FileWriter(users,true);
            out = new BufferedWriter(myWriter);

            //write user into file
            out.write(String.format("%20s %20s \r\n",username,password));

            //close loose ends
            out.close();
            myWriter.close();

            //insert file back into database
            fm.insertFileIntoBucket(BucketManager.bucketName, UserDatabase.Filename,users);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void take(User u, String Filename,AmazonS3 s3) {

    }
}
