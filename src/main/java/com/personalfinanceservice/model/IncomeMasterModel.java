package com.personalfinanceservice.model;

public class IncomeMasterModel {
	
	private String incomeName;
	private String active;
	private String incomeId;
	
	
	public IncomeMasterModel() {
		super();
	}

	
	public String getIncomeId() {
		return incomeId;
	}
	public void setIncomeId(String incomeId) {
		this.incomeId = incomeId;
	}
	public String getIncomeName() {
		return incomeName;
	}
	public void setIncomeName(String incomeName) {
		this.incomeName = incomeName;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	
	@Override
	public String toString() {
		return "IncomeMaster [incomeName=" + incomeName + ", active=" + active + ", incomeId=" + incomeId + "]";
	}

	
	

}
