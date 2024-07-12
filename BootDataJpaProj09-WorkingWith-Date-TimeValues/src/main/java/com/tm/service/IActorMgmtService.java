package com.tm.service;

import java.util.List;

import com.tm.entity.Actor;

public interface IActorMgmtService {
   
	public String registerActor(Actor actor);
	public List<Actor> showAllActor();
	public Iterable<Actor>  showAllActorByid(Iterable<Integer>id);
	public String  delteActorByid(Integer act);
 
}
