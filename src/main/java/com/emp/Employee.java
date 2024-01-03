package com.emp;

public class Employee {

	private int empId;
	private String name;
	private String projectNameString;
	private String skillset;
	public Employee(int empId, String name, String projectNameString, String skillset) {
		super();
		this.empId = empId;
		this.name = name;
		this.projectNameString = projectNameString;
		this.skillset = skillset;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProjectNameString() {
		return projectNameString;
	}
	public void setProjectNameString(String projectNameString) {
		this.projectNameString = projectNameString;
	}
	public String getSkillset() {
		return skillset;
	}
	public void setSkillset(String skillset) {
		this.skillset = skillset;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", projectNameString=" + projectNameString
				+ ", skillset=" + skillset + "]";
	}
	
	
	
	
}
