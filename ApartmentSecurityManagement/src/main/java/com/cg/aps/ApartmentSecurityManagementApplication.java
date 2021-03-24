package com.cg.aps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.sun.el.stream.Optional;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class ApartmentSecurityManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApartmentSecurityManagementApplication.class, args);
	}

	 @Bean
	    public AuditorAware<String> auditorProvider() {

		 return new AuditorAwareImpl();
	        /*
	          if you are using spring security, you can get the currently logged username with following code segment.
	          SecurityContextHolder.getContext().getAuthentication().getName()
	         */
		
	    }
}
