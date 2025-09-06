package com.ecommerce.project.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // <project working dir>/uploads  (works even if the path has spaces)
        Path root = Paths.get(System.getProperty("user.dir"), "uploads")
                .toAbsolutePath().normalize();

        String location = root.toUri().toString(); // e.g. file:///…/self%20developed/project/uploads/
        if (!location.endsWith("/")) location += "/";

        System.out.println("STATIC /uploads/** -> " + location); // debug
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations(location);
    }
}
