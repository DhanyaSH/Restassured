package com.emp;

public class QA extends Employee  {

	public QA(int empId, String name, String projectNameString, String skillset) {
		super(empId, name, projectNameString, skillset);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "QA [getEmpId()=" + getEmpId() + ", getName()=" + getName() + ", getProjectNameString()="
				+ getProjectNameString() + ", getSkillset()=" + getSkillset() + "]";
	}


	
	
}
