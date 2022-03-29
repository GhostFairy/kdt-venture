package edu.multi.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "edu", "clova" })
public class NaverAiApplication {

	public static void main(String[] args) {
		SpringApplication.run(NaverAiApplication.class, args);
	}

}
