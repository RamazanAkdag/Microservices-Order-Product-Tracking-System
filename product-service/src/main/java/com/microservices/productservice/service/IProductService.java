package com.microservices.productservice.service;

import com.microservices.productservice.dto.ProductRequest;
import com.microservices.productservice.dto.ProductResponse;
import com.microservices.productservice.model.Product;

import java.util.List;

public interface IProductService {
    public void createProduct(ProductRequest productRequest);

    public List<ProductResponse> getAllProducts();
}
