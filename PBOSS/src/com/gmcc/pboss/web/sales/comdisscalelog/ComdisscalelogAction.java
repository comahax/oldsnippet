/**
 * auto-generated code
 * Thu Jul 01 16:27:16 CST 2010
 */
 package com.gmcc.pboss.web.sales.comdisscalelog;

import com.gmcc.pboss.business.sales.comdisscalelog.ComdisscalelogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.sales.comdisscalelog.ComdisscalelogDBParam;
import com.gmcc.pboss.control.sales.comdisscalelog.Comdisscalelog ;

/**
 * <p>Title: ComdisscalelogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ComdisscalelogAction extends BaseAction{
	
	public ComdisscalelogAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new ComdisscalelogForm());
		this.setParam(new ComdisscalelogDBParam());

        //指定VO类
        setClsVO(ComdisscalelogVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Comdisscalelog.class);
		this.setClsQueryParam(ComdisscalelogDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}