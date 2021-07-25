package com.abhishek.productslist;

import com.abhishek.productslist.exception.RestTemplateResponseErrorHandler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class ProductsListApplication {

	@Bean
	@LoadBalanced
	public RestTemplate getInstance(RestTemplateBuilder restTemplateBuilder) {
		return restTemplateBuilder.errorHandler(new RestTemplateResponseErrorHandler()).build();
	}

	public static void main(String[] args) {
		SpringApplication.run(ProductsListApplication.class, args);
	}

}
