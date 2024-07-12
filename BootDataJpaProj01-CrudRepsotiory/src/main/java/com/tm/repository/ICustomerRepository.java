package com.tm.repository;

import org.springframework.data.repository.CrudRepository;

import com.tm.entity.Customer;

public interface ICustomerRepository extends CrudRepository<Customer,Integer> {



}
