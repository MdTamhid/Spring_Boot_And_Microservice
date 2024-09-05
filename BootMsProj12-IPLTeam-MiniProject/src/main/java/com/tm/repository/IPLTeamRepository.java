package com.tm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tm.entity.IPLTeam;

public interface IPLTeamRepository extends JpaRepository<IPLTeam, Integer> {

}
