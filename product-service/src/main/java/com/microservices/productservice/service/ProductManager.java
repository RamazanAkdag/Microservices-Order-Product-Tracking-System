package com.microservices.productservice.service;

import com.microservices.productservice.dataAccess.ProductRepository;
import com.microservices.productservice.dto.ProductRequest;
import com.microservices.productservice.dto.ProductResponse;
import com.microservices.productservice.model.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductManager implements IProductService{

    private final ProductRepository productRepository;
    @Override
    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder().name(productRequest.getName()).description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        this.productRepository.save(product);
        log.info("product {} is saved",product.getId());
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream().map(product -> {
            return ProductResponse.builder().id(product.getId()).description(product.getDescription()).name(product.getName())
                    .price(product.getPrice())
                    .build();
        }).toList();

    }
}
