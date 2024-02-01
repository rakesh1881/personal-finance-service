package com.personalfinanceservice.query;

import org.springframework.stereotype.Component;

import com.personalfinanceservice.model.IncomeMasterModel;
import com.personalfinanceservice.model.IncomeTranModel;

@Component
public class IncomeQuery {

	
	StringBuilder sb = new StringBuilder();
	
	public String getIncomeQuerykeycode(String keyCode) {
		sb= new StringBuilder();
		sb.append("Select name as incomename,keycode as incomeid ,active from IncomeMaster where keycode='"+keyCode+"';");
		return sb.toString();
	}
	
	public String getIncomeQuery() {
		sb= new StringBuilder();
		sb.append("Select name as incomename,keycode as incomeid ,active from IncomeMaster;");
		return sb.toString();
	}

	
	public String getIncomeCount() {
		sb= new StringBuilder();
		sb.append("select count(*) count from IncomeMaster");
		return sb.toString();
	}
	public String getupdateQuery(IncomeMasterModel incomemodel) {
		sb= new StringBuilder();
		sb.append("update IncomeMaster set name='"+incomemodel.getIncomeName()+"',active='"+incomemodel.getActive()+"' where keycode='"+incomemodel.getIncomeId()+"';");
		return sb.toString();
	}
	public String getIncomeCodebyIncomeName(String incomeName) {
		sb= new StringBuilder();
		sb.append("select keycode from IncomeMaster where incomeName='"+incomeName+"';");
		return sb.toString();
	}
	
	//Transaction
	public String getIncomeTran() {
		sb= new StringBuilder();
		sb.append("select description,trankey,incomeaccount as accountcode,keycode as incomecode,amount,trandate from Incometran;");
		return sb.toString();
	}
	public String getIncometranbyTrankey(String trankey) {
		sb= new StringBuilder();
		sb.append("select description,trankey,incomeaccount as accountcode,keycode as incomecode,amount,trandate from Incometran where trankey='"+trankey+"';");
		return sb.toString();
	}
	
	public String updateIncometranbyTrankey(IncomeTranModel incomeTranModel) {		
		sb= new StringBuilder();
		sb.append("update Incometran set amount="+incomeTranModel.getAmount()+",description='"+incomeTranModel.getDescription()+",incomeaccount="+incomeTranModel.getAccountCode()+",");
		sb.append("keycode='"+incomeTranModel.getIncomeCode()+"' where trankey='"+incomeTranModel.getTrankey()+"'");
		return sb.toString();
	}

}
