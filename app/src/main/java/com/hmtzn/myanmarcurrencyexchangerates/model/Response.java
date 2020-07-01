package com.hmtzn.myanmarcurrencyexchangerates.model;

import com.hmtzn.myanmarcurrencyexchangerates.model.Rates;

public class Response{
	private Rates rates;
	private String description;
	private String info;
	private String timestamp;

	public Rates getRates(){
		return rates;
	}

	public String getDescription(){
		return description;
	}

	public String getInfo(){
		return info;
	}

	public String getTimestamp(){
		return timestamp;
	}
}
