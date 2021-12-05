package Model.User;

//import Model.User.LoginSystem;
import Model.Database.BucketManager;
import Model.User.User;
import Model.User.UserDatabase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class UserUnitTest {

    @Test
    public void testUserClass()
    {
        User newUser1 = new User("user1", "password123");
        User newUser2 = new User("user2", "apples34");
        assertEquals("username should be user1", newUser1.getUsername(), "user1");
        assertEquals("Password should be password123", newUser1.getPassword(), "password123");
        assertEquals("userName should be user2", newUser2.getUsername(), "user2");
        assertEquals("password should be apples34", newUser2.getPassword(), "apples34");
    }

    @Test
    public void testUserDatabaseSearchUser()
    {
        User newUser1 = new User("user1", "password123");
        User newUser2 = new User("user2", "apples34");
        User newUser3 = new User("user3", "password456");
        User searchUser = new User("user3", "password456");
        List<User> listOfUsers = new ArrayList<>();
        listOfUsers.add(newUser1);
        listOfUsers.add(newUser2);
        listOfUsers.add(newUser3);
        UserDatabase userDatabase = new UserDatabase();
        assertTrue(userDatabase.searchUser(searchUser,listOfUsers));
    }

    @Test
    public void testUserDatabaseDownloadUsers(){
        BucketManager b = new BucketManager();
        UserDatabase userDatabase = new UserDatabase();
        List<User> listOfDownloadedUsers = userDatabase.downloadUser("placeholder",b.getS3Database(),3);
        assertTrue(listOfDownloadedUsers.size()<=3);
    }
/*
    @Test
    public void testUserLoginSystem()
    {
        User testUser = new User("test", "43asd");
        UserDatabase userDatabase = new UserDatabase();
        userDatabase.storeUser(testUser);
        String falseUserName = "tset";
        String falsePassword = "4sdfk";
        //Test if it works with string inputs
        assertTrue(LoginSystem.UserLogin("test", "43asd",userDatabase));
        //Test if it works with wrong inputs
        assertFalse(LoginSystem.UserLogin(falseUserName,falsePassword,userDatabase));
        //Test if it works with right inputs
        assertTrue(LoginSystem.UserLogin(testUser.getUsername(), testUser.getPassword(),userDatabase));
        //Test if it works with right user, wrong password
        assertFalse(LoginSystem.UserLogin(testUser.getUsername(), "wrongpassword", userDatabase));
    }
*/

}
