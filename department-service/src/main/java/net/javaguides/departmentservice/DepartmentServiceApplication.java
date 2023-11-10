package net.javaguides.departmentservice;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(
		info = @Info(
				title = "Department Service Rest API's",
		        description = "Department Service Rest API's Documentation",
		        version = "v1.0",
		        contact = @Contact(
		        		name = "Ruby",
		        		email = "rubybtechbanasthali@gmail.com",
		        		url = "https://www.javaguides.net"
		        		),
		        license = @License(
		        		name = "Apache 2.0",
		        		url = "https://www.javaguides.net"
		        		)
				),
		externalDocs = @ExternalDocumentation(
				description = "Department-Service Doc",
				url = "https://www.javaguides.net"
				)
		)
@SpringBootApplication
public class DepartmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
	}
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
