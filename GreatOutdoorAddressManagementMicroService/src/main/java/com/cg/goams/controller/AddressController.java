package com.cg.goams.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.goams.exception.AddressException;
import com.cg.goams.model.AddressModel;
import com.cg.goams.service.AddressService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	@GetMapping("/address/all/{userId}")
	public ResponseEntity<List<AddressModel>> getAddress(@PathVariable("userId") String userId) {
		ResponseEntity<List<AddressModel>> response=null;
		List<AddressModel> addressList=addressService.getAllAddress(userId);
		if(addressList==null) {
			response=new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else {
			response=new ResponseEntity<>(addressList, HttpStatus.OK);
		}
		return response;
	}
	
	@PostMapping("/address/add")
	public ResponseEntity<AddressModel> addAddress(@RequestBody AddressModel model) throws AddressException
	{
		model.setAddressId(getAddressId()+"");
		return new ResponseEntity<>(addressService.addAddress(model),HttpStatus.CREATED);
	}
	
	@GetMapping("/address/{addid}")
	public ResponseEntity<AddressModel> findByIdAddress(@PathVariable("addid") String addid) throws AddressException {
		ResponseEntity<AddressModel> response=null;
		AddressModel address=addressService.findAddressById(addid);
		if(address==null) {
			response=new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else {
			response=new ResponseEntity<>(address, HttpStatus.OK);
		}
		return response;
	}
	
	@PutMapping("/address/update")
	public ResponseEntity<AddressModel> updateAddress(@RequestBody AddressModel model) throws AddressException
	{
		return new ResponseEntity<>(addressService.updateAddress(model),HttpStatus.OK);
		
	}
	
	@DeleteMapping("/address/delete/{addId}")
	public ResponseEntity<?> deleteAddress(@PathVariable("addId") String addid) throws AddressException {

			addressService.deleteAddress(addid);
			return new ResponseEntity<>(HttpStatus.OK);
	
	}
	
	public int getAddressId() {
	    Random r = new Random( System.currentTimeMillis() );
	    return 10000 + r.nextInt(20000);
	}
	

}
