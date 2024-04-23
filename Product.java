package com.example.demo;



import jakarta.persistence.*;

@Table(name="product")
@Entity
public class Product {
	@Id
	private int id;
	private String name;
	private int price;
	
	
	public int getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}



}
