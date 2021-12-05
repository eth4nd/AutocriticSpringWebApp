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
import interfaces.ModelDatabase;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * UserDatabase model class that represents a database that stores User objects
 * There is a local database for demonstration purposes and an AWS database
 * {@value #LocalFilename} name of local file
 * {@value #Filename} name of S3 bucket
 */
public class UserDatabase implements ModelDatabase {
    /**
     * {@value #LocalFilename} name of local file
     */
    public static final String LocalFilename = "Users.txt"; //local file name
    /**
     * {@value #Filename} name of S3 bucket
     */
    public static final String Filename = "USERS"; //file name in s3 bucket database

    private HashMap<String, User> cache = new HashMap<>();

    // Stores user object with its username as the key value
    // Should be called when user wants to create a new account

    // returns true if the user exists in the database, or false if it doesn't
    // Should be called when user wants to sign in

    /**
     * creates a new local file
     */
    public void createLocalFile(){
        File local = new File(UserDatabase.LocalFilename);
        try{
            local.createNewFile();
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    /**
     * downloads the user database from the AWS database
     * @param s3 the AmazonS3 bucket
     */
    public void downloadUserFile(AmazonS3 s3){
        s3.getObject(
                new GetObjectRequest(BucketManager.bucketName, UserDatabase.Filename),
                new File(UserDatabase.LocalFilename)
        );
    }

    /**
     * does nothing but is required by ModelDatabase interface
     * @param user user
     * @param Filename the file
     * @param s3 the AmazonS3 bucket
     */
    @Override
    public void delete(Model user, String Filename,AmazonS3 s3) {

    }

    /**
     * insert user into file and store it in AWS database
     * @param user the User object
     * @param Filename the File to delete from
     * @param s3 the AmazonS3 bucket
     */
    @Override
    public void insert(Model user, String Filename,AmazonS3 s3) {
        FileManager fm = new FileManager();
        BufferedWriter out = null;
        if(!(user instanceof User))
        {
            System.out.println("wrong model class");
            return;
        }
        User u = (User) user;
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

    /**
     * does nothing but is required by ModelDatabase interface
     * @param user user
     * @param Filename the file
     * @param s3 the AmazonS3 bucket
     */
    @Override
    public void take(Model user, String Filename,AmazonS3 s3) {

    }

    /**
     * downloads a text file of users from aws s3 database
     * @param Filename the File to read from
     * @param s3 the AmazonS3 bucket
     * @param amount the total amount of users downloaded from the local/AWS database
     * @return an ArrayList of User objects
     */
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
                listOfUsers.add(new User(sc.next(),sc.next()));

            }
        }catch(FileNotFoundException e){
            downloadUserFile(s3);
        }
        return listOfUsers;
    }

    /**
     * searches for users within a list of Users
     * @param search to compare with user
     * @param listOfUsers list of users
     * @return btrue if user is within list and false if not
     */
    public boolean searchUser(User search, List<User> listOfUsers){
        for(User u :listOfUsers){
            /*
            System.out.println
                    ("comparing " + search.getUsername() + " and " + u.getUsername() + " = " + search.getUsername().equals(u.getUsername()));
            System.out.println
                    ("comparing " + search.getPassword() + " and " + u.getPassword() + " = " + search.getPassword().equals(u.getPassword()));
            */
            if(search.equals(u)){
                return true;
            }
        }
        return false;
    }

}
