/**
 * auto-generated code
 * Tue Nov 15 11:32:53 CST 2011
 */
 package com.gmcc.pboss.web.sales.disoverdetail;

import com.gmcc.pboss.business.sales.disoverdetail.DisoverdetailVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.sales.disoverdetail.DisoverdetailDBParam;
import com.gmcc.pboss.control.sales.disoverdetail.Disoverdetail ;

/**
 * <p>Title: DisoverdetailAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class DisoverdetailAction extends BaseAction{
	
	public DisoverdetailAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new DisoverdetailForm());
		this.setParam(new DisoverdetailDBParam());

        //指定VO类
        setClsVO(DisoverdetailVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"seqid"};
		this.setClsControl(Disoverdetail.class);
		this.setClsQueryParam(DisoverdetailDBParam.class) ;

	}
}