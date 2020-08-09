package com.cg.goarm.service;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.cg.goarm.model.OrderModel;

@FeignClient(name="cart-service")
@RibbonClient(name="cart-service")
public interface OrderProxyService {
	
	@GetMapping("/api/orders")
    public List<OrderModel> getAllOrders();

}
