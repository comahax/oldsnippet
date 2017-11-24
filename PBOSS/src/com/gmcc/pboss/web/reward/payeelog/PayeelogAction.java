package com.gmcc.pboss.web.reward.payeelog;

import com.gmcc.pboss.business.reward.payeelog.PayeelogDBParam;
import com.gmcc.pboss.business.reward.payeelog.PayeelogVO;
import com.gmcc.pboss.control.reward.payeelog.Payeelog;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * <p>Title: PayeelogAction </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author a-biao
 * @version 1.0
 */
public class PayeelogAction extends BaseAction{
	
	public PayeelogAction() {
		super();

		this.setForm(new PayeelogForm());
		this.setParam(new PayeelogDBParam());

        setClsVO(PayeelogVO.class);
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Payeelog.class);
		this.setClsQueryParam(PayeelogDBParam.class) ;

	}
}