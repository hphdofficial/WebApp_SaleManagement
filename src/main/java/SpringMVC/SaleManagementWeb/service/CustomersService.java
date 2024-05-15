package SpringMVC.SaleManagementWeb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SpringMVC.SaleManagementWeb.entity.Customers;
import SpringMVC.SaleManagementWeb.reposity.CustomersRepository;

@Service
public class CustomersService {
	@Autowired
	private CustomersRepository customersRepository;
	
	public Iterable<Customers> getAllCustomers() {
		return customersRepository.findAll();
	}
	
	public void save(Customers c) {
		customersRepository.save(c);
	}
	
	public Customers getCustomerByFullname(String fullname) {
		for (Customers c : customersRepository.findAll()) {
			if (c.getFullname().equals(fullname)) {
				return c;
			}
		}
		return null;
	}
}
