package com.example;

import net.unicon.cas.client.configuration.CasClientConfigurerAdapter;
import net.unicon.cas.client.configuration.EnableCasClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableCasClient
@ComponentScan
public class ModuleWebApplication extends CasClientConfigurerAdapter {

	@Override
	public void configureAuthenticationFilter(FilterRegistrationBean authenticationFilter) {
		super.configureAuthenticationFilter(authenticationFilter);
		authenticationFilter.getInitParameters().put("artifactParameterName", "casTicket");
		authenticationFilter.getInitParameters().put("serviceParameterName", "targetService");
	}

	@Override
	public void configureValidationFilter(FilterRegistrationBean validationFilter) {
		super.configureValidationFilter(validationFilter);
		validationFilter.getInitParameters().put("millisBetweenCleanUps","5000");
		validationFilter.getInitParameters().put("useSession", "false");
	}

	public static void main(String[] args) {
		SpringApplication.run(ModuleWebApplication.class, args);
	}

}

