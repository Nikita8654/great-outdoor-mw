package com.cg.gops.controller;

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

import com.cg.gops.exception.ProductNotFoundException;
import com.cg.gops.model.ProductModel;
import com.cg.gops.service.ProductService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

	 @Autowired
	 private ProductService productService;
	 
	    @GetMapping("/products")
	    public List<ProductModel> findAllProducts() {
	  
	        return productService.getAllProducts();
	    }

	    @GetMapping(value = "/products/{id}")
	    public ResponseEntity<ProductModel> getProductById(@PathVariable("id") String id) throws ProductNotFoundException {
	      
	    	ResponseEntity<ProductModel> response=null;
	        ProductModel product = productService.getProductById(id);
	        		if(product==null) {
	        			response=new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        		}
	        		else {
	        			response=new ResponseEntity<>(product,HttpStatus.OK);
	        		}
					return response;
	        		
	       
	    }

	    @PostMapping(value = "/products")
	    public ResponseEntity<ProductModel> addProduct(@Valid @RequestBody ProductModel productModel) throws ProductNotFoundException{
	    	productModel.setProductId(getProductId()+"");
	        return new  ResponseEntity<>(productService.addProduct(productModel),HttpStatus.OK);
	    }

	    @PutMapping(value = "/products/{id}")
	    public ResponseEntity<ProductModel> updateProduct(@PathVariable("id") String id,@Valid @RequestBody ProductModel productModel)
	            throws ProductNotFoundException {
	     
	        return ResponseEntity.ok(productService.updateProduct(productModel));
	    }


	    @DeleteMapping("/products/{id}")
	    public ResponseEntity<Boolean> deleteProduct(@PathVariable(value = "id") String id)
	            throws ProductNotFoundException {
	       
	        productService.deleteProduct(id);
	        return ResponseEntity.ok(true);
	    }

	    @GetMapping("/products/getAll")
	    public List<ProductModel> getAllProductList() {
	  
	        return productService.getAllProductList();
	    }
	    
	    public int getProductId() {
		    Random r = new Random( System.currentTimeMillis() );
		    return 10000 + r.nextInt(20000);
		}
}
