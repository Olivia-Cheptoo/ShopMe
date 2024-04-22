package com.shopMe.product.domainmodel.aggregateroot;

import com.shopMe.product.domainmodel.commands.CreateProductValueObjectsCommand;
import com.shopMe.product.domainmodel.entities.ProductAvailableStock;
import com.shopMe.product.domainmodel.entities.ProductBrand;
import com.shopMe.product.domainmodel.entities.ProductCategory;
import com.shopMe.product.domainmodel.valueobjects.ProductColor;
import com.shopMe.product.domainmodel.valueobjects.ProductColor.Color;
import com.shopMe.product.domainmodel.valueobjects.ProductDescription;
import com.shopMe.product.domainmodel.valueobjects.ProductId;
import com.shopMe.product.domainmodel.valueobjects.ProductImages;
import com.shopMe.product.domainmodel.valueobjects.ProductMaterial;
import com.shopMe.product.domainmodel.valueobjects.ProductMaterial.MaterialType;
import com.shopMe.product.domainmodel.valueobjects.ProductName;
import com.shopMe.product.domainmodel.valueobjects.ProductPrice;
import com.shopMe.product.domainmodel.valueobjects.ProductSize;
import com.shopMe.product.domainmodel.valueobjects.ProductWeight;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(insertable = false, updatable = false)
	private Long id;
	@Embedded
	private ProductId productId;
	@Embedded
	private ProductName name;
	@Embedded
	private ProductSize size;
	@Embedded
	private ProductColor color;
	@Embedded
	private ProductDescription description;
	@Embedded
	private ProductImages images;
	@Embedded
	private ProductPrice price;
	@Embedded
	private ProductMaterial material;
	@Embedded
	private ProductWeight weight;
	@ManyToOne
	@JoinColumn(name = "brand_id")
	private ProductBrand brand;
	@ManyToOne
	@JoinColumn(name = "category_id")
	private ProductCategory category;
	@OneToOne(mappedBy = "product")
	private ProductAvailableStock availableStock;

	public Product(CreateProductValueObjectsCommand command, ProductCategory category, ProductBrand brand,
			ProductAvailableStock availableStock) {
		this.productId = ProductId.fromString(command.getProductId());
		this.name = new ProductName(command.getProductName());
		this.size = new ProductSize(command.getSize());
		this.color = new ProductColor(Color.valueOf(command.getColor().toUpperCase()));
		this.description = new ProductDescription(command.getDescription());
		this.images = new ProductImages(command.getImages());
		this.price = new ProductPrice(command.getPrice(), command.getPriceCurrency(), command.getPriceTax());
		this.material = new ProductMaterial(MaterialType.valueOf(command.getMaterial().toUpperCase()));
		this.weight = new ProductWeight(command.getWeight());
		// set entities.

		this.brand = brand;
		this.category = category;
		this.availableStock = availableStock;

	}

	public boolean isNew() {
		return id == null;
	}

	public boolean isNotNew() {
		return !isNew();
	}
}