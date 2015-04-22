package com.xzymon.tomcat_starter.cdi.producers;

import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xzymon.tomcat_starter.util.AppConstants;

public class HibernateSessionProducer {

	@Inject
	private FacesContext facesContext;
	
	@Produces
	@RequestScoped
	public Session produceHibernateSession(){
		Map<String, Object> servletContextMap = facesContext.getExternalContext().getApplicationMap();
		SessionFactory factory = (SessionFactory) servletContextMap.get(AppConstants.HIBERNATE_SESSION_FACTORY_ATTR_NAME);
		return factory.openSession();
	}
}
