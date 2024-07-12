package com.tm.runners;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.tm.entity.prod.Product;
import com.tm.entity.promotions.Promotions;
import com.tm.service.ITwoDBMgmtService;

@Component
public class TwoDBTestRunner implements CommandLineRunner {

	@Autowired
	private ITwoDBMgmtService dbService;

	@Override
	public void run(String... args) throws Exception {
		
		Product prod=new Product(1008,"table",80000.0,20.0);
		Promotions pro1=new Promotions(null,"ugadi-offer","u-1001",10.0,LocalDateTime.of(2024,5,10,11,30));
              
		
		         try {
                 String msg=dbService.saveData(prod, pro1);
                 System.out.println(msg);
		         }
                	 catch(Exception e)
                	 {
                		 e.printStackTrace();
                	 }
                 }
	}


