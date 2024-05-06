package ru.testproj.book.backend.api.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "Микросервис book-service",
                version = "1.0"
        )
)
@Configuration
public class OpenApiConfig {
}