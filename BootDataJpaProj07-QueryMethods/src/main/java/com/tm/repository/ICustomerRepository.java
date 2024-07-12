package com.tm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tm.entity.Customer;

import jakarta.transaction.Transactional;


public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
	// Both query working 
	@Query("from Customer where billAmt>=?1 and billAmt<=?2")
	public List<Customer> showCustomersByBillAmtRange(double min, double max);
	//@Query("from Customer where billAmt>=:min and billAmt<=:max")
	//@Query("from Customer cust where cust.billAmt>=:min and cust.billAmt<=:max")
	//@Query("select cust from Customer cust where cust.billAmt>=:min and cust.billAmt<=:max")
	//public List<Customer> showCustomersByBillAmtRange(@Param("min")double start,@Param("max") double end);
	
	@Query("from Customer where cadd in(:addrs1,:addrs2) order by cadd")
	public List<Customer> showCustomersByAddress(String addrs1, String addrs2);
	
	
	@Query("select cmnme,billAmt from Customer where billAmt>=:start and billAmt<=:end")
	public List<Object[]> showCustomersDataByBillAmt(double start, double end);
	
	
	@Query("select cmnme from Customer where cmnme like:initialChars")
	public List<String> showCustomersDataByCnameChars(String initialChars);
	
	
	@Transactional
	@Modifying
	@Query("update Customer set billAmt=billAmt-(billAmt*:discountPerecentage/100.0f) where cadd in(:city1,:city2)")
	public int updateCustomersBillAmtWithDiscountByCityNames(String city1, String city2,double discountPerecentage);
	
	
	@Query("from Customer where cmnme=:name")
	public Customer fetchCustomerByName(String name);
	
	@Query("select cmnme,billAmt from Customer where cmnme=:name")
	public Object fetchCustomerDataByName(String name);
	
	@Query("select billAmt from Customer where cmnme=:name")
	public double fetchCustomerBillAmtByName(String name);
	
	@Query("select count(*) from Customer")
	public long fetchCustomerCount();
	
	@Query("select count(distinct cmnme) from Customer")
	public long fetchUniqueCustomerNamesCount();
	
	@Query("select count(*),max(billAmt),min(billAmt),sum(billAmt),avg(billAmt) from Customer")
	public Object fetchCusomtersAggregate();
	
	// =======================Native SQL Quaries==================
	@Query(value="INSERT INTO JPA_CUSTMOER(CNAME,CADD,BILLAMT)VALUES(:name,:addrs,:amt)",nativeQuery=true)
	@Transactional
	@Modifying
	public int registerCustomer(String name,String addrs,double amt);
	
	
	@Query(value="SELECT now() FROM DUAL",nativeQuery=true)
	public String showSystemDate();
	
	
	@Query(value="create table Temp4(clo1 integer,col2 varchar(20))",nativeQuery=true )
	@Transactional
	@Modifying
	public int createTempTable();
}


     



