package com.personalfinanceservice.service;

import java.sql.Date;

import com.personalfinanceservice.model.AllSummaryReport;

public interface ReportService {
	
	public AllSummaryReport getAllSummaryReport(Date trandate);
	

}
