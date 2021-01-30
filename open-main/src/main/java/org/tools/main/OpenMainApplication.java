package org.tools.main;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.tools.main.*.mapper")
public class OpenMainApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenMainApplication.class, args);
	}

}
