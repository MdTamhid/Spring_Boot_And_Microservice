package com.tm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tm.entity.prod.Product;
import com.tm.entity.promotions.Promotions;
import com.tm.repository.prod.IProductRepository;
import com.tm.repository.promotions.IPromotionsRepository;

@Service
public class TwoDbMgmtServiceImpl implements ITwoDBMgmtService {

	@Autowired
	private IProductRepository prodRepo;
	@Autowired
	private IPromotionsRepository promosRepo;
	
	@Override
	public String saveData(Product prod, Promotions promso) {
		int idVal1=prodRepo.save(prod).getId();
		long idVal2=promosRepo.save(promso).getPrid();
		return "product and promostions are saved in two diffrent DBs having id values"+idVal1+"......."+idVal2;
	}

}
