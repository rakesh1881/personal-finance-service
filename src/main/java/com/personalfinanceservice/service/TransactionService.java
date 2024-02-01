package com.personalfinanceservice.service;

import java.util.List;

import com.personalfinanceservice.model.AccountTranModel;
import com.personalfinanceservice.model.ExpenseTranModel;
import com.personalfinanceservice.model.IncomeTranModel;

public interface TransactionService {

	public List<IncomeTranModel>  getIncomeTransaction() throws Exception;
	
	public IncomeTranModel  getIncomeTransactionbyTrankey(String trankey) throws Exception;
	
	public IncomeTranModel  saveIncomeTransaction(IncomeTranModel incometranmodel) throws Exception;
	
	public String  updateIncomeTransaction(IncomeTranModel incometranmodel) throws Exception;
	
	
	public List<ExpenseTranModel>  getExpenseTransaction() throws Exception;
	
	public ExpenseTranModel  getExpenseTransactionbyTrankey(String trankey) throws Exception;
	
	public ExpenseTranModel  saveExpenseTransaction(ExpenseTranModel expensetranmodel) throws Exception;
	
	public String  updateExpenseTransaction(ExpenseTranModel expensetranmodel) throws Exception;
	
	
	//Account
	
	public List<AccountTranModel>  getAccountTransaction() throws Exception;
	
	public AccountTranModel  getAccountTransactionbyTrankey(String trankey) throws Exception;
	
	public AccountTranModel  saveAccountTransaction(AccountTranModel accounttranmodel) throws Exception;
	
	public String  updateAccountTransaction(AccountTranModel accounttranmodel) throws Exception;
	
}
