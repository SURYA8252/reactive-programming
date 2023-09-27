package com.reactive.programming.cud.service;

import org.springframework.data.domain.Range;
import org.springframework.stereotype.Service;

import com.reactive.programming.cud.dto.ProductDto;
import com.reactive.programming.cud.repository.ProductRepository;
import com.reactive.programming.cud.utils.AppUtils;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {
	
    private final ProductRepository repository;
    
    public ProductService(ProductRepository repository) {
		super();
		this.repository = repository;
	}
	public Flux<ProductDto> getAllProducts() {
    	return repository.findAll().map(AppUtils::entityToDto);
    }
    public Mono<ProductDto> getProduct(int id) {
    	return repository.findById(id).map(AppUtils::entityToDto);
    }
    public Flux<ProductDto> getProductInRange(double min, double max) {
    	return repository.findByPriceBetween(Range.closed(min, max));
    }
    public Mono<ProductDto> saveProduct(Mono<ProductDto> productDtoMono) {
    	return productDtoMono.map(AppUtils::dtoToEntity).flatMap(repository::save).map(AppUtils::entityToDto);
    }
    public Mono<ProductDto> updateProduct(Mono<ProductDto> productDtoMono, int id) {
    	return repository.findById(id).flatMap(p -> productDtoMono.map(AppUtils::dtoToEntity).doOnNext(e -> e.setId(id))).flatMap(repository::save).map(AppUtils::entityToDto);
    }
    public Mono<Void> deleteProduct(int id) {
    	return repository.deleteById(id);
    }
}
