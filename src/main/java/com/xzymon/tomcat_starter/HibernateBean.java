package com.xzymon.tomcat_starter;

import java.util.List;

import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.Session;

import com.xzymon.tomcat_starter.model.Test;

@Named
@RequestScoped
public class HibernateBean {
	
	@Inject
	private Session session;
	
	public List<Test> getTests(){
		session.beginTransaction();
		List<Test> result = (List<Test>) session.createQuery("from Test").list();
		session.getTransaction().commit();
		return result;
	}
	
	@PreDestroy
	private void closeSession(){
		session.close();
	}
}
