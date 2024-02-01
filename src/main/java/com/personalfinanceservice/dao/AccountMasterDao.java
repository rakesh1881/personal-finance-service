package com.personalfinanceservice.dao;

import java.util.List;

import com.personalfinanceservice.model.AccountMasterModel;

public interface AccountMasterDao {

    public List<AccountMasterModel> getAccountMaster() throws Exception;
	
	public AccountMasterModel getAccountMasterbykeycode(String keycode) throws Exception;
	
	public AccountMasterModel saveAccountMaster(AccountMasterModel accountMasterModel) throws Exception;
	
	public int getAccountLastnumber()throws Exception;
	
	public String getAccountCodeByAccountname(String accountName)throws Exception;
	
	public String upateAccountMaster(AccountMasterModel accountmasterModel) throws Exception;
	
}
