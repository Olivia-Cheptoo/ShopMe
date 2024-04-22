package com.shopMe.product.domainmodel.valueobjects;

import java.math.BigDecimal;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.Getter;

@Getter
@Embeddable
public class ProductPrice {
	@Embedded
	private Money price;
	private int tax;

	ProductPrice() {
	}

	public ProductPrice(BigDecimal amount, String currency, int tax) {
		this(new Money(amount, currency), tax);
	}

	public ProductPrice(Money price, int tax) {
		this.price = price;
		this.tax = tax;
	}

	public Money getTotalPrice() {
		return price.multiply(BigDecimal.valueOf(1 + tax / 100.0));
	}

	public Object getAmount() {
		// TODO Auto-generated method stub
		return price.getAmount();
	}

	public Object getCurrency() {
		// TODO Auto-generated method stub
		return price.getCurrency();
	}

	// work more on this
}