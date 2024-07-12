package com.tm.service;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ReportGenerateService {

	/*@Scheduled(initialDelay = 2000,fixedDelay = 3000)
	public void generateReport()
	{
		System.out.println("Sales report on:: "+new Date());
	}*/
	
	/*@Scheduled(fixedDelay = 2000)
	public void generateReport()
	{
		System.out.println("Sales report on:: "+new Date());
		try 
		{
		      Thread.sleep(15000);	
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("end "+ new Date());
	}*/
	
	/*@Scheduled(cron="15 * * * * *")
	public void generateReport1()
	{
	    System.out.println("Sales report on:: "+new Date());
	}*/
	
	@Scheduled(cron="16 38 * * * *")
	public void generateReport1()
	{
	    System.out.println("Sales report on:: "+new Date());
	}

		
}








