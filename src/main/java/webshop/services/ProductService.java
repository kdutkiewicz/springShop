package webshop.services;

import java.util.List;
import java.util.Map;
import java.util.Set;

import webshop.domain.Product;

public interface ProductService {
	List<Product> getAllProducts();
	List<Product> getProductsByCategory(String category);
	Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);
}
