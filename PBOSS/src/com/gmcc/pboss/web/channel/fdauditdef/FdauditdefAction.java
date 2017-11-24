/**
 * auto-generated code
 * Wed Oct 07 20:21:59 CST 2009
 */
package com.gmcc.pboss.web.channel.fdauditdef;

import com.gmcc.pboss.business.channel.fdauditdef.FdauditdefDBParam;
import com.gmcc.pboss.business.channel.fdauditdef.FdauditdefVO;
import com.gmcc.pboss.control.channel.fdauditdef.Fdauditdef;
import com.gmcc.pboss.control.channel.fdauditdef.FdauditdefBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * <p>
 * Title: FdauditdefAction
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
 * @author Yedaoe
 * @version 1.0
 */
public class FdauditdefAction extends BaseAction {
	private String enable;

	public FdauditdefAction() {
		super();

		// 以下几个方法是必须的
		this.setForm(new FdauditdefForm());
		this.setParam(new FdauditdefWebParam());

		// 指定VO类
		setClsVO(FdauditdefVO.class);
		// 指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
		this.pkNameArray = new String[] { "field", "tablename", "typename" };
		this.setClsControl(Fdauditdef.class);
		this.setClsQueryParam(FdauditdefDBParam.class);

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}

	protected void onDuplicatePk() {
		setActionMessage("已经存在相同的记录!");
	}

	public String doEnable() throws Exception {
		String[] selectArray = ((DBQueryParam) getParam()).get_selectitem();

		if (selectArray == null) {
			addActionError("无法获取选中项目！");
			return "list";
		}
		try {
			for (int i = 0; i < selectArray.length; i++) {
				FdauditdefVO vo = (FdauditdefVO) getSelectedPkVO(selectArray[i]);
				Fdauditdef fdauditdef = (Fdauditdef) BOFactory.build(
						FdauditdefBO.class, getDBAccessUser());
				vo = fdauditdef.doFindByPk(vo);
				if ("true".equals(this.enable)) {
					vo.setState(new Short("1"));
				} else {
					vo.setState(new Short("0"));
				}
				vo = fdauditdef.doUpdate(vo);
			}
		} catch (Exception e) {
			addActionError(e.getMessage());
		}
		return doList();
	}

	public String doList() throws Exception {
		DataPackage dp = null;
		try {
			FdauditdefWebParam param = (FdauditdefWebParam) getParam();
//			if (param.get_ne_state() == null) {
//				param.set_ne_state(new Short("0"));
//			}
			dp = (DataPackage) executeDlgMethod(METHOD_TYPE_QUERY, getParam());
		} catch (Exception e) {
			addActionError(e.getMessage());
		}
		setDp(dp);
		return WEB_RESULT_LIST;
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}
}