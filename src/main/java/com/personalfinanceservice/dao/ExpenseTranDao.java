package com.personalfinanceservice.dao;

import java.util.List;

import com.personalfinanceservice.model.ExpenseTranModel;

public interface ExpenseTranDao {
	
	public List<ExpenseTranModel>  getExpenseTransaction() throws Exception;
	
	public ExpenseTranModel  getExpenseTransactionbyTrankey(String trankey);
	
	public ExpenseTranModel  saveExpenseTransaction(ExpenseTranModel expensetranmodel);
	
	public String  updateExpenseTransaction(ExpenseTranModel expensetranmodel);
}
