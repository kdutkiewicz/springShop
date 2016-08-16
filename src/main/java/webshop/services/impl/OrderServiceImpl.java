package webshop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webshop.domain.Product;
import webshop.domain.repository.ProductRepository;
import webshop.services.OrderService;
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private ProductRepository productRepository;

	public void processOrder(String productId, int count) {
		Product productById = productRepository.getProductById(productId);
		if (productById.getUnitsInStock() < count) {
			throw new IllegalArgumentException(
					"Not enought products in magazine. There is only:" + productById.getUnitsInStock());
		}
		productById.setUnitsInStock(productById.getUnitsInStock() - count);
	}

}
