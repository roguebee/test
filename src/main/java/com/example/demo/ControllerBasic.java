package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerBasic {

	private static final String TEST_REPONSE = "test reponse";

	public ControllerBasic() { 	
		
	}
	
	@GetMapping("/basicResponse")
	public String basicResponse() {
		// TODO Auto-generated method stub
		return TEST_REPONSE;
	}

	@GetMapping("/currentDayOfWeek")
	public String currentDayOfWeek() {
		
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();

		return new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date.getTime());
	}

}
