package com.fiap.Tech_Challenge_I;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.sql.init.SqlInitializationAutoConfiguration;

@SpringBootApplication(exclude = SqlInitializationAutoConfiguration.class)
public class TechChallengeIApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechChallengeIApplication.class, args);
	}

}
