package com.newsvalidator.constants;


public enum Environment {
	
	/*
	 * To decide which property file has to be used for testing
	 * */

	QA("QA"), DEV("DEV"), PROD("PROD");


	String env;

	Environment(String env) {
		this.env = env;
	}

	public String getValue() {
		return env;
	}

}
