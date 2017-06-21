package de.felten.jenkinsmonitor.backing;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import de.felten.jenkinsmonitor.JenkinsMonitor;
import de.felten.jenkinsmonitor.ProjectStatus;

@Service(value="monitorBacking")
public class JenkinsMonitorBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Logger logger = LoggerFactory.getLogger(JenkinsMonitor.class);

	@Autowired
	JenkinsMonitor jenkinsMonitor;

	private int updateInterval = 10;
	private LocalDateTime lastUpdateTime = LocalDateTime.now();

	public LocalDateTime getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(LocalDateTime lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public void setUpdateInterval(int updateInterval) {
		if (updateInterval > 2) {
			this.updateInterval = updateInterval;
		}
	}

	public int getUpdateInterval() {
		return updateInterval;
	}

	public void setJenkinsMonitor(JenkinsMonitor jenkinsMonitor) {
		this.jenkinsMonitor = jenkinsMonitor;
	}

	public List<ProjectStatus> getProjectsStatus() {
		try {
			final List<ProjectStatus> jobs = jenkinsMonitor.crawlStatus().getJobs();
			lastUpdateTime = LocalDateTime.now();
			logger.info("Refreshed projects status: {}", jobs);
			return jobs;
		} catch (Exception e) {
			logger.error("Failed to get projects status: {}", e.getLocalizedMessage());
			return Collections.emptyList();
		}
	}

}
