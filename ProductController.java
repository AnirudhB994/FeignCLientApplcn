package com.infosys.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.entity.Product;

@RestController
@RequestMapping("/products")
public class ProductController {

	@GetMapping("/{pid}")
	public Product getProduct(@PathVariable("pid") long id) {
		return new Product(id,"Sample Product",26.29);
	}
}
