package webshop.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import webshop.domain.Product;
import webshop.domain.repository.ProductRepository;
import webshop.services.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	@RequestMapping("/products")
	public String list(Model model){		
		model.addAttribute("products", productService.getAllProducts());
		return "products";
	}
}
