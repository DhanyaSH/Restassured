package com.dao;

import com.db.pojo.MST_OEM_POJO;

public class Runner_DAO {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		 MST_OEM_DAO mstDao = new  MST_OEM_DAO();
		 
		 MST_OEM_POJO myData = mstDao.getOENInoBy(2); 
		 System.out.println( myData.getId());
		 System.out.println( myData.getName());
		 System.out.println(myData);

}
}
