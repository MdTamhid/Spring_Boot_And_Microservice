package com.tm.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tm.entity.Customer;
import com.tm.repository.ICustomerRepository;
/**
 * 
 */
@Service
public class CustomerMgmtServiceImpl implements ICustomerMgmtService {

	@Autowired
	private ICustomerRepository cusRepo;
	
	@Override
	public String registerCustomer(Customer cus) {
		
		System.out.println("Proxy class name::"+cusRepo.getClass()+" "+Arrays.toString(cusRepo.getClass().getInterfaces()));
		// save the object
		Customer cust1 = cusRepo.save(cus);
		return "Customer is saved(record inserted) with the id value:"+cust1.getCon();
	}

	@Override
	public boolean isCustomerAvailable(int id) {
		// use Repo
		
		return cusRepo.existsById(id);
	}

	@Override
	public long showCustmomerCount() {
		
		return cusRepo.count();
	}

	@Override
	public Iterable<Customer> showAllCustmer() {
		
		return cusRepo.findAll();
	}

	@Override
	public Iterable<Customer> showAllcustomerByid(Iterable<Integer>id) {
		
		return cusRepo.findAllById(id);
	}

	@Override
	public String registerGroupCustomer(List<Customer> custList) {
		
		Iterable<Customer>savedCustList=cusRepo.saveAll(custList);
		//System.out.println("Data print in Custtomer Service persent!!"+savedCustList);
		return custList.size()+"No of records are inserted!!";
	}

	/*@Override
	public Customer showCustomerById(int id) {	
		
		return cusRepo.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid id!!"));
	}*/
	
	/*@Override
	public Customer showCustomerById(int id) {	
		
		Optional<Customer> opt=cusRepo.findById(id);
		if(opt.isPresent())
		{
			return opt.get();
		}
		else
		{
			throw new IllegalArgumentException("Invalid Id!!");
		}
	}*/
	
	@Override
	public Customer showCustomerById(int id) {	
		
		Customer Incust= new Customer();
		Incust.setCadd("In house Customer!!");Incust.setBillAmt(0.0f);
		Customer cust=cusRepo.findById(id).orElse(Incust);
		return cust;
	}

	@Override
	public String registerOrUpdate(Customer cust) {
		// Load Boject
		Optional<Customer> opt=cusRepo.findById(cust.getCon());
		if(opt.isPresent())
		{
			cusRepo.save(cust); // Update the object
			return cust.getCon()+"Customer is updated!!";
		}
		else
		{
			Customer sCust=cusRepo.save(cust);// Inserted records
			return sCust.getCon()+"Customer is saved";
		}
		
	}

	@Override
	public String updateCustomerAddrs(int con, String newAddrs) {
		//Load the customer
		Optional<Customer>opt=cusRepo.findById(con);
		if(opt.isPresent())
		{
			// Get customer object from Optioinal object
			Customer cust=opt.get();
			cust.setCadd(newAddrs);
			cusRepo.save(cust);
			return con+"Customer address is Updated!!";
		}
		return con+"Cusotmer is not found for Updation!!";
	}

	@Override
	public String reomoveCustomerById(int con) {
		//  Deleting the boject
		Optional<Customer>opt=cusRepo.findById(con);
		if(opt.isPresent())
		{
			cusRepo.deleteById(con);
			return con+" Customer is deleted!!";
		}
		return con+" Cusotmer is not found for delete!!";
	}

	@Override
	public String removeCustomer(Customer cust) {
		
		Optional<Customer>opt=cusRepo.findById(cust.getCon());
		if(opt.isPresent())
		{
			// deleting the object
			cusRepo.delete(cust);
			return "Customer is deleted!!";
		}
		return cust.getCon()+" Customer is not found for deletion!!s";
	}
	
    @Override
    public String removeALlCustomer() {
    	
    	long count=cusRepo.count();
    	cusRepo.deleteAll();
    	return count+" no of record deleted !!";
    }
	
    @Override
    public String deleteCustomerById(int cno) {
    	
    	Optional<Customer>opt=cusRepo.findById(cno);
    	if(opt.isPresent())
    	{
    		cusRepo.deleteById(cno);
    		return cno+" Customer is deleted";
    	}
    	return cno+" Customer is not founded for delete!!";
    }
}
