package com.personalfinanceservice.dao;

import java.util.List;

import com.personalfinanceservice.model.AccountTranModel;

public interface AccountTranDao {
	
	public List<AccountTranModel>  getAccountTransaction() throws Exception;
	
	public AccountTranModel  getAccountTransactionbyTrankey(String trankey);
	
	public AccountTranModel  saveAccountTransaction(AccountTranModel accounttranmodel);
	
	public String  updateAccountTransaction(AccountTranModel accounttranmodel);
}
