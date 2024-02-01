package com.personalfinanceservice.model;

public class ExpenseMasterModel {
	
	private String expenseName;
	private String active;
	private String expenseId;
	
	
	public ExpenseMasterModel() {
		super();
	}

	
	public String getExpenseId() {
		return expenseId;
	}
	public void setExpenseId(String expenseId) {
		this.expenseId = expenseId;
	}
	public String getExpenseName() {
		return expenseName;
	}
	public void setExpenseName(String expenseName) {
		this.expenseName = expenseName;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	
	@Override
	public String toString() {
		return "expenseMaster [expenseName=" + expenseName + ", active=" + active + ", expenseId=" + expenseId + "]";
	}

	
	

}
