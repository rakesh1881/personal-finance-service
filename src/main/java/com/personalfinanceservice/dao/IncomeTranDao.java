package com.personalfinanceservice.dao;

import java.util.List;

import com.personalfinanceservice.model.IncomeTranModel;

public interface IncomeTranDao {
	
	public List<IncomeTranModel>  getIncomeTransaction() throws Exception;
	
	public IncomeTranModel  getIncomeTransactionbyTrankey(String trankey);
	
	public IncomeTranModel  saveIncomeTransaction(IncomeTranModel incometranmodel);
	
	public String  updateIncomeTransaction(IncomeTranModel incometranmodel);
}
