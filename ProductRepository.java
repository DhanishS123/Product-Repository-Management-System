package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{
	List<Product>findById(int id);
	List<Product>findByName(String name);
	List<Product>findByPrice(int price);
	
}
