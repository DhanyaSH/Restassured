package com.api.pojo;

import com.google.gson.Gson;

public class Runner3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Customer customer = new Customer("Virag", "N", "777777777", null, "virag@gmail.com", null);
		CustomerAddress address = new CustomerAddress("101", "ABC Apt", "XYZ street", "PQR", "area", "410042", "India",
				"maharashtra");
		CustomerProduct product = new CustomerProduct("2023-06-10T18:30:00.000Z", "40486011257803", "40486011257803",
				"40486011257803", "2023-06-10T18:30:00.000Z", 1, 1);
		Problem[] problems = new Problem[2];
		problems[0] = new Problem(1, "test");
		problems[1] = new Problem(2, "test 233245");

		CreateJobPOJO createJobPOJO = new CreateJobPOJO(1, 2, 0, 1, customer, address, product, problems);

		System.out.println(createJobPOJO);

	}

	public static String getJsonObject(Object pojo) {
		Gson gson = new Gson();
		String jsonData = gson.toJson(pojo);
		return jsonData;
	}

}
