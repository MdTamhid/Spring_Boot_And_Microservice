package com.tm.runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.tm.entity.Customer;
import com.tm.repository.ICustomerRepository;


@Component
public class QueryMethodsTestRunner implements CommandLineRunner {

	@Autowired
	private ICustomerRepository custRepo;
	 
	@Override
	public void run(String... args) throws Exception {
		/*
		List<Customer>list=custRepo.showCustomersByBillAmtRange(3000, 5000);
		list.forEach(System.out::println);
		*/
		
		/*custRepo.showCustomersByAddress("Siwan","Patna").forEach(System.out::println);
		System.out.println("---------------------------");
		
		custRepo.showCustomersDataByBillAmt(2300, 5000).forEach(row->{
			for(Object obj:row)
			{
				System.out.print(obj+" ");
			}
			System.out.println();
		});
		
		System.out.println("-----------------------------");
		custRepo.showCustomersDataByCnameChars("a%").forEach(System.out::println);*/
		
		/*	
			int names = custRepo.updateCustomersBillAmtWithDiscountByCityNames("Bali", "Nareshpur", 20.0);
			System.out.println("no of records"+"----------- "+names);*/
		
		/*Customer name = custRepo.fetchCustomerByName("Aman");
		System.out.println("Single complete record "+name+" ");
		
		System.out.println("--------------------------------");
		
		Object byName = custRepo.fetchCustomerDataByName("Saddam");
		Object data[]=(Object[])byName;
		System.out.println("Single record multiple values are:: "+Arrays.toString(data));
		
		System.out.println("--------------------------------");
		double d = custRepo.fetchCustomerBillAmtByName("Aman");
		System.out.println("Customer bill data "+d);*/
		
		
		/*	System.out.println("All customer count::"+custRepo.fetchCustomerCount());
			System.out.println("All cusotmer names unique count::"+custRepo.fetchUniqueCustomerNamesCount());
			
			Object row[]=(Object[])custRepo.fetchCusomtersAggregate();
			System.out.println("Result are::"+Arrays.toString(row));
			*/
		
		custRepo.createTempTable();
		System.out.println("-----------");
		System.out.println(custRepo.showSystemDate());
		System.out.println("------------");
		custRepo.registerCustomer("Bhusan Singh", "Odisha",6700.0);
		
	}
	
}



