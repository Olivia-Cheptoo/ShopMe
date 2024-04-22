package com.shopMe.product.applicationservices.commandservices;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shopMe.product.domainmodel.aggregateroot.Product;
import com.shopMe.product.domainmodel.commands.CreateProductEntitiesCommand;
import com.shopMe.product.domainmodel.commands.CreateProductValueObjectsCommand;
import com.shopMe.product.domainmodel.entities.ProductAvailableStock;
import com.shopMe.product.domainmodel.entities.ProductBrand;
import com.shopMe.product.domainmodel.entities.ProductCategory;
import com.shopMe.product.infrastructure.repositories.AvailableStockRepository;
import com.shopMe.product.infrastructure.repositories.BrandRepository;
import com.shopMe.product.infrastructure.repositories.CategoryRepository;
import com.shopMe.product.infrastructure.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private final CategoryRepository categoryRepository;
	@Autowired
	private final BrandRepository brandRepository;
	@Autowired
	private final AvailableStockRepository availableStockRepository;
	@Autowired
	private final ProductRepository productRepository;

	public ProductService(CategoryRepository categoryRepository, BrandRepository brandRepository,
			AvailableStockRepository availableStockRepository, ProductRepository productRepository) {

		this.categoryRepository = categoryRepository;
		this.brandRepository = brandRepository;
		this.availableStockRepository = availableStockRepository;
		this.productRepository = productRepository;
	}

	@Transactional
	public Product createProduct(CreateProductValueObjectsCommand valueObjectsCommand,
			CreateProductEntitiesCommand entitiesCommand) {

		// Check if the product exists by name
		Optional<Product> existingProduct = productRepository.findByName(valueObjectsCommand.getProductName());
		if (existingProduct.isPresent()) {
			throw new IllegalStateException(
					"Product with name " + valueObjectsCommand.getProductName() + " already exists.");
		}

		// Check if the available stock exists by product name
		Optional<ProductAvailableStock> existingStock = availableStockRepository
				.findByProductName(valueObjectsCommand.getProductName());
		ProductAvailableStock stock;
		if (!existingStock.isPresent()) {
			// Create a new available stock
			stock = createAvailableStock(entitiesCommand.getAvailableQuantity());
		} else {
			stock = existingStock.get();
		}

		// Create the category if it doesn't exist
		Optional<ProductCategory> existingCategory = categoryRepository.findByName(entitiesCommand.getCategoryName());
		ProductCategory category = existingCategory.orElseGet(
				() -> createCategory(entitiesCommand.getCategoryName(), entitiesCommand.getCategoryDescription()));

		// Create the brand if it doesn't exist
		Optional<ProductBrand> existingBrand = brandRepository.findByName(entitiesCommand.getBrandName());
		ProductBrand brand = existingBrand
				.orElseGet(() -> createBrand(entitiesCommand.getBrandName(), entitiesCommand.getBrandDescription()));

		// Create the product
		Product newProduct = new Product(valueObjectsCommand, category, brand, stock);
		newProduct = productRepository.save(newProduct);

		// Set the product for the category
		category.addProduct(newProduct);
		categoryRepository.save(category);

		// Set the product for the brand
		brand.addProduct(newProduct);
		brandRepository.save(brand);

		// Set the product for the stock
		stock.addProduct(newProduct);
		availableStockRepository.save(stock);

		return newProduct;
	}

	private ProductAvailableStock createAvailableStock(int availableQuantity) {
		ProductAvailableStock stock = new ProductAvailableStock(availableQuantity);
		stock = availableStockRepository.save(stock);
		return stock;
	}

	private ProductCategory createCategory(String name, String description) {
		ProductCategory category = new ProductCategory(name, description);
		category = categoryRepository.save(category);
		return category;
	}

	private ProductBrand createBrand(String name, String description) {
		ProductBrand brand = new ProductBrand(name, description);
		brand = brandRepository.save(brand);
		return brand;
	}

	// ...
}