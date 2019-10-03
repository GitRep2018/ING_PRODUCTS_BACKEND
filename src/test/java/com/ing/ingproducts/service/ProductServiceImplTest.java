package com.ing.ingproducts.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.ing.ingproducts.dto.ProductDescription;
import com.ing.ingproducts.dto.ProductDetails;
import com.ing.ingproducts.dto.ProductResponse;
import com.ing.ingproducts.entity.Category;
import com.ing.ingproducts.entity.Product;
import com.ing.ingproducts.repository.ProductRepository;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest {
	
	@InjectMocks
	ProductServiceImpl productServiceImpl;
	
	@Mock
	ProductRepository productRepository;
	
	ProductResponse productResponse;
	Category category;
	Product product1;
	Product product2;
	List<Product> products;
	ProductDescription productDescription;
	ProductDetails productDetails1;
	ProductDetails productDetails2;
	List<ProductDetails> productDetails;
	
	@Before
	public void setup() {

	
	
	product1=new Product();
	product1.setProductId(1L);
	
	product2=new Product();
	product2.setProductId(2L);
	
	products=new ArrayList<Product>();
	products.add(product1);
	products.add(product2);
	
	category=new Category();
	category.setCategoryId(1L);
	category.setCategoryName("bank");
	category.setProducts(products);
	
	productDescription=new ProductDescription();
	productDescription.setProductId(1L);
	
	productDetails1=new ProductDetails();
	productDetails1.setProductId(1L);
	
	productDetails2=new ProductDetails();
	productDetails2.setProductId(2L);
	
	productDetails=new ArrayList<ProductDetails>();
	productDetails.add(productDetails1);
	productDetails.add(productDetails2);
	
	productResponse=new ProductResponse();
	productResponse.setProductDetails(productDetails);
	productResponse.setStatusMessage("successful");
	
	}
	
	@Test
	public void testGetProductsByCategory()
	{
		Mockito.when(productRepository.findProductByCategoryId(category.getCategoryId())).thenReturn(products);
		
		ProductResponse actualProductResponse=productServiceImpl.getProductsByCategory(category.getCategoryId());
		
		Assert.assertEquals(productResponse.getStatusMessage(),actualProductResponse.getStatusMessage());
	}
	
	@Test
	public void testGetProductDetails()
	{
		
		Mockito.when(productRepository.findById(product1.getProductId())).thenReturn(Optional.of(product1));
		ProductDescription productDescription=productServiceImpl.getProductDetails(product1.getProductId());
		Assert.assertEquals(product1.getProductId(),productDescription.getProductId());

	}

}