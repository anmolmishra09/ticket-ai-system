package com.example.support.config;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

/**
 * Gemini API settings bound from {@code app.gemini.*}.
 * A blank API key is allowed: the application then uses the fallback classification.
 */
@Validated
@ConfigurationProperties(prefix = "app.gemini")
public record GeminiConfig(
        String apiKey,
        @NotBlank String baseUrl,
        @NotBlank String model,
        @PositiveOrZero int timeoutMs,
        @PositiveOrZero int maxRetries,
        @PositiveOrZero long retryBackoffMs) {

    public boolean isConfigured() {
        return apiKey != null && !apiKey.isBlank();
    }
}
