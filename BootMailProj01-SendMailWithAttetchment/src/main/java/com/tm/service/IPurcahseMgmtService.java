package com.tm.service;

public interface IPurcahseMgmtService {
	
	public String shoping(String[]items,
			              float[]prices,
			              String fromMail,
			              String[] toMail	) throws Exception;

}
