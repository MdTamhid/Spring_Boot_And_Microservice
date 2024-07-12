package com.tm.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tm.entity.Actor;

public interface IActorReository extends JpaRepository<Actor, Integer>{

	public String registerActor();
	public List<Actor> showAllActor();
	public Iterable<Actor> showAllActorByid(Iterable<Integer>id);
	
}
