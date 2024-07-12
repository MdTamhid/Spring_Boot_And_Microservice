package com.tm.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.tm.entity.Customer;
import com.tm.service.IcustomerMgmtService;

@Component
public class PLSQLProgrammingTestRunner implements CommandLineRunner {

	@Autowired
	private IcustomerMgmtService custService;

	@Override
	public void run(String... args) throws Exception {

		try {
                   
			List<Customer> list=custService.showCustomerByBillAmtRange(2200,7500);
			list.forEach(System.out::println);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
