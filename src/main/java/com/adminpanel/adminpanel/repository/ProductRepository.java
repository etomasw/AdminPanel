package com.adminpanel.adminpanel.repository;

import com.adminpanel.adminpanel.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
