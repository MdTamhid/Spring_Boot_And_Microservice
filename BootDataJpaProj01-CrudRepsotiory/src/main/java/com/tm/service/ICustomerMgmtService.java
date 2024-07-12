package com.tm.service;

import java.util.List;

import com.tm.entity.Customer;

public interface ICustomerMgmtService {
	
	public String registerCustomer(Customer cus);
	public boolean isCustomerAvailable(int id);
	public long showCustmomerCount();
	public Iterable<Customer>showAllCustmer();
    public Iterable<Customer>showAllcustomerByid(Iterable<Integer>id);
    public String registerGroupCustomer(List<Customer>custList);
    public Customer showCustomerById(int id);
    public String registerOrUpdate(Customer cust);
    public String updateCustomerAddrs(int con, String newAddrs);
    public String reomoveCustomerById(int con);
    public String removeCustomer(Customer cust);
    public String removeALlCustomer();
    public String deleteCustomerById(int cno);
}
