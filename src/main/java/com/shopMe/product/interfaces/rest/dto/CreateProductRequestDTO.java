package com.shopMe.product.interfaces.rest.dto;

import java.math.BigDecimal;
import java.util.List;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateProductRequestDTO {

	@NotBlank
	private String productName;

	@NotBlank
	private String productId;

	@NotBlank
	private String description;

	@NotBlank
	private List<String> size;

	@NotBlank
	private String color;

	@NotBlank
	private List<byte[]> images;

	@NotBlank
	private BigDecimal price;

	@NotBlank
	private String priceCurrency;

	@NotBlank
	private int priceTax;

	@NotBlank
	private String material;

	@NotBlank
	private int weight;

	// Entities

	@NotBlank
	private String categoryName;
	private String categoryDescription;

	@NotBlank
	private String brandName;
	private String brandDescription;

	@Min(0)
	private int availableQuantity;

	// ...

}