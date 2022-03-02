package com.joomak.backend.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.joomak.backend.domain.product.Product;
import com.joomak.backend.service.ProductService;

public class ProductController {
	private final ProductService productService = new ProductService();

    // 상품번호로 상품 한개 조회
    @GetMapping(value = "/products/{productId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Product> getProducts(@PathVariable("productId") Long productId) {
        Product product = productService.findById(productId);
        return ResponseEntity.ok(product);
    }
    
    // 전체 상품 조회
    @GetMapping(value = "/products/all", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Product>> getProductsAll() {
        List<Product> product = productService.findAll();
        return ResponseEntity.ok(product);
    }
    
    // 매장에 등록된 모든 상품 조회
    @GetMapping(value = "/products/{stordId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Product>> getStoreProducts(@PathVariable("storeId") Long storeId) {
    	List<Product> storeProducts = productService.findStoreProducts(storeId);
        return ResponseEntity.ok(storeProducts);
    }
    
    // 상품 등록
    @PostMapping(value = "/product")
    public ResponseEntity<Product> save(Product product) {
        return ResponseEntity.ok(productService.save(product));
    }
}
