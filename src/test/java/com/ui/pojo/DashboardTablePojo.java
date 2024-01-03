package com.ui.pojo;

import java.util.Objects;

public class DashboardTablePojo {
private String OEM;
private String Job_Number;
private String Imei;
private String Product;
private String Model;
private String Warranty_Status;
private String Action_Status;
public DashboardTablePojo(String oEM, String job_Number, String imei, String product, String model,
		String warranty_Status, String action_Status) {
	super();
	OEM = oEM;
	Job_Number = job_Number;
	Imei = imei;
	Product = product;
	Model = model;
	Warranty_Status = warranty_Status;
	Action_Status = action_Status;	
}

public String getOEM() {
	return OEM;
}
public void setOEM(String oEM) {
	OEM = oEM;
}
public String getJob_Number() {
	return Job_Number;
}
public void setJob_Number(String job_Number) {
	Job_Number = job_Number;
}
public String getImei() {
	return Imei;
}
public void setImei(String imei) {
	Imei = imei;
}
public String getProduct() {
	return Product;
}
public void setProduct(String product) {
	Product = product;
}
public String getModel() {
	return Model;
}
public void setModel(String model) {
	Model = model;
}
public String getWarranty_Status() {
	return Warranty_Status;
}
public void setWarranty_Status(String warranty_Status) {
	Warranty_Status = warranty_Status;
}
public String getAction_Status() {
	return Action_Status;
}
public void setAction_Status(String action_Status) {
	Action_Status = action_Status;
}
	
	
	
@Override
public String toString() {
	return "DashboardTablePojo [OEM=" + OEM + ", Job_Number=" + Job_Number + ", Imei=" + Imei + ", Product=" + Product
			+ ", Model=" + Model + ", Warranty_Status=" + Warranty_Status + ", Action_Status=" + Action_Status + "]";
}

@Override
public int hashCode() {
	return Objects.hash(Action_Status, Imei, Job_Number, Model, OEM, Product, Warranty_Status);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	DashboardTablePojo other = (DashboardTablePojo) obj;
	return Objects.equals(Action_Status, other.Action_Status) && Objects.equals(Imei, other.Imei)
			&& Objects.equals(Job_Number, other.Job_Number) && Objects.equals(Model, other.Model)
			&& Objects.equals(OEM, other.OEM) && Objects.equals(Product, other.Product)
			&& Objects.equals(Warranty_Status, other.Warranty_Status);
}
	
	
	
	
	
	
	
	
	
	
}
