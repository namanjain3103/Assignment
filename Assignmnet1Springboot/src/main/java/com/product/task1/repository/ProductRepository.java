package com.product.task1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.product.task1.entity.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    @Query("SELECT p FROM ProductEntity p WHERE p.productPrice > :givenPrice")
    List<ProductEntity> findProductsByPriceLimit(double givenPrice);

    @Query("SELECT p FROM ProductEntity p WHERE p.productPrice BETWEEN :minPrice AND :maxPrice")
    List<ProductEntity> findProductsByPriceRange( double minPrice, double maxPrice);
	
}
