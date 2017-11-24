/**
 * auto-generated code
 * Mon Sep 14 16:46:42 CST 2009
 */
package com.gmcc.pboss.web.promotion.tieinsale;

import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.promotion.tieinsale.TieinsaleDBParam;
import com.gmcc.pboss.business.promotion.tieinsale.TieinsaleVO;
import com.gmcc.pboss.control.promotion.tieinsale.Tieinsale;
import com.gmcc.pboss.control.promotion.tieinsale.TieinsaleBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * <p>
 * Title: TieinsaleAction
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
 * @author 
 * @version 1.0
 */
public class TieinsaleAction extends BaseAction {

	public TieinsaleAction() {
		super();

		// 以下几个方法是必须的
		this.setForm(new TieinsaleForm());
		this.setParam(new TieinsaleWebParam());

		// 指定VO类
		setClsVO(TieinsaleVO.class);
		// 指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
		this.pkNameArray = new String[] { "comcategory", "ruleid" };
		this.setClsControl(Tieinsale.class);
		this.setClsQueryParam(TieinsaleDBParam.class);

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	public String doNew() throws Exception {
		TieinsaleForm form = (TieinsaleForm) getForm();
		form.setPid(new Long(ServletActionContext.getRequest()
				.getParameter("pk")));
		setCMD(WEB_CMD_NEW);
		return WEB_RESULT_CONTENT;
	}

	@Override
	public String doList() throws Exception {
		try {
			TieinsaleForm qform = (TieinsaleForm) getForm();
			if (ServletActionContext.getRequest()
					.getParameter("pk") != null) {
				qform.setRuleid(new Long(ServletActionContext.getRequest()
						.getParameter("pk")));
				qform.setPid(new Long(ServletActionContext.getRequest()
						.getParameter("pk1")));
				qform.setIsEnabled(ServletActionContext.getRequest()
						.getParameter("isActive"));
			}
			TieinsaleDBParam params = (TieinsaleDBParam) this.getParam();
			TieinsaleBO pbo = (TieinsaleBO) BOFactory.build(TieinsaleBO.class,
					getDBAccessUser());
			params.set_ne_ruleid(qform.getRuleid().toString());

			DataPackage pdp = pbo.doQuery(params);
			if (pdp != null && pdp.getDatas().size() > 0) {
				this.setDp(pdp);
				return "list";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			setActionMessage(ex.getMessage());
		}
		return "list";
	}
	
	public String doSave() throws Exception {
		TieinsaleForm tform = (TieinsaleForm) getForm();
		super.doSave();
		tform.setPid(new Long(ServletActionContext.getRequest()
				.getParameter("pk1")));
		return "content";
	}
	
	@Override
	public String doEdit() throws Exception {
		TieinsaleForm rform = (TieinsaleForm) getForm();
		TieinsaleDBParam param = (TieinsaleDBParam) getParam();
		super.doEdit();
		rform.setPid(new Long(param.getPid()));
		return "content";
	}
	
}