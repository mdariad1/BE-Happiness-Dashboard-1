/**
 * 
 */
package com.ibm.ro.tm.apprenticeship.poll.metter.be;

import com.ibm.ro.tm.apprenticeship.poll.metter.entity.controller.UserController;
import com.ibm.ro.tm.apprenticeship.poll.metter.entity.controller.PollController;
import com.ibm.ro.tm.apprenticeship.poll.metter.entity.controller.AnswerController;
import com.ibm.ro.tm.apprenticeship.poll.metter.service.UserService;
import com.ibm.ro.tm.apprenticeship.poll.metter.service.PollService;
import com.ibm.ro.tm.apprenticeship.poll.metter.service.AnswerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@SpringBootApplication
@ComponentScan(basePackageClasses = { UserController.class,PollController.class,AnswerController.class, //
		UserService.class,PollService.class,AnswerService.class, //
		DataLoader.class, //
		SwaggerConfiguration.class })
@EntityScan(basePackages = { "com.ibm.ro.tm.apprenticeship.poll.metter.entity" })
@EnableJpaRepositories(basePackages = { "com.ibm.ro.tm.apprenticeship.poll.metter.repository" })

class DataLoader {

	public static void main(String[] args) {
		SpringApplication.run(DataLoader.class, args);
	}


	@Bean(name = "rat1")
	public CorsFilter corsFilter() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:8080"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}

}


