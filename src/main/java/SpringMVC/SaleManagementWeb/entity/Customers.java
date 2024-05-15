package SpringMVC.SaleManagementWeb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Customers")
public class Customers {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer CustomerID;
	private String Password;
	private String Fullname;
	private String Address;
	private String City;
	public Integer getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(Integer customerID) {
		CustomerID = customerID;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getFullname() {
		return Fullname;
	}
	public void setFullname(String fullname) {
		Fullname = fullname;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
}
