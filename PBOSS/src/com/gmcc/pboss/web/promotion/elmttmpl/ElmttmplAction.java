/**
 * auto-generated code
 * Mon Sep 14 14:22:16 CST 2009
 */
package com.gmcc.pboss.web.promotion.elmttmpl;

import com.gmcc.pboss.business.promotion.elmttmpl.ElmttmplDBParam;
import com.gmcc.pboss.business.promotion.elmttmpl.ElmttmplVO;
import com.gmcc.pboss.control.promotion.elmttmpl.Elmttmpl;
import com.gmcc.pboss.control.promotion.elmttmpl.ElmttmplBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * <p>
 * Title: ElmttmplAction
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
 * @author linli
 * @version 1.0
 */
public class ElmttmplAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ElmttmplAction() {
		super();

		// ���¼��������Ǳ����
		this.setForm(new ElmttmplForm());
		this.setParam(new ElmttmplWebParam());

		// ָ��VO��
		setClsVO(ElmttmplVO.class);
		// ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
		this.pkNameArray = new String[] { "tmplid" };
		this.setClsControl(Elmttmpl.class);
		this.setClsQueryParam(ElmttmplDBParam.class);
	}

	/**
	 * ����Ԫ��ģ��״̬(ʧЧ/��Ч)
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doUpdate() throws Exception {
		try {
			ElmttmplForm form = (ElmttmplForm) this.getForm();
			Elmttmpl bo = (Elmttmpl) BOFactory.build(ElmttmplBO.class,
					getDBAccessUser());

			ElmttmplVO vo = bo.doFindByPk(form.getTmplid());
			if (vo != null) {
				// "1" ��Ч, "0" ʧЧ
				if (vo.getState().equals("1")) {
					vo.setState("0");
				} else {
					vo.setState("1");
				}
				bo.doUpdate(vo);
			}
			return super.doList();
		} catch (Exception ex) {
			String msg = ex.getMessage();
			addActionError(msg);
			return ERROR;
		}
	}

	/**
	 * ����
	 */
	public String doSave() throws Exception {
		ElmttmplForm form = (ElmttmplForm) this.getForm();

		String colinfo = form.getColumnsinfo();
		String regex = "^(((���б�ʶ\\|)?)((��������\\|)?)(��Ʒ����\\|)?(��Դ��ʶ\\|)?(ҵ����\\|)?)$";
		//��ȷ��ʽΪ���б�ʶ|��������|��Ʒ����|��Դ��ʶ|ҵ����|������һ���ҽ�����һ��
		if(!colinfo.matches(regex)){
			addActionError("�ֶ���Ϣ����Ҫ�� ���б�ʶ|��������|��Ʒ����|��Դ��ʶ|ҵ����|�е�һ�������ؼ���,����'�������[ | ]'����!");
			return "content";
		}
		return super.doSave();
	}
}