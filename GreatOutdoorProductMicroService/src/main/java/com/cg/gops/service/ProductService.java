package com.cg.gops.service;

import java.util.List;

import com.cg.gops.exception.ProductNotFoundException;
import com.cg.gops.model.ProductModel;

public interface ProductService {
	
	    public List<ProductModel> getAllProducts();
	    public List<ProductModel> getAllProductList();// for admin report
	    public ProductModel getProductById(String id) throws ProductNotFoundException;
	    public ProductModel addProduct(ProductModel productModel) throws ProductNotFoundException;
	    public ProductModel updateProduct(ProductModel productModel) throws ProductNotFoundException;
	    public void deleteProduct(String id) throws ProductNotFoundException;

}
