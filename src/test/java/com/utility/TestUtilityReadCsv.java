package com.utility;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;



public class TestUtilityReadCsv {


	
	public static Iterator<String[]> readCSVFile(String filename){
        File csvFile = new File(System.getProperty("user.dir")+"//testData//loginData.csv");
        FileReader fileReader = null;
        CSVReader csvReader ;
        List<String[]> datalist = null ;
        
		try {
			fileReader = new FileReader(csvFile);
		    csvReader = new CSVReader(fileReader);
		     datalist =csvReader.readAll();	
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 	
		 catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (CsvException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	Iterator<String[]> dataiterator = datalist.iterator();
	return dataiterator;
	}
	}

