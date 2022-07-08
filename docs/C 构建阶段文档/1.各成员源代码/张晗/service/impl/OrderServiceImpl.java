package com.lsp.service.impl;

import com.lsp.dao.OrderDao;
import com.lsp.domain.Order;
import com.lsp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Author:
 * @createTime: 2022年07月06日 09:38:49
 * @version:
 * @Description:
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    public boolean AddOrderInfo(Order order) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        order.setOrder_status('0');
        order.setOrder_created_at(timestamp);
        orderDao.save(order);
        return true;
    }

    public boolean CompleteOrder(Order order) {
        orderDao.complete(order);
        return true;
    }

    public List<Order> DisplayOrderInfo() {
        return orderDao.getAll();
    }
}
