package com.cg.gocms.service;

import java.util.List;

import com.cg.gocms.exception.OrderException;
import com.cg.gocms.model.OrderModel;

public interface OrderService {
 
	 public List<OrderModel> placeOrder(List<OrderModel> model) throws OrderException;
	 public List<OrderModel> getAllOrderList(String userId);
	 public OrderModel getOrderByOrderId(String orderId);
	 public List<OrderModel> getAllOrders(); 
	 public void updateDispatchStatus(String orderId,int code) throws OrderException;
}
