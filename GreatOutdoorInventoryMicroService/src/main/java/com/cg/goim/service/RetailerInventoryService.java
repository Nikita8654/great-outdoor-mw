package com.cg.goim.service;


import java.util.List;


import com.cg.goim.exception.RetailerInventoryException;
import com.cg.goim.model.RetailerInventoryModel;

public interface RetailerInventoryService {
	
	public RetailerInventoryModel addProduct(RetailerInventoryModel product) throws RetailerInventoryException;
    public RetailerInventoryModel updateProductStock(RetailerInventoryModel productStock) throws RetailerInventoryException;
	public RetailerInventoryModel findProductByInventoryId(String inventoryId);
	public void deleteInventoryById(String inventoryId);
	public List<RetailerInventoryModel> getAllByRetailerId(String retailerId);

}
