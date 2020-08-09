package com.cg.gops;

import com.cg.gops.dao.ProductRepository;
import com.cg.gops.entity.ProductCategory;
import com.cg.gops.entity.ProductEntity;
import com.cg.gops.exception.ProductNotFoundException;
import com.cg.gops.model.ProductModel;
import com.cg.gops.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@SpringBootTest
class GreatOutdoorProductMicroServiceApplicationTests {

	@Autowired
	private ProductService productService;
	@MockBean
	private ProductRepository productRepository;

	@Test
	void getAllProductsTest() {
		when(productRepository.findAllByIsDeletedIsFalse()).thenReturn(Stream
				.of(new ProductEntity("AB0021","Tent",200,
						"Grey",ProductCategory.CAMPING_EQUIPMENT,20,
						"For camping",0),
						new ProductEntity("ME0003","Bag",800,
								"Blue", ProductCategory.MOUNTAINEERING_EQUIPMENT,2,
								"for mountaineering",0))
				.collect(Collectors.toList()));
		assertEquals(2,productService.getAllProducts().size());
	}

	@Test
	public void getProductByIdTest() {
		String id="BC9018";
		ProductEntity product=new ProductEntity("CE2019","Tent",200,
				"Grey", ProductCategory.CAMPING_EQUIPMENT,20,
				"For camping purposes.",0);
		when(productRepository.findById(id)).thenReturn(Optional.of(product));

	}

	@Test
	public void addProductTest() throws ProductNotFoundException {
		ProductModel product =new ProductModel("AB2019","Rope",120,"Brown",
				ProductCategory.CAMPING_EQUIPMENT,20,"for camping");
		when(productRepository.save(of(product))).thenReturn(of(product));
		assertEquals(product,productService.addProduct(product));

	}
	@Test
	public void updateProductTest() throws ProductNotFoundException {
		ProductModel product =new ProductModel("AB2019","Rope",120,"Brown",
				ProductCategory.CAMPING_EQUIPMENT,20,"for camping");
		given(productRepository.save(of(product))).willReturn(of(product));
		/*ProductModel expected=productService.updateProduct(product);
		verify(productRepository).save(any(ProductEntity.class));*/

	}
	private ProductEntity of(ProductModel source) {
		ProductEntity result=null;
		if(source!=null) {
			result=new ProductEntity();
			result.setIsDeleted(0);
			result.setProductId(source.getProductId());
			result.setProductName(source.getProductName());
			result.setProductPrice(source.getProductPrice());
			result.setProductCategory(source.getProductCategory());
			result.setProductQuantity(source.getProductQuantity());
			result.setProductSpecification(source.getProductSpecification());
			result.setProductColor(source.getProductColor());
		}
		return result;

	}

	private ProductModel of(ProductEntity source) {
		ProductModel result=null;
		if(source!=null) {
			result=new ProductModel();
			result.setProductId(source.getProductId());
			result.setProductName(source.getProductName());
			result.setProductPrice(source.getProductPrice());
			result.setProductCategory(source.getProductCategory());
			result.setProductQuantity(source.getProductQuantity());
			result.setProductSpecification(source.getProductSpecification());
			result.setProductColor(source.getProductColor());
		}
		return result;
	}


}
