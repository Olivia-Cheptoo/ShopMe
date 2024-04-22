package com.shopMe.product.domainmodel.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class ProductWeight {
	private double weight;

	ProductWeight() {
	}

	public ProductWeight(double weight) {
		this.weight = weight;
	}

	// i removed methods to change the weight.
}