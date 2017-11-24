package com.gmcc.pboss.web.reward.stypelog;

import com.gmcc.pboss.business.reward.stypelog.StypelogDBParam;
import com.gmcc.pboss.business.reward.stypelog.StypelogVO;
import com.gmcc.pboss.control.reward.stypelog.Stypelog;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * <p>Title: StypelogAction </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author a-biao
 * @version 1.0
 */
public class StypelogAction extends BaseAction{
	
	public StypelogAction() {
		super();

		this.setForm(new StypelogForm());
		this.setParam(new StypelogDBParam());

        setClsVO(StypelogVO.class);
        this.pkNameArray=new String[]{"stype"};
		this.setClsControl(Stypelog.class);
		this.setClsQueryParam(StypelogDBParam.class) ;

	}
}