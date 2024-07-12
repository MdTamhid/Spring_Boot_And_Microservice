package com.tm.service;

import java.util.List;
import java.util.Optional;

import com.tm.entity.Customer;

public interface ICustomerMgmtService {
	
	public String deleteCustomerByIdInBatch(List<Integer>ids);
	public List<Customer> showCustomersByExampleData(Customer cus, boolean flagOrder, String...properties);
    public Customer showCustomerById(int cno);
    public Optional<Customer> fetchCustoemrById(int cno);

}
