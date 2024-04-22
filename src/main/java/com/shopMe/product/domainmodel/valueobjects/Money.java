package com.shopMe.product.domainmodel.valueobjects;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.shopMe.product.domainmodel.valueobjects.Currency.Code;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.Getter;

@Embeddable
@Getter
public class Money {
	private BigDecimal amount;
	@Embedded
	private Currency currency;

	Money() {
	}

	public Money(BigDecimal amount, String currency) {
		this.amount = amount;
		this.currency = new Currency(Code.valueOf(currency.toUpperCase()));
	}

	// whose using this constructor??
	public Money(BigDecimal amount2, Currency currency2) {
		this.amount = amount2;
		this.currency = currency2;
		// TODO Auto-generated constructor stub
	}

	public Money add(Money other) {
		if (!this.currency.equals(other.currency)) {
			throw new IllegalArgumentException("Cannot add Money with different currencies");
		}
		return new Money(this.amount.add(other.amount), this.currency);
	}

	public Money multiply(BigDecimal multiplier) {
		return new Money(this.amount.multiply(multiplier), this.currency);
	}

	public Money divide(BigDecimal divisor) {
		return new Money(this.amount.divide(divisor, RoundingMode.HALF_UP), this.currency);
	}

}
