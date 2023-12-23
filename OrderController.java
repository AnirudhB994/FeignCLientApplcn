package com.infosys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.infosys.service.Product;
import com.infosys.service.ProductFeignClient;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	private ProductFeignClient pfc;
	
	public OrderController(ProductFeignClient pfc){
		this.pfc=pfc;
	}
	
	/*public WebClient.Builder wbc;
	public OrderController(WebClient.Builder wbc) {
		this.wbc=wbc;
	}*/
	
	@GetMapping("/{oid}")
	public String getOrder(@PathVariable("oid") long id) {
		long pid=1;
		Product p=pfc.getProduct(pid);
		return "OrderId: "+id+" and the product name is: "+p.getName();
	}
	
	/*@GetMapping("/{oid}")
	public Mono<String> getOrder(@PathVariable("oid") long id) {
		return wbc.build()
				.get()
				.uri("http://localhost:8081/products/{pid}",id)
				.retrieve()
				.bodyToMono(Product.class)
				.map(product->"Order Id: "+id+
						" and the product name: "+product.getName());
	}*/
	

}
