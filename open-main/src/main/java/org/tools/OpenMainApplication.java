package org.tools;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("classpath:org.tools.dao.*.impl.mapper")
public class OpenMainApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenMainApplication.class, args);
	}

}
