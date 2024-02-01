package com.personalfinanceservice.model;

public class IncomeSummaryModel {

	private String incomeName;
	private double totalIncome;
	
	
	public String getIncomeName() {
		return incomeName;
	}
	public void setIncomeName(String incomeName) {
		this.incomeName = incomeName;
	}
	public double getTotalIncome() {
		return totalIncome;
	}
	public void setTotalIncome(double totalIncome) {
		this.totalIncome = totalIncome;
	}
	@Override
	public String toString() {
		return "IncomeSummaryModel [incomeName=" + incomeName + ", totalIncome=" + totalIncome + "]";
	}
	
	
}
