package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ControllerTest {

	private static final String API_KEY = "H4EUUANL128ARQUP";

	private RestTemplate restTemplate;

	private ControllerBasic controllerBasic;

	public ControllerTest() {
		restTemplate = Mockito.mock(RestTemplate.class);
		controllerBasic = new ControllerBasic(restTemplate);
	}

	@Test
	public void testBasicReturn() {
		// arrange
		String expectedResponse = "test reponse";

		// act
		String actualResponse = controllerBasic.basicResponse();

		// assert
		assertThat(actualResponse).isEqualTo(expectedResponse);
	}

	@Test
	public void currentDay() {
		// arrange
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();

		String expectedResponse = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date.getTime());

		// act
		String actualResponse = controllerBasic.currentDayOfWeek();

		// assert
		assertThat(actualResponse).isEqualTo(expectedResponse);
	}

	@Test
	public void stockIndustry() {
		// arrange
		String expectedResponse = "industry";
		String urlAMC = "https://www.alphavantage.co/query?function=OVERVIEW&symbol=AMC&apikey=H4EUUANL128ARQUP";

		controllerBasic.setAlphaKey(API_KEY);

		String stockIndustry = "industry";

		ApiOverview apiOverview = new ApiOverview();
		apiOverview.setIndustry(stockIndustry);

		Mockito.when(restTemplate.getForEntity(urlAMC, ApiOverview.class))
				.thenReturn(new ResponseEntity<ApiOverview>(apiOverview, HttpStatus.OK));

		// act
		String stockTicker = "AMC";
		String actualResponse = controllerBasic.getStockIndustry(stockTicker);

		// assert
		assertThat(actualResponse).isEqualTo(expectedResponse);
	}
}
