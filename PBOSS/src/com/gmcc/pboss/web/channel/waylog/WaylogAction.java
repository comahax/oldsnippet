/**
 * auto-generated code
 * Sun Oct 18 20:23:20 CST 2009
 */
package com.gmcc.pboss.web.channel.waylog;

import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.gmcc.pboss.business.channel.waylog.WaylogVO;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.gmcc.pboss.business.channel.waylog.WaylogDBParam;
import com.gmcc.pboss.control.channel.waylog.Waylog;

/**
 * <p>
 * Title: WaylogAction
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
 * @author Jerimy
 * @version 1.0
 */
public class WaylogAction extends BaseAction {
	private String wayType;

	public WaylogAction() {
		super();

		// 以下几个方法是必须的
		this.setForm(new WaylogForm());
		this.setParam(new WaylogWebParam());

		// 指定VO类
		setClsVO(WaylogVO.class);
		// 指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
		this.pkNameArray = new String[] { "logid" };
		this.setClsControl(Waylog.class);
		this.setClsQueryParam(WaylogDBParam.class);

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}

	/**
	 * 合作商日志查询
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doListdis() throws Exception {
		DataPackage dp = null;
		try {
			WaylogDBParam param = (WaylogDBParam) getParam();
			setWayType("DIS");
			param.set_se_waytype("AG");
			param.set_se_waysubtype("DIS");
			dp = (DataPackage) executeDlgMethod(METHOD_TYPE_QUERY, param);
		} catch (Exception e) {
			addActionError(e.getMessage());
		}
		setDp(dp);
		return "listdis";
	}
	
	/**
	 * 配送商日志查询
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doListlogs() throws Exception {
		DataPackage dp = null;
		try {
			WaylogDBParam param = (WaylogDBParam) getParam();
			param.set_se_waytype("AG");
			param.set_se_waysubtype("LOGS");
			dp = (DataPackage) executeDlgMethod(METHOD_TYPE_QUERY, param);
		} catch (Exception e) {
			addActionError(e.getMessage());
		}
		setDp(dp);
		return "listlogs";
	}
	
	/**
	 * 社会网点日志查询
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doListag() throws Exception {
		DataPackage dp = null;
		try {
			WaylogDBParam param = (WaylogDBParam) getParam();
			setWayType("AG");
			param
					.set_sql_waysubtype(" waysubtype = 'PSAL' or waysubtype = 'STRB' or waysubtype = 'SAGT' or waysubtype = 'FD' or waysubtype = 'FDS' or waysubtype = 'VWAY' or waysubtype is null or waysubtype = ''");
			dp = (DataPackage) executeDlgMethod(METHOD_TYPE_QUERY, getParam());
		} catch (Exception e) {
			addActionError(e.getMessage());
		}
		setDp(dp);
		return "listag";
	}

	public String getWayType() {
		return wayType;
	}

	public void setWayType(String wayType) {
		this.wayType = wayType;
	}
}