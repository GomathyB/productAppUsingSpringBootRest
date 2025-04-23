package com.cts.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "products_info")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Product {
	@Id
	@Column(name = "pid")
	@GeneratedValue
	private int productId;
	@NotBlank(message = "Product Name can't be NULL or EMPTY") // does not allow " " checks for null and blank
	// @NotNull
	// @NotEmpty allows " "
	private String productName;
	@Column(name = "price")
	@Min(value = 100, message = "Product price can't be less than 100")
	@Max(value = 100000, message = "Product price should not exceed 100000")
	private int productPrice;
	@Size(min = 5, max = 12, message = "Category length should be between 5 and 12 characters")
	private String productCategory;
	@Column(name = "quantity")
	@Positive(message="Quantity should be greater than 0")
	
	private int productQuantity;

	public Product(String productName, int productPrice, String productCategory, int productQuantity) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.productCategory = productCategory;
		this.productQuantity = productQuantity;
	}

}
