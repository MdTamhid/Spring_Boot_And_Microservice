package com.tm.service;

import java.util.List;

import com.tm.entity.Customer;

public interface IcustomerMgmtService {
	
	public List<Customer> showCustomerByBillAmtRange(double start, double end);

}
