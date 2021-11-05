import org.junit.Test;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import userprofile.User;

import java.util.UUID;

public class UserUnitTest {

    private final UUID uuid = UUID.randomUUID();
    private final String username = "username";
    private final int password = 123456789;
    private final User user = new User(uuid, username, password);

    @Test
    public void testGetPassword() {
        assertEquals(user.getPassword(), password, "Passwords should be the same");
        try{
            User userWithLongPassword = new User(uuid, username, Integer.MAX_VALUE + 1);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetUsername() {
        assertEquals(user.getUsername(), username, "Usernames should be the same");
    }

    @Test
    public void testGetUserID() {
        assertEquals(user.getUserID(), uuid, "UserIDs should be the same");
    }

    @Test
    public void testEquals() {
        User user1 = new User(uuid, username, password);
        User user2 = new User(uuid, username, password);
        User user3 = new User(UUID.randomUUID(), username, password);
        assertEquals(user1, user2, "Users should be the same");
        assertNotEquals(user1, user3, "Users should not be the same");
    }

    @Test
    public void testHashCode() {
        User user1 = new User(uuid, username, password);
        User user2 = new User(uuid, username, password);
        User user3 = new User(UUID.randomUUID(), username, password);
        assertEquals(user1, user2, "Hash codes should be the same");
        assertNotEquals(user1, user3, "Hash codes should not be the same");
    }
}
