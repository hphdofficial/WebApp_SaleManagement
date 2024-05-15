package SpringMVC.SaleManagementWeb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import SpringMVC.SaleManagementWeb.service.CustomersService;
import SpringMVC.SaleManagementWeb.entity.Customers;

@RequestMapping(value = {"/authentication", "/authentication/"})
@Controller
public class AuthenticationController {
	
	@Autowired
	private CustomersService customersService;
	
	@GetMapping(value = {"/signin", "/signin/"})
	public String signin(Model model) {
		Customers customers = new Customers();
        model.addAttribute("customers", customers);
		return "Authentication/signin";
	}
	
	@PostMapping(value = {"/auth"})
	public String authLogin(Model model, @ModelAttribute("customers") Customers customers) {
		String fullname = customers.getFullname();
		Customers c = customersService.getCustomerByFullname(fullname);
		if (c == null) {
			model.addAttribute("error", "Invalid username or password");
		    return "Authentication/signin";
		}
		String password = customers.getPassword();
		if (c.getPassword().equals(password)) {
			model.addAttribute("currentCus", c);
			return "index";
		}
		else {
			model.addAttribute("customers", new Customers());
		    model.addAttribute("error", "Invalid username or password");
		    return "Authentication/signin";
		}
	}
	
	@GetMapping(value = {"/signup", "/signup/"})
	public String signup(Model model) {
		Customers customers = new Customers();
        model.addAttribute("customers", customers);
		return "Authentication/signup";
	}
	
	@PostMapping(value = {"/add"})
	public String registerCustomer(Model model, @ModelAttribute("customers") Customers customers) {
		String fullname = customers.getFullname();
		Customers c = customersService.getCustomerByFullname(fullname);
		if (c != null) {
			model.addAttribute("error", "User already exists");
		    return "Authentication/signup";
		}
		customersService.save(customers);
		model.addAttribute("success","Successful registration, please login to use");
		return "Authentication/signin";
	}
}
