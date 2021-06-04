package com.example.demo;
import static org.assertj.core.api.Assertions.assertThat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

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
	
	@Test
	public void currentDay() {
		//arrange
		
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();

		String expectedResponse = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date.getTime());
		
		//act
		String actualResponse = controllerBasic.currentDayOfWeek();
		
		//assert
		assertThat(actualResponse).isEqualTo(expectedResponse);
	}
}
