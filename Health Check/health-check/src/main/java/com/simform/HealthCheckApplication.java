package com.simform;

import com.simform.entity.Person;
import com.simform.repository.PersonRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HealthCheckApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthCheckApplication.class, args);
	}

	@Autowired
	private PersonRepository repository;

	@Bean
	InitializingBean populatePersons() {
		return () -> {
			repository.deleteAll();
			repository.save(Person.builder().firstName("Car").lastName("Testing").profileURL("http://linkin.com/565656").build());
			repository.save(Person.builder().firstName("Truck").lastName("Testing").build());
		};
	}
}
