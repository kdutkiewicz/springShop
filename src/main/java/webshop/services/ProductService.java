package webshop.services;

import java.util.List;

import webshop.domain.Product;

public interface ProductService {
	List<Product> getAllProducts();
	List<Product> getProductsByCategory(String category);
}
