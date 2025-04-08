package com.rm.reina.madre.services.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Swagger Configuration
 *
 * @author Israel Elias Salgado
 *
 * @version 1.0
 *
 */
@OpenAPIDefinition
@Configuration
public class OpenApi30Config {

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info().title("BackEnd Services Reina Madre Documentation").version("1.0.0").description("Spring doc"));
	}
}