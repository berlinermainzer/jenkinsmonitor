package de.felten.jenkinsmonitor;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProjectStatus {

	public enum STATUS {
		blue, blue_anime, red, red_anime, yellow, yellow_anime, green, green_anime, aborted, disabled, notbuilt, aborted_anime
	}

	private String name;
	private STATUS status;

	public ProjectStatus(@JsonProperty("displayName") String name, @JsonProperty("color") String status) {
		this.name = name;
		this.status = STATUS.valueOf(status);
	}

	public String getName() {
		return name;
	}

	public STATUS getStatus() {
		return status;
	}

	@Override
	public String toString() {
		return name + ": " + status.toString();
	}
}
