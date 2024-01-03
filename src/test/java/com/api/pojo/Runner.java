package com.api.pojo;

import com.google.gson.Gson;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LoginRequestPOJO loginRequestPOJO = new LoginRequestPOJO("iamfd", "password");
		System.out.println(loginRequestPOJO);

		LoginRequestPOJO loginRequestPOJO2 = new LoginRequestPOJO("iamsup", "password");
		System.out.println(loginRequestPOJO2);

		// to convert Java object to JSON object
		// Java doesnt know how to do it?
		// 3rd party library- GSON
		Gson gson = new Gson();
		String data = gson.toJson(loginRequestPOJO);
		System.out.println(data);
		
		
		data = gson.toJson(loginRequestPOJO2);
		System.out.println(data);

	}

}
