package org.open.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.open.boot.service.netty.json.JsonHttpServer;
import org.open.boot.service.netty.socket.WebSocketServer;
import org.open.boot.service.netty.source.NettyServer;
import org.open.boot.service.netty.string.StringTcpServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"org.open.boot.dao.*.impl"})
public class OpenMainApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenMainApplication.class, args);
		try {
			new StringTcpServer(8088).start();
			new JsonHttpServer(8880).start();
			new WebSocketServer(9999).start();
			new NettyServer(12345).start();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("NettyServerError:"+e.getMessage());
		}
	}
}
