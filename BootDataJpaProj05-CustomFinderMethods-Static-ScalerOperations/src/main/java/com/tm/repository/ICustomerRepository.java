package com.tm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tm.entity.Customer;
import com.tm.view.ResultView;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

   public List<ResultView> findByBillAmtBetween(double start,double end);
   
   
}


     