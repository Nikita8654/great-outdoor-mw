package com.cg.goim.controller;

import java.util.List;
import java.util.Random;

import javax.validation.Valid;

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

import com.cg.goim.exception.RetailerInventoryException;
import com.cg.goim.model.RetailerInventoryModel;
import com.cg.goim.service.RetailerInventoryService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class RetailerInventoryController {

	@Autowired
	private RetailerInventoryService retailerService;
	
	@PostMapping("/inventory")
	public ResponseEntity<RetailerInventoryModel> createProduct(@Valid @RequestBody RetailerInventoryModel inventory) throws RetailerInventoryException{
		
		inventory.setInventoryId(getInventoryId()+"");
		inventory=retailerService.addProduct(inventory);
		return new ResponseEntity<>(inventory,HttpStatus.OK);
	}
	
	
	@PutMapping("/inventory")
	public ResponseEntity<RetailerInventoryModel> updateTrainee(@RequestBody RetailerInventoryModel productStock) throws RetailerInventoryException {
		productStock = retailerService.updateProductStock(productStock);
		return new ResponseEntity<>(productStock, HttpStatus.OK);
	}
	

	@GetMapping("/inventory/getAll/{retailerId}")
	public ResponseEntity<List<RetailerInventoryModel>> getRetailerId(@PathVariable("retailerId") String retailerId){
		ResponseEntity<List<RetailerInventoryModel>> response=null;
		List<RetailerInventoryModel> inventoryList=retailerService.getAllByRetailerId(retailerId);
	    if(inventoryList==null) {
	    	response=new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	    else {
	    	response=new ResponseEntity<>(inventoryList,HttpStatus.OK);
	    }
		return response;
	}
	
	@GetMapping("/inventory/{inventoryId}")
	public ResponseEntity<RetailerInventoryModel> findById(@PathVariable("inventoryId") String inventoryId) {
		
		ResponseEntity<RetailerInventoryModel> response = null;

		RetailerInventoryModel product = retailerService.findProductByInventoryId(inventoryId);

		if (product == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity<>(product, HttpStatus.OK);
		}
  
		return response;
	}
	
	@DeleteMapping("/inventory/{inventoryId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("inventoryId") String inventoryId) {

        ResponseEntity<Void> response = null;

        RetailerInventoryModel product = retailerService.findProductByInventoryId(inventoryId);

        if (product == null) {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            retailerService.deleteInventoryById(inventoryId);
            response = new ResponseEntity<>(HttpStatus.OK);
        }

        return response;
    }
	public int getInventoryId() {
	    Random r = new Random( System.currentTimeMillis() );
	    return 10000 + r.nextInt(20000);
	}
	
	
}
