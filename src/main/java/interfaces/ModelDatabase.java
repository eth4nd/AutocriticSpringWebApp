package interfaces;

import Model.User.User;
import com.amazonaws.services.s3.AmazonS3;

public interface ModelDatabase {

    void delete(Model m, String Filename, AmazonS3 s3);
    void insert(Model m,String Filename,AmazonS3 s3);
    void take(Model m,String Filename,AmazonS3 s3);
}
