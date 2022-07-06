package com.lsp.service;

import com.lsp.domain.Delivery;

import java.util.List;

public interface DeliveryService {
    public boolean AddDeliveryInfo(Delivery delivery);
    public boolean UpdateDeliveryInfo(Delivery delivery);
    public List<Delivery> DisplayDeliveryInfo();
}
