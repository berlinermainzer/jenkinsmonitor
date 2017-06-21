package de.felten.jenkinsmonitor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("jenkinsMonitor")
public class JenkinsMonitor {

	@Value("${monitor.url}")
	private String urlString;

	public JobsStatus crawlStatus() {
		RestTemplate restTemplate = new RestTemplate();
		JobsStatus status = restTemplate.getForObject(urlString, JobsStatus.class);
		return status;
	}

}
