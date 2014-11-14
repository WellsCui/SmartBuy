package com.smartbuy.services;

import com.smartbuy.domain.Order;
import com.smartbuy.domain.OrderStatus;

public interface OrderService {
    OrderStatus	Submit(Order order);

}
