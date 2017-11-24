package com.gmcc.pboss.web.base.parameter;


import org.apache.commons.lang.ClassUtils;

import com.gmcc.pboss.business.base.parameter.ParameterDBParam;
import com.gmcc.pboss.business.base.parameter.ParameterVO;
import com.sunrise.jop.exception.system.ActionException;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.gmcc.pboss.control.base.parameter.Parameter;
/**
 * <p>Title: ParameterAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */

public class ParameterAction extends BaseAction{

	public ParameterAction(){
		super();
		
		this.setForm(new ParameterForm());
		this.setParam(new ParameterDBParam());
		
		setClsVO(ParameterVO.class);
		
		this.pkNameArray = new String[1];
		pkNameArray[0]="paramid";
		
		this.setClsControl(Parameter.class);
		this.setClsQueryParam(ParameterDBParam.class);
	}
	
}

