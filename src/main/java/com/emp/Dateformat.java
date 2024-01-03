package com.emp;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Dateformat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Date date = new Date ();
		System.out.println(date.toString());
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YY-HH-mm");
		String formateddate= sdf.format(date);
		System.out.println(formateddate);
	}

}
