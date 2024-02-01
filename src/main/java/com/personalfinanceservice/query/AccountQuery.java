package com.personalfinanceservice.query;

import org.springframework.stereotype.Component;

import com.personalfinanceservice.model.AccountMasterModel;
import com.personalfinanceservice.model.AccountTranModel;

@Component
public class AccountQuery {

	
	StringBuilder sb = new StringBuilder();
	
	public String getAccountQuerykeycode(String keyCode) {
		sb= new StringBuilder();
		sb.append("Select name as accountname,keycode as accountid ,active from AccountMaster where keycode='"+keyCode+"';");
		return sb.toString();
	}
	
	public String getAccountQuery() {
		sb= new StringBuilder();
		sb.append("Select name as accountname,keycode as accountid ,active from AccountMaster;");
		return sb.toString();
	}
	
	public String getAccountCount() {
		sb= new StringBuilder();
		sb.append("select count(*) count from AccountMaster");
		return sb.toString();
	}
	public String getupdateQuery(AccountMasterModel accountmodel) {
		sb= new StringBuilder();
		sb.append("update AccountMaster set name='"+accountmodel.getAccountName()+"',active='"+accountmodel.getActive()+"' where keycode='"+accountmodel.getAccountId()+"';");
		return sb.toString();
	}

	public String getAccountCodeByAccountName(String accountName) {
		
		sb= new StringBuilder();
		sb.append("select keycode from AccountMaster where AccountName='"+accountName+"';");
		return sb.toString();
	}
	
	//Transaction
	
		public String getAccountTran() {
			sb= new StringBuilder();
			sb.append("select description,trankey,Accountaccount as accountcode,keycode as Accountcode,amount,trandate from Accounttran;");
			return sb.toString();
		}
		public String getAccounttranbyTrankey(String trankey) {
			sb= new StringBuilder();
			sb.append("select description,trankey,Accountaccount as accountcode,keycode as Accountcode,amount,trandate from Accounttran where trankey='"+trankey+"';");
			return sb.toString();
		}
		
		public String updateAccounttranbyTrankey(AccountTranModel incomeTranModel) {		
			sb= new StringBuilder();
			sb.append("update Accounttran set amount="+incomeTranModel.getAmount()+",description='"+incomeTranModel.getDescription()+",Accountaccount="+incomeTranModel.getAccountCode()+",");
			sb.append("keycode='"+incomeTranModel.getAccountCode()+"' where trankey='"+incomeTranModel.getTrankey()+"'");
			return sb.toString();
		}
	
}
