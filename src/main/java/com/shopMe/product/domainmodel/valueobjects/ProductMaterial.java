package com.shopMe.product.domainmodel.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Getter
@Embeddable
public class ProductMaterial {
	private MaterialType materialType;

	ProductMaterial() {
	}

	public ProductMaterial(MaterialType materialType) {
		this.materialType = materialType;

	}

	public enum MaterialType {
		PLASTIC, METAL, WOOD, GLASS
	}
}
