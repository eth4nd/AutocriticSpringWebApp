package RestApi.user;


import Model.Database.BucketManager;
import Model.Database.FileManager;
import Model.User.User;
import Model.User.UserDatabase;
import com.amazonaws.services.ec2.model.UserData;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.LinkedHashMap;
import java.util.List;


@RestController
@RequestMapping("api/v1/user")
@CrossOrigin("*")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }


    @GetMapping
    public List<User> getUsers()
    {
        System.out.println("getmapping called");
        return userService.getUsers();
    }


//grabs User data from frontend
    @PostMapping(path="upload",
            consumes = MediaType.APPLICATION_JSON_VALUE, //grabs a datatype from front end and
             produces = MediaType.APPLICATION_JSON_VALUE //produces a datatype in back end
    )
    public void saveUser(@RequestBody LinkedHashMap data){
        LinkedHashMap<String,String> element = data;
        System.out.println(data.getClass());
        System.out.println(data.get("username"));
        System.out.println(data.get("password"));
    }



    //grabs uploads new user into database
    @PostMapping(path="signUp",
            consumes = MediaType.APPLICATION_JSON_VALUE, //grabs a datatype from front end and
            produces = MediaType.APPLICATION_JSON_VALUE //produces a datatype in back end
    )
    public void signUp(@RequestBody LinkedHashMap data){
        UserDatabase userDatabase = new UserDatabase();
        BucketManager b = new BucketManager();
        LinkedHashMap<String,String> element = data;
        System.out.println(data.getClass());

        User user = new User((String)data.get("username"),(String)data.get("password"));

        System.out.println(user.getUsername());
        System.out.println(user.getPassword());

        userDatabase.insert(user,"This field is already specified in UserDatabase", b.getS3Database());
        userDatabase.downloadUserFile(b.getS3Database());
    }

    //grabs uploads new user into database
    @PostMapping(path="logIn",
            consumes = MediaType.APPLICATION_JSON_VALUE, //grabs a datatype from front end and
            produces = MediaType.APPLICATION_JSON_VALUE //produces a datatype in back end
    )
    public void logIn(@RequestBody LinkedHashMap data){
        UserDatabase userDatabase = new UserDatabase();
        BucketManager b = new BucketManager();
        LinkedHashMap<String,String> element = data;
        System.out.println(data.getClass());
        String username = (String)data.get("username");

    }
}
