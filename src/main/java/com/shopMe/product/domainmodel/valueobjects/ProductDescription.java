package com.shopMe.product.domainmodel.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class ProductDescription {
	private String description;

	ProductDescription() {
	}

	public ProductDescription(String description, int maxLength) {
		if (description.length() > maxLength) {
			throw new IllegalArgumentException("ProductDescription cannot exceed " + maxLength + " characters.");
		}
		this.description = description;
	}

	public ProductDescription(String description) {
		this(description, 255);
	}
}
