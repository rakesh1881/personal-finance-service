package com.personalfinanceservice.daoimpl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.personalfinanceservice.dao.ReportSummaryListDao;
import com.personalfinanceservice.model.AccountSummaryModel;
import com.personalfinanceservice.model.AllSummaryReport;
import com.personalfinanceservice.model.ExpenseSummaryModel;
import com.personalfinanceservice.model.IncomeSummaryModel;
import com.personalfinanceservice.query.ReportQuery;

@Component
public class ReportSummaryListDaoImpl implements ReportSummaryListDao{

	@Autowired
	JdbcTemplate trandb;
	
	@Autowired
	ReportQuery reportQuery;
	
	@Override
	public AllSummaryReport getAllSummaryReport(Date trandate) {
		AllSummaryReport summary = new AllSummaryReport();   
		
		summary.setLstAccSummary(getAccountSummaryModel(trandate));
		summary.setLstIncomeSummary(getIncomeSummaryModel(trandate));
		summary.setLstExpenseSummary(getExpenseSummaryModel(trandate));
		
		return summary;
	}

	@Override
	public List<AccountSummaryModel> getAccountSummaryModel(Date trandate) {
	    
		
		
		return trandb.query(reportQuery.getAccountSummary(trandate)
				, BeanPropertyRowMapper.newInstance(AccountSummaryModel.class));
	}

	@Override
	public List<IncomeSummaryModel> getIncomeSummaryModel(Date trandate) {

		return trandb.query(reportQuery.getIncomeSummary(trandate)
				, BeanPropertyRowMapper.newInstance(IncomeSummaryModel.class));
	}

	@Override
	public List<ExpenseSummaryModel> getExpenseSummaryModel(Date trandate) {

		return trandb.query(reportQuery.getExpenseSummary(trandate)
				, BeanPropertyRowMapper.newInstance(ExpenseSummaryModel.class));
	}

}
