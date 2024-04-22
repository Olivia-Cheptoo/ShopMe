package com.shopMe.product.domainmodel.valueobjects;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Lob;
import lombok.Getter;

@Embeddable
@Getter
public class ProductImages {
	@Lob
	@Column(length = 10485760)
	private byte[] image1;

	@Lob
	@Column(length = 10485760)
	private byte[] image2;

	@Lob
	@Column(length = 10485760)
	private byte[] image3;

	ProductImages() {
	}

	public ProductImages(List<byte[]> images) {
		if (images.size() != 3) {
			throw new IllegalArgumentException("Exactly three images are required.");
		}
		this.image1 = images.get(0);
		this.image2 = images.get(1);
		this.image3 = images.get(2);
	}

}