package com.tm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.tm.entity.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {



}
