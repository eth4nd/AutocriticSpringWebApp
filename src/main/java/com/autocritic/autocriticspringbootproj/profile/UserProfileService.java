//package com.autocritic.autocriticspringbootproj.profile;
//
//import RestApi.User;
//import RestApi.UserDataAccessService;
//import com.autocritic.autocriticspringbootproj.datastore.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.awt.*;
//import java.util.UUID;
//
//@Service
//public class UserProfileService {
//    private final UserDataAccessService userDataAccessService;
//
//    @Autowired
//    public UserProfileService(UserDataAccessService userDataAccessService) {
//        this.userDataAccessService = userDataAccessService;
//    }
//
//    List<User> getUserProfiles(){
//        return userDataAccessService.getUsers();
//    }
//
////    public void uploadUserProfileImage(UUID userProfileId, MultipartFile file) {
////        //1. Check if image is not empty
////        //2. If file is an image
////        //3. The user exists in our database
////        //4. Grab some metadata from file if any
////        //5. Store the image in s3 and update
////    }
//}
//
