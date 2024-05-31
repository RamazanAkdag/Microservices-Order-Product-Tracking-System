package com.microservices.inventoryservice.service;

import com.microservices.inventoryservice.dto.InventoryResponse;

import java.util.List;

public interface IInventoryService {
    List<InventoryResponse> isInStock(List<String> skuCode) throws InterruptedException;
}
