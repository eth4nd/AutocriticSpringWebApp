//package RestApi.config;
//
//import com.amazonaws.auth.AWSCredentials;
//import com.amazonaws.auth.AWSStaticCredentialsProvider;
//import com.amazonaws.auth.BasicAWSCredentials;
//import com.amazonaws.services.s3.AmazonS3;
//import com.amazonaws.services.s3.AmazonS3ClientBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class AmazonConfig {
//    @Bean
//    public AmazonS3 s3(){
//        AWSCredentials awsCredentials = new BasicAWSCredentials(
//           "AKIAQNUHEPFEGYHK6KU6","46fiA27SLsAU0zp7N6TgmOYJ7hV7xKZXdS/Gx/lP"
//        );
//        return AmazonS3ClientBuilder
//                .standard()
//                .withRegion("us-west-1")
//                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
//                .build();
//    }
//
//}
