package com.modu.everymusic.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig {

	private static final String API_NAME = "Every_Music";
	private static final String API_VERSION = "V1";
	private static final String API_DESCRIPTION = "EveryMusic API TEST";
	private static final String API_URL = "http://localhost:8889/everymusic/swagger-ui.html";
	
	
	@Bean
	public Docket api() {
		
		List<ResponseMessage> responseMessages = new ArrayList<ResponseMessage>();
		responseMessages.add(new ResponseMessageBuilder().code(200).message("Request Success").build());
		responseMessages.add(new ResponseMessageBuilder().code(500).message("Server Error").build());
		responseMessages.add(new ResponseMessageBuilder().code(404).message("Not Found Page").build());
		
		return new Docket(DocumentationType.SWAGGER_2)
										   .apiInfo(apiInfo())
										   .select()
										   .apis(RequestHandlerSelectors.basePackage("com.modu.everymusic.controller"))	// 경로설정
										   .paths(PathSelectors.ant("/api/**"))			// 모든 패키지에 대하여 경로 설정 
										   .build()
										   .useDefaultResponseMessages(false)	// Response Message 설정 (Default 해제)
										   .globalResponseMessage(RequestMethod.GET, responseMessages)
										   .globalResponseMessage(RequestMethod.POST, responseMessages)
										   .globalResponseMessage(RequestMethod.DELETE, responseMessages)
										   .globalResponseMessage(RequestMethod.PUT, responseMessages);
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title(API_NAME)
								   .version(API_VERSION)
								   .description(API_DESCRIPTION)
								   .license("swings134 License")
								   .termsOfServiceUrl(API_URL)
								   .build();
	}
	
}
