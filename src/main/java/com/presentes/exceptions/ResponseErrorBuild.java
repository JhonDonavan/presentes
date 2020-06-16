package com.presentes.exceptions;

public class ResponseErrorBuild {

	private final String message;
	private final Integer code;
	private final String status;
	private final String error;

	public ResponseErrorBuild(String message, Integer code, String status, String error) {
		super();
		this.message = message;
		this.code = code;
		this.status = status;
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public Integer getCode() {
		return code;
	}

	public String getStatus() {
		return status;
	}

	public String getError() {
		return error;
	}

}
