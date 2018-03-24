package com.pszypau.SweetBusinessChat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@SpringBootApplication
public class SweetBusinessChatApplication {

	public static void main(String[] args) {
		SpringApplication.run(SweetBusinessChatApplication.class, args);
	}


	@Bean
	public Docket newsApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("SweetBusinessChat")
				.apiInfo(apiInfo())
				.select()
				.paths(regex("/api.*"))
				.build();
	}
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Spring REST Ticket Service Application")
				.description("Spring REST Ticket Service Application")
				.contact("SweetBusinessChat")
				.license("Apache License Version 2.0")
				.version("2.0")
				.build();
	}
}