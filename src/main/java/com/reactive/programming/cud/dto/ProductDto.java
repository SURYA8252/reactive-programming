package com.reactive.programming.cud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
	private int id;
	private String name;
	private int qyt;
	private double price;
}
