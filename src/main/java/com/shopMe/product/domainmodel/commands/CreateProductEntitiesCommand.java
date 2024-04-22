package com.shopMe.product.domainmodel.commands;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CreateProductEntitiesCommand {

	@NotNull
	private String categoryName;

	@NotNull
	private String categoryDescription;

	@NotNull
	private String brandName;

	@NotNull
	private String brandDescription;

	@NotNull
	private int availableQuantity;
}
