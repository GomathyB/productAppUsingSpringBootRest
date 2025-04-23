package com.cts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.model.Product;
import com.cts.repository.ProductRepository;
import com.cts.service.ProductServiceImpl;

@SpringBootTest
class ProductCrudOperationsUsingSpringJpaApplicationTests {
	@Mock
	ProductRepository repository;
	
	@InjectMocks
	ProductServiceImpl service;
	@Test
	void saveProducttest() {
		Product product=new Product("Samsung",23000,"Electronics",20);
		Mockito.when(repository.save(product)).thenReturn(product);
		
		String response=service.saveProduct(product);
		
		assertEquals("Product saved successfully",response);
		//assertTrue("");
	}

}
