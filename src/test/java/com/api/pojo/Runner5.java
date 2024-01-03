package com.api.pojo;

import com.github.javafaker.Faker;
import com.google.gson.Gson;

public class Runner5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LoginRequestPOJO login = new LoginRequestPOJO("iamfd", "password");

		String data = getJsonObject(login);

		System.out.println(data);
		CreateJobPOJO createJobPOJO = getCreatJobPOJO();

		data = getJsonObject(createJobPOJO);
		System.out.println(data);
	}

	public static String getJsonObject(Object pojo) {
		Gson gson = new Gson();
		String jsonData = gson.toJson(pojo);
		return jsonData;
	}

	public static CreateJobPOJO getCreatJobPOJO() {
		Faker faker = new Faker();
		String fName = faker.name().name();
		System.out.println(fName);
		String emailAddress = faker.internet().emailAddress();
		String contactNumber = faker.numerify("98########");
		Customer customer = new Customer(fName, "N", contactNumber, null, emailAddress, null);
		CustomerAddress address = new CustomerAddress("101", "ABC Apt", "XYZ street", "PQR", "area", "410042", "India",
				"maharashtra");

		String imei = faker.numerify("124############");
		CustomerProduct product = new CustomerProduct("2023-06-10T18:30:00.000Z", imei, imei, imei,
				"2023-06-10T18:30:00.000Z", 1, 1);
		Problem[] problems = new Problem[2];
		problems[0] = new Problem(1, "test");
		problems[1] = new Problem(2, "test 233245");

		CreateJobPOJO createJobPOJO = new CreateJobPOJO(1, 2, 0, 1, customer, address, product, problems);
		return createJobPOJO;
	}

}
