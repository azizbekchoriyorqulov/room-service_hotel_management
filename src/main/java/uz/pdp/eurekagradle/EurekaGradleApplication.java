package uz.pdp.eurekagradle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer
public class EurekaGradleApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaGradleApplication.class, args);
    }

}
