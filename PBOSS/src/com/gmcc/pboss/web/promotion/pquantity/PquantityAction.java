/**
 * auto-generated code
 * Mon Sep 14 16:43:37 CST 2009
 */
package com.gmcc.pboss.web.promotion.pquantity;

import org.apache.struts2.ServletActionContext;
import com.gmcc.pboss.business.promotion.pquantity.PquantityDBParam;
import com.gmcc.pboss.business.promotion.pquantity.PquantityVO;
import com.gmcc.pboss.control.promotion.pquantity.Pquantity;
import com.gmcc.pboss.control.promotion.pquantity.PquantityBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * <p>
 * Title: PquantityAction
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
public class PquantityAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PquantityAction() {
		super();

		// 以下几个方法是必须的
		this.setForm(new PquantityForm());
		this.setParam(new PquantityWebParam());

		// 指定VO类
		setClsVO(PquantityVO.class);
		// 指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
		this.pkNameArray = new String[] { "prodid", "ruleid" };
		this.setClsControl(Pquantity.class);
		this.setClsQueryParam(PquantityDBParam.class);

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}

	public String doNew() throws Exception {
		PquantityForm form = (PquantityForm) getForm();
		form.setPid(new Long(ServletActionContext.getRequest()
				.getParameter("pk")));
		setCMD(WEB_CMD_NEW);
		return WEB_RESULT_CONTENT;
	}

	/**
	 * 查询对应方案标识下的规则标识与搭售的记录
	 */
	public String doList() throws Exception {
		try {
			PquantityForm qform = (PquantityForm) getForm();
			if (ServletActionContext.getRequest()
					.getParameter("pk") != null) {
				qform.setRuleid(new Long(ServletActionContext.getRequest()
						.getParameter("pk")));
				qform.setPid(new Long(ServletActionContext.getRequest()
						.getParameter("pk1")));
				qform.setIsEnabled(ServletActionContext.getRequest()
						.getParameter("isActive"));
			}
			PquantityDBParam params = (PquantityDBParam) this.getParam();
			PquantityBO pbo = (PquantityBO) BOFactory.build(PquantityBO.class,
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

	@Override
	public String doSave() throws Exception {
		PquantityForm rform = (PquantityForm) getForm();
		super.doSave();
		rform.setPid(new Long(ServletActionContext.getRequest()
				.getParameter("pk1")));
		return "content";
	}
	
	@Override
	public String doEdit() throws Exception {
		PquantityForm rform = (PquantityForm) getForm();
		rform.setIncat("0");
		PquantityDBParam param = (PquantityDBParam) getParam();
		super.doEdit();
		rform.setPid(new Long(param.getPid()));
		return "content";
	}

}