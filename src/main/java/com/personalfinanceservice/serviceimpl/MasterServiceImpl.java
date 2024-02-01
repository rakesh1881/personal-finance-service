package com.personalfinanceservice.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personalfinanceservice.dao.AccountMasterDao;
import com.personalfinanceservice.dao.ExpenseMasterDao;
import com.personalfinanceservice.dao.IncomeMasterDao;
import com.personalfinanceservice.model.AccountMasterModel;
import com.personalfinanceservice.model.ExpenseMasterModel;
import com.personalfinanceservice.model.IncomeMasterModel;
import com.personalfinanceservice.service.MasterService;

@Service
public  class MasterServiceImpl implements MasterService{
	
	@Autowired
	IncomeMasterDao incomeDao;
	
	@Autowired
	ExpenseMasterDao expenseDao;
	
	@Autowired
	AccountMasterDao accountDao;

	@Override
	public IncomeMasterModel getIncomeMasterbykeycode(String keyCode) throws Exception {
			
		return incomeDao.getIncomeMasterbykeycode(keyCode);
	}

	@Override
	public IncomeMasterModel saveIncomeMaster(IncomeMasterModel incomeMasterModel) throws Exception {
		
		String keycode ="I"+(incomeDao.getIncomeLastnumber()+1);		
		incomeMasterModel.setIncomeId(keycode);	
		return incomeDao.saveIncomeMaster(incomeMasterModel);
	}

	@Override
	public String updateIncomeMaster(IncomeMasterModel incomeMasterModel) throws Exception {
		
		return incomeDao.upateIncomeMaster(incomeMasterModel);
	}

	@Override
	public List<IncomeMasterModel> getIncomeMaster() throws Exception {
		
		return incomeDao.getIncomeMaster();
	}

	@Override
	public List<ExpenseMasterModel> getExpenseMaster() throws Exception {
		
		return expenseDao.getExpenseMaster();
	}

	@Override
	public ExpenseMasterModel getExpenseMasterbykeycode(String keycode) throws Exception {
		
		return expenseDao.getExpenseMasterbykeycode(keycode);
	}

	@Override
	public ExpenseMasterModel saveExpenseMaster(ExpenseMasterModel expenseMasterModel) throws Exception {
		String keycode ="E"+(expenseDao.getExpenseLastnumber()+1);		
		expenseMasterModel.setExpenseId(keycode);	
		
		return expenseDao.saveExpenseMaster(expenseMasterModel);
	}

	@Override
	public String updateExpenseMaster(ExpenseMasterModel expensemasterModel) throws Exception {
		
		return expenseDao.upateExpenseMaster(expensemasterModel);
	}

	@Override
	public List<AccountMasterModel> getAccountMaster() throws Exception {
		
		return accountDao.getAccountMaster();
	}

	@Override
	public AccountMasterModel getAccountMasterbykeycode(String keycode) throws Exception {
		
		return accountDao.getAccountMasterbykeycode(keycode);
	}

	@Override
	public AccountMasterModel saveAccountMaster(AccountMasterModel accountMasterModel) throws Exception {
		String keycode ="A"+(accountDao.getAccountLastnumber()+1);		
		accountMasterModel.setAccountId(keycode);	
		return accountDao.saveAccountMaster(accountMasterModel);
	}

	@Override
	public String updateAccountMaster(AccountMasterModel accountmasterModel) throws Exception {
		
		return accountDao.upateAccountMaster(accountmasterModel);
	}

}
