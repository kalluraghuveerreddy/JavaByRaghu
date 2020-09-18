package com.javabyraghu.friendsportal.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class FreindsWebApplicationsInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

		AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
		webApplicationContext.register(WebApplicationContextConfig.class);

		DispatcherServlet dispatcherServlet = new DispatcherServlet(webApplicationContext);
		ServletRegistration.Dynamic customeDispatcherServlet = servletContext.addServlet("myDispatcher",
				dispatcherServlet);
		customeDispatcherServlet.setLoadOnStartup(1);
		customeDispatcherServlet.addMapping("/");

	}

}
