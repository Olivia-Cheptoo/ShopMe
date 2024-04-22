package com.shopMe.product.domainmodel.valueobjects;

import java.util.UUID;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Embeddable
@EqualsAndHashCode
public class ProductId {
	@Getter
	private UUID id;

	ProductId() {
	}

	public static ProductId fromString(String id) {
		return new ProductId(UUID.fromString(id));
	}

	public ProductId(UUID fromString) {
		// TODO Auto-generated constructor stub
		this.id = fromString;
	}

}