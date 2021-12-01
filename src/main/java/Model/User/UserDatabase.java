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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class UserDatabase implements Model {
    public static final String LocalFilename = "Users.txt"; //local file name
    public static final String Filename = "USERS"; //file name in s3 bucket database

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

    //download a text file of users from aws s3 database
    public List<User> downloadUser(String Filename,AmazonS3 s3,int amount){
        List<User> listOfUsers = new ArrayList<>();
        System.out.println("Downloading " + amount+ " users " +  " from " + UserDatabase.LocalFilename);

        try{
            File users = new File(UserDatabase.LocalFilename);
            Scanner sc = new Scanner(users);
            System.out.println(sc.nextLine());
            for(int i = 0;i<amount;i++){
                if(!sc.hasNext()){
                    return listOfUsers;
                }
                listOfUsers.add(new User(sc.next(),""));
                sc.next();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return listOfUsers;
    }

    //search for user within a list of Users
    public boolean searchUser(User search, List<User> listOfUsers){
        for(User u :listOfUsers){
            if(search.equals(u)){
                return true;
            }
        }
        return false;
    }

}
