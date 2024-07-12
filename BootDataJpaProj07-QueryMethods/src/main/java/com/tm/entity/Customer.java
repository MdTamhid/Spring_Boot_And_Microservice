package com.tm.entity;

import io.micrometer.common.lang.NonNull;
import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="JPA_CUSTMOER")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Customer {
	
	@Column(name="CID")
	@Id
	//@GeneratedValue  // Generates the id values 1,2,52,102,152 and etc... default Generator is AUTO
	                 // for generation the id values in some other pattern configure other generation(SEQUENCE,TABLE INDEMTITY)
	@SequenceGenerator(name="gen1",sequenceName = "CNO_SEQ",initialValue = 100,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Integer con;
	
	@NonNull
	@Column(name="CNAME")
	private String cmnme;
	
	@NonNull
	@Column(name="CADD")
	private String cadd;
	
	@Nonnull
	@Column(name="BILLAMT")
	private Float billAmt;
	
	

}
