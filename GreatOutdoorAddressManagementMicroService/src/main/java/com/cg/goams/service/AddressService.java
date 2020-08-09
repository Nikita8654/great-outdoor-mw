package com.cg.goams.service;

import java.util.List;

import com.cg.goams.exception.AddressException;
import com.cg.goams.model.AddressModel;

public interface AddressService {
	public AddressModel addAddress(AddressModel model) throws AddressException;
	public void deleteAddress(String addressId) throws AddressException;
	public List<AddressModel> getAllAddress(String userId);
	public AddressModel updateAddress(AddressModel model) throws AddressException;
	public AddressModel findAddressById(String addid) throws AddressException;
}
