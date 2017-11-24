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

		// ���¼��������Ǳ����
		this.setForm(new TieinsaleForm());
		this.setParam(new TieinsaleWebParam());

		// ָ��VO��
		setClsVO(TieinsaleVO.class);
		// ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
		this.pkNameArray = new String[] { "comcategory", "ruleid" };
		this.setClsControl(Tieinsale.class);
		this.setClsQueryParam(TieinsaleDBParam.class);

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
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