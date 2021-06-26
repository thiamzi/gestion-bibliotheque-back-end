package sn.thies.ut;

import java.util.Arrays;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import email.EmailService;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class GestionBibliothequeApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionBibliothequeApplication.class, args);
		
	}
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("sn.thies.ut"))
				.paths(PathSelectors.any())
				.build();
	}

	@Bean
	public CorsFilter corsFilter() {

	CorsConfiguration corsConfiguration = new CorsConfiguration();

	corsConfiguration.setAllowCredentials(true);
	
	corsConfiguration.setAllowedOrigins(Arrays.asList("https://biblioteque-4dc77.web.app" , "http://localhost:41327"));

	corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",

	"Accept", "Authorization", "Origin, Accept", "X-Requested-With", "Access-Control-Request-Method", "Access-Control-Request-Headers"));

	corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",

	"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));

	corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));

	UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();

	urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);

	return new CorsFilter(urlBasedCorsConfigurationSource);

	}
	
	
	@Bean 
	public EmailService sendEmail() {
		return new EmailService();
	}
    
    
}
