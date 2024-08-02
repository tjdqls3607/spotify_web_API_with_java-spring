package com.example.firstproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run( DemoApplication.class, args);

		// CreateToken 클래스 실행
		String accessToken = CreateToken.accesstoken();
		System.out.println("Access Token: " + accessToken);
	}
}