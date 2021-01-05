package org.tools.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OpenMainApplication {

	public static void main(String[] args) {
		System.out.println("启动");
		SpringApplication.run(OpenMainApplication.class, args);
	}

}
