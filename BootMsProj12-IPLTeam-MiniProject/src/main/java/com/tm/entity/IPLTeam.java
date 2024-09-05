package com.tm.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="IPL_TEAM_INFO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IPLTeam implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Integer teamId;
	

	@Column(length = 25)
	private String teamName;
	
	

	@Column(length = 20)
	private String owner;
	

	@Column(length = 20)
	private String area;
	
	 
	
	
	
	
}











