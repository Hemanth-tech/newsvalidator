package com.newsvalidator.constants;


public enum ErrorCodes {
	
	/*
	 * To Provide customized error messages for assertions 
	 * */

	GUARDIAN_TITLE_MISMATCH("GUARDIAN_01", "Guardian page title mismatch"),
	GOOGLE_TITLE_MISMATCH("GOOGLE_01", "Google page title mismatch");
    
  

    private final String code;
    private final String message;

    ErrorCodes(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
