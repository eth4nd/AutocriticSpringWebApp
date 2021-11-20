package com.autocritic.autocriticspringbootproj.datastore;
import com.autocritic.autocriticspringbootproj.profile.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class FakeUserProfileDataStore {
    private static final List<User> USER_PROFILES = new ArrayList<>();

    static{
        USER_PROFILES.add(new User(UUID.randomUUID(),
                "user1" ,
                null));
        USER_PROFILES.add(new User(UUID.randomUUID(),
                "user2",
                null));
    }

    public List<User> getUserProfiles(){
        return USER_PROFILES;
    }

}

