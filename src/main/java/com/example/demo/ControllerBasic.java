package com.example.demo;

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

}
