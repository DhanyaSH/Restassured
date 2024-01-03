package com.api.pojo;

import java.util.Arrays;

public class RepairCompletePojo {
	
	private int job_id;
	private Problem problems[];
	
	public RepairCompletePojo(int job_id, Problem problems[]) {
		super();
		this.job_id = job_id;
		this.problems = problems;
	}

	public int getJob_id() {
		return job_id;
	}

	public void setJob_id(int job_id) {
		this.job_id = job_id;
	}

	public Problem[] getProblems() {
		return problems;
	}

	public void setProblems(Problem[] problems) {
		this.problems = problems;
	}

	@Override
	public String toString() {
		return "RepairCompletePojo [job_id=" + job_id + ", problems=" + Arrays.toString(problems) + "]";
	}


	
	
	
	
	
	
}
