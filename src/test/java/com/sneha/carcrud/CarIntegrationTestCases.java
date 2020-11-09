package com.sneha.carcrud;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.sneha.controller.CarsController;
import com.sneha.model.Cars;
import com.sneha.service.CarsService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CarsController.class)
public class CarIntegrationTestCases {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CarsService carService;

	Cars mockCar = new Cars(2,"Jazz",100000,"XUV",2006,"PETROL");

	String exampleCarJson = "{\n" + 
			"    \"carid\": \"2\",\n" + 
			"    \"carname\": \"Jazz\",\n" + 
			"    \"price\": \"1000000\",\n" + 
			"    \"model\": \"XUV\",\n" + 
			"    \"yearOfManufacture\" : \"2006\",\n" + 
			"    \"fuelType\":\"PETROL\"\n" + 
			"}";

	@Test
	public void retrieveDetailsForCourse() throws Exception {

		Mockito.when(
				carService.getCarsById(Mockito.anyInt())).thenReturn(mockCar);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/car").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "{carid:2,carname:Jazz,price:1000000,model:XUV,yearOfManufacture:2006,fuelType:PETROL}";


		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}

	
}
