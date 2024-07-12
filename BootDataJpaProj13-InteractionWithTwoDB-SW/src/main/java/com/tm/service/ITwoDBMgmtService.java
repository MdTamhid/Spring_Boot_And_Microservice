package com.tm.service;

import com.tm.entity.prod.Product;
import com.tm.entity.promotions.Promotions;

public interface ITwoDBMgmtService {
	
	public String saveData(Product prod, Promotions promso);

}
