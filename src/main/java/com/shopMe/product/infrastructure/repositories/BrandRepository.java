package com.shopMe.product.infrastructure.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopMe.product.domainmodel.entities.ProductBrand;

public interface BrandRepository extends JpaRepository<ProductBrand, Long> {

	Optional<ProductBrand> findByName(String name);

}
