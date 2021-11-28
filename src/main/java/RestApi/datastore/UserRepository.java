package RestApi.datastore;



import Model.Database.BucketManager;
import Model.User.User;
import Model.User.UserDatabase;
//import RestApi.user.User;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.util.concurrent.TimeUnit;


@Repository
public class UserRepository {

    private List<User> USERS;
    BucketManager bucketManager;
    UserDatabase userDatabase;

    public UserRepository(){
        this.bucketManager = new BucketManager();
        this.userDatabase = new UserDatabase();
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

//    public void addUser(User user){
//        USERS.add(user);
//    }

    public List<User> getUsers(){
//        System.out.println("repository called getUser");
//        for(User u:USERS){
//            System.out.println(u.getUsername() + ", ");
//        }
//        System.out.println("");
        //USERS.add(new User("test","test"));
        USERS =userDatabase.downloadUser("placeholder", bucketManager.getS3Database(),100);
        return USERS;
    }
}
