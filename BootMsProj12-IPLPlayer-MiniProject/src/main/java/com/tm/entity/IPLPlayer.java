package com.tm.entity;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="IPL_PLAYER_INFO")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class IPLPlayer {
	
	@Id
	@SequenceGenerator(name="gen1",sequenceName = "	PID_SEQ",initialValue = 1,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	
	private Integer pid;
	
	
	
	@Column(length = 20)
	private String pname;
	
    private Integer age;
  
	@Column(length = 20)
	private String role; 
	
	
	
	@ManyToOne(targetEntity = IPLTeam.class,cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
	@JoinColumn(name="t_id",referencedColumnName = "teamId") // for FK column
	private IPLTeam team; // to build many to one association

    @Override
	public String toString() {
		return "IPLPlayer [pid=" + pid + ", pname=" + pname + ", age=" + age + ", role=" + role +"]";
	}
	
}
