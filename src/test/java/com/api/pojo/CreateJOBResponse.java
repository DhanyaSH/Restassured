package com.api.pojo;

public class CreateJOBResponse {
	String message;
	CreateJobData data;

	public CreateJOBResponse(String message, CreateJobData data) {
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

	public CreateJobData getData() {
		return data;
	}

	public void setData(CreateJobData data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "CreateJOBResponse [message=" + message + ", data=" + data + "]";
	}

}
