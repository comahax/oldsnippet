package com.gmcc.pboss.web.reward.ratelog;

import com.gmcc.pboss.business.reward.ratelog.RatelogDBParam;
import com.gmcc.pboss.business.reward.ratelog.RatelogVO;
import com.gmcc.pboss.control.reward.ratelog.Ratelog;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * <p>Title: RatelogAction </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author a-biao
 * @version 1.0
 */
public class RatelogAction extends BaseAction{
	
	public RatelogAction() {
		super();

		this.setForm(new RatelogForm());
		this.setParam(new RatelogDBParam());

        setClsVO(RatelogVO.class);
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Ratelog.class);
		this.setClsQueryParam(RatelogDBParam.class) ;

	}
}