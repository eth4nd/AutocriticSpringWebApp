package interfaces;

import Model.User.User;
import com.amazonaws.services.s3.AmazonS3;

/**
 * ModelDatabase interface for model classes that use AWS database
 */
public interface ModelDatabase {

    /**
     * Method for deleting model from database
     * @param m class that implements Model interface
     * @param Filename name of the file
     * @param s3 the AmazonS3 bucket
     */
    void delete(Model m, String Filename, AmazonS3 s3);

    /**
     * Method for inserting model to database
     * @param m class that implements Model interface
     * @param Filename name of the file
     * @param s3 the AmazonS3 bucket
     */
    void insert(Model m,String Filename,AmazonS3 s3);

    /**
     * Method for taking model from database
     * @param m class that implements Model interface
     * @param Filename name of the file
     * @param s3 the AmazonS3 bucket
     */
    void take(Model m,String Filename,AmazonS3 s3);
}
