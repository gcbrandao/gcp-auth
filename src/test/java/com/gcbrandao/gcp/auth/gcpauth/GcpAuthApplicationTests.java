package com.gcbrandao.gcp.auth.gcpauth;

import com.google.auth.oauth2.GoogleCredentials;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
@AutoConfigureMockMvc
class GcpAuthApplicationTests {

	@Autowired
	GCPAccessToken gcpAccessToken;


	@Test
	public void shoulReturnTokenFromDirectFile() throws IOException {


		GoogleCredentials credentialDirectFile = gcpAccessToken.getCredentialDirectFile();
		// instanciando o GoogleCredentials e chamando nosso metodo que usa o JSON para se autenticar

		String accessToken = credentialDirectFile.getAccessToken().toString();
		// Salvando o conteudo do AccessToken em uma String

		System.out.printf("AccessToken: %s", accessToken);
		// Imprime na tela o valor do Token
	}

	@Test
	public void shouldReturnTokenFromEnvironmentVariable() throws IOException {
		GoogleCredentials credentialEnvironmentVariable = gcpAccessToken.getCredentialEnvironmentVariable();

		String accessToken = credentialEnvironmentVariable.getAccessToken().toString();

		System.out.printf("AccessToken: %s", accessToken);
	}

}
