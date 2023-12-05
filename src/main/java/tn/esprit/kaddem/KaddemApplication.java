package tn.esprit.kaddem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableAspectJAutoProxy
@SpringBootApplication
public class KaddemApplication {

    public static void main(String[] args) {
        SpringApplication.run(KaddemApplication.class, args);
    }

}