package com.ui.filters;

import java.util.function.Predicate;



import com.ui.pojo.DashboardTablePojo;

public class imeiFilter implements Predicate<DashboardTablePojo> {
  //predicate is the interface.predicate is to be the type of data you want to handle.i want to habndle imei it is part of DashboardTable pojo
	
	public String imei;
  
	public imeiFilter(String imei) {
	super();
	this.imei = imei;
}

	public boolean test(DashboardTablePojo t) {
		// TODO Auto-generated method stub

     if(imei.equals(t.getImei())) {
	 
	  return true;   
}else {

 return false;
}}}
