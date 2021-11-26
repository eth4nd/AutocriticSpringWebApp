package RestApi.datastore;



import Model.Database.BucketManager;
import Model.User.User;
import Model.User.UserDatabase;
//import RestApi.user.User;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Repository
public class UserRepository {

    private List<User> USERS;

    public UserRepository(){
        BucketManager bucketManager = new BucketManager();
        UserDatabase userDatabase = new UserDatabase();
        //load users into the user repository for frontend
        USERS = userDatabase.downloadUser("placeholder", bucketManager.getS3Database(),100);

    }

    //private static final List<User> USERS = new ArrayList<>();
//    //static gets called first then constructor gets called after
//    static {
//        BucketManager bucketManager = new BucketManager();
//        UserDatabase userDatabase = new UserDatabase();
//        userDatabase.downloadUserFile(bucketManager.getS3Database());
//        USERS.add(new User("John","pass"));
//        USERS.add(new User("Jane","pass2"));
//        USERS.add(new User("Jane3","pass2"));
//
//
//    }

    public List<User> getUsers(){
        return USERS;
    }
}
