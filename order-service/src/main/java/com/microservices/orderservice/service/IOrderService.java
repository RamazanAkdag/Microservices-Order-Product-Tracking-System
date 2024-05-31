package com.microservices.orderservice.service;

import com.microservices.orderservice.dto.OrderRequest;

public interface IOrderService {

    public String placeOrder(OrderRequest orderRequest);
}
