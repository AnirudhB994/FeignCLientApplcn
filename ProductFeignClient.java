package com.infosys.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="PRODUCT-SERVICE")
public interface ProductFeignClient {

	@GetMapping("/products/{pid}")
	public Product getProduct(@PathVariable("pid") long id) ;
}
