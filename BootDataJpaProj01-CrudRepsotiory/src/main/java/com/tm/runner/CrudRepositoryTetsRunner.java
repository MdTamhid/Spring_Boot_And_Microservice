package com.tm.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.tm.entity.Customer;
import com.tm.service.ICustomerMgmtService;

@Component
public class CrudRepositoryTetsRunner implements CommandLineRunner {

	@Autowired
	private ICustomerMgmtService custService;

	@Override
	public void run(String... args) throws Exception {
       // Invoking bussiness object
		/*try {
		Customer cust = new Customer();
		cust.setCmnme("Raj");
		cust.setCadd("Delhi234");
		cust.setBillAmt(90000.0f);
		
		String resultMsg=custService.registerCustomer(cust);
		System.out.println(resultMsg);
		}
		catch(Exception e)
		{e.printStackTrace();
			
		}
		*/		

		/*try {
			System.out.println("100 id customer available ??"+custService.isCustomerAvailable(100));
			System.out.println("100 id customer available ??"+custService.isCustomerAvailable(102));
			System.out.println("100 id customer available ??"+custService.isCustomerAvailable(103));
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}*/

		/*try {
			System.out.println("Customer count::"+custService.showCustmomerCount());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}*/
		
		/*try {
		Iterable<Customer>list=custService.showAllCustmer();
		//list.forEach(data->{System.out.println("Data from customer table::"+data);});
		//list.forEach(System.out::println);
		//list.forEach(data->System.out.println("Data from customer table::"+data));
		for(Customer data:list)
		{
			System.out.println(data);
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			Iterable<Customer>list=custService.showAllcustomerByid(List.of(101,102,103,104,333,232));
			//System.out.println("Customer data by ID::"+list+"\n");
			list.forEach(System.out::println);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}*/

		// Save multiple records in DB
		/*try {
			
			Customer cust1=new Customer();
			cust1.setCmnme("Sonu");
			cust1.setCadd("Hyd");
			cust1.setBillAmt(4000.0f);
			Customer cust2=new Customer();
			cust2.setCmnme("Monu");
			cust2.setCadd("Chpra");
			cust2.setBillAmt(5000.0f);
			Customer cust3=new Customer();
			cust3.setCmnme("Gopal");
			cust3.setCadd("Ara");
			cust3.setBillAmt(6000.0f);
			Customer cust4=new Customer();
			cust2.setCmnme("Rahul");
			cust2.setCadd("Up");
			cust2.setBillAmt(8000.0f);
			List<Customer>custList=List.of(cust1,cust2,cust3,cust4);
			String msg=custService.registerGroupCustomer(custList);
			System.out.println(msg);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		*/
		
		/*	try {
				Customer cust= custService.showCustomerById(1010);
				System.out.println(cust);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}*/

		// Customer Registered Or Update
		/*try
		{
			Customer cust=new Customer();
			cust.setCon(1018);
			cust.setCmnme("Tabish");
			cust.setCadd("Noida");
			cust.setBillAmt(700.0f);
			String reslutMsg=custService.registerOrUpdate(cust);
			System.out.println(reslutMsg);
		}
		catch(Exception e)
		{
		  e.printStackTrace();		
		}*/

		// Customer Address Updated
		/*try {

			String msg = custService.updateCustomerAddrs(10188, "UK");
			System.out.println(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		// Delete operation
		/*try
		{
			String msg=custService.reomoveCustomerById(107);
			System.out.println(msg);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}*/
		
		// Reomve customer
		/*try
		{
			Customer cust=new Customer();
			cust.setCon(114);
			cust.setCmnme("Tabish");
			cust.setCadd("Noida");
			cust.setBillAmt(700.0f);
			String msg=custService.removeCustomer(cust);
			System.out.println(msg);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}*/
		
		// All customer deleted
		/*try
		{
			String msg=custService.removeALlCustomer();
			System.out.println(msg);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}*/
		
		try
		{
			//Customer cust =new Customer();
			String msg=custService.deleteCustomerById(116);
			System.out.println(msg);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
