package com.tm.service;

import org.springframework.beans.factory.annotation.Autowired;
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
	public Iterable<Customer> showCustomersSorted(boolean flag, String... properties) {
		
		// prepare Sort object
		Sort sort=Sort.by(flag?Direction.ASC:Direction.DESC, properties);
		// executes the logics
		Iterable<Customer> it=custRepo.findAll(sort);
		return it;
	}
	@Override
	public Page<Customer> showCustomersByPageNo(int pageNo, int pageSize,
			boolean flagOrder,String... properties) {
		// create sort object
		Sort sort=Sort.by(flagOrder?Direction.ASC:Direction.DESC, properties);
		// create Pegeble object (pageNo, oageSize)
		Pageable page=PageRequest.of(pageNo-1, pageSize,sort);
		// get Page<T> object having requested page records
		Page<Customer>pg=custRepo.findAll(page);
		
		return pg;
	}
	
	@Override
	public void showCustomersDataPageByPage(int pageSize) {

		// get records count
		long count=custRepo.count();
		long pagesCount=count/pageSize;
		if(count%pageSize!=0)
		{
			pagesCount++;
		}
		// Display each page records
		for(int i=0; i<pagesCount;++i)
		{
			// cretae pageble object
			PageRequest pagebale=PageRequest.of(i, pageSize);
			// get each page records
			Page<Customer>page=custRepo.findAll(pagebale);
			System.out.println("----------------"+(i+1)+"/"+page.getTotalPages()+"records are::------------");
			page.getContent().forEach(System.out::println);
		}
		
	}
}
