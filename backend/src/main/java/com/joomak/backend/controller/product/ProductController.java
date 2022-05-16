package com.joomak.backend.controller.product;

import com.joomak.backend.model.product.entity.Product;
import com.joomak.backend.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

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
    @GetMapping(value = "/products/{storeId}", produces = {MediaType.APPLICATION_JSON_VALUE})
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
