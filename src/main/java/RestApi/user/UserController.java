package RestApi.user;


import Model.User.User;
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



    //grabs User data from frontend
    @PostMapping(path="signUp",
            consumes = MediaType.APPLICATION_JSON_VALUE, //grabs a datatype from front end and
            produces = MediaType.APPLICATION_JSON_VALUE //produces a datatype in back end
    )
    public void signUp(@RequestBody LinkedHashMap data){
        LinkedHashMap<String,String> element = data;
        System.out.println(data.getClass());
        User user = new User((String)data.get("username"),(String)data.get("password"));
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
    }

}
