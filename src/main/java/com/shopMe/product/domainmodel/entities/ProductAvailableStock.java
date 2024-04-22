package com.shopMe.product.domainmodel.entities;

import com.shopMe.product.domainmodel.aggregateroot.Product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "available_stock")
@Getter
public class ProductAvailableStock {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne(optional = false)
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;
	private int quantity;

	ProductAvailableStock() {
	}

	public ProductAvailableStock(int quantity) {
		this.id = null;
		this.quantity = quantity;
	}

	public void decreaseQuantity(int quantity) {
		if (this.quantity < quantity) {
			throw new IllegalStateException("Not enough stock available");
		}
		this.quantity -= quantity;
	}

	public void increaseQuantity(int quantity) {
		this.quantity += quantity;
	}

	public void addProduct(Product newProduct) {
		// TODO Auto-generated method stub
		this.product = newProduct;

	}

}