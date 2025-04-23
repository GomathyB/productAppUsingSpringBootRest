package com.cts.repository;

import com.cts.model.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	// Here we have used the DSL grammar for the custom queries.
	// It is Domain Specific Language. Follow the naming conventions provided there
	// to the method name
	public abstract List<Product> findByProductPriceBetween(int intialPrice, int finalPrice);

	public abstract List<Product> findByProductCategory(String category);

	public abstract List<Product> findByProductPriceGreaterThan(int price);

//	@Query("select p from Product p where p.productPrice between ?1 and ?2")
//	public abstract List<Product> getAllProductsBetween(int intialPrice, int finalPrice);

//	@Query("select p from Product p where p.productCategory=?1")
//	public abstract List<Product> getAllProductsByCategory(String category);

//	public abstract List<Product> getProductAbovePrice(int price);

}
