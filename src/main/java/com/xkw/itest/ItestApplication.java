package com.xkw.itest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import redis.clients.jedis.Jedis;

@SpringBootApplication
@MapperScan("com.xkw.itest.mapper")
public class ItestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItestApplication.class, args);
	}

}
