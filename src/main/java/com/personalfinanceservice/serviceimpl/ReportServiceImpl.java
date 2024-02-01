package com.personalfinanceservice.serviceimpl;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personalfinanceservice.dao.ReportSummaryListDao;
import com.personalfinanceservice.model.AllSummaryReport;
import com.personalfinanceservice.service.ReportService;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	ReportSummaryListDao reportDao;
	
	@Override
	public AllSummaryReport getAllSummaryReport(Date trandate) {
		
		return reportDao.getAllSummaryReport(trandate);
	}

}
