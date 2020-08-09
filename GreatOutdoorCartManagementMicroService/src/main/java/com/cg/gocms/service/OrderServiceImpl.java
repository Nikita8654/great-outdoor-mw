package com.cg.gocms.service;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.gocms.dao.OrderRepo;
import com.cg.gocms.entity.OrderEntity;
import com.cg.gocms.exception.OrderException;
import com.cg.gocms.model.AddressModel;
import com.cg.gocms.model.OrderModel;
import com.cg.gocms.model.ProductModel;

@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderRepo repo;
	
	@Autowired 
	private ProductProxyService productProxy;
	
	@Autowired 
	private AddressProxyService addressProxy;

	@Autowired
	private CartItemService service;
	private OrderEntity of(OrderModel source) {
		OrderEntity result=null;
		if(source!=null) {
			result = new OrderEntity();
			result.setUserId(source.getUserId());
			result.setOrderId(source.getOrderId());
			result.setAddressId(source.getAddressId());
			result.setProductId(source.getProductId());
			result.setPaymentType(source.getPaymentType());
			result.setPrice(source.getPrice());
			result.setItemQuantity(source.getItemQuantity());
			
			result.setOrderInitiateTime(source.getOrderInitiateTime());
			result.setOrderDispatchTime(source.getOrderDispatchTime());
			result.setDispatchStatus(source.getDispatchStatus());
			
	
		}
		return result;
	}
    private OrderModel of(OrderEntity source) {
    	OrderModel result=null;
		if(source!=null) {
			result = new OrderModel();
			result.setId(source.getId());
			result.setUserId(source.getUserId());
			result.setOrderId(source.getOrderId());
			result.setAddressId(source.getAddressId());
			result.setProductId(source.getProductId());
			result.setPaymentType(source.getPaymentType());
			result.setPrice(source.getPrice());
			result.setItemQuantity(source.getItemQuantity());
			result.setOrderInitiateTime(source.getOrderInitiateTime());
			result.setOrderDispatchTime(source.getOrderDispatchTime());
			result.setDispatchStatus(source.getDispatchStatus());
			
			ProductModel productModel=productProxy.getProduct(source.getProductId());
			AddressModel addressModel=addressProxy.getAddressById(source.getAddressId());
			if(productModel!=null && addressModel!=null) {
				result.setAddressModel(addressModel);
				result.setProductModel(productModel);
			}
		
		}
		return result;
	}

	@Override
	public List<OrderModel> placeOrder(List<OrderModel> modelList) throws OrderException{
		try {
			if(!(modelList.isEmpty())) {
				String userId=modelList.get(0).getUserId();
				List<OrderEntity> itemList=new ArrayList<>();
				for(OrderModel orderModel:modelList) {
					itemList.add(of(orderModel));
				}
				repo.saveAll(itemList);
				service.removeAllCartByUserId(userId);
				return this.getAllOrderList(userId);
				
			}else {
				throw  new OrderException("Should not be empty");
			}
			
		}
		catch(Exception e) {
			throw new OrderException("Error while checkout ");
		}
		
	}
	@Override
	public List<OrderModel> getAllOrderList(String userId) {
		
		return repo.findAllByUserId(userId).stream().map((entity)->of(entity)).collect(Collectors.toList());
	}
	@Override
	public OrderModel getOrderByOrderId(String orderId) {
		
		return of(repo.findByOrderId(orderId));
	}
	@Override
	public void updateDispatchStatus(String orderId, int code) throws OrderException{
		if(code==2 || code==3 || code==4) {
			repo.updateDispatchStatus(orderId, code);
		}
		else {
			throw new OrderException("Status code must be between 2 to 4");
		}
		
		
	}
	@Override
	public List<OrderModel> getAllOrders() {
		return repo.findAll().stream().map((entity)->of(entity)).collect(Collectors.toList());
	}
	
	

}
