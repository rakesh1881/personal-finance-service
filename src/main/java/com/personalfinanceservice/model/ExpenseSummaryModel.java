package com.personalfinanceservice.model;

public class ExpenseSummaryModel {
	
	
	private String expenseName;
	private double totalExpense;
	
	
	public String getExpenseName() {
		return expenseName;
	}
	public void setExpenseName(String expenseName) {
		this.expenseName = expenseName;
	}
	public double getTotalExpense() {
		return totalExpense;
	}
	public void setTotalExpense(double totalExpense) {
		this.totalExpense = totalExpense;
	}
	@Override
	public String toString() {
		return "ExpenseSummaryModel [expenseName=" + expenseName + ", totalExpense=" + totalExpense + "]";
	}
	
	
	
}
