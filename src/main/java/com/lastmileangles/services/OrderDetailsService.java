package com.lastmileangles.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lastmileangles.dao.IOrderDetailsDAO;
import com.lastmileangles.entity.OrderDetails;

@Service
public class OrderDetailsService implements IOrderDetailsService {

	@Autowired
	private IOrderDetailsDAO dao;

	@Override
	public List<OrderDetails> getOrderDetails() {
		return dao.getOrderDetails();
	}

	@Override
	public OrderDetails createOrderDetails(OrderDetails orderDetails) {
		return dao.createOrderDetails(orderDetails);
	}

	@Override
	public OrderDetails updateOrderDetails(int orderId, OrderDetails orderDetails) {
		return dao.updateOrderDetails(orderId, orderDetails);
	}

	@Override
	public OrderDetails getOrderDetail(int orderId) {
		return dao.getOrderDetail(orderId);
	}

	@Override
	public String sendMail(int orderId) {
		return dao.sendMail(orderId);
	}

}
