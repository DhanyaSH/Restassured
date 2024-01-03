package com.api.pojo;

public class jobidpojo{
	private int job_id;

	public jobidpojo(int job_id) {
		super();
		this.job_id = job_id;
	}

	public int getJob_id() {
		return job_id;
	}

	public void setJob_id(int job_id) {
		this.job_id = job_id;
	}

	@Override
	public String toString() {
		return "jobidpojo [job_id=" + job_id + "]";
	}
	
	
}
