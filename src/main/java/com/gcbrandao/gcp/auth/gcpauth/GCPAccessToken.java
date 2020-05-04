package com.gcbrandao.gcp.auth.gcpauth;

import com.gcbrandao.gcp.auth.gcpauth.config.GoogleCloudProperties;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ServiceAccountCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

@Component
@ComponentScan
public class GCPAccessToken {


	@Autowired
	private GoogleCloudProperties cloudProperties;
	// injetando a classe de configuração

	private GoogleCredentials credential;


	/*
	 * Pega o token apontando para o arquivo JSON direto
	 */

	public  GoogleCredentials getCredentialDirectFile() throws IOException {

		String securityKeyFile = cloudProperties.getSecurityKeyFile();
		// recuperando o arquivo json
		credential = GoogleCredentials // objeto resposavel pelas credenciais
				.fromStream(new ClassPathResource(securityKeyFile).getInputStream()) // recupera o arquivo JSON
				.createScoped(Collections.singletonList("https://www.googleapis.com/auth/devstorage.read_only"));
				// informa o escopo do acesso

		credential.refreshIfExpired();

		return credential;
		// retorna o objeto GoogleCredentials com as credenciais nele
	}

	public GoogleCredentials getCredentialEnvironmentVariable() throws IOException {

		// Authenticate requests using Google Application Default credentials.
		GoogleCredentials credential = GoogleCredentials.getApplicationDefault();
		credential = credential.createScoped(Collections.singletonList("https://www.googleapis.com/auth/devstorage.read_only"));



		credential.refreshIfExpired();

		return credential;

	}
}
