package com.gmcc.pboss.web.channel.waystoreinfolog;

import com.gmcc.pboss.business.channel.waystoreinfolog.WaystoreinfologVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.channel.waystoreinfolog.WaystoreinfologDBParam;
import com.gmcc.pboss.control.channel.waystoreinfolog.Waystoreinfolog ;

/**
 * <p>Title: WaystoreinfologAction </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author a-biao
 * @version 1.0
 */
public class WaystoreinfologAction extends BaseAction{
	
	public WaystoreinfologAction() {
		super();

		this.setForm(new WaystoreinfologForm());
		this.setParam(new WaystoreinfologDBParam());

        setClsVO(WaystoreinfologVO.class);
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Waystoreinfolog.class);
		this.setClsQueryParam(WaystoreinfologDBParam.class) ;

	}
}