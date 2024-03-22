package com.example.ams;

import com.example.ams.generate.LoginGenerator;
import com.example.ams.generate.SecurePasswordGenerator;
import com.example.ams.service.JwtService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class AmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmsApplication.class, args);

//		String fullName = "Снъмщикьова Юлия Николаевна";
//		String login = LoginGenerator.generateLogin(fullName);
//		System.out.println("Логин: " + login);
//
//		System.out.println(SecurePasswordGenerator.generateSecurePassword());
	}

}
