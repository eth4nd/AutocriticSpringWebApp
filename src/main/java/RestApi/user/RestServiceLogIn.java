package RestApi.user;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/service")
@CrossOrigin("*")
public class RestServiceLogIn {

    public static boolean login = false;

    @GetMapping
    public boolean login(){
        return login;
    }
    public static void setLogin(boolean b){
        login = b;
    }
}
