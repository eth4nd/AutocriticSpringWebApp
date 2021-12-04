package Model.Car;
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

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
    public static final String LocalFilename = "Cars.txt"; // local file name
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
            System.out.println("wrong model class used");
            return;
        }
        Car c = (Car) car;

        try {
            //cars.createNewFile();
            File cars = new File("Cars.txt");
            FileWriter myWriter = new FileWriter(cars,true);
            out = new BufferedWriter(myWriter);

            //write car into file
            out.write(c.carName()+","+c.getMSRP() + "\n");

            //close loose ends
            out.close();
            myWriter.close();

            //insert file back into database
            fm.insertFileIntoBucket(BucketManager.bucketName, CarDatabase.Filename,cars);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void take(Model car, String Filename,AmazonS3 s3) {
        // does nothing, required by ModelDatabase interface
    }

    /**
     *downloads a text file of cars from aws s3 database
     * @param Filename the File to read from
     * @param s3 the AmazonS3 bucket
     * @param amount the total number of cars downloaded from the local/AWS database
     * @return an ArrayList of Car objects
     */
    public List<Car> downloadCar(String Filename,AmazonS3 s3,int amount){
        List<Car> listOfCars = new ArrayList<>();
        System.out.println("Downloading " + amount+ " cars " +  " from " + CarDatabase.LocalFilename);

        try {
            File cars = new File(CarDatabase.LocalFilename);
            Scanner sc = new Scanner(cars);

            while(sc.hasNextLine())
            {
                String line = sc.nextLine();
                String[] carParameters = line.split(",");
                listOfCars.add(new Car(Integer.parseInt(carParameters[0]),carParameters[1],carParameters[2],Double.parseDouble(carParameters[3])));
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
        } catch(IOException e){
            e.printStackTrace();
        }
        return listOfCars;
    }
}
