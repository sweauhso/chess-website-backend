package dev.uofc_chessclub.Chess.Club;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**") // Apply to all API endpoints
                        .allowedOrigins("http://localhost:3000", "http://localhost:3001", "https://your-vercel-frontend.vercel.app")  // ✅ Allow frontend domains
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Allow specific HTTP methods
                        .allowedHeaders("*")  // Allow all headers
                        .allowCredentials(true);  // Allow cookies if needed
            }
        };
    }
}
