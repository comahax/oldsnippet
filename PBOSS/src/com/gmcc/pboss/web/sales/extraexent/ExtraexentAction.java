/**
 * auto-generated code
 * Thu Jun 16 17:11:00 CST 2011
 */
package com.gmcc.pboss.web.sales.extraexent;

import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.sales.extraexent.ExtraexentVO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.gmcc.pboss.business.sales.extraexent.ExtraexentDBParam;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.sales.extraexent.Extraexent;
import com.gmcc.pboss.control.sales.extraexent.ExtraexentBO;

/**
 * <p>
 * Title: ExtraexentAction
 * </p>;
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author limin
 * @version 1.0
 */
public class ExtraexentAction extends BaseAction {

	public ExtraexentAction() {
		super();

		// 以下几个方法是必须的
		this.setForm(new ExtraexentForm());
		this.setParam(new ExtraexentDBParam());

		// 指定VO类
		setClsVO(ExtraexentVO.class);
		// 指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
		this.pkNameArray = new String[] { "cityid", "countyid" };
		this.setClsControl(Extraexent.class);
		this.setClsQueryParam(ExtraexentDBParam.class);

	}

	public String doList() throws Exception {
		
		
		ExtraexentDBParam extraexentDBParam =(ExtraexentDBParam)this.getParam();
		extraexentDBParam.set_se_cityid(this.getDBAccessUser().getCityid());
		this.setParam(extraexentDBParam);
		
		return super.doList();
	}

	
	
	
	public String doNew() throws Exception {
		
		User dbaccessuser = (User)this.getDBAccessUser();
		
		ExtraexentVO extraexentvo = new ExtraexentVO();
		extraexentvo.setCityid(dbaccessuser.getCityid());
		Way way = (Way)BOFactory.build(WayBO.class, dbaccessuser);
		WayVO wayvo = (WayVO)way.doFindByPk(dbaccessuser.getWayid());
		//extraexentvo.setCountyid(wayvo.getCountyid());
        this.setForm(extraexentvo);

		return super.doNew();
	}

	@Override
	public String doEdit() throws Exception {
		// TODO Auto-generated method stub
		return super.doEdit();
	}

	@Override
	public String doDelete() throws Exception {
		// TODO Auto-generated method stub
		return super.doDelete();
	}
	
	
	
	
}