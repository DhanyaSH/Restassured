package com.emp;

public final class Intern extends Dev {

	public Intern(int empId, String name, String projectNameString, String skillset) {
		super(empId, name, projectNameString, skillset);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Intern [getEmpId()=" + getEmpId() + ", getName()=" + getName() + ", getProjectNameString()="
				+ getProjectNameString() + ", getSkillset()=" + getSkillset() + "]";
	}

	
	
	}


