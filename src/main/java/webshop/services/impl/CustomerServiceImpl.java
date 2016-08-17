package webshop.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webshop.domain.Customer;
import webshop.domain.repository.CustomerRepository;
import webshop.services.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	public CustomerRepository customerRepository;

	public List<Customer> getAllCustomers() {
		return customerRepository.getAllCustomers();
	}

}
