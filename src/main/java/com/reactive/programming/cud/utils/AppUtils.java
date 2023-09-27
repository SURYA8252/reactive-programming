package com.reactive.programming.cud.utils;

import org.springframework.beans.BeanUtils;

import com.reactive.programming.cud.dto.ProductDto;
import com.reactive.programming.cud.entity.Product;

public class AppUtils {
    public static ProductDto entityToDto(Product product) {
    	ProductDto productDto = new ProductDto();
    	BeanUtils.copyProperties(product, productDto);
    	return productDto;
    }
    public static Product dtoToEntity(ProductDto productDto) {
    	Product product = new Product();
    	BeanUtils.copyProperties(productDto, product);
    	return product;
    }
}
