package com.tm.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.tm.service.IPurcahseMgmtService;
@Component
public class MailTestRunner implements CommandLineRunner {
	
	@Autowired
	private IPurcahseMgmtService service;
	@Autowired
	private Environment env;

	@Override
	public void run(String... args) throws Exception {
		
		String fromMail=env.getRequiredProperty("spring.mail.username");
		
		String resultMsg=service.shoping(new String[]{"Shirt","Trouser","Shoes","Cap"},
				                         new float[] {1300.0f,900.0f,2300.0f,550.0f},
		                                 fromMail,
		                                 new String[] 
		                             	 {"tamhidalam450@gmail.com","tamhid2554@gmail.com","Saddamhussainrr786@gmail.com"});
        System.out.println(resultMsg);
	
	}

}
