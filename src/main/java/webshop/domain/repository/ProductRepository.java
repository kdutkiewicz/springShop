package webshop.domain.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

import webshop.domain.Product;

public interface ProductRepository {
	public List <Product> getAllProducts();
	public Product getProductById(String productId);
	public List<Product> getProductsByCategory(String category);
	public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);
}
