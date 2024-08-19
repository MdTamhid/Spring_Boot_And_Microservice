package com.tm.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name = "student_demo_api")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)


	private Integer stuId;
	
	@NotBlank(message="Name is mandatory")
	@Size(min =3, max= 15,
	message="Name should have atlist minimum 3 characters or maxinimum 15 characters")
	private String stuName;
	private String stuAddrs;

}
