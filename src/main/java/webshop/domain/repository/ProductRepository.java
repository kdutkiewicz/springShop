package webshop.domain.repository;

import java.util.List;

import webshop.domain.Product;

public interface ProductRepository {
	public List <Product> getAllProducts();
	public Product getProductById(String productId);
	public List<Product> getProductsByCategory(String category);
}
