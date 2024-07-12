package com.tm.runner;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.tm.entity.Customer;
import com.tm.repository.ICustomerRepository;


@Component
public class CustomFinderMethodsRunner implements CommandLineRunner {

	@Autowired
	private ICustomerRepository custRepo;
	 
	@Override
	public void run(String... args) throws Exception {
					
		/*List <Customer>custList=custRepo.findBycmnmeEquals("Faruk");
		custList.forEach(System.out::println);
		
		System.out.println("========================");
		List<Customer> list = custRepo.findBycmnmeIs("Aman");
		list.forEach(System.out::println);
		
		System.out.println("=======================");
		custRepo.findBycmnme("Saddam").forEach(System.out::println);
		*/
		
		/*custRepo.findBycmnmeStartingWith("a").forEach(System.out::println);
		System.out.println("------------------------");
		custRepo.findBycmnmeEndingWith("r").forEach(System.out::println);
		System.out.println("------------------------");
		custRepo.findBycmnmeContaining("h").forEach(System.out::println);*/
		
		//custRepo.findBycmnmeEqualsIgnoreCase("faRuk").forEach(System.out::println);
		
		//custRepo.findBybillAmtBetween(2100, 7000).forEach(System.out::println);
		
		//custRepo.findByBillAmtGreaterThanEqualAndBillAmtLessThanEqual(2000.0f, 7000.0f).forEach(System.out::println);
		custRepo.findByCaddInOrCmnmeLikeIgnoreCase(List.of("Patna","Siwan","Delhi"), "a%").forEach(System.out::println);
	}
	
}



