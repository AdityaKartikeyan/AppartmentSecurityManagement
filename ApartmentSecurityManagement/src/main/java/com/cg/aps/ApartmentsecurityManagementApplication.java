package com.cg.aps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ApartmentsecurityManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApartmentsecurityManagementApplication.class, args);
	}

}
