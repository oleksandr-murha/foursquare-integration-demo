package uk.co.whitbread;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableConfigurationProperties
@SpringBootApplication
public class FoursquareIntegrationDemoApplication {

	@Bean
	public RestTemplate createRestTemplate(){
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(FoursquareIntegrationDemoApplication.class, args);
	}
}
