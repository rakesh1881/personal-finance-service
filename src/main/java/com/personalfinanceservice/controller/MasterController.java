package com.personalfinanceservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.personalfinanceservice.model.AccountMasterModel;
import com.personalfinanceservice.model.ExpenseMasterModel;
import com.personalfinanceservice.model.IncomeMasterModel;
import com.personalfinanceservice.service.MasterService;

@RestController
public class MasterController {

	@Autowired
	MasterService service;
	private Logger logger = LoggerFactory.getLogger(getClass());

	@GetMapping("/Hello")
	public String hello() {
		return "Hello This Is Rakesh";

	}

	@RequestMapping("/viewIncome")
	public List<IncomeMasterModel> getIncomeMaster() throws Exception {

		return service.getIncomeMaster();

	}

	@GetMapping("/viewIncomebykeycode")
	public IncomeMasterModel getIncomeMasterbykeycode(@RequestParam(name = "keycode") String keyCode) throws Exception {
		logger.info("Get Income Master keycode is {}", keyCode);
		return service.getIncomeMasterbykeycode(keyCode);

	}

	@PostMapping("/SaveIncome")
	public ResponseEntity<IncomeMasterModel> saveIncomeMaster(@RequestBody IncomeMasterModel incomeModel)
			throws Exception {

		return new ResponseEntity<IncomeMasterModel>(service.saveIncomeMaster(incomeModel), HttpStatus.OK);
	}

	@PostMapping("/updateIncome")
	public String updateIncomeMaster(@RequestBody IncomeMasterModel incomeModel) throws Exception {

		return service.updateIncomeMaster(incomeModel);
	}

//Expense
	@GetMapping("/viewExpense")
	public List<ExpenseMasterModel> getExpenseMaster() throws Exception {

		return service.getExpenseMaster();

	}

	@GetMapping("/viewExpensebykeycode")
	public ExpenseMasterModel getExpenseMasterbykeycode(@RequestParam(name = "keycode") String keyCode)
			throws Exception {
		logger.info("Get Expense Master keycode is {}", keyCode);
		return service.getExpenseMasterbykeycode(keyCode);

	}

	@PostMapping("/SaveExpense")
	public ResponseEntity<ExpenseMasterModel> saveExpenseMaster(@RequestBody ExpenseMasterModel incomeModel)
			throws Exception {

		return new ResponseEntity<ExpenseMasterModel>(service.saveExpenseMaster(incomeModel), HttpStatus.OK);
	}

	@PostMapping("/updateExpense")
	public String updateExpenseMaster(@RequestBody ExpenseMasterModel incomeModel) throws Exception {

		return service.updateExpenseMaster(incomeModel);
	}

//Account

	@GetMapping("/viewAccount")
	public List<AccountMasterModel> getAccountMaster() throws Exception {

		return service.getAccountMaster();

	}

	@GetMapping("/viewAccountbykeycode")
	public AccountMasterModel getAccountMasterbykeycode(@RequestParam(name = "keycode") String keyCode)
			throws Exception {
		logger.info("Get Expense Master keycode is {}", keyCode);
		return service.getAccountMasterbykeycode(keyCode);

	}

	@PostMapping("/SaveAccount")
	public ResponseEntity<AccountMasterModel> saveAccountMaster(@RequestBody AccountMasterModel incomeModel)
			throws Exception {

		return new ResponseEntity<AccountMasterModel>(service.saveAccountMaster(incomeModel), HttpStatus.OK);
	}

	@PostMapping("/updateAccount")
	public String updateExpenseMaster(@RequestBody AccountMasterModel incomeModel) throws Exception {

		return service.updateAccountMaster(incomeModel);
	}

}
