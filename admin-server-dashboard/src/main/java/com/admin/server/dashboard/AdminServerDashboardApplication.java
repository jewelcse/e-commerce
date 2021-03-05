package com.admin.server.dashboard;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableAdminServer
@EnableDiscoveryClient
public class AdminServerDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminServerDashboardApplication.class, args);
		new SpringApplicationBuilder(AdminServerDashboardApplication.class)
				.web(WebApplicationType.REACTIVE)
				.run(args);
	}

}
