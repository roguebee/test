package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class QuoteApiService {

	private RestTemplate restTemplate;
	
	public QuoteApiService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public Map<LocalDate, BigDecimal> getDailySeries(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
