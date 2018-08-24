package de.felten.jenkinsmonitor;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import de.felten.jenkinsmonitor.JenkinsMonitor;
import de.felten.jenkinsmonitor.JenkinsMonitorApplication;
import de.felten.jenkinsmonitor.JobsStatus;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = JenkinsMonitorApplication.class)
@WebAppConfiguration
public class JenkinsmonitorApplicationTests {

	@Autowired
	JenkinsMonitor monitor;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testName() throws Exception {
		JobsStatus status = monitor.crawlStatus();
		Assert.assertFalse(status.getJobs().isEmpty());
	}

}
