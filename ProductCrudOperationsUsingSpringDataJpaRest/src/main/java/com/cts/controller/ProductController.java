package com.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.exception.ProductNotFound;
import com.cts.model.Product;
import com.cts.service.ProductService;

@RestController
@RequestMapping("/products") // http://localhost:1111/products
public class ProductController {
	@Autowired
	ProductService service;

	// RequestMapping + Get request
	@GetMapping("/getMsg") // http://localhost:1111/products/getMsg
	// @RequestMappint(value="/getMsg", method=RequestMethod.GET)

	public String sayHello() {
		return "I am trying to listen but am getting sleep";
	}

	@PostMapping("/saveproduct") // http://localhost:1111/products/saveproduct
	public String insertProduct(@RequestBody @Validated Product product) {
		return service.saveProduct(product);
	}

	@PutMapping("/updateproduct") // http://localhost:1111/products/updateproduct
	public Product updateProduct(@RequestBody Product product) {
		return service.updateProduct(product);
	}

	@GetMapping("/getproduct/{pid}") // http://localhost:1111/products/getproduct/253
	public Product fetchProduct(@PathVariable("pid") int productId) throws ProductNotFound {
		return service.getProduct(productId);
	}

	@DeleteMapping("/deleteproduct/{pid}") // http://localhost:1111/products/deleteproduct/253
	public String deleteProduct(@PathVariable("pid") int productId) {
		service.removeProduct(productId);
		return "Product deleted successfully";
	}

	@GetMapping("/getAllproduct") // http://localhost:1111/products/getAllproduct
	public List<Product> getAllProduct() {
		return service.getAllProducts();
	}

	@GetMapping("/getAllproductBetween/{min}/{max}") // http://localhost:1111/products/getAllproductBetween
	public List<Product> getAllProductsBetween(@PathVariable("min") int min, @PathVariable("max") int max) {
		return service.getAllProductsBetween(min, max);
	}

	@GetMapping("/getAllProductsByCategory/{category}") // http://localhost:1111/products/getAllProductsByCategory/Electronics
	public List<Product> getAllProductsByCategory(@PathVariable("category") String category) {
		return service.getAllProductsByCategory(category);
	}

	@GetMapping("/getProductAbovePrice/{price}") // http://localhost:1111/products/getProductAbovePrice/500
	public List<Product> getProductAbovePrice(@PathVariable("price") int price) {
		return service.getProductAbovePrice(price);

	}
	
	//This is controller level exception handling. For every exception u have to create a method like this
	// and cant be handled by other controller so go for global exception handling
//	@ExceptionHandler(exception = ProductNotFound.class,produces = "Product Id Is Invalid")
//	public void handleProductNotFound()
//	{
//		
//	}
}
