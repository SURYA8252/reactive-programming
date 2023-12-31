package com.reactive.programming.cud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reactive.programming.cud.dto.ProductDto;
import com.reactive.programming.cud.service.ProductService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService service;
	@GetMapping("/")
	public Flux<ProductDto> getProducts() {
		return service.getAllProducts();
	}
	@GetMapping("/{id}")
	public Mono<ProductDto> getProduct(@PathVariable int id) {
		return service.getProduct(id);
	}
	@GetMapping("/product-range")
	public Flux<ProductDto> getProductBetweenRange(@RequestParam("min") double min, @RequestParam("max") double max) {
		return service.getProductInRange(min, max);
	}
	@PostMapping("/")
	public Mono<ProductDto> saveProduct(@RequestBody Mono<ProductDto> productDtoMono) {
		return service.saveProduct(productDtoMono);
	}
	@PutMapping("/{id}")
	public Mono<ProductDto> updateProduct(@RequestBody Mono<ProductDto> productDtoMono, @PathVariable int id) {
		return service.updateProduct(productDtoMono, id);
	}
	@DeleteMapping("/{id}")
	public Mono<Void> deleteProduct(@PathVariable int id) {
		return service.deleteProduct(id);
	}
}
