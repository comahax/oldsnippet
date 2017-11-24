/**
 * auto-generated code
 * Wed Jul 28 15:30:49 CST 2010
 */
package com.gmcc.pboss.web.sales.audit;

import java.util.ArrayList;
import java.util.List;

import com.gmcc.pboss.business.sales.audit.AuditVO;
import com.gmcc.pboss.business.sales.order.StockInfoVO;

/**
 * <p>Title: AuditForm </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class AuditForm extends AuditVO {
	List<StockInfoVO>  stockInfoList = new ArrayList<StockInfoVO>();
	private String opercode;
	private String buttonflag;

	public List<StockInfoVO> getStockInfoList() {
		return stockInfoList;
	}

	public void setStockInfoList(List<StockInfoVO> stockInfoList) {
		this.stockInfoList = stockInfoList;
	}

	public String getOpercode() {
		return opercode;
	}

	public void setOpercode(String opercode) {
		this.opercode = opercode;
	}

	public String getButtonflag() {
		return buttonflag;
	}

	public void setButtonflag(String buttonflag) {
		this.buttonflag = buttonflag;
	}
	
	

}
