package webshop.domain.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import webshop.domain.Customer;
import webshop.domain.repository.CustomerRepository;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository {
	private List<Customer> listOfAllCustomers = new ArrayList<Customer>();

	public InMemoryCustomerRepository() {
		Customer c1 = new Customer("C1", "Sosnowiec", "Kacper");
		Customer c2 = new Customer("C2", "Katowice", " Ala");
		Customer c3 = new Customer("C3", "Katowice", " ma kota");
		listOfAllCustomers.add(c1);
		listOfAllCustomers.add(c2);
		listOfAllCustomers.add(c3);
	}

	public List<Customer> getAllCustomers() {
		return listOfAllCustomers;

	}

}
