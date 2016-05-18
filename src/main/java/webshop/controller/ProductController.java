package webshop.controller;

import java.math.BigDecimal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import webshop.domain.Product;

@Controller
public class ProductController {
	@RequestMapping("/products")
	public String list(Model model){
		Product iPhone = new Product("P1234", "iphone 5s", new BigDecimal(500));
		iPhone.setDescription("Apple bla bla bla");
		iPhone.setCategory("Smart Phone");
		iPhone.setManufacturer("Apple");
		iPhone.setUnitsInStock(1000);
		model.addAttribute("product", iPhone);
		return "products";
	}
}
