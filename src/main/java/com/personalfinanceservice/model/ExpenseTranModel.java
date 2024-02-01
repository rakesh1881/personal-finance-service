package com.personalfinanceservice.model;

import java.sql.Date;

public class ExpenseTranModel {

	
	private String Description;
	private String Trankey;
	private String accountCode;
	private String expenseCode;
	private double amount;
	private Date trandate;
	private String expenseName;
	private String AccountName;
	
	
	
	public String getExpenseName() {
		return expenseName;
	}
	public void setExpenseName(String expenseName) {
		this.expenseName = expenseName;
	}
	public String getAccountName() {
		return AccountName;
	}
	public void setAccountName(String accountName) {
		AccountName = accountName;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getTrankey() {
		return Trankey;
	}
	public void setTrankey(String trankey) {
		Trankey = trankey;
	}
	public String getAccountCode() {
		return accountCode;
	}
	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}
	public String getExpenseCode() {
		return expenseCode;
	}
	public void setExpenseCode(String expenseCode) {
		this.expenseCode = expenseCode;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getTrandate() {
		return trandate;
	}
	public void setTrandate(Date trandate) {
		this.trandate = trandate;
	}
	
	
	@Override
	public String toString() {
		return "IncomeTranModel [Description=" + Description + ", Trankey=" + Trankey + ", accountCode=" + accountCode
				+ ", incomeCode=" + expenseCode + ", amount=" + amount + ", trandate=" + trandate + "]";
	}
	
	
}
