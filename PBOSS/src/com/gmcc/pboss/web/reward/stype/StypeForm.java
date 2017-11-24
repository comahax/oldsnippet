package com.gmcc.pboss.web.reward.stype;

import com.gmcc.pboss.business.reward.stype.StypeVO;

/**
 * <p>Title: StypeForm </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author a-biao
 * @version 1.0
 */
public class StypeForm extends StypeVO {
	 /** identifier field */
    private String optype;
    
    private Float rate;
    public String getOptype() {
		return optype;
	}

	public void setOptype(String optype) {
		this.optype = optype;
	}

	public Float getRate() {
		return rate;
	}

	public void setRate(Float rate) {
		this.rate = rate;
	}
}
