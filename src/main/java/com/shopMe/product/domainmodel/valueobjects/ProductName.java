package com.shopMe.product.domainmodel.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class ProductName {
	private String name;

	ProductName() {
	}

	public ProductName(String name) {
		this(name, 255);
	}

	public ProductName(String name, int maxLength) {
		if (name.length() > maxLength) {
			throw new IllegalArgumentException("ProductName cannot exceed " + maxLength + " characters.");
		}
		this.name = name;
	}
}