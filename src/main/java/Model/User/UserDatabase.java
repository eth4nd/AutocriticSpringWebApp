package Model.User;

import java.util.HashMap;

public class UserDatabase {

    private HashMap<String, User> userDataBase = new HashMap<>();

    // Stores user object with its username as the key value
    // Should be called when user wants to create a new account
    public void storeUser(User u){
        if(findUser(u.getUsername())) {
            System.out.println("Error: username already exists in our system");
            return;
        }
        userDataBase.put(u.getUsername(), u);

    }
    // returns true if the user exists in the database, or false if it doesn't
    // Should be called when user wants to sign in
    public boolean findUser(String username){
        if(userDataBase.get(username) == null)
            return false;
        else
            return true;
    }

    public User getUser(String username)
    {
        return userDataBase.get(username);
    }

}
