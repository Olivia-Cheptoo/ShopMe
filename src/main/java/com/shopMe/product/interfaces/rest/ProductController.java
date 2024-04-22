package com.shopMe.product.interfaces.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopMe.product.applicationservices.commandservices.ProductService;
import com.shopMe.product.domainmodel.aggregateroot.Product;
import com.shopMe.product.domainmodel.commands.CreateProductEntitiesCommand;
import com.shopMe.product.domainmodel.commands.CreateProductValueObjectsCommand;
import com.shopMe.product.interfaces.rest.dto.CreateProductRequestDTO;
import com.shopMe.product.interfaces.rest.transform.ProductMapper;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	@Autowired
	private final ProductService productService;
	@Autowired
	private final ProductMapper productMapper;

	public ProductController(ProductService productService, ProductMapper productMapper) {
		this.productService = productService;
		this.productMapper = productMapper;
	}

	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody CreateProductRequestDTO createProductRequestDTO) {
		CreateProductValueObjectsCommand valueObjectsCommand = productMapper
				.mapToCreateProductValueObjectsCommand(createProductRequestDTO);
		CreateProductEntitiesCommand entitiesCommand = productMapper
				.mapToCreateProductEntitiesCommand(createProductRequestDTO);
		Product createdProduct = productService.createProduct(valueObjectsCommand, entitiesCommand);
		return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
	}

}