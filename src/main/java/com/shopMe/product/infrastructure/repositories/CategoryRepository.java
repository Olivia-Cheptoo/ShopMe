package com.shopMe.product.infrastructure.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopMe.product.domainmodel.entities.ProductCategory;

public interface CategoryRepository extends JpaRepository<ProductCategory, Long> {

	Optional<ProductCategory> findByName(String name);

}
