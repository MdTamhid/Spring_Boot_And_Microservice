package com.tm.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.tm.entity.Customer;

public interface ICustomerMgmtService {
	
	public Iterable<Customer> showCustomersSorted(boolean asc,String...properties);
	public Page<Customer> showCustomersByPageNo(int pageNo, int pageSize,boolean flagOrder,String...peoperties);
    public void showCustomersDataPageByPage(int pageSize);


}
