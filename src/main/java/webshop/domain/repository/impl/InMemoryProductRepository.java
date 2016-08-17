package webshop.domain.repository.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import webshop.domain.Product;
import webshop.domain.repository.ProductRepository;
@Repository
public class InMemoryProductRepository implements ProductRepository{
	private List<Product> listOfProducts = new ArrayList<Product>();
	
	public InMemoryProductRepository(){
		Product iPhone = new Product("P1234", "iphone 5s", new BigDecimal(500));
		iPhone.setDescription("Apple bla bla bla");
		iPhone.setCategory("SmartPhone");
		iPhone.setManufacturer("Apple");
		iPhone.setUnitsInStock(1000);
		
		Product laptop_dell = new Product("D1222", "dell 1r1", new BigDecimal(1500));
		laptop_dell.setDescription("Dell bla bla bla");
		laptop_dell.setCategory("Laptop");
		laptop_dell.setManufacturer("Dell");
		laptop_dell.setUnitsInStock(500);
		
		Product tablet_nexus = new Product("ASD", "nexus 123", new BigDecimal(800));
		tablet_nexus.setDescription("Google bla bla bla");
		tablet_nexus.setCategory("Tablet");
		tablet_nexus.setManufacturer("Google");
		tablet_nexus.setUnitsInStock(7000);
		
		listOfProducts.add(iPhone);
		listOfProducts.add(laptop_dell);
		listOfProducts.add(tablet_nexus);
	}
	
	public List<Product> getAllProducts() {		
		return listOfProducts;
	}

	public Product getProductById(String productId) {
		Product productById = null;
		for(Product p : listOfProducts){
			if(p != null && p.getProductId() != null &&
					p.getProductId().equals(productId)){
				productById = p;
				break;
			}
		}
		if(productById  == null){
			throw new IllegalArgumentException("Thers is not product with id= "+productId);
		}
		return productById;
	}

	public List<Product> getProductsByCategory(String category) {
		List<Product> listOfProductsByCategory = new ArrayList<Product>();
		for(Product p: listOfProducts){
			if(category.equalsIgnoreCase(p.getCategory())){
				listOfProductsByCategory.add(p);
			}
		}
		return listOfProductsByCategory;
	}

	public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
		Set<Product> productsByBrand = new HashSet<Product>();
		Set<Product> productsByCategory = new HashSet<Product>();
		Set<String> criterias = filterParams.keySet();
		if(criterias.contains("brand")){
			for(String brandName: filterParams.get("brand")){
				for(Product p: listOfProducts){
					if(brandName.equalsIgnoreCase(p.getManufacturer())){
						productsByBrand.add(p);
					}
				}
				
			}
		}
		if(criterias.contains("category")){
			for(String category: filterParams.get("category")){
				productsByCategory.addAll(this.getProductsByCategory(category));
			}
		}
		productsByCategory.retainAll(productsByBrand);
		return productsByCategory;
	}
}
