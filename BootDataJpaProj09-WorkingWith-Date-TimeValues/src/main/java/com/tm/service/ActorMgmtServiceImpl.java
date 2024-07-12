package com.tm.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tm.entity.Actor;
import com.tm.repository.IActorReository;

@Service
public class ActorMgmtServiceImpl implements IActorMgmtService {

	@Autowired
	private IActorReository actorRepo;
	
	@Override
	public String registerActor(Actor actor) {
	
		int idVal=actorRepo.save(actor).getAid();
		
		return "actor pbject is saved with the id value::"+idVal;
	}
	
	 @Override
	public List<Actor> showAllActor() {
		
		return actorRepo.findAll();
	}
	 @Override
	public Iterable<Actor> showAllActorByid(Iterable<Integer>id) {
      
		Iterable<Actor>actors = actorRepo.findAllById(id);
		 
		return actors;
	}
	 
	 @Override
	public String delteActorByid(Integer act) {
		
		 actorRepo.deleteById(act);
		 
		 return"Actor deltail delete!!"+act.intValue();
		// return ""+act.getInteger(act);
	}
	 

}
