package com.example.demo;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class ControllerTest {
	
	private ControllerBasic controllerBasic;
	
	public ControllerTest() {
		controllerBasic = new ControllerBasic();
	}	
	
	@Test
	public void testBasicReturn() {
		//arrange
		String expectedResponse = "test reponse";
		
		//act
		String actualResponse = controllerBasic.basicResponse();
		
		//assert
		assertThat(actualResponse).isEqualTo(expectedResponse);
	}
}
