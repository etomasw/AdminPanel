package com.adminpanel.adminpanel.service.impl;

import com.adminpanel.adminpanel.model.Product;
import com.adminpanel.adminpanel.repository.ProductRepository;
import com.adminpanel.adminpanel.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product saveProduct(final Product product){
        return this.productRepository.save(product);
    }

    @Override
    public Product updateProduct(final Product product){
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(final Long productId){
        productRepository.deleteById(productId);
    }

    @Override
    public Long numberOfProducts(){
        return productRepository.count();
    }

    @Override
    public List<Product> findAllProducts(){
        return productRepository.findAll();
    }
}
