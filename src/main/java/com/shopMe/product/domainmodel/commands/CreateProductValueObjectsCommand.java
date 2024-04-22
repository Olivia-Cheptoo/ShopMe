package com.shopMe.product.domainmodel.commands;

import java.math.BigDecimal;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CreateProductValueObjectsCommand {

	@NotNull
	private String productName;

	@NotNull
	private String productId;

	@NotBlank
	private String description;

	@NotNull
	private List<String> size;

	@NotNull
	private String color;

	@NotNull
	private List<byte[]> images;

	@NotNull
	private BigDecimal price;

	@NotNull
	private String priceCurrency;

	@NotNull
	private int priceTax;

	@NotNull
	private String material;

	@NotNull
	private int weight;
}
