package com.shopMe.product.domainmodel.valueobjects;

import java.util.EnumSet;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class Currency {
	private Code code;

	Currency() {
	}

	public Currency(Code valueOf) {
		// TODO Auto-generated constructor stub
		if (valueOf == null) {
			throw new IllegalArgumentException("Currency code cannot be null");
		}
		if (!valueOf.name().matches("[A-Z]{3}")) {
			throw new IllegalArgumentException("Currency code must be a three-letter ISO 4217 code");
		}
		this.code = valueOf;
	}

	public static String getCode(Code code) {
		return code.name();
	}

	public static Code getCode(String code) {
		return EnumSet.allOf(Code.class).stream().filter(c -> c.name().equalsIgnoreCase(code)).findFirst().orElse(null);
	}

	public static EnumSet<Code> getAll() {
		return EnumSet.allOf(Code.class);
	}

	public enum Code {
		KSH, USD, EUR, GBP, JPY, CAD, CHF, AUD, HKD, NZD, SEK, NOK, DKK, SGD, CZK, HUF, PLN, RON, BRL, CNY, INR, KRW,
		MXN, MYR, THB, TRY, ZAR, ILS;

		public static String getCode(Code code) {
			return code.name();
		}

		public static Code getCode(String code) {
			return EnumSet.allOf(Code.class).stream().filter(c -> c.name().equalsIgnoreCase(code)).findFirst()
					.orElse(null);
		}

		public static EnumSet<Code> getAll() {
			return EnumSet.allOf(Code.class);
		}
	}

}