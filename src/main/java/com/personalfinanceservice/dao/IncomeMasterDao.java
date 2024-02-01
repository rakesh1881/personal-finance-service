package com.personalfinanceservice.dao;

import java.util.List;

import com.personalfinanceservice.model.IncomeMasterModel;

public interface IncomeMasterDao {

	public List<IncomeMasterModel> getIncomeMaster() throws Exception;
	
	public IncomeMasterModel getIncomeMasterbykeycode(String keycode) throws Exception;
	
	public IncomeMasterModel saveIncomeMaster(IncomeMasterModel incomeMasterModel) throws Exception;
	
	public int getIncomeLastnumber()throws Exception;
	
	public String getIncomeCodeByincomename(String incomeName)throws Exception;
	
	public String upateIncomeMaster(IncomeMasterModel incomemasterModel) throws Exception;
	
}
