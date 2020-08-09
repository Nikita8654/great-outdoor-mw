package com.cg.goams.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.goams.dao.AddressRepo;
import com.cg.goams.entity.AddressEntity;
import com.cg.goams.exception.AddressException;
import com.cg.goams.model.AddressModel;

@Service
public class AddressServiceImpl implements AddressService{

	@Autowired
	private AddressRepo addressRepo;
	
	private AddressEntity of(AddressModel source) {
		AddressEntity result=null;
		if(source!=null) {
			result=new AddressEntity();
			result.setAddressId(source.getAddressId());
			result.setUserId(source.getUserId());
			result.setFullName(source.getFullName());
			result.setAddressLine(source.getAddressLine());
			result.setAddressType(source.getAddressType());
			result.setCity(source.getCity());
			result.setPhoneNo(source.getPhoneNo());
			result.setOtherPhoneNo(source.getOtherPhoneNo());
			result.setState(source.getState());
			result.setPincode(source.getPincode());
			
		}
		return result;
	}
	private AddressModel of(AddressEntity source) {
		AddressModel result=null;
		if(source!=null) {
			result=new AddressModel();
			result.setAddressId(source.getAddressId());
			result.setUserId(source.getUserId());
			result.setFullName(source.getFullName());
			result.setAddressLine(source.getAddressLine());
			result.setAddressType(source.getAddressType());
			result.setCity(source.getCity());
			result.setPhoneNo(source.getPhoneNo());
			result.setOtherPhoneNo(source.getOtherPhoneNo());
			result.setState(source.getState());
			result.setPincode(source.getPincode());
			
		}
		return result;
	}
	@Override
	public AddressModel addAddress(AddressModel model) throws AddressException {
		if(model!=null) {
			if(addressRepo.existsById(model.getAddressId())) {
				throw new AddressException("Address already exist !");
			}
			else {
				model=of(addressRepo.save(of(model)));
			}
		}
		return model;
	}

	@Override
	public void deleteAddress(String addressId) throws AddressException {
		
		if(!(addressRepo.findById(addressId).isPresent())) {
			throw new AddressException("Address does not exist !");
		}
		else {
			addressRepo.deleteById(addressId);
		}	
	}

	@Override
	public List<AddressModel> getAllAddress(String userId) {
	
		return addressRepo.findAllByUserId(userId).stream().map(this::of).collect(Collectors.toList());
	}

	@Override
	public AddressModel updateAddress(AddressModel model) throws AddressException {
		if(model!=null) {
			if(addressRepo.existsById(model.getAddressId())) {
				model=of(addressRepo.save(of(model)));	
			}
			else {
				throw new AddressException("Address does not exist !");
			}
		}
		return model;
	}

	@Override
	public AddressModel findAddressById(String addid) throws AddressException {
		AddressModel model=null;
		Optional<AddressEntity> entity=addressRepo.findById(addid);
		if(!entity.isPresent()) {
			throw new AddressException("Address Id not exist !");
		}
		else {
			model=of(entity.get());
		}
		return model;
	}

}
