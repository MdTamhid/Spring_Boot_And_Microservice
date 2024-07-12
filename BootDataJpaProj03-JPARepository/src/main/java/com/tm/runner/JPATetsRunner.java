package com.tm.runner;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.tm.entity.Customer;
import com.tm.service.ICustomerMgmtService;

@Component
public class JPATetsRunner implements CommandLineRunner {

	@Autowired
	private ICustomerMgmtService custService;

	@Override
	public void run(String... args) throws Exception {
       // Invoking the service class method		
		
		/*try
		{
			String msg=custService.deleteCustomerByIdInBatch(List.of(123,124));
			System.out.println(msg);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}*/
		
		/*try
		{
			Customer cus=new Customer();
			cus.setCmnme("Juhi");cus.setCadd("Siwan");
			List<Customer>list=custService.showCustomersByExampleData(cus, true, "billAmt");
			list.forEach(System.out::println);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}*/
		
		try
		{
			Customer cust=custService.showCustomerById(133);
			System.out.println(cust.getClass()+"----"+cust.getClass().getSuperclass()+"From Runner------");
			System.out.println(cust);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		System.out.println("=============================");
		
		try
		{
			Optional<Customer>opt=custService.fetchCustoemrById(1225);
			if(opt.isPresent())
			{
				System.out.println("Record is::"+opt.get());
			}
			else
			{
				System.out.println("Record not found!!");
			}
			
         }
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
