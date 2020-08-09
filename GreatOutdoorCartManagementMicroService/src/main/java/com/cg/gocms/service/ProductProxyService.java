package com.cg.gocms.service;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cg.gocms.model.ProductModel;

@FeignClient(name="product-service")
@RibbonClient(name="product-service")
public interface ProductProxyService {

	@GetMapping("/api/products/{id}")
    public ProductModel getProduct(@PathVariable(name="id") String id);
}
