package com.joomak.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joomak.backend.domain.product.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findStoreProduct(Long storeId);

}
