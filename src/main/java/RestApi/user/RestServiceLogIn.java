package RestApi.user;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/service")
@CrossOrigin("*")
public class RestServiceLogIn {

    //if login is false, do nothing
    //if login is true, direct user to homepage
    public static boolean login = false;

    @GetMapping
    public boolean login(){
        return login;
    }
    public static void setLogin(boolean b){
        login = b;
    }
}
