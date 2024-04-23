package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes({ "id", "name", "price" })
public class MainController {

	@Autowired
	private ProductRepository productRepository;

	@GetMapping("hello")
	public String displayHello() {
		System.out.println("Inside hello");
		return "hello";
	}

	@GetMapping("product")
	public String displayproduct() {
		System.out.println("Inside product");
		return "product";
	}

	@PostMapping("productView")
	public String displayProductView(@RequestParam("id") String id, @RequestParam("name") String name,
			@RequestParam("price") String price, @ModelAttribute Product product, Model model) {
		System.out.println("Inside product view");
		System.out.println("Id is: " + id);
		System.out.println("name is " + product.getName());
		System.out.println("price is " + price);
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		model.addAttribute("price", price);
		
		productRepository.save(product);

		List<Product> proList = productRepository.findAll();
		System.out.println("Displaying all employeesfrom table employee :");
		for (Product p : proList) {
			System.out.println(p.getName());
		}

		// Fetches single Product Select * from Product where id=1
		System.out.println("Displaying single Product from table Product :");
		List<Product> prodOpt = productRepository.findById(Integer.parseInt(id));
		Product pro = prodOpt.get(0);
		System.out.println(pro.getId());

		// Fetches all Products Select * from Product where name=....
		List<Product> proList2 = productRepository.findByName(product.getName());
		System.out.println("Displaying  Products from table Product for a particular Name :");
		for (Product p2 : proList2) {
			System.out.println(p2.getName());
		}

		// Fetches all Products Select * from Product where position=...

		List<Product> proList3 = productRepository.findByPrice(Integer.parseInt(price));
		System.out.println("Displaying  Products from table Product for a particular Position :");
		for (Product p3 : proList3) {
			System.out.println(p3.getPrice());

		}
		return "productView";
	}
}
