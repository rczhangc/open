package org.open.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"org.open.boot.dao.*.impl"})
public class OpenMainApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenMainApplication.class, args);
	}

}
