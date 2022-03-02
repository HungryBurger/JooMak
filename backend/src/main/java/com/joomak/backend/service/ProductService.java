package com.joomak.backend.service;

import com.joomak.backend.domain.product.Product;
import com.joomak.backend.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository = null;

    public Product findById(Long prdNo) {
        return productRepository.findById(prdNo)
                .orElseThrow();
    }
    
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(e -> products.add(e));
        return products;
    }
    
    public List<Product> findStoreProducts(Long storeId) {
        List<Product> storeProducts = new ArrayList<>();
        productRepository.findByStore_Id(storeId).forEach(e -> storeProducts.add(e));
        return storeProducts;
    }

    @Transactional
    public Product save(Product product) {
        Product saved = productRepository.save(product);
        log.info("Saved Product = {}", saved);
        return saved;
    }

}
