package com.personalfinanceservice.model;

import java.util.List;

public class AllSummaryReport {

	private List<AccountSummaryModel> lstAccSummary;
	
	private List<IncomeSummaryModel> lstIncomeSummary;
	
	private List<ExpenseSummaryModel> lstExpenseSummary;

	public List<AccountSummaryModel> getLstAccSummary() {
		
		return lstAccSummary;
	}

	public void setLstAccSummary(List<AccountSummaryModel> lstAccSummary) {
		this.lstAccSummary = lstAccSummary;
	}

	public List<IncomeSummaryModel> getLstIncomeSummary() {
		return lstIncomeSummary;
	}

	public void setLstIncomeSummary(List<IncomeSummaryModel> lstIncomeSummary) {
		this.lstIncomeSummary = lstIncomeSummary;
	}

	public List<ExpenseSummaryModel> getLstExpenseSummary() {
		return lstExpenseSummary;
	}

	public void setLstExpenseSummary(List<ExpenseSummaryModel> lstExpenseSummary) {
		this.lstExpenseSummary = lstExpenseSummary;
	}

	@Override
	public String toString() {
		return "AllSummaryReport [lstAccSummary=" + lstAccSummary + ", lstIncomeSummary=" + lstIncomeSummary
				+ ", lstExpenseSummary=" + lstExpenseSummary + "]";
	}
	
	
	
	
}
