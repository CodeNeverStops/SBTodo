package com.example.sbtodo;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages="com.example.sbtodo", annotationClass = Mapper.class)
public class SbtodoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbtodoApplication.class, args);
	}
}
