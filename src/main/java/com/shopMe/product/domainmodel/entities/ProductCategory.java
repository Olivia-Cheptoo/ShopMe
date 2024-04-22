package com.shopMe.product.domainmodel.entities;

import java.util.HashSet;
import java.util.Set;

import com.shopMe.product.domainmodel.aggregateroot.Product;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "category")
@Getter
public class ProductCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 50)
	private String name;
	@Column(length = 100)
	private String description;
	@OneToMany(mappedBy = "category")
	private Set<Product> products = new HashSet<>();

	ProductCategory() {
	}

	public ProductCategory(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public boolean hasSameName(String name) {
		return this.name.equals(name);
	}

	public boolean hasSameDescription(String description) {
		return this.description.equals(description);
	}

	public boolean isNameValid() {
		return this.name.length() <= 50;
	}

	public boolean isDescriptionValid() {
		return this.description.length() <= 100;
	}

	public void addProduct(Product product) {
		this.products.add(product);
	}

	public void removeProduct(Product product) {
		this.products.remove(product);
	}
}