package com.tm.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.tm.repository.ICustomerRepository;
import com.tm.view.ResultView;


@Component
public class CustomFinderMethodsRunner implements CommandLineRunner {

	@Autowired
	private ICustomerRepository custRepo;
	 
	@Override
	public void run(String... args) throws Exception {
		
		List<ResultView> list=custRepo.findByBillAmtBetween(3300.0, 4900.0);
		list.forEach(view->{System.out.println(view.getcmnme()+"------>"+view.getcadd());});
	}
	
}



