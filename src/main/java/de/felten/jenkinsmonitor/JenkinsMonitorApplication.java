package de.felten.jenkinsmonitor;

import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.ServletContextAware;

import de.felten.jenkinsmonitor.config.Initializer;

@SpringBootApplication
public class JenkinsMonitorApplication extends SpringBootServletInitializer implements ServletContextAware {

	public static void main(String[] args) {
		SpringApplication.run(JenkinsMonitorApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(new Class[] { JenkinsMonitorApplication.class, Initializer.class });
	}

	@Bean
	public ServletRegistrationBean facesServletRegistration() {
		ServletRegistrationBean registration = new ServletRegistrationBean(new FacesServlet(), "*.xhtml");
		registration.setLoadOnStartup(1);
		return registration;
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
	}

}
