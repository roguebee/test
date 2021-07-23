package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GlobalQuoteRoot {
	@JsonProperty("Global Quote")
	public GlobalQuote globalQuote;

	public GlobalQuote getGlobalQuote() {
		return globalQuote;
	}

	public void setGlobalQuote(GlobalQuote globalQuote) {
		this.globalQuote = globalQuote;
	}

}
