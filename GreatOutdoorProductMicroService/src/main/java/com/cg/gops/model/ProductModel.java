package com.cg.gops.model;

import com.cg.gops.entity.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel {
	
	    private String productId;
	    private String productName;
	    private Integer productPrice;
	    private String productColor;
	    private ProductCategory productCategory;
	    private Integer productQuantity;
	    private String productSpecification;

}
