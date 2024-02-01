package com.personalfinanceservice.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personalfinanceservice.dao.AccountMasterDao;
import com.personalfinanceservice.dao.AccountTranDao;
import com.personalfinanceservice.dao.ExpenseMasterDao;
import com.personalfinanceservice.dao.ExpenseTranDao;
import com.personalfinanceservice.dao.IncomeMasterDao;
import com.personalfinanceservice.dao.IncomeTranDao;
import com.personalfinanceservice.model.AccountTranModel;
import com.personalfinanceservice.model.ExpenseTranModel;
import com.personalfinanceservice.model.IncomeTranModel;
import com.personalfinanceservice.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	IncomeTranDao incometranDao;
	
	@Autowired
	ExpenseTranDao expensetranDao;
	
	@Autowired
	AccountTranDao accounttranDao;
	
	@Autowired
	AccountMasterDao accountMasterDao;
	
	@Autowired
	IncomeMasterDao incomeMasterDao;
	
	@Autowired
	ExpenseMasterDao expenseMasterDao;
	
	@Override
	public List<IncomeTranModel> getIncomeTransaction() throws Exception {
		
		return incometranDao.getIncomeTransaction();
	}

	@Override
	public IncomeTranModel getIncomeTransactionbyTrankey(String trankey) throws Exception {
		
		return incometranDao.getIncomeTransactionbyTrankey(trankey);
	}

	@Override
	public IncomeTranModel saveIncomeTransaction(IncomeTranModel incometranmodel) throws Exception {
		
		return incometranDao.saveIncomeTransaction(incometranmodel);
	}

	@Override
	public String updateIncomeTransaction(IncomeTranModel incometranmodel) throws Exception {
		
		incometranmodel.setAccountCode(accountMasterDao.getAccountCodeByAccountname(incometranmodel.getAccountName()));
		incometranmodel.setIncomeCode(incomeMasterDao.getIncomeCodeByincomename(incometranmodel.getIncomeName()));
		
		
		return incometranDao.updateIncomeTransaction(incometranmodel);
	}

	@Override
	public List<ExpenseTranModel> getExpenseTransaction() throws Exception {
		
		return expensetranDao.getExpenseTransaction();
	}

	@Override
	public ExpenseTranModel getExpenseTransactionbyTrankey(String trankey) throws Exception {
		
		return expensetranDao.getExpenseTransactionbyTrankey(trankey);
	}

	@Override
	public ExpenseTranModel saveExpenseTransaction(ExpenseTranModel expensetranmodel) throws Exception {
		
		return expensetranDao.saveExpenseTransaction(expensetranmodel);
	}

	@Override
	public String updateExpenseTransaction(ExpenseTranModel expensetranmodel) throws Exception {
		
		expensetranmodel.setAccountCode(accountMasterDao.getAccountCodeByAccountname(expensetranmodel.getAccountName()));
		expensetranmodel.setExpenseCode(expenseMasterDao.getExpenseCodeByExpensename(expensetranmodel.getExpenseName()));
		
		return expensetranDao.updateExpenseTransaction(expensetranmodel);
	}

	@Override
	public List<AccountTranModel> getAccountTransaction() throws Exception {
		
		return accounttranDao.getAccountTransaction();
	}

	@Override
	public AccountTranModel getAccountTransactionbyTrankey(String trankey) throws Exception {
		
		return accounttranDao.getAccountTransactionbyTrankey(trankey);
	}

	@Override
	public AccountTranModel saveAccountTransaction(AccountTranModel accounttranmodel) throws Exception {
		
		return accounttranDao.saveAccountTransaction(accounttranmodel);
	}

	@Override
	public String updateAccountTransaction(AccountTranModel accounttranmodel) throws Exception {
		
		accounttranmodel.setAccountCode(accountMasterDao.getAccountCodeByAccountname(accounttranmodel.getAccountName()));
		
		return accounttranDao.updateAccountTransaction(accounttranmodel);
	}

}
