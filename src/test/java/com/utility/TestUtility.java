package com.utility;


import java.util.function.Predicate;
import static io.restassured.RestAssured.given;
import org.testng.ITestContext;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.groovy.parser.antlr4.GroovyParser.NonWildcardTypeArgumentsContext;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.ITestContext;

import com.api.pojo.AssigntoEngineerPOJO;
import com.api.pojo.CreateJOBResponse;
import com.api.pojo.CreateJobPOJO;
import com.api.pojo.Customer;
import com.api.pojo.CustomerAddress;
import com.api.pojo.CustomerProduct;
import com.api.pojo.LoginRequestPOJO;
import com.api.pojo.Problem;
import com.api.pojo.RepairCompletePojo;
import com.github.javafaker.DateAndTime;
import com.github.javafaker.Faker;
import com.github.javafaker.IdNumber;
import com.github.javafaker.Number;
import com.github.javafaker.PhoneNumber;
import com.google.gson.Gson;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.ui.filters.imeiFilter;
import com.ui.pojo.CreatejobPojo;
import com.ui.pojo.DashboardTablePojo;

import freemarker.core.ReturnInstruction.Return;
import io.restassured.http.Header;
import io.restassured.mapper.ObjectMapper;

public class TestUtility {

	public static int job_id;
	public static int engineer_id;

	public static AssigntoEngineerPOJO getjobidemployeeid() {
		AssigntoEngineerPOJO jobidemployeeid = new AssigntoEngineerPOJO(TestUtility.job_id,TestUtility.engineer_id);
		
		return jobidemployeeid;
		}
	
	
	
	
	
	

	/**
	 * utility method for reading the excel file to pass data to the data provider method
	 * @return String [][]
	 * @throws IOException
	 */
	public static String[][] readExcelFile() throws IOException {

		XSSFWorkbook myWorkbook = new XSSFWorkbook(System.getProperty("user.dir") + "//testData//LoginExcel.xlsx");
		XSSFSheet mySheet = myWorkbook.getSheetAt(0);
		int lastIndexOfRow = mySheet.getLastRowNum();
		XSSFRow myHeader = mySheet.getRow(0);
		int totalNumberOfCols = myHeader.getLastCellNum();
		System.out.println("Last Index of Row is" + lastIndexOfRow);
		System.out.println("total Number of Cols is " + totalNumberOfCols);

		String myData[][] = new String[lastIndexOfRow][totalNumberOfCols];
		XSSFRow myRow;
     	XSSFCell myCell;
		for (int rowIndex = 1; rowIndex <= lastIndexOfRow; rowIndex++) {
			for (int colIndex = 0; colIndex < totalNumberOfCols; colIndex++) {
				myRow = mySheet.getRow(rowIndex);
				myCell = myRow.getCell(colIndex);
				myData[rowIndex - 1][colIndex] = myCell.getStringCellValue(); // You have read excel and stored it in a
																				// 2D
			}
			System.out.println("");
		}

		return myData;
	}
	
	

	/**
	 * it will be used in the API request to pass the JSON body
	 * @param pojo
	 * @return JSON representation of the POJO in string format
	 */
	public static String getJsonObject(Object pojo) {
		Gson gson = new Gson();
		String jsonData = gson.toJson(pojo);
		return jsonData;
	}

	public static CreateJOBResponse convertJSONtoCreateJOBResponsePOJO(String jsonData) {
		Gson gson = new Gson();
		CreateJOBResponse pojo = gson.fromJson(jsonData, CreateJOBResponse.class);
		return pojo;
	}

	public static Iterator<String[]> readCSVFile(String fileName) {

		File csvFile = new File(System.getProperty("user.dir") + "//testData//" + fileName);
		FileReader fileReader = null;
		CSVReader csvReader;
		List<String[]> dataList = null;
		try {
			fileReader = new FileReader(csvFile);
			csvReader = new CSVReader(fileReader);
			dataList = csvReader.readAll();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CsvException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Iterator<String[]> dataIterator = dataList.iterator();

		dataIterator.next(); // oth retrived but i will not store
	return dataIterator;

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

		CreateJobPOJO createJobPOJO = new CreateJobPOJO(0, 2, 1, 1, customer, address, product, problems);
		return createJobPOJO;
	}

	public static String getTokenFor(String role) {
		LoginRequestPOJO loginPojo = null;
		if (role.equalsIgnoreCase("fd")) {
			loginPojo = new LoginRequestPOJO("iamfd", "password");
		} else if (role.equalsIgnoreCase("sup")) {
			loginPojo = new LoginRequestPOJO("iamsup", "password");

		} else if (role.equalsIgnoreCase("eng")) {
			loginPojo = new LoginRequestPOJO("iameng", "password");

		} else if (role.equalsIgnoreCase("qc")) {
			loginPojo = new LoginRequestPOJO("iamqc", "password");

		}

		String token = given().when().header(new Header("Content-type", "application/json")).and()
				.body(getJsonObject(loginPojo)).and().log().all().post("/login").then().extract().jsonPath()
				.getString("data.token");

		return token;
	}

	public static String gettime() {
		Date date = new Date();
		System.out.println(date.toString());

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YY-HH-mm");
		String formateddate = sdf.format(date);
		System.out.println(formateddate);
		return formateddate;
	}

	public static CreatejobPojo createFakeData() {
		Faker faker = new Faker();
		String fName = faker.name().name();
///	CreatejobPojo data = new CreatejobPojo("Google","Nexus 2",faker.name().firstName(),faker.name().lastName(),faker.internet().emailAddress());
        String imei = faker.numerify("12345678912345");
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
        String  dateString = sdf.format(faker.date().birthday());
    
         String contactNumber = faker.numerify("9446423672");
         String flatno  = faker.numerify("89");
          String pincode = faker.numerify("67#####");
        
		CreatejobPojo data = new CreatejobPojo("Google", "Nexus 2","Nexus 2 blue",imei,dateString,"In Warrenty","Poor battery life",faker.name().firstName(),
				faker.name().firstName(), faker.name().lastName(), contactNumber, faker.internet().emailAddress(),flatno,
				faker.name().name(), faker.name().name(), faker.name().name(),
				faker.name().name(), faker.name().name(),faker.name().name(),pincode);

		return data;
	

}
	
//search something from collection
	
public static boolean  searchEntryInList(List<DashboardTablePojo> dataList,DashboardTablePojo data) {

Iterator<DashboardTablePojo> dataIterator = dataList.iterator();
boolean status = false;
while(dataIterator.hasNext()) {
DashboardTablePojo datafromTable = dataIterator.next();
System.out.println(datafromTable );
System.out.println(data);
if(datafromTable.equals(data))
{
status = true;

}else 
{
status = false;

}
}
return status;
}

//compare with stream

public static boolean  searchEntryInList(List<DashboardTablePojo> dataList,String imeiNumber) {
	 imeiFilter Filter = new  imeiFilter(imeiNumber);
Object[] data = dataList.stream().filter( Filter).toArray();
if(data.length >1) {
	System.out.println("found");
	return true;
}else {
	return false;
}

}
}