package com.api.pojo;

public class LoginResponse {
	private String message;
	private Data data;

	public LoginResponse(String message, Data data) {
		super();
		this.message = message;
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "LoginResponse [message=" + message + ", data=" + data + "]";
	}

}
