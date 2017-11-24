/**
 * auto-generated code
 * Thu Sep 17 15:16:11 CST 2009
 */
package com.gmcc.pboss.web.promotion.ppzlncom;

import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.promotion.ppzlncom.PpzlncomVO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.gmcc.pboss.business.promotion.ppzlncom.PpzlncomDBParam;
import com.gmcc.pboss.control.promotion.ppzlncom.Ppzlncom;
import com.gmcc.pboss.control.promotion.ppzlncom.PpzlncomBO;
import com.gmcc.pboss.web.promotion.ppzlncom.PpzlncomForm;

/**
 * <p>
 * Title: PpzlncomAction
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
public class PpzlncomAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PpzlncomAction() {
		super();

		// ���¼��������Ǳ����
		this.setForm(new PpzlncomForm());
		this.setParam(new PpzlncomWebParam());

		// ָ��VO��
		setClsVO(PpzlncomVO.class);
		// ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
		this.pkNameArray = new String[] { "comcategory", "pid" };
		this.setClsControl(Ppzlncom.class);
		this.setClsQueryParam(PpzlncomDBParam.class);

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}

	/**
	 * ��ѯ��Ӧ������ʶ�µķ�������Ʒ��ϵ����
	 */
	public String doList() throws Exception {
		try {

			PpzlncomForm form = (PpzlncomForm) super.getForm();
			PpzlncomDBParam comparam = (PpzlncomDBParam) getParam();
			PpzlncomBO combo = (PpzlncomBO) BOFactory.build(PpzlncomBO.class,
					getDBAccessUser());
			if (form.getPid() == null) {
				form.setPid(new Long(ServletActionContext.getRequest()
						.getParameter("param._pk")));
				form.setIsEnabled(ServletActionContext.getRequest()
						.getParameter("isActive"));
			}

			comparam.set_se_pid(form.getPid().toString());
			DataPackage comdp = combo.doQuery(comparam);
			if (comdp != null && comdp.getDatas().size() > 0) {
				this.setDp(comdp);
				return "list";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			super.addActionError(ex.getMessage());
		}
		return "list";
	}

	/**
	 * �����Ӧ������ʶ�µķ�������Ʒ��ϵ����
	 */
	public String doSave() throws Exception {
		try {
			PpzlncomForm form = (PpzlncomForm) super.getForm();
			PpzlncomVO comvo = new PpzlncomVO();
			comvo.setComcategory(form.getComcategory());
			comvo.setPid(form.getPid());
		} catch (Exception ex) {
			ex.printStackTrace();
			super.addActionError(ex.getMessage());
		}
		return super.doSave();
	}

	@Override
	public String doNew() throws Exception {
		setCMD(WEB_CMD_NEW);
		return WEB_RESULT_CONTENT;
	}

	/**
	 * ɾ����Ӧ������ʶ�µķ�������Ʒ��ϵ����
	 */
	public String doDelete() throws Exception {
		try {

			String[] selectArray = ((DBQueryParam) getParam()).get_selectitem();
			PpzlncomForm form = (PpzlncomForm) super.getForm();
			PpzlncomBO combo = (PpzlncomBO) BOFactory.build(PpzlncomBO.class,
					getDBAccessUser());
			PpzlncomDBParam comparam = new PpzlncomDBParam();
			PpzlncomVO comvo = new PpzlncomVO();
			// ���û�й�ѡ��¼, ��¼��ȫ��ɾ��, ��ҳ����javascript����
			if (selectArray == null) {
				comparam.set_pagesize("0");
				comparam.set_se_pid(form.getPid().toString());
				DataPackage comdp = combo.doQuery(comparam);
				if (comdp != null && comdp.getDatas().size() > 0) {
					int j = 0;
					for (j = 0; j < comdp.getDatas().size(); j++) {
						comvo = (PpzlncomVO) comdp.getDatas().get(j);
						combo.doRemoveByVO(comvo);
					}
					setActionMessage("��¼��ȫ��ɾ��!");
				}
				return doList();
			}
			// ��ɾ����ѡ�ļ�¼
			int i = 0;
			for (i = 0; i < selectArray.length; i++) {
				comvo.setPid(form.getPid());
				comvo.setComcategory(selectArray[i]);
				combo.doRemoveByVO(comvo);
			}
			setActionMessage("ɾ���ɹ�!");
			return doList();
		} catch (Exception ex) {
			ex.printStackTrace();
			super.addActionError(ex.getMessage());
		}
		return "list";
	}
}