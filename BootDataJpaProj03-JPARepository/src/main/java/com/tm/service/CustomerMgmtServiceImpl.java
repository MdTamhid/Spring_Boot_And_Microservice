package com.tm.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.tm.entity.Customer;
import com.tm.repository.ICustomerRepository;
/**
 * 
 */
@Service
public class CustomerMgmtServiceImpl implements ICustomerMgmtService {

	@Autowired
	private ICustomerRepository custRepo;
	
	@Override
	public String deleteCustomerByIdInBatch(List<Integer> ids) {
		
		List<Customer>list=custRepo.findAllById(ids);
		custRepo.deleteAllByIdInBatch(ids);
		return list.size()+" No of customers recored are deleted!!";
	}
	@Override
	public List<Customer> showCustomersByExampleData(Customer cus, boolean flagOrder, String...properties) {
		// cretae example object
		Example<Customer>example=Example.of(cus);
		Sort sort=Sort.by(flagOrder?Direction.ASC:Direction.DESC,properties);
		List<Customer>list=custRepo.findAll(example,sort);
		
		return list;
	}
	
	@Override
	public Customer showCustomerById(int cno) {
		Customer cust=custRepo.getReferenceById(cno);
		System.out.println(cust.getClass()+"-----"+cust.getClass().getSuperclass());
		return cust;
	}
	
	@Override
	public Optional<Customer> fetchCustoemrById(int cno) {

       Optional<Customer>opt=custRepo.findById(cno);
		return opt;
	}
}

