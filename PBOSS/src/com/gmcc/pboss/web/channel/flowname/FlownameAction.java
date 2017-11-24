/**
 * auto-generated code
 * Sun Nov 01 15:18:07 CST 2009
 */
 package com.gmcc.pboss.web.channel.flowname;

import javax.servlet.http.HttpServletRequest;

import com.gmcc.pboss.business.channel.flowname.FlownameVO ;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.channel.flowname.FlownameDBParam;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.flowname.Flowname ;

/**
 * <p>Title: FlownameAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public class FlownameAction extends BaseAction{
	public String flag;
	public FlownameAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new FlownameForm());
		this.setParam(new FlownameWebParam());

        //指定VO类
        setClsVO(FlownameVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"stepid"};
		this.setClsControl(Flowname.class);
		this.setClsQueryParam(FlownameDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	public String doNew() throws Exception {
		try {
			HttpServletRequest request = getRequest();
//			String wayid = request.getParameter("param._pk");
			
			// 检查权限令牌
			DBAccessUser user = getDBAccessUser();
			Sysparam sysparam = (Sysparam)BOFactory.build(SysparamBO.class, user);
			String paramvalue = sysparam.doFindByID(new Long("77"), "channel");
			// 如果paramvalue查到记录并且值为1，则需要用新的固定参数显示步骤ID下拉框
			if ("1".equals(paramvalue)) {
				this.setFlag("yes");
			}
			
		} catch (Exception e) {
			setActionMessage(e.getMessage());
		}
		this.CMD = WEB_CMD_NEW;
		return "content";
	}
	
	public String doEdit() throws Exception {
		try {
			super.doEdit();
			
			// 检查权限令牌
			DBAccessUser user = getDBAccessUser();
			Sysparam sysparam = (Sysparam)BOFactory.build(SysparamBO.class, user);
			String paramvalue = sysparam.doFindByID(new Long("77"), "channel");
			// 如果paramvalue查到记录并且值为1，则需要用新的固定参数显示步骤ID下拉框
			if ("1".equals(paramvalue)) {
				this.setFlag("yes");
			}
			
		} catch (Exception e) {
			setActionMessage(e.getMessage());
		}
		this.CMD = WEB_CMD_EDIT;
		return "content";
	}

	public String doList() throws Exception {
		try {
			
			// 检查权限令牌
			DBAccessUser user = getDBAccessUser();
			Sysparam sysparam = (Sysparam)BOFactory.build(SysparamBO.class, user);
			String paramvalue = sysparam.doFindByID(new Long("77"), "channel");
			// 如果paramvalue查到记录并且值为1，则需要用新的固定参数显示步骤ID下拉框
			if ("1".equals(paramvalue)) {
				this.setFlag("yes");
			}
			
		} catch (Exception e) {
			setActionMessage(e.getMessage());
		}
		
		return super.doList();
	}
	
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
}