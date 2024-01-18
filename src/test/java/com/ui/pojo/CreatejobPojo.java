package com.ui.pojo;

import com.github.javafaker.DateAndTime;
import com.github.javafaker.IdNumber;
import com.github.javafaker.Number;
import com.github.javafaker.PhoneNumber;

public class CreatejobPojo {
private String  OemName;
private String productName;
private String modelName;
private String imeiNumber;
private String dateofPurchase;
private String warrantyStatus;
private String selectProblem;
private String remarks;
private String firstname;
private String lastname;
private String contactNumber;
private String Emailid;
private String flat;
private String apartmentName;
private String Landmark;
private String StreetName;
private String Area;
private String country;
private String state;
private String  pincode;
private String submit;
private String jobtoast;
public CreatejobPojo(String oemName, String productName, String modelName, String imeiNumber, String dateofPurchase,
		String warrantyStatus, String selectProblem, String remarks, String firstname, String lastname,
		String contactNumber, String emailid,  String flat, String apartmentName, String landmark, String streetName,
		String area, String country, String state, String  pincode) {
	super();
	OemName = oemName;
	this.productName = productName;
	this.modelName = modelName;
	this.imeiNumber = imeiNumber;
	this.dateofPurchase = dateofPurchase;
	this.warrantyStatus = warrantyStatus;
	this.selectProblem = selectProblem;
	this.remarks = remarks;
	this.firstname = firstname;
	this.lastname = lastname;
	this.contactNumber = contactNumber;
	Emailid = emailid;
	this.flat = flat;
	this.apartmentName = apartmentName;
	Landmark = landmark;
	StreetName = streetName;
	Area = area;
	this.country = country;
	this.state = state;
	this.pincode = pincode;
	this.submit = submit;
	this.jobtoast = jobtoast;
}
public String getOemName() {
	return OemName;
}
public void setOemName(String oemName) {
	OemName = oemName;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public String getModelName() {
	return modelName;
}
public void setModelName(String modelName) {
	this.modelName = modelName;
}
public String getImeiNumber() {
	return imeiNumber;
}
public void setImeiNumber(String imeiNumber) {
	this.imeiNumber = imeiNumber;
}
public String getDateofPurchase() {
	return dateofPurchase;
}
public void setDateofPurchase(String dateofPurchase) {
	this.dateofPurchase = dateofPurchase;
}
public String getWarrantyStatus() {
	return warrantyStatus;
}
public void setWarrantyStatus(String warrantyStatus) {
	this.warrantyStatus = warrantyStatus;
}
public String getSelectProblem() {
	return selectProblem;
}
public void setSelectProblem(String selectProblem) {
	this.selectProblem = selectProblem;
}
public String getRemarks() {
	return remarks;
}
public void setRemarks(String remarks) {
	this.remarks = remarks;
}
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public  String getContactNumber() {
	return contactNumber;
}
public void setContactNumber(String contactNumber) {
	this.contactNumber = contactNumber;
}
public String getEmailid() {
	return Emailid;
}
public void setEmailid(String emailid) {
	Emailid = emailid;
}
public String getFlat() {
	return flat;
}
public void setFlat(String flat) {
	this.flat = flat;
}
public String getApartmentName() {
	return apartmentName;
}
public void setApartmentName(String apartmentName) {
	this.apartmentName = apartmentName;
}
public String getLandmark() {
	return Landmark;
}
public void setLandmark(String landmark) {
	Landmark = landmark;
}
public String getStreetName() {
	return StreetName;
}
public void setStreetName(String streetName) {
	StreetName = streetName;
}
public String getArea() {
	return Area;
}
public void setArea(String area) {
	Area = area;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getPincode() {
	return pincode;
}
public void setPincode(String pincode) {
	this.pincode = pincode;
}
public String getSubmit() {
	return submit;
}
public void setSubmit(String submit) {
	this.submit = submit;
}
public String getJobtoast() {
	return jobtoast;
}
public void setJobtoast(String jobtoast) {
	this.jobtoast = jobtoast;
}
@Override
public String toString() {
	return "CreatejobPojo [OemName=" + OemName + ", productName=" + productName + ", modelName=" + modelName
			+ ", imeiNumber=" + imeiNumber + ", dateofPurchase=" + dateofPurchase + ", warrantyStatus=" + warrantyStatus
			+ ", selectProblem=" + selectProblem + ", remarks=" + remarks + ", firstname=" + firstname + ", lastname="
			+ lastname + ", contactNumber=" + contactNumber + ", Emailid=" + Emailid + ", flat=" + flat
			+ ", apartmentName=" + apartmentName + ", Landmark=" + Landmark + ", StreetName=" + StreetName + ", Area="
			+ Area + ", country=" + country + ", state=" + state + ", pincode=" + pincode + ", submit=" + submit
			+ ", jobtoast=" + jobtoast + "]";
}



}