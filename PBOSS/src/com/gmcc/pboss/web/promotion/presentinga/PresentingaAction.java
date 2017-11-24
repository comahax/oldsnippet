/**
 * auto-generated code
 * Mon Sep 14 17:09:30 CST 2009
 */
package com.gmcc.pboss.web.promotion.presentinga;

import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.promotion.presentinga.PresentingaDBParam;
import com.gmcc.pboss.business.promotion.presentinga.PresentingaVO;
import com.gmcc.pboss.control.promotion.presentinga.Presentinga;
import com.gmcc.pboss.control.promotion.presentinga.PresentingaBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * <p>
 * Title: PresentingaAction
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
public class PresentingaAction extends BaseAction {

	public PresentingaAction() {
		super();

		// ���¼��������Ǳ����
		this.setForm(new PresentingaForm());
		this.setParam(new PresentingaWebParam());

		// ָ��VO��
		setClsVO(PresentingaVO.class);
		// ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
		this.pkNameArray = new String[] { "comcategory", "ruleid" };
		this.setClsControl(Presentinga.class);
		this.setClsQueryParam(PresentingaDBParam.class);

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}

	public String doNew() throws Exception {
		PresentingaForm form = (PresentingaForm) getForm();
		form.setPid(new Long(ServletActionContext.getRequest()
				.getParameter("pk")));
		setCMD(WEB_CMD_NEW);
		return WEB_RESULT_CONTENT;
	}

	/**
	 * ��ѯ��Ӧ������ʶ�µĹ����ʶ������(�º�)�ļ�¼
	 */
	public String doList() throws Exception {
		try {
			PresentingaForm pform = (PresentingaForm) getForm();
			if (ServletActionContext.getRequest()
					.getParameter("pk") != null) {
				pform.setRuleid(new Long(ServletActionContext.getRequest()
						.getParameter("pk")));
				pform.setPid(new Long(ServletActionContext.getRequest()
						.getParameter("pk1")));
				pform.setIsEnabled(ServletActionContext.getRequest()
						.getParameter("isActive"));
			}
			PresentingaDBParam params = (PresentingaDBParam) this.getParam();
			PresentingaBO pbo = (PresentingaBO) BOFactory.build(
					PresentingaBO.class, getDBAccessUser());
			params.set_ne_ruleid(pform.getRuleid().toString());

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
		PresentingaForm pform = (PresentingaForm) getForm();
		super.doSave();
		pform.setPid(new Long(ServletActionContext.getRequest()
				.getParameter("pk1")));
		return "content";
	}
	
	@Override
	public String doEdit() throws Exception {
		PresentingaForm pform = (PresentingaForm) getForm();
		PresentingaDBParam param = (PresentingaDBParam) getParam();
		super.doEdit();
		pform.setPid(new Long(param.getPid()));
		return "content";
	}
}