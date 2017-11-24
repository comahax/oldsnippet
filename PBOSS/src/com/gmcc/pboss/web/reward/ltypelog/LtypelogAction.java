package com.gmcc.pboss.web.reward.ltypelog;

import com.gmcc.pboss.business.reward.ltypelog.LtypelogDBParam;
import com.gmcc.pboss.business.reward.ltypelog.LtypelogVO;
import com.gmcc.pboss.control.reward.ltypelog.Ltypelog;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * <p>Title: LtypelogAction </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author a-biao
 * @version 1.0
 */
public class LtypelogAction extends BaseAction{
	
	public LtypelogAction() {
		super();

		this.setForm(new LtypelogForm());
		this.setParam(new LtypelogDBParam());

        setClsVO(LtypelogVO.class);
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Ltypelog.class);
		this.setClsQueryParam(LtypelogDBParam.class) ;

	}
}