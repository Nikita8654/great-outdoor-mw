package com.cg.gops.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="GREAT_OUTDOOR_PRODUCT_TABLE")
public class ProductEntity {
	
	    @Id
	    @Column(name="PRODUCT_ID")
	    private String productId;
	    
	    @Column(name="PRODUCT_NAME",nullable=false)
	    private String productName;
	    
	    @Column(name="PRODUCT_PRICE",nullable=false)
	    private Integer productPrice;
	    
	    @Column(name="PRODUCT_COLOR",nullable=false)
	    private String productColor;
	    
	    @Enumerated(EnumType.STRING)
	    @Column(name="PRODUCT_CATEGORY",nullable=false)
	    private ProductCategory productCategory;
	    
	    @Column(name="PRODUCT_QUANTITY",nullable=false)
	    private Integer productQuantity;
	    
	    @Column(name="PRODUCT_SPECIFICATION")
	    private String productSpecification;
	    
	    @Column(name="IS_DELETED_STATUS")
	    private int isDeleted;

}
