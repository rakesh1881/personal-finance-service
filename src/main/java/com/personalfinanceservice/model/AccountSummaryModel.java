package com.personalfinanceservice.model;

public class AccountSummaryModel {

	private double openingAmount;
	private double incomeAmount;
	private double expenseAmount;
	private double accountChangeOutAmount;
	private double accountChangeinAmount;
	private double closingAmount;
	private String accountName;

	public double getOpeningAmount() {
		return openingAmount;
	}

	public void setOpeningAmount(double openingAmount) {
		this.openingAmount = openingAmount;
	}

	public double getIncomeAmount() {
		return incomeAmount;
	}

	public void setIncomeAmount(double incomeAmount) {
		this.incomeAmount = incomeAmount;
	}

	public double getExpenseAmount() {
		return expenseAmount;
	}

	public void setExpenseAmount(double expenseAmount) {
		this.expenseAmount = expenseAmount;
	}

	public double getAccountChangeOutAmount() {
		return accountChangeOutAmount;
	}

	public void setAccountChangeOutAmount(double accountChangeOutAmount) {
		this.accountChangeOutAmount = accountChangeOutAmount;
	}

	public double getAccountChangeinAmount() {
		return accountChangeinAmount;
	}

	public void setAccountChangeinAmount(double accountChangeinAmount) {
		this.accountChangeinAmount = accountChangeinAmount;
	}

	public double getClosingAmount() {
		return closingAmount;
	}

	public void setClosingAmount(double closingAmount) {
		this.closingAmount = closingAmount;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	@Override
	public String toString() {
		return "AccountSummaryModel [openingAmount=" + openingAmount + ", incomeAmount=" + incomeAmount
				+ ", expenseAmount=" + expenseAmount + ", accountChangeOutAmount=" + accountChangeOutAmount
				+ ", accountChangeinAmount=" + accountChangeinAmount + ", closingAmount=" + closingAmount
				+ ", accountName=" + accountName + "]";
	}

	
}
