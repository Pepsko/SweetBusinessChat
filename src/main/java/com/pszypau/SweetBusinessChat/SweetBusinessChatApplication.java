package com.pszypau.SweetBusinessChat;

import com.pszypau.SweetBusinessChat.Security.SecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@Import(SecurityConfig.class)
public class SweetBusinessChatApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
		return application.sources(SweetBusinessChatApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(SweetBusinessChatApplication.class, args);
	}

}