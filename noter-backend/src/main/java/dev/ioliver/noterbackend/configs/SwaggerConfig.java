package dev.ioliver.noterbackend.configs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
  @Bean
  public OpenAPI openAPI() {
    return new OpenAPI().info(
        new Info().title("Noter Backend").description("API for Noter").version("0.0.1"));
  }
}