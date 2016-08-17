package webshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import webshop.services.CustomerService;

@Controller
public class CustomerController {
	@Autowired
	public CustomerService customerServices;
	@RequestMapping("/customers")
	public String getAllCustomers(Model model){
		model.addAttribute("customers", customerServices.getAllCustomers());
		return "customers";
	}
}
