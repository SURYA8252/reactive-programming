package com.reactive.programming.cud.repository;

import org.springframework.data.domain.Range;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.reactive.programming.cud.dto.ProductDto;
import com.reactive.programming.cud.entity.Product;

import reactor.core.publisher.Flux;

public interface ProductRepository extends R2dbcRepository<Product, Integer>{

	Flux<ProductDto> findByPriceBetween(Range<Double> priceRange);

}
