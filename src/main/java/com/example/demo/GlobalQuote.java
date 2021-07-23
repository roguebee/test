package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString), Root.class); */
public class GlobalQuote {
	@JsonProperty("01. symbol")
	public String _01Symbol;
	@JsonProperty("02. open")
	public String _02Open;
	@JsonProperty("03. high")
	public String _03High;
	@JsonProperty("04. low")
	public String _04Low;
	@JsonProperty("05. price")
	public String _05Price;
	@JsonProperty("06. volume")
	public String _06Volume;
	@JsonProperty("07. latest trading day")
	public String _07LatestTradingDay;
	@JsonProperty("08. previous close")
	public String _08PreviousClose;
	@JsonProperty("09. change")
	public String _09Change;
	@JsonProperty("10. change percent")
	public String _10ChangePercent;

	public String get_01Symbol() {
		return _01Symbol;
	}

	public void set_01Symbol(String _01Symbol) {
		this._01Symbol = _01Symbol;
	}

	public String get_02Open() {
		return _02Open;
	}

	public void set_02Open(String _02Open) {
		this._02Open = _02Open;
	}

	public String get_03High() {
		return _03High;
	}

	public void set_03High(String _03High) {
		this._03High = _03High;
	}

	public String get_04Low() {
		return _04Low;
	}

	public void set_04Low(String _04Low) {
		this._04Low = _04Low;
	}

	public String get_05Price() {
		return _05Price;
	}

	public void set_05Price(String _05Price) {
		this._05Price = _05Price;
	}

	public String get_06Volume() {
		return _06Volume;
	}

	public void set_06Volume(String _06Volume) {
		this._06Volume = _06Volume;
	}

	public String get_07LatestTradingDay() {
		return _07LatestTradingDay;
	}

	public void set_07LatestTradingDay(String _07LatestTradingDay) {
		this._07LatestTradingDay = _07LatestTradingDay;
	}

	public String get_08PreviousClose() {
		return _08PreviousClose;
	}

	public void set_08PreviousClose(String _08PreviousClose) {
		this._08PreviousClose = _08PreviousClose;
	}

	public String get_09Change() {
		return _09Change;
	}

	public void set_09Change(String _09Change) {
		this._09Change = _09Change;
	}

	public String get_10ChangePercent() {
		return _10ChangePercent;
	}

	public void set_10ChangePercent(String _10ChangePercent) {
		this._10ChangePercent = _10ChangePercent;
	}

}
