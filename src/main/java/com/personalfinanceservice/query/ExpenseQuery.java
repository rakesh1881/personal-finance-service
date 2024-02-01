package com.personalfinanceservice.query;

import org.springframework.stereotype.Component;

import com.personalfinanceservice.model.ExpenseMasterModel;
import com.personalfinanceservice.model.ExpenseTranModel;

@Component
public class ExpenseQuery {

	
	StringBuilder sb = new StringBuilder();
	
	public String getExpenseQuerykeycode(String keyCode) {
		sb= new StringBuilder();
		sb.append("Select name as expensename,keycode as expenseid ,active from ExpenseMaster where keycode='"+keyCode+"';");
		return sb.toString();
	}
	
	public String getExpenseQuery() {
		sb= new StringBuilder();
		sb.append("Select name as expensename,keycode as expenseid ,active from ExpenseMaster;");
		return sb.toString();
	}
	
	public String getExpenseCount() {
		sb= new StringBuilder();
		sb.append("select count(*) count from ExpenseMaster");
		return sb.toString();
	}
	public String getupdateQuery(ExpenseMasterModel expensemodel) {
		sb= new StringBuilder();
		sb.append("update ExpenseMaster set name='"+expensemodel.getExpenseName()+"',active='"+expensemodel.getActive()+"' where keycode='"+expensemodel.getExpenseId()+"';");
		return sb.toString();
	}
	public String getExpenseCodebyExpenseName(String expenseName) {
		sb= new StringBuilder();
		sb.append("select keycode from ExpenseMaster where expenseName='"+expenseName+"';");
		return sb.toString();
	}
	
	//Transaction
	public String getExpenseTran() {
		sb= new StringBuilder();
		sb.append("select description,trankey,expenseaccount as accountcode,keycode as expensecode,amount,trandate from Expensetran;");
		return sb.toString();
	}
	public String getExpensetranbyTrankey(String trankey) {
		sb= new StringBuilder();
		sb.append("select description,trankey,expenseaccount as accountcode,keycode as expensecode,amount,trandate from Expensetran where trankey='"+trankey+"';");
		return sb.toString();
	}
	
	public String updateExpensetranbyTrankey(ExpenseTranModel expenseTranModel) {		
		sb= new StringBuilder();
		sb.append("update Expensetran set amount="+expenseTranModel.getAmount()+",description='"+expenseTranModel.getDescription()+",expenseaccount="+expenseTranModel.getAccountCode()+",");
		sb.append("keycode='"+expenseTranModel.getExpenseCode()+"' where trankey='"+expenseTranModel.getTrankey()+"'");
		return sb.toString();
	}

	
}
