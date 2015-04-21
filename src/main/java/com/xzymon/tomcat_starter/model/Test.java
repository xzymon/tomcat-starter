package com.xzymon.tomcat_starter.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity(name="Test")
@Table(name="test", uniqueConstraints={
		@UniqueConstraint(columnNames={"id_test"})
})
public class Test implements Serializable{
	
	private static final long serialVersionUID = 8243940356821340149L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_test", nullable=false, unique=true)
	private Long id;
	
	@Column(name="nazwa", nullable=false)
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Test id:" + id + " name:" + name ;
	}
	
}
