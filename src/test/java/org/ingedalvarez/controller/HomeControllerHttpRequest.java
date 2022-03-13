package org.ingedalvarez.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
	@DisplayName("Http Request deleteEmployee sussefull return deleted employee and status value 200")
	public void deleteEmployeeHttpRequest() throws Exception {
		
		this.restTemplate.getForEntity(local+port+"/addEmployee?id=999&name=Jhon+Doe&age=99&salary=999999", String.class).getBody().toString();
		String body = this.restTemplate.getForEntity(local+port+"/deleteEmployee?id=999", String.class).getBody().toString();
		assertTrue(body.contains("Employee [id=999, name=Jhon Doe, age=99, salary=999999.0]"));
		assertEquals(200, this.restTemplate.getForEntity(local+port+"/addEmployee?id=999&name=Jhon+Doe&age=99&salary=999999", String.class).getStatusCodeValue());
	}
	
	@Test
	@DisplayName("Http Request addEmployee sussefull and status value 200")
	public void addEmployeeHttpRequest() throws Exception {
		String body = this.restTemplate.getForEntity(local+port+"/addEmployee?id=999&name=Jhon+Doe&age=99&salary=999999", String.class).getBody().toString();
		assertTrue(body.contains("Employee [id=999, name=Jhon Doe, age=99, salary=999999.0]"));
		assertEquals(200, this.restTemplate.getForEntity(local+port+"/addEmployee?id=999&name=Jhon+Doe&age=99&salary=999999", String.class).getStatusCodeValue());
	}
	
	@Test
	@DisplayName("Http Request showAllEmployees status value 200")
	public void showAllEmployeesHttpRequest() throws Exception {
		String body = this.restTemplate.getForEntity(local+port+"/showAllEmployees", String.class).getBody().toString();
		assertTrue(body.contains("[Employee [id=101, name=Edward Alvarez, age=44, salary=1200.0], Employee [id=102, name=Freddy Alvarez, age=41, salary=1300.0], Employee [id=103, name=Johan Alvarez, age=47, salary=1100.0], Employee [id=104, name=Patricia Alvarez, age=38, salary=1000.0], Employee [id=105, name=Yolecy Sarmiento, age=37, salary=1800.0], Employee [id=106, name=Carmen Gonzalez, age=65, salary=1900.0], Employee [id=107, name=Yalena Sarmiento, age=43, salary=2200.0], Employee [id=108, name=Raul Sarmiento, age=43, salary=3000.0], Employee [id=109, name=Veronica Viedma, age=35, salary=2500.0]"));
		assertEquals(200, this.restTemplate.getForEntity(local+port+"/showAllEmployees", String.class).getStatusCodeValue());
	}


	@Test
	@DisplayName("Http Request showEmployee status value 200")
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
