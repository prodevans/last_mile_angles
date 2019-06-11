package com.lastmileangles.services;

import java.util.List;

import com.lastmileangles.entity.OrderDetails;

public interface IOrderDetailsService {

	List<OrderDetails> getOrderDetails();

	OrderDetails getOrderDetail(int orderId);

	OrderDetails createOrderDetails(OrderDetails orderDetails);

	OrderDetails updateOrderDetails(int orderId, OrderDetails orderDetails);

	String sendMail(int orderId);
}
