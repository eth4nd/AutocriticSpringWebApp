package RestApi.user;


import Model.User.User;
import com.amazonaws.services.ec2.model.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserDataAccess userDataAccess;

    @Autowired
    public UserService(UserDataAccess userDataAccess){
        this.userDataAccess = userDataAccess;
    }
    List<User> getUsers(){
        return userDataAccess.getUsers();
    }

}
