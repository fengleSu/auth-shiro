package com.fl.auth.authshiro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = {"com.fl.auth.authshiro.dao"})
public class AuthShiroApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthShiroApplication.class, args);
	}
}
