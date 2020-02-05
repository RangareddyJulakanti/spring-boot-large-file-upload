package com.ranga.spring.web.fileio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication
public class FileIoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileIoApplication.class, args);
	}
	@Bean
	MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		factory.setMaxFileSize(DataSize.ofBytes(51200000000000L));
		factory.setMaxRequestSize(DataSize.ofBytes(51200000000000L));
		factory.setFileSizeThreshold(DataSize.ofBytes(51200000000000L));
		return factory.createMultipartConfig();
	}
}
