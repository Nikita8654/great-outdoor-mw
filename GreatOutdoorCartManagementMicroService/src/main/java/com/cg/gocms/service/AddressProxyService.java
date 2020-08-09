package com.cg.gocms.service;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cg.gocms.model.AddressModel;

@FeignClient(name="address-service")
@RibbonClient(name="address-service")
public interface AddressProxyService {

	
	@GetMapping("/api/address/{addid}")
    public AddressModel getAddressById(@PathVariable(name="addid") String id);
}
