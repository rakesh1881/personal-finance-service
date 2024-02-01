package com.personalfinanceservice.model;

public class AccountMasterModel {
	
	private String accountName;
	private String active;
	private String accountId;
	
	
	public AccountMasterModel() {
		super();
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	
	@Override
	public String toString() {
		return "AccountMaster [accountName=" + accountName + ", active=" + active + ", accountId=" + accountId + "]";
	}

	
	

}
