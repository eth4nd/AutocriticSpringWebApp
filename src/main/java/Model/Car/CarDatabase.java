package Model.Car;
import Model.Database.BucketManager;

import Model.Review.Review;
import Model.Review.ReviewDatabase;
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
 * CarDatabase model class that represents a database that stores Car objects.
 * There is a local database for demonstration purposes and an AWS database.
 */
public class CarDatabase implements ModelDatabase {
    /**
     * {@value #LocalFilename} name of local file
     */
    public static final String LocalFilename = "Cars.txt"; // local file name
    /**
     * {@value #Filename} name of file in S3 bucket
     */
    public static final String Filename = "CARS"; // file name in s3 bucket database

    private HashMap<String, Car> cache = new HashMap<>();

    /**
     * Creates a new local file
     **/
    public void createLocalFile(){
        File local = new File(CarDatabase.LocalFilename);
        try {
            local.createNewFile();
        } catch(IOException e){
            e.printStackTrace();
        }

    }

    /**
     * Downloads the car database from the AWS database
     * @param s3 the AmazonS3 bucket
     */
    public void downloadCarFile(AmazonS3 s3){
        s3.getObject(
                new GetObjectRequest(BucketManager.bucketName, CarDatabase.Filename),
                new File(CarDatabase.LocalFilename)
        );
    }

    /**
     * // does nothing, required by ModelDatabase interface
     * @param car the car
     * @param Filename name of the file
     * @param s3 the AmazonS3 bucket
     */
    @Override
    public void delete(Model car, String Filename, AmazonS3 s3) {
        // does nothing, required by ModelDatabase interface
    }

    /**
     * Inserts a car into the file and stores it in AWS database
     * @param car the Car object
     * @param Filename the File to delete from
     * @param s3 the AmazonS3 bucket
     */
    @Override
    public void insert(Model car, String Filename,AmazonS3 s3) {
        FileManager fm = new FileManager();
        BufferedWriter out = null;
        if(!(car instanceof Car))
        {
            System.out.println("wrong model class");
            return;
        }
        Car c = (Car) car;

        try{
            //reviews.createNewFile();
            File cars = new File("Cars.txt");
            FileWriter myWriter = new FileWriter(cars,true);
            out = new BufferedWriter(myWriter);

            //write review into file


            out.write(String.format("%s|%s|%s|\r\n","carName","username","review"));


            //close loose ends
            out.close();
            myWriter.close();

            //insert file back into database
            fm.insertFileIntoBucket(BucketManager.bucketName, ReviewDatabase.Filename,cars);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //append anything to file
    public void append(String carName, String username, String review, String Filename,AmazonS3 s3) {
        FileManager fm = new FileManager();
        BufferedWriter out = null;
        try{
            //reviews.createNewFile();
            File cars = new File("Cars.txt");
            FileWriter myWriter = new FileWriter(cars,true);
            out = new BufferedWriter(myWriter);

            //write review into file

            out.write(String.format(";%s;%s;%s\r\n",carName,username,review));


            //close loose ends
            out.close();
            myWriter.close();

            //insert file back into database
            fm.insertFileIntoBucket(BucketManager.bucketName, ReviewDatabase.Filename,cars);
        }catch (IOException e){
            e.printStackTrace();

        }
    }

    /**
     * does nothing, required by ModelDatabase interface
     * @param car the car
     * @param Filename name of the file
     * @param s3 the AmazonS3 bucket
     */
    @Override
    public void take(Model car, String Filename,AmazonS3 s3) {

    }

    /**
     *downloads a text file of cars from aws s3 database
     * @param Filename the File to read from
     * @param s3 the AmazonS3 bucket
     * @param amount the total number of cars downloaded from the local/AWS database
     * @return an ArrayList of Car objects
     */
    public List<Car> downloadCar(String Filename,AmazonS3 s3,int amount){
        String carName = "";
        String avgRating = "";
        String numOfRatings = "";
        String totalRatings = "";
        List<Car> listOfCars = new ArrayList<>();
        System.out.println("Downloading " + amount+ " cars " +  " from " + CarDatabase.LocalFilename);

        try {
            File cars = new File(CarDatabase.LocalFilename);
            Scanner sc = new Scanner(cars);
            sc.useDelimiter(";");
            System.out.println(sc.nextLine());
            for(int i = 0;i<amount;i++){
                //if there's no more car found in database, return list
                if(!sc.hasNextLine()){
                    System.out.println("End of database spotted. Returning list...");
                    return listOfCars;
                }
                System.out.println("initializing vars...");
                //initiate values to make review objects
                carName = sc.next();
                avgRating = sc.next();
                numOfRatings = sc.next();
                totalRatings = sc.next();
                System.out.println("end of initializing vars...");
//                System.out.println("Car: " +car);
//                System.out.println("User: " +user);
//                System.out.println("Review: " + review);
                System.out.println("Adding car to list...");
                listOfCars.add(new Car(carName,Double.parseDouble(avgRating),Integer.parseInt(numOfRatings),Integer.parseInt(totalRatings)));
            }
//            for(int i = 0;i<amount;i++){
//                if(!sc.hasNext()){
//                    return listOfCars;
//                }
//                String line = sc.nextLine();
//                String[] carParameters = line.split(",");
//                listOfCars.add(new Car(Integer.parseInt(carParameters[0]),carParameters[1],carParameters[2],Double.parseDouble(carParameters[3])));
//                sc.next();
//            }
        }catch(FileNotFoundException e) {
            downloadCarFile(s3);
        }
        System.out.println("Returning list...");
        return listOfCars;
    }
}
