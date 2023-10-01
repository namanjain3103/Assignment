package com.product.task1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.task1.entity.ProductEntity;
import com.product.task1.repository.ProductRepository;

import jakarta.validation.ValidationException;

@Service
public class ProductService {

	
	@Autowired
	private ProductRepository productRepository;

	public List<ProductEntity> getProductsByPriceLimit(double givenPrice) {
		 if (givenPrice < 0) {
	            throw new ValidationException("Given price must be greater than 0.");
	        }
	        return productRepository.findProductsByPriceLimit(givenPrice);
	}
	
    public List<ProductEntity> getProductsByPriceRange(double minPrice, double maxPrice) {
        if (minPrice < 0 || maxPrice < 0 || minPrice > maxPrice) {
            throw new ValidationException("Invalid price range");
        }
        return productRepository.findProductsByPriceRange(minPrice, maxPrice);
    }

}
