package com.tm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tm.entity.Customer;

import jakarta.transaction.Transactional;


public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
	
	
	
}


     



