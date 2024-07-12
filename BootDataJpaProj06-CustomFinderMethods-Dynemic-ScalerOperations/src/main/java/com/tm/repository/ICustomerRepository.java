package com.tm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tm.entity.Customer;
import com.tm.view.View;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

   public <T extends View> List<T> findByBillAmtBetween(double start,double end,Class<T>clzz);
   
   
}


     