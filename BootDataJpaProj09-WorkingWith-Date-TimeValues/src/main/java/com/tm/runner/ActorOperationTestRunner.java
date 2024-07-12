package com.tm.runner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.tm.entity.Actor;
import com.tm.service.IActorMgmtService;

@Component
public class ActorOperationTestRunner implements CommandLineRunner {

	@Autowired
	private IActorMgmtService actorSerive;
	
	@Override
	public void run(String... args) throws Exception {
		
		/*try {
		Actor actor=new Actor("Allu Arjun","Hero",LocalDate.of(1985, 07, 28),
				LocalTime.of(9, 2,3),
				LocalDateTime.of(2008,6,9,1,35,42));
		
		
		
		String msg=actorSerive.registerActor(actor);
		System.out.println(msg);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}*/
	    
		/*try {
			  Iterable<Actor> byid = actorSerive.showAllActorByid(List.of(1,2));
			  byid.forEach(data->{System.out.println("Show Acoter detail!!"+data);});
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		*/
		
		String byid = actorSerive.delteActorByid(2);
		System.out.println(byid);
	}

}
