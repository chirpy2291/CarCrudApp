package com.sneha.carcrud;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.sneha.model.Cars;


@RunWith(SpringRunner.class)
@SpringBootTest()
public class CarCrudIntegrationTests {
	
	@Autowired
	TestRestTemplate restTemplate;

//	@LocalServerPort
//	private int port;

	private String getRootUrl() {
		return "http://localhost:8080";
	}

	@Test
	public void testCreateEmployee() {
	        Cars car = new Cars();
	        car.setCarid(1);
	        car.setCarname("Hu");
	        car.setFuelType("PETROL");
	        car.setModel("SUV");
	        car.setPrice(10000);
	        car.setYearOfManufacture(2020);
	      
	        ResponseEntity<Cars> postResponse = restTemplate.postForEntity(getRootUrl() + "/cars", car, Cars.class);
	        assertNotNull(postResponse);
	        assertNotNull(postResponse.getBody());
	    }

	@Test
	public void testGetAllEmployees() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/car", HttpMethod.GET, entity,
				String.class);
		assertNotNull(response.getBody());
	}

}
