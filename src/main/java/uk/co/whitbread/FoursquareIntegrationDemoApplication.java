package uk.co.whitbread;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@SpringBootApplication
public class FoursquareIntegrationDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoursquareIntegrationDemoApplication.class, args);
	}
}
