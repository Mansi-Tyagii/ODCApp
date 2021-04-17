package com.cg.trg.app;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.function.Predicate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
@SpringBootApplication(scanBasePackages = "com.cg.trg")
@EntityScan(basePackages = "com.cg.trg.entity")
@EnableJpaRepositories(basePackages = "com.cg.trg.dao")
@EnableOpenApi

public class OnlineDryCleaningAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineDryCleaningAppApplication.class, args);
	}
	
	@Bean
	  public Docket openApiAdminODC() {
	    return new Docket(DocumentationType.OAS_30)
	        .groupName("open-admin-api-online-dryclean")
	        .select()
	        .paths(productPaths())
	        .build();
	  }

	  private Predicate<String> productPaths() {
	    return regex(".*/api/adm/.*");
	  }
	  
	  @Bean
	  public Docket openApiUserODC() {
	    return new Docket(DocumentationType.OAS_30)
	        .groupName("open-User-api-online-dryclean")
	        .select()
	        .paths(productPaths1())
	        .build();
	  }

	  private Predicate<String> productPaths1() {
	    return regex(".*/api/uc/.*");
	  }
	  
	  @Bean
	  public Docket openApiCustomerODC() {
	    return new Docket(DocumentationType.OAS_30)
	        .groupName("open-Customer-api-online-dryclean")
	        .select()
	        .paths(productPaths2())
	        .build();
	  }

	  private Predicate<String> productPaths2() {
	    return regex(".*/api/cust/.*");
	  }


}
