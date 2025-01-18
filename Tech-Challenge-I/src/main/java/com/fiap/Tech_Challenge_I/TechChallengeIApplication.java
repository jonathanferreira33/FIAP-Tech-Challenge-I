package com.fiap.Tech_Challenge_I;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.sql.init.SqlInitializationAutoConfiguration;
/*@OpenAPIDefinition(info = @Info(title = "TechChallenge", version= "1.1", description = "Api desenvolvida ao curso Software Architecture, a FIAP"))*/
/*@SpringBootApplication(exclude = SqlInitializationAutoConfiguration.class)*/
@SpringBootApplication()
public class TechChallengeIApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechChallengeIApplication.class, args);
	}

}
