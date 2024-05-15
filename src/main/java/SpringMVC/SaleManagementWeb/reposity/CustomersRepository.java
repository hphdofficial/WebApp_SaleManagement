package SpringMVC.SaleManagementWeb.reposity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import SpringMVC.SaleManagementWeb.entity.Customers;

@Repository
public interface CustomersRepository extends CrudRepository<Customers, Integer> {}
