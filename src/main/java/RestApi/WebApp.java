package RestApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;


@SpringBootApplication
public class WebApp {
    public static void main(String[] args){
        //declare controller and view here
        //call controller's main loop

        SpringApplication.run(WebApp.class,args);
    }
}
