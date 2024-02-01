package com.personalfinanceservice.dao;

import java.sql.Date;
import java.util.List;

import com.personalfinanceservice.model.AccountSummaryModel;
import com.personalfinanceservice.model.AllSummaryReport;
import com.personalfinanceservice.model.ExpenseSummaryModel;
import com.personalfinanceservice.model.IncomeSummaryModel;

public interface ReportSummaryListDao {
	
	public AllSummaryReport getAllSummaryReport(Date trandate);

	public List<AccountSummaryModel> getAccountSummaryModel(Date trandate);
	
	public List<IncomeSummaryModel> getIncomeSummaryModel(Date trandate);
	
	public List<ExpenseSummaryModel> getExpenseSummaryModel(Date trandate);
	
}
