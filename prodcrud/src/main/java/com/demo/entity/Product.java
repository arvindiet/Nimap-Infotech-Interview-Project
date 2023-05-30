package com.demo.entity;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	private String pname;
	private double price;
	private String description;
	@ManyToOne
	@JsonIgnore
	//@JsonBackReference
	private Category category;
	public Product() {
		super();
		
	}
	public Product(int id, String pname, double price, String description, Category category) {
		super();
		Id = id;
		this.pname = pname;
		this.price = price;
		this.description = description;
		this.category = category;
	}
	public int getId() {
		return Id;
	}
	public String getPname() {
		return pname;
	}
	public double getPrice() {
		return price;
	}
	public String getDescription() {
		return description;
	}
	public Category getCategory() {
		return category;
	}
	public void setId(int id) {
		Id = id;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Product [Id=" + Id + ", pname=" + pname + ", price=" + price + ", description=" + description
				+ ", category=" + category + "]";
	}

	
}

