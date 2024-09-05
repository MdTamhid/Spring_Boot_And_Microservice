package com.tm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tm.entity.IPLPlayer;
import com.tm.repository.IPlayerRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class IPLPlayerMgmtServiceImpl implements IPLPlayerMgmtService {
	
	@Autowired
	private IPlayerRepository iplRepo;

	@Override
	public String registerPlayer(IPLPlayer player) {
		log.info("registerPlayer()mthod");
		Integer pid = iplRepo.save(player).getPid();
		return "Player is register with the id :"+pid;
	}

	@Override
	public IPLPlayer findPlayerById(int id) {
		log.info("findPlayerById()mthod");
		Optional<IPLPlayer> op = iplRepo.findById(id);
		if(op.isPresent()) {
			log.info("registerPlayer()mthod player found and return");
			return op.get();
		}
		log.info("Problem in finding the player");
		throw new IllegalArgumentException("Player not found");
	}

	@Override
	public List<IPLPlayer> findAllPlayers() {
		log.info("findAllPlayer()mthod");
		return iplRepo.findAll();
	}

}
