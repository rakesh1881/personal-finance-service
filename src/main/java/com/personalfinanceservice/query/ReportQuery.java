package com.personalfinanceservice.query;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class ReportQuery {
	
	StringBuilder sb;
	
	
	public String getAccountSummary(Date trandate) {
		sb = new StringBuilder();
		sb.append("call sp_getsummaryofAccount('"+trandate+"');");
		
		return sb.toString();
	}
	public String getIncomeSummary(Date trandate) {
		
		sb = new StringBuilder();
		sb.append("select m.name as incomeName ,sum(ifnull(i.amount,0.00)) IncomeAmount from  demo.incomemaster as m \n");
		sb.append("left join  incometran as i  on i.keycode=m.keycode \n");
		sb.append("group by m.name;");
		
		return sb.toString();
	}

	
	public String getExpenseSummary(Date trandate) {
		
		sb = new StringBuilder();
		sb.append("select m.name as expenseName ,sum(ifnull(i.amount,0.00)) expenseAmount from  demo.expensemaster as m \n");
		sb.append("left join  incometran as i  on i.keycode=m.keycode \n");
		sb.append("group by m.name;");
		
		return sb.toString();
	}
	

}
