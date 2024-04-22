package com.shopMe.product.infrastructure.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopMe.product.domainmodel.entities.ProductAvailableStock;

public interface AvailableStockRepository extends JpaRepository<ProductAvailableStock, Long> {

	Optional<ProductAvailableStock> findByProductName(String name);

}
