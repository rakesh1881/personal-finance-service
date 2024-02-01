package com.personalfinanceservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.personalfinanceservice.model.AccountTranModel;
import com.personalfinanceservice.model.ExpenseTranModel;
import com.personalfinanceservice.model.IncomeTranModel;
import com.personalfinanceservice.service.TransactionService;

@RestController
public class TransactionController {
	
	@Autowired
	TransactionService transervice;
    
	
	@RequestMapping("test")
	public String gettest() throws Exception{
		
	return	"test";
	
	}
	
	@RequestMapping("viewtransaction")
	public List<IncomeTranModel> getIncomeTransaction() throws Exception{
		
	return	transervice.getIncomeTransaction();
	
	}
	
	@GetMapping("viewtransactionbykeycode")
	public IncomeTranModel getIncomeTransaction(@RequestParam(name="keycode")   String keycode) throws Exception{
		
	return	transervice.getIncomeTransactionbyTrankey(keycode);
	
	}
	
	@PostMapping("Updateincometransaction")
	public String updateIncomeTransaction(@RequestBody IncomeTranModel incometranModel) throws Exception{
		
	return	transervice.updateIncomeTransaction(incometranModel);
	
	}
	
	@PostMapping("Saveincometransaction")
	public ResponseEntity<IncomeTranModel> saveIncomeTransaction(@RequestBody IncomeTranModel incometranModel) throws Exception{
		
	return	new ResponseEntity<IncomeTranModel>(transervice.saveIncomeTransaction(incometranModel), HttpStatus.OK);
	
	}
	
	//Expense
	
	@RequestMapping("viewexpensetransaction")
	public List<ExpenseTranModel> getExpenseTransaction() throws Exception{
		
	return	transervice.getExpenseTransaction();
	
	}
	
	@GetMapping("viewExpensetransactionbykeycode")
	public ExpenseTranModel getExpenseTransaction(@RequestParam(name="keycode")   String keycode) throws Exception{
		
	return	transervice.getExpenseTransactionbyTrankey(keycode);
	
	}
	
	@PostMapping("UpdateExpensetransaction")
	public String updateExpenseTransaction(@RequestBody ExpenseTranModel expensetranModel) throws Exception{
		
	return	transervice.updateExpenseTransaction(expensetranModel);
	
	}
	
	@PostMapping("Saveexpensetransaction")
	public ResponseEntity<ExpenseTranModel> saveIncomeTransaction(@RequestBody ExpenseTranModel expensetranModel) throws Exception{
		
	return	new ResponseEntity<ExpenseTranModel>(transervice.saveExpenseTransaction(expensetranModel), HttpStatus.OK);
	
	}
	
//  Account  account
	

	@RequestMapping("viewaccounttransaction")
	public List<ExpenseTranModel> getAccountTransaction() throws Exception{
		
	return	transervice.getExpenseTransaction();
	
	}
	
	@GetMapping("viewAccounttransactionbykeycode")
	public AccountTranModel getAccountTransaction(@RequestParam(name="keycode")   String keycode) throws Exception{
		
	return	transervice.getAccountTransactionbyTrankey(keycode);
	
	}
	
	@PostMapping("UpdateAccounttransaction")
	public String updateAccountTransaction(@RequestBody AccountTranModel accounttranModel) throws Exception{
		
	return	transervice.updateAccountTransaction(accounttranModel);
	
	}
	
	@PostMapping("SaveAccounttransaction")
	public ResponseEntity<AccountTranModel> saveAccountTransaction(@RequestBody AccountTranModel accounttranModel) throws Exception{
		
	return	new ResponseEntity<AccountTranModel>(transervice.saveAccountTransaction(accounttranModel), HttpStatus.OK);
	
	}
}
