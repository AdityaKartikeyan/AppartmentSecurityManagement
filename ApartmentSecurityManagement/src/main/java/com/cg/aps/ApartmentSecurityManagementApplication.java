/**
 * 
 */
package com.cg.aps;
/**
 * @author Vishal Rana
 *
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ApartmentSecurityManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApartmentSecurityManagementApplication.class, args);
	}

}