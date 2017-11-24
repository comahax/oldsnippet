package com.gmcc.pboss.web.reward.paymentlog;

import com.gmcc.pboss.business.reward.paymentlog.PaymentlogDBParam;
import com.gmcc.pboss.business.reward.paymentlog.PaymentlogVO;
import com.gmcc.pboss.control.reward.paymentlog.Paymentlog;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * <p>Title: PaymentlogAction </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author a-biao
 * @version 1.0
 */
public class PaymentlogAction extends BaseAction{
	
	public PaymentlogAction() {
		super();

		this.setForm(new PaymentlogForm());
		this.setParam(new PaymentlogDBParam());

        setClsVO(PaymentlogVO.class);
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Paymentlog.class);
		this.setClsQueryParam(PaymentlogDBParam.class) ;

	}
}