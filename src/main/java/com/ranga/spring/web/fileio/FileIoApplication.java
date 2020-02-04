package com.ranga.spring.web.fileio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication
public class FileIoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileIoApplication.class, args);
	}
	/*@Bean
	public TomcatServletWebServerFactory containerFactory() {
		return new TomcatServletWebServerFactory() {
			protected void customizeConnector(Connector connector) {
				int maxSize = 500000000;
				super.customizeConnector(connector);
				connector.setMaxPostSize(maxSize);
				connector.setMaxSavePostSize(maxSize);
				if (connector.getProtocolHandler() instanceof AbstractHttp11Protocol) {

					((AbstractHttp11Protocol <?>) connector.getProtocolHandler()).setMaxSwallowSize(maxSize);
					logger.info("Set MaxSwallowSize "+ maxSize);
				}
			}
		};

	}*/
	//Tomcat large file upload connection reset
	//http://www.mkyong.com/spring/spring-file-upload-and-connection-reset-issue/
	/*@Bean
	@Primary
	public TomcatServletWebServerFactory tomcatEmbedded() {

		TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
		//tomcat.getTomcatConnectorCustomizers().clear();
		tomcat.addConnectorCustomizers((TomcatConnectorCustomizer) connector -> {
			if ((connector.getProtocolHandler() instanceof AbstractHttp11Protocol<?>)) {
				connector.setMaxPostSize(-1);
				connector.setMaxSavePostSize(-1);
			}
		});

		return tomcat;

	}*/
	@Bean
	MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		factory.setMaxFileSize(DataSize.ofBytes(512000000L));
		factory.setMaxRequestSize(DataSize.ofBytes(512000000L));
		factory.setFileSizeThreshold(DataSize.ofBytes(512000000L));
		return factory.createMultipartConfig();
	}
}
