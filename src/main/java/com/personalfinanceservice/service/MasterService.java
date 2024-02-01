package com.personalfinanceservice.service;

import java.util.List;

import com.personalfinanceservice.model.AccountMasterModel;
import com.personalfinanceservice.model.ExpenseMasterModel;
import com.personalfinanceservice.model.IncomeMasterModel;

public interface MasterService {
	
	public List<IncomeMasterModel> getIncomeMaster() throws Exception;
	
	public IncomeMasterModel getIncomeMasterbykeycode(String keycode) throws Exception;
	
	public IncomeMasterModel saveIncomeMaster(IncomeMasterModel incomeMasterModel) throws Exception;
	
	public String updateIncomeMaster(IncomeMasterModel incomeMasterModel) throws Exception;

    public List<ExpenseMasterModel> getExpenseMaster() throws Exception;
	
	public ExpenseMasterModel getExpenseMasterbykeycode(String keycode) throws Exception;
	
	public ExpenseMasterModel saveExpenseMaster(ExpenseMasterModel expenseMasterModel) throws Exception;
	
	public String updateExpenseMaster(ExpenseMasterModel expensemasterModel) throws Exception;
	
    public List<AccountMasterModel> getAccountMaster() throws Exception;
	
	public AccountMasterModel getAccountMasterbykeycode(String keycode) throws Exception;
	
	public AccountMasterModel saveAccountMaster(AccountMasterModel accountMasterModel) throws Exception;
	
	public String updateAccountMaster(AccountMasterModel accountmasterModel) throws Exception;
	
	
}
