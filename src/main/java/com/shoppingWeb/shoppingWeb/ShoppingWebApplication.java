package com.shoppingWeb.shoppingWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class ShoppingWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingWebApplication.class, args);
	}

}
