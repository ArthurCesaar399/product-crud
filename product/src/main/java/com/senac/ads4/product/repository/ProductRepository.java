package com.senac.ads4.product.repository;

import com.senac.ads4.product.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductModel, Integer> {
}
