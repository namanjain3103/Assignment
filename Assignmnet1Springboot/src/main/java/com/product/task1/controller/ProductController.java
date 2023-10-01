package com.product.task1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product.task1.entity.ProductEntity;
import com.product.task1.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	  @GetMapping("/product-price")
	    public List<ProductEntity> getProductsByPriceLimit(@RequestParam("price") Double price) {
	        return productService.getProductsByPriceLimit(price);
	    }
	  
	  @GetMapping("/price-range")
	    public List<ProductEntity> getProductsByPriceRange(
	        @RequestParam("minPrice") double minPrice,
	        @RequestParam("maxPrice") double maxPrice) {
		  System.out.println("hello");
	        return productService.getProductsByPriceRange(minPrice, maxPrice);
	    }
}
