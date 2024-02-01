package com.personalfinanceservice.dao;

import java.util.List;

import com.personalfinanceservice.model.ExpenseMasterModel;

public interface ExpenseMasterDao {

public List<ExpenseMasterModel> getExpenseMaster() throws Exception;
	
	public ExpenseMasterModel getExpenseMasterbykeycode(String keycode) throws Exception;
	
	public ExpenseMasterModel saveExpenseMaster(ExpenseMasterModel expenseMasterModel) throws Exception;
	
	public int getExpenseLastnumber()throws Exception;
	
	public String upateExpenseMaster(ExpenseMasterModel expensemasterModel) throws Exception;
	
	public String getExpenseCodeByExpensename(String expenseName)throws Exception;
}
