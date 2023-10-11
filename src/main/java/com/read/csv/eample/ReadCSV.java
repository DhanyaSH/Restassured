package com.read.csv.eample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

public class ReadCSV {

	public static void main(String[] args) throws IOException, CsvException {
		// TODO Auto-generated method stub
		
		//to tell path of the file
		File csvFile = new File(System.getProperty("user.dir")+"//testData//loginData.csv");
        FileReader fileReader = new FileReader(csvFile);
        CSVReader csvReader = new CSVReader(fileReader);
        
//       String data[] = csvReader.readNext();
//       print array
//       for (String myValues : data)
//       {
//        System.out.println(myValues);
//	}
//       System.out.println(data);
       
      List<String[]> datalist =csvReader.readAll();
     for(String data[]:datalist) {
    	 for(String myValue:data) {
    		 System.out.print(myValue+ " ");
    	 }
    	 System.out.println("");
	}
    
	}
}
