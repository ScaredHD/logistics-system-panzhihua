package com.lsp.service;

import com.lsp.domain.Order;

import java.util.List;

public interface OrderService {
    public boolean AddOrderInfo(Order order);
    public boolean CompleteOrder(Order order);
    public List<Order> DisplayOrderInfo();
}
