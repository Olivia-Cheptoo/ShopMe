package com.shopMe.product.interfaces.rest.transform;

import org.mapstruct.Mapper;

import com.shopMe.product.domainmodel.commands.CreateProductEntitiesCommand;
import com.shopMe.product.domainmodel.commands.CreateProductValueObjectsCommand;
import com.shopMe.product.interfaces.rest.dto.CreateProductRequestDTO;

@Mapper
public interface ProductMapper {

	CreateProductValueObjectsCommand mapToCreateProductValueObjectsCommand(
			CreateProductRequestDTO createProductRequestDTO);

	CreateProductEntitiesCommand mapToCreateProductEntitiesCommand(CreateProductRequestDTO createProductRequestDTO);

}
