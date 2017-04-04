package com.niit.shoppingcart.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Entity					//it will assume that a table exists with the name Category
@Table // if the class name and table name are different
@Component				//if we want to create the instance of class Category-category
public class Category 
{
	//add simple properties - same as category table
	//generate getter/setter methods
	
	@Id
	@GeneratedValue
	private int id;
	@Column(name="name")  //if the field name and property name is diff
	@NotEmpty
	private String name;
	@NotEmpty
	private String description;
	
	
	@OneToMany(mappedBy="category",fetch=FetchType.EAGER)
	private Set<Product> products;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
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
