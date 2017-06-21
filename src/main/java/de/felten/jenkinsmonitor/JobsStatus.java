package de.felten.jenkinsmonitor;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JobsStatus {

	private final List<ProjectStatus> jobs;

	public JobsStatus(@JsonProperty("jobs") List<ProjectStatus> jobs) {
		this.jobs = jobs;
	}

	public List<ProjectStatus> getJobs() {
		return jobs;
	}

	@Override
	public String toString() {
		return jobs.toString();
	}
}
