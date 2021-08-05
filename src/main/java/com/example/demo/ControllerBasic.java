package com.example.demo;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.BitmapEncoder.BitmapFormat;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.style.markers.SeriesMarkers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
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

	@GetMapping("/quote/{ticker}")
	public String getStockQuote(@PathVariable String ticker) {
		ResponseEntity<GlobalQuoteRoot> responseEntity = restTemplate.getForEntity(
				"https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=" + ticker + "&apikey=" + apiKey,
				GlobalQuoteRoot.class);

		return responseEntity.getBody().getGlobalQuote().get_05Price();
	}

	@GetMapping(value = "/quote/graph/{ticker}", produces = MediaType.IMAGE_PNG_VALUE)
	public byte[] getStockGraph(String ticker) throws IOException {
		double[] yData = new double[] { 2.0, 1.0, 0.0 };

//		// Create Chart
		XYChart chart = new XYChart(500, 400);
		chart.setTitle("Sample Chart");
		chart.setXAxisTitle("X");
		chart.setXAxisTitle("Y");
		XYSeries series = chart.addSeries("y(x)", null, yData);
		series.setMarker(SeriesMarkers.CIRCLE);
		
		byte[] bitmapBytes = BitmapEncoder.getBitmapBytes(chart, BitmapFormat.PNG);
		
	    return bitmapBytes;
	}
	
	@GetMapping(value = "/quote/graph/{ticker}", produces = MediaType.IMAGE_PNG_VALUE)
	public byte[] getStockGraphExample() throws IOException {
		double[] yData = new double[] { 2.0, 1.0, 0.0 };

//		// Create Chart
		XYChart chart = new XYChart(500, 400);
		chart.setTitle("Sample Chart");
		chart.setXAxisTitle("X");
		chart.setXAxisTitle("Y");
		XYSeries series = chart.addSeries("y(x)", null, yData);
		series.setMarker(SeriesMarkers.CIRCLE);
		
		byte[] bitmapBytes = BitmapEncoder.getBitmapBytes(chart, BitmapFormat.PNG);
		
	    return bitmapBytes;
	}

}
