package com.tm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tm.entity.Customer;
import com.tm.repository.ICustomerRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

@Service
public class CustomerMgmtServiceImpl implements IcustomerMgmtService {
	
	@Autowired
	private EntityManager em;
     
	/*
	CREATE DEFINER=`root`@`localhost` PROCEDURE `get_cust_billamt_range`(in min float,
			in max float)
			BEGIN
			select * from jpa_custmoer where billamt>=min and billamt<=max;
			END*/
	
	
	@Override
	public List<Customer> showCustomerByBillAmtRange(double start, double end) {
		
		// cretae the storeedPRcrdure Query Object
		StoredProcedureQuery query=em.createStoredProcedureQuery("get_cust_billamt_range",Customer.class);
		//Register IN,OUT mode params bu specifying their index and mode
		//query.registerStoredProcedureParameter(1, Object.class, ParameterMode.REF_CURSOR);
		query.registerStoredProcedureParameter(1, Double.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, Double.class, ParameterMode.IN);
		// set the PL/SQL procedure
		query.setParameter(1, start);
		query.setParameter(2, end);
		// execute the PL/SQL procedure
		List<Customer> list=query.getResultList();		
		return list;
	}

}
