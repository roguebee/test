package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.mockito.Mockito;
import org.springframework.web.client.RestTemplate;

public class QuoteApiServiceTest {

	private static final String TICKER = "AMC";
	private QuoteApiService quoteApiService;
	private RestTemplate restTemplate;

	public QuoteApiServiceTest() {
		restTemplate = Mockito.mock(RestTemplate.class);
		quoteApiService = new QuoteApiService(restTemplate);
	}

	public void timeSeriesDailyTest() {
		// arrange
		Map<LocalDate, BigDecimal> expectedDailyData = new HashMap<LocalDate, BigDecimal>();
		expectedDailyData.put(LocalDate.parse("2007-02-12", DateTimeFormatter.BASIC_ISO_DATE), new BigDecimal(100));
		expectedDailyData.put(LocalDate.parse("2007-02-13", DateTimeFormatter.BASIC_ISO_DATE), new BigDecimal(120));
		expectedDailyData.put(LocalDate.parse("2007-02-14", DateTimeFormatter.BASIC_ISO_DATE), new BigDecimal(140));
		expectedDailyData.put(LocalDate.parse("2007-02-15", DateTimeFormatter.BASIC_ISO_DATE), new BigDecimal(105));

		// act
		Map<LocalDate, BigDecimal> actualDailyData = quoteApiService.getDailySeries(TICKER);

		// assert
	}

}
