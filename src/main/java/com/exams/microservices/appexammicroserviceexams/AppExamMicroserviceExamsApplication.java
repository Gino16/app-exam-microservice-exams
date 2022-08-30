package com.exams.microservices.appexammicroserviceexams;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.exams.microservices.appexamlibcommonexams.models.entities"})
public class AppExamMicroserviceExamsApplication {

  public static void main(String[] args) {
    SpringApplication.run(AppExamMicroserviceExamsApplication.class, args);
  }

}
