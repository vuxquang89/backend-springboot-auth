package com.vux.example.RegisterLogin.Config;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{
	
	private final long MAX_AGE_SECS = 3600;

    @Value("${app.cors.allowedOrigins}")
    private String[] allowedOrigins;
    
    @Override
    public void addCorsMappings(CorsRegistry registry) {
    	registry.addMapping("/**")
        .allowedOrigins(allowedOrigins)
        .allowedMethods("HEAD", "OPTIONS", "GET", "POST", "PUT", "PATCH", "DELETE")
        .maxAge(MAX_AGE_SECS);
//        .allowedHeaders("*")
//        .exposedHeaders("Authorization")
//        .allowCredentials(true);
    }
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	registry.addResourceHandler("/**")
    			.addResourceLocations("classpath:/static/");
    	exposeDirectory("upload", registry);
    }
    
    private void exposeDirectory(String dirName, ResourceHandlerRegistry registry) {
    	Path uploadDir = Paths.get(dirName);
    	String uploadPath = uploadDir.toFile().getAbsolutePath();
    	
    	if(dirName.startsWith("../")) dirName = dirName.replace("../", "");
    	
    	registry.addResourceHandler("/" + dirName + "/**").addResourceLocations("file:///" + uploadPath + "/");
    }
}
