package com.personalfinanceservice.model;

import java.sql.Date;

public class IncomeTranModel {

	
	private String Description;
	private String Trankey;
	private String accountCode;
	private String incomeCode;
	private double amount;
	private Date trandate;
	private String IncomeName;
	private String AccountName;
	
	
	
	public String getIncomeName() {
		return IncomeName;
	}
	public void setIncomeName(String incomeName) {
		IncomeName = incomeName;
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
	public String getIncomeCode() {
		return incomeCode;
	}
	public void setIncomeCode(String incomeCode) {
		this.incomeCode = incomeCode;
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
				+ ", incomeCode=" + incomeCode + ", amount=" + amount + ", trandate=" + trandate + "]";
	}
	
	
}
