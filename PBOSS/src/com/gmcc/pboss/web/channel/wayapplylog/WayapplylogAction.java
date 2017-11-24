/**
 * auto-generated code
 * Mon Nov 23 16:35:24 CST 2009
 */
 package com.gmcc.pboss.web.channel.wayapplylog;

import com.gmcc.pboss.business.channel.wayapplylog.WayapplylogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.channel.wayapplylog.WayapplylogDBParam;
import com.gmcc.pboss.control.channel.wayapplylog.Wayapplylog ;

/**
 * <p>Title: WayapplylogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public class WayapplylogAction extends BaseAction{
	
	public WayapplylogAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new WayapplylogForm());
		this.setParam(new WayapplylogDBParam());

        //指定VO类
        setClsVO(WayapplylogVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Wayapplylog.class);
		this.setClsQueryParam(WayapplylogDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	@Override
	public String doList() throws Exception {
		// TODO Auto-generated method stub
		WayapplylogDBParam param = (WayapplylogDBParam) getParam();
		// 网点审批日志表是地市表，因此不必加地市ID的限制
//		param.set_se_cityid(getDBAccessUser().getCityid());
		return super.doList();
	}
}