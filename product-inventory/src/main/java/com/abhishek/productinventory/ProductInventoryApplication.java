package com.abhishek.productinventory;

import com.abhishek.productinventory.exception.RestTemplateResponseErrorHandler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ProductInventoryApplication {

	@Bean
	public RestTemplate getInstance(RestTemplateBuilder restTemplateBuilder) {
		return restTemplateBuilder.errorHandler(new RestTemplateResponseErrorHandler()).build();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ProductInventoryApplication.class, args);
	}

}
