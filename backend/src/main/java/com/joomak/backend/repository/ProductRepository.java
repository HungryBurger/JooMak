package com.joomak.backend.repository;

import com.joomak.backend.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByStore_Id(@Param(value = "storeId")Long storeId);
}
