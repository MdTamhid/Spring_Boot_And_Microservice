package com.tm.service;

import java.util.List;

import com.tm.entity.IPLTeam;

public interface IPLTeamMgmtService {
	
	// save IPL Team data
	public String registerIPLTeam(IPLTeam team);
	
	// get all the teams
	public List<IPLTeam> getAllTemas();
	
	// get team by id
	public IPLTeam getTeamById(Integer teamId);

}
