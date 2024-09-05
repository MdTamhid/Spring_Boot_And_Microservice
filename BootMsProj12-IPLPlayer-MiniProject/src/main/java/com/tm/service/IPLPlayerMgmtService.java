package com.tm.service;

import java.util.List;

import com.tm.entity.IPLPlayer;

public interface IPLPlayerMgmtService {

	public String registerPlayer(IPLPlayer player);
	public IPLPlayer findPlayerById(int id);
    public List<IPLPlayer> findAllPlayers();
}
