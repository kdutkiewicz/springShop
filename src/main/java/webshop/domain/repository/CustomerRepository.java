package webshop.domain.repository;

import java.util.List;

import webshop.domain.Customer;

public interface CustomerRepository {
	public List<Customer> getAllCustomers();
}
