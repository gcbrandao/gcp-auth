package com.gcbrandao.gcp.auth.gcpauth.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Data
// lombok de getters e setters
@Component
@ComponentScan
@ConfigurationProperties(prefix = "google.cloud")
// config que aponta para leitura do nosso application.yml
public class GoogleCloudProperties {

	private int connectionTimeout = 60000;
	private int readTimeout = 60000; 
	private String securityKeyFile;
    private String projectId;
    private String location;

    
}

