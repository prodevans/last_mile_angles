package com.lastmileangles.dao;

import java.util.List;

import com.lastmileangles.entity.OrderDetails;

public interface IOrderDetailsDAO {
	
	List<OrderDetails> getOrderDetails();
	OrderDetails getOrderDetail(int orderId);
	OrderDetails createOrderDetails(OrderDetails orderDetails);
	OrderDetails updateOrderDetails(int orderId, OrderDetails orderDetails);
	String sendMail(int orderId);
}
