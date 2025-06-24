package com.nc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.nc.mapper")
public class AdminPanelApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminPanelApplication.class, args);
	}

}
