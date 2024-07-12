package com.tm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tm.entity.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

   public List<Customer> findBycmnmeEquals(String name);
   public List<Customer> findBycmnmeIs(String name);   
   public List<Customer> findBycmnme(String name);
   
   public List<Customer> findBycmnmeStartingWith(String initialChars);
   public List<Customer> findBycmnmeEndingWith(String lastChars);
   public List<Customer> findBycmnmeContaining(String chars);
   public List<Customer> findBycmnmeEqualsIgnoreCase(String name);
   public List<Customer> findBybillAmtBetween(double start, double end);
   
   // --------------- Having multiple conditions -------------------------
   
   public List<Customer> findByBillAmtGreaterThanEqualAndBillAmtLessThanEqual(double d,double e);
   public List<Customer> findByCaddInOrCmnmeLikeIgnoreCase(List<String>addresses, String namePattern);
   
   
}


     