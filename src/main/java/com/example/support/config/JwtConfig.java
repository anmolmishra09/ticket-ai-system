package com.example.support.config;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

/**
 * JWT settings bound from {@code app.jwt.*}. The secret must be at least 32 characters
 * (256 bits) for HS256 and is always supplied via environment variable in production.
 */
@Validated
@ConfigurationProperties(prefix = "app.jwt")
public record JwtConfig(
        @NotBlank @Size(min = 32, message = "JWT secret must be at least 32 characters") String secret,
        @Positive long accessExpirationMs,
        @Positive long refreshExpirationMs,
        @NotBlank String issuer) {
}
