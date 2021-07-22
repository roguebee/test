package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ControllerBasic {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${apiKey}")
	private String apiKey;

	public ControllerBasic(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public void setAlphaKey(String alphaKey) {
		this.apiKey = alphaKey;
	}

	@GetMapping("/basicResponse")
	public String basicResponse() {
		return "test reponse";
	}

	@GetMapping("/currentDayOfWeek")
	public String currentDayOfWeek() {

		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();

		return new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date.getTime());
	}

	@GetMapping("/industry/{ticker}")
	public String getStockIndustry(@PathVariable String ticker) {
		ResponseEntity<ApiOverview> responseEntity = restTemplate.getForEntity(
				"https://www.alphavantage.co/query?function=OVERVIEW&symbol=" + ticker + "&apikey=" + apiKey,
				ApiOverview.class);

		return responseEntity.getBody().getIndustry();
	}

}
