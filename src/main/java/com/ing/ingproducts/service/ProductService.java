package com.ing.ingproducts.service;

import com.ing.ingproducts.dto.ProductDescription;
import com.ing.ingproducts.dto.ProductResponse;

public interface ProductService {

	public ProductResponse getProductsByCategory(Long categoryId);

	public ProductDescription getProductDetails(Long productId);

}
