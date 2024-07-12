package com.tm.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.tm.entity.Customer;
import com.tm.service.ICustomerMgmtService;

@Component
public class PASTetsRunner implements CommandLineRunner {

	@Autowired
	private ICustomerMgmtService custService;

	@Override
	public void run(String... args) throws Exception {
       // Invoking the service class method
		
		/*try
		{
			custService.showCustomersSorted(true, "cmnme").forEach(System.out::println);
			System.out.println("--------------------------");
			custService.showCustomersSorted(true, "cadd").forEach(System.out::println);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}*/
		
		// Pagination
		/*try
		{
			Page<Customer>page=custService.showCustomersByPageNo(1, 3,true,"cmnme");
			Iterable<Customer>it=page.getContent();// page Content
			System.out.println("Page no::"+(page.getNumber()+1)+"/"+(page.getTotalPages())+"records are!!");
			it.forEach(System.out::println);
			System.out.println("Total no of pages!! "+page.getTotalPages());
			System.out.println("Curent page no!! "+page.getNumber());
			System.out.println("Total no of records!! "+page.getTotalElements());
			System.out.println("Curent page no of records!! "+page.getNumberOfElements());
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}*/
		
		try
		{
			custService.showCustomersDataPageByPage(3);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
