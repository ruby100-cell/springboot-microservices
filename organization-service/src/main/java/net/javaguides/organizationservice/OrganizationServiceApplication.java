package net.javaguides.organizationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(
		info = @Info(
				title = "Organization Service Rest Api's",
				description = "Organization Service Rest Api's Documentation",
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
				description = "Organization Service Doc",
				url = "https://www.javaguides.net"
				)
		)
@SpringBootApplication
@EnableMongoAuditing
public class OrganizationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganizationServiceApplication.class, args);
	}

}
