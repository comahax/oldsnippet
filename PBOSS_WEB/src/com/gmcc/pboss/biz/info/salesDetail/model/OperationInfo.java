package com.gmcc.pboss.biz.info.salesDetail.model;

import java.io.Serializable;

public class OperationInfo implements Serializable {
	
	private String opnid;
	private String opnname;
	
	public OperationInfo(){
		
	}
	public OperationInfo(ChPwOperationsms o){
		this.opnid = o.getId().getOpnid();
		this.opnname = o.getOpnname();
	}
	
	public String getOpnid() {
		return this.opnid;
	}
	public void setOpnid(String opnid) {
		this.opnid = opnid;
	}
	public String getOpnname() {
		return this.opnname;
	}

	public void setOpnname(String opnname) {
		this.opnname = opnname;
	}
}
