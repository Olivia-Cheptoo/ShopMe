package com.shopMe.product.domainmodel.valueobjects;

import java.util.List;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class ProductSize {
	private int width;
	private int height;
	private int depth;

	ProductSize() {
	}

	public ProductSize(List<String> sizes) {
		if (sizes.size() != 3) {
			throw new IllegalArgumentException("Invalid number of dimensions provided.");
		}

		this.width = Integer.parseInt(sizes.get(0));
		this.height = Integer.parseInt(sizes.get(1));
		this.depth = Integer.parseInt(sizes.get(2));
	}

	/**
	 * public ProductSize(int width, int height, int depth, int maxWidth, int
	 * maxHeight, int maxDepth) { if (width > maxWidth || height > maxHeight ||
	 * depth > maxDepth) { throw new IllegalArgumentException("ProductSize
	 * dimensions cannot exceed the maximum allowed dimensions."); } this.width =
	 * width; this.height = height; this.depth = depth; }
	 * 
	 * public ProductSize(int width, int height, int depth) { this(width, height,
	 * depth, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE); }
	 **/

}
