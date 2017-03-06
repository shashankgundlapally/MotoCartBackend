package com.nkart.shoppingcart.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity					//it will assume that a table exists with the name Category
@Table(name="Category") // if the class name and table name are different
@Component				//if we want to create the instance of class Category-category
public class Category 
{
	//add simple properties - same as category table
	//generate getter/setter methods
	
	@Id
	private String id;
	@Column(name="name")  //if the field name and property name is diff
	private String name;
	
	private String description;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
