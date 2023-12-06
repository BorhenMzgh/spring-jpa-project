package soa.metier;

import org.springframework.web.servlet.config.annotation.CorsRegistry;

public interface WebMvcConfigurer {
    void addCorsMappings(CorsRegistry registry);
}
