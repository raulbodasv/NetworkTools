package com.rbodas.verifyConnections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class VerifyConnectionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(VerifyConnectionsApplication.class, args);
	}
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(VerifyConnectionsApplication.class);
	}

}
