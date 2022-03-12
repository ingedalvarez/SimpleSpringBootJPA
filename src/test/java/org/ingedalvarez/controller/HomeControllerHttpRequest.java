package org.ingedalvarez.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HomeControllerHttpRequest {
	@LocalServerPort
	private int port;
	private final TestRestTemplate restTemplate = new TestRestTemplate();	
	private final String local = "http://localhost:";
	

	@Test
	@DisplayName("Http Request showAllEmployees status value 200")
	public void showAllEmployeesHttpRequest() throws Exception {
		assertEquals(200, this.restTemplate.getForEntity(local+port+"/showAllEmployees", String.class).getStatusCodeValue());
	}


	@Test
	@DisplayName("Http Request showEmployee status 200")
	public void showEmployeeHttpRequestStatus() throws Exception {

		ResponseEntity<String> mv = this.restTemplate.getForEntity(local + port + "/showEmployee?id={id}", String.class,
				101);
		assertEquals(200, mv.getStatusCodeValue());

	}
	
	
	@Test
	@DisplayName("home controller return String home")
	void homeControllerTest() throws Exception {
		assertThat(this.restTemplate.getForObject(local + port + "/", String.class).contains("home"));
	}

	

}
