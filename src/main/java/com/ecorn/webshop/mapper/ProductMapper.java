package com.ecorn.webshop.mapper;


import com.ecorn.webshop.dto.ProductDTO;
import com.ecorn.webshop.entity.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {
	ProductMapper MAPPER = Mappers.getMapper(ProductMapper.class);

	Product toProduct(ProductDTO dto);

	@InheritInverseConfiguration
	ProductDTO fromProduct(Product product);

	List<Product> toProductList(List<ProductDTO> productDtos);

	List<ProductDTO> fromProductList(List<Product> products);

}