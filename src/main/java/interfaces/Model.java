package interfaces;

import Model.User.User;
import com.amazonaws.services.s3.AmazonS3;

public interface Model {
    void delete(User u, String Filename, AmazonS3 s3);
    void insert(User u,String Filename,AmazonS3 s3);
    void take(User u,String Filename,AmazonS3 s3);
}
