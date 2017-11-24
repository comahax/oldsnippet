/**
 * auto-generated code
 * Mon Sep 14 14:47:12 CST 2009
 */
package com.gmcc.pboss.web.promotion.elmtinst;

import com.gmcc.pboss.business.promotion.elmtinst.ElmtinstDBParam;
import com.gmcc.pboss.business.promotion.elmtinst.ElmtinstVO;
import com.gmcc.pboss.control.promotion.elmtinst.Elmtinst;
import com.gmcc.pboss.control.promotion.elmtinst.ElmtinstBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.struts2.AAUtilsForStruts2;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * <p>
 * Title: ElmtinstAction
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
public class ElmtinstAction extends BaseAction {
	private static String WEB_RESULT_ELMTINSTSELECT = "elmtinstSelect";
	public ElmtinstAction() {
		super();

		// ���¼��������Ǳ����
		this.setForm(new ElmtinstForm());
		
		ElmtinstDBParam param = new ElmtinstDBParam();
		param.set_orderby("instid");
		param.set_desc("1");
		this.setParam(param);

		// ָ��VO��
		setClsVO(ElmtinstVO.class);
		// ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
		this.pkNameArray = new String[] { "instid" };
		this.setClsControl(Elmtinst.class);
		this.setClsQueryParam(ElmtinstDBParam.class);

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}

	public String doEdit() throws Exception {
		super.doEdit();
		
		//��ȡģ��˵��
		ElmtinstForm form = (ElmtinstForm) this.getForm();
		Object[] paramInfo = getParamInfo(String.valueOf(form.getTmplid()));
		String elmttmplMemo = (String)paramInfo[1];
		form.setElmttmplMemo(elmttmplMemo);
		
		return WEB_RESULT_CONTENT;
	}
	
	public String doNew() throws Exception {
		super.doNew();
		//ѡ������ʱ����ѡ��������ҳ��
		ElmtinstForm form = (ElmtinstForm) this.getForm();
		if("SELECT".equals(form.getType()))
		{
			return WEB_RESULT_ELMTINSTSELECT;
		}
		return WEB_RESULT_CONTENT;
	}

	public String doSave() throws Exception {
		super.doSave();
		
		//��ȡģ��˵��
		ElmtinstForm form = (ElmtinstForm) this.getForm();
		Object[] paramInfo = getParamInfo(String.valueOf(form.getTmplid()));
		String elmttmplMemo = (String)paramInfo[1];
		form.setElmttmplMemo(elmttmplMemo);
		
		//ѡ������ʱ����ѡ��������ҳ��
		if("SELECT".equals(form.getType()))
		{
			return WEB_RESULT_ELMTINSTSELECT;
		}
		return WEB_RESULT_CONTENT;
	}
	
	//��̬��ȡ������Ϣ
	public String doGetParamInfo() throws Exception {
		if (AAUtilsForStruts2.isAjaxRequest()) {
			ElmtinstForm form = (ElmtinstForm) this.getForm();
			Object[] paramInfo = getParamInfo(String.valueOf(form.getTmplid()));
			
			String paramNameStr = (String)paramInfo[0];
			String elmttmplMemo = (String)paramInfo[1];
			getRequest().setAttribute("paramNameStr", paramNameStr);
			form.setElmttmplMemo(elmttmplMemo);
			
			AAUtilsForStruts2.addZonesToRefresh("refreshTable");
		}
		return WEB_RESULT_CONTENT;
	}

	//��ȡ������Ϣ
	private Object[] getParamInfo(String tmplid) throws Exception {
		
		Elmtinst elmtinst = (Elmtinst)BOFactory.build(ElmtinstBO.class,getDBAccessUser());
		Object[] paramInfo = elmtinst.doGetParamInfo(tmplid);
		return paramInfo;
	}
}