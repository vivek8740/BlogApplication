package com.springblog.payload;

public class ResponseApi {

	private String message;
	private boolean status;

	public ResponseApi() {
		super();
	}

	public ResponseApi(String message, boolean status) {
		this.message = message;
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
