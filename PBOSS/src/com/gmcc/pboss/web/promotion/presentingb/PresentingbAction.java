/**
 * auto-generated code
 * Mon Sep 14 17:07:50 CST 2009
 */
 package com.gmcc.pboss.web.promotion.presentingb;


import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.promotion.presentingb.PresentingbDBParam;
import com.gmcc.pboss.business.promotion.presentingb.PresentingbVO;
import com.gmcc.pboss.control.promotion.presentingb.Presentingb;
import com.gmcc.pboss.control.promotion.presentingb.PresentingbBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * <p>Title: PresentingbAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public class PresentingbAction extends BaseAction{
	
	public PresentingbAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new PresentingbForm());
		this.setParam(new PresentingbWebParam());

        //指定VO类
        setClsVO(PresentingbVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"comcategory","ruleid"};
		this.setClsControl(Presentingb.class);
		this.setClsQueryParam(PresentingbDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	@Override
	public String doNew() throws Exception {
		PresentingbForm form = (PresentingbForm) getForm();
		form.setPid(new Long(ServletActionContext.getRequest()
				.getParameter("pk")));
		setCMD(WEB_CMD_NEW);
		return WEB_RESULT_CONTENT;
	}

	
	/**
	 * 查询对应方案标识下的规则标识与赠送(事前)的记录
	 */
	public String doList() throws Exception {
		try {
			PresentingbForm pform = (PresentingbForm) getForm();
			if (ServletActionContext.getRequest()
					.getParameter("pk") != null) {
				pform.setRuleid(new Long(ServletActionContext.getRequest()
						.getParameter("pk")));
				pform.setPid(new Long(ServletActionContext.getRequest()
						.getParameter("pk1")));
				pform.setIsEnabled(ServletActionContext.getRequest()
						.getParameter("isActive"));
			}
			PresentingbDBParam params = (PresentingbDBParam) this.getParam();
			PresentingbBO pbo = (PresentingbBO) BOFactory.build(PresentingbBO.class,
					getDBAccessUser());
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
		PresentingbForm pform = (PresentingbForm) getForm();
		super.doSave();
		pform.setPid(new Long(ServletActionContext.getRequest()
				.getParameter("pk1")));
		return "content";
	}
	
	@Override
	public String doEdit() throws Exception {
		PresentingbForm pform = (PresentingbForm) getForm();
		PresentingbDBParam param = (PresentingbDBParam) getParam();
		super.doEdit();
		pform.setPid(new Long(param.getPid()));
		return "content";
	}
}