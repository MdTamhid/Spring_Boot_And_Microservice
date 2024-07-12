package com.tm.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class BankAccount {

	@SequenceGenerator(name ="gen1",sequenceName = "ACNO_SEQ",initialValue=10000000,allocationSize=1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	@Id
	
	private Long acno;
	@Column(length=20)
	@NonNull
	private String type;
	@Column(length=20)
	@NonNull
	private String ownerName;
	@NonNull
	private Double balance;
	@Version
	private Integer updateionCount;
	@CreationTimestamp
	private LocalDateTime doc;
	@CreationTimestamp
	private LocalDateTime lastAccessedOn;
}
