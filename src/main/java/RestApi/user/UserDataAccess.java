package RestApi.user;

import Model.User.User;
import RestApi.datastore.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDataAccess {

    private final UserRepository userRepository;

    @Autowired
    public UserDataAccess(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    List<User> getUsers(){
        return userRepository.getUsers();
    }
}
