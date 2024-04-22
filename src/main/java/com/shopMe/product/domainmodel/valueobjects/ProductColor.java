package com.shopMe.product.domainmodel.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class ProductColor {
	private Color color;

	public ProductColor(Color color) {
		this(color, true);
	}

	ProductColor() {
	}

	public ProductColor(Color color, boolean validate) {
		if (validate && !Color.isValid(color)) {
			throw new IllegalArgumentException("Invalid ProductColor.");
		}
		this.color = color;
	}

	public enum Color {
		RED, GREEN, BLUE, YELLOW, BLACK, WHITE;

		public static boolean isValid(Color color) {

			return color != null;
		}
	}

}