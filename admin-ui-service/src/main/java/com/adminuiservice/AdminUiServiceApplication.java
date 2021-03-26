package com.adminuiservice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableHystrix
public class AdminUiServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminUiServiceApplication.class, args);
	}


	@Bean
	public RestTemplate restTemplate(){
		HttpComponentsClientHttpRequestFactory httpRequestFactory
				= new HttpComponentsClientHttpRequestFactory();
		httpRequestFactory.setConnectTimeout(2000);
		return new RestTemplate(httpRequestFactory);
	}
}
