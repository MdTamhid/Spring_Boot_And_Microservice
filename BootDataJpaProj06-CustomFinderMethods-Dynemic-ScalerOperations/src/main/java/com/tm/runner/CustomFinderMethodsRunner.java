package com.tm.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.tm.repository.ICustomerRepository;
import com.tm.view.ResultView1;
import com.tm.view.ResultView2;
import com.tm.view.ResultView3;
import com.tm.view.ResultView4;


@Component
public class CustomFinderMethodsRunner implements CommandLineRunner {

	@Autowired
	private ICustomerRepository custRepo;
	 
	@Override
	public void run(String... args) throws Exception {
		
		List<ResultView1> list1=custRepo.findByBillAmtBetween(2000, 3200, ResultView1.class);
	    list1.forEach(view1->{System.out.println(view1.getcmnme());});
	    
	    System.out.println("---------------------------------");
	    
	    List<ResultView2> list12=custRepo.findByBillAmtBetween(3500, 4500, ResultView2.class);
	    list12.forEach(view2->{System.out.println(view2.getcmnme()+"----"+view2.getcadd());});
	    
	    System.out.println("----------------------------------");
	    
	    List<ResultView3> list13=custRepo.findByBillAmtBetween(3500, 4500, ResultView3.class);
	    list13.forEach(view3->{System.out.println(view3.getcmnme()+"----"+view3.getcadd()+"---"+view3.getbillAmt());});
	
	    System.out.println("-----------------------------------");
	    
	    List<ResultView4> list14=custRepo.findByBillAmtBetween(3500, 4500, ResultView4.class);
	    list14.forEach(view4->{System.out.println(view4.getcmnme()+"----"+view4.getbillAmt());});
	    
	
	
	}
	
}



