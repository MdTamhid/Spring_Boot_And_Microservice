package com.tm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tm.entity.IPLTeam;
import com.tm.repository.IPLTeamRepository;

import lombok.extern.slf4j.Slf4j;

@Service("IPLTeamService")
@Slf4j
public class IPLTeamMgmtServiceImpl implements IPLTeamMgmtService {
	
	@Autowired
	private IPLTeamRepository iplRepo;

	@Override
	public String registerIPLTeam(IPLTeam team) {
	
		log.info("registerIPLTeam method(service)");
		Integer idVal = iplRepo.save(team).getTeamId();
		
		return "IPLTeam is saved with the value :"+idVal;
	}

	@Override
	public List<IPLTeam> getAllTemas() {
	
		log.info("getAlTeams method(service)");
		return iplRepo.findAll();
	}

	@Override
	public IPLTeam getTeamById(Integer teamId) {
	
		log.info("getTeamById(-)method(service)");
		
		return iplRepo.findById(teamId).orElseThrow(()-> new IllegalArgumentException("Invalid team id"));
	}

}
