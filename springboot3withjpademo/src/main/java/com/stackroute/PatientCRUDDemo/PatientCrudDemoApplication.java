package com.stackroute.PatientCRUDDemo;

import com.stackroute.PatientCRUDDemo.filter.PatientFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PatientCrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientCrudDemoApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean getBean(){
		FilterRegistrationBean bean = new FilterRegistrationBean();
		bean.setFilter(new PatientFilter());
		bean.addUrlPatterns("/api/v1/*");
		return bean;
	}

}
