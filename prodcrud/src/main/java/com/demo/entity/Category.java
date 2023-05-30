package com.demo.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long cid;
    
    @Column(nullable = false)
	private String cname;
	private String description;
	@OneToMany(mappedBy = "category",fetch = FetchType.EAGER)
	@JsonIgnore
	//@JsonManagedReference
	private List<Product> products=new ArrayList<>();
	
	public Category() {
		super();
		
	}

	public Category(long cid, String cname, String description, List<Product> products) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.description = description;
		this.products = products;
	}

	public long getCid() {
		return cid;
	}

	public String getCname() {
		return cname;
	}

	public String getDescription() {
		return description;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setCid(long cid) {
		this.cid = cid;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Category [cid=" + cid + ", cname=" + cname + ", description=" + description + ", products=" + products
				+ "]";
	}

	
	
}
