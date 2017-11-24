/**
 * auto-generated code
 * Thu Sep 17 15:17:36 CST 2009
 */
package com.gmcc.pboss.web.promotion.ppzlnres;

import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.promotion.ppzlnres.PpzlnresDBParam;
import com.gmcc.pboss.business.promotion.ppzlnres.PpzlnresVO;
import com.gmcc.pboss.business.resource.comressmp.ComressmpDBParam;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.gmcc.pboss.control.promotion.ppzlnres.PpzlnresBO;
import com.gmcc.pboss.control.promotion.ppzlnres.Ppzlnres;
import com.gmcc.pboss.control.resource.comressmp.ComressmpBO;
import com.gmcc.pboss.web.promotion.ppzlnres.PpzlnresForm;

/**
 * <p>
 * Title: PpzlnresAction
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
public class PpzlnresAction extends BaseAction {

	public PpzlnresAction() {
		super();

		// ���¼��������Ǳ����
		this.setForm(new PpzlnresForm());
		this.setParam(new PpzlnresWebParam());

		// ָ��VO��
		setClsVO(PpzlnresVO.class);
		// ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
		this.pkNameArray = new String[] { "pid", "resid" };
		this.setClsControl(Ppzlnres.class);
		this.setClsQueryParam(PpzlnresDBParam.class);

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}

	public String doNew() throws Exception {
		setCMD(WEB_CMD_NEW);
		return WEB_RESULT_CONTENT;
	}

	/**
	 * ��ѯ��Ӧ������ʶ�µķ�������Դ����
	 */
	public String doList() throws Exception {
		try {

			PpzlnresForm form = (PpzlnresForm) getForm();
			PpzlnresDBParam resparam = (PpzlnresDBParam) getParam();
			PpzlnresBO resbo = (PpzlnresBO) BOFactory.build(PpzlnresBO.class,
					getDBAccessUser());
			String pid = ServletActionContext.getRequest().getParameter(
					"param._pk");
			String isenable = ServletActionContext.getRequest().getParameter(
			"isActive");
			if (form.getPid() == null) {
				form.setPid(new Long(pid));
				form.setIsEnabled(isenable);
			}

			resparam.set_ne_pid(form.getPid().toString());

			DataPackage resdp = resbo.doQueryComcategory(resparam);
			if (resdp != null && resdp.getDatas().size() > 0) {
				this.setDp(resdp);
				return "list";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			super.addActionError(ex.getMessage());
		}
		return "list";
	}

	/**
	 * ɾ����Ӧ������ʶ�µķ�������Դ����
	 */
	public String doDelete() throws Exception {
		PpzlnresForm form = (PpzlnresForm) getForm();
		String[] selectArray = ((DBQueryParam) getParam()).get_selectitem();
		PpzlnresVO resvo = new PpzlnresVO();
		PpzlnresBO resbo = (PpzlnresBO) BOFactory.build(PpzlnresBO.class,
				getDBAccessUser());
		PpzlnresDBParam resparam = (PpzlnresDBParam) getParam();
		try {
			//���û�й�ѡ��¼, ��¼��ȫ��ɾ��, ��ҳ����javascript����
			if (selectArray == null) {
				resparam.setQueryAll(true);
				resparam.set_ne_pid(form.getPid().toString());
				DataPackage resdp = resbo.doQuery(resparam);
				if (resdp != null && resdp.getDatas().size() > 0) {
					for (int j = 0; j < resdp.getDatas().size(); j++) {
						resvo = (PpzlnresVO) resdp.getDatas().get(j);
						resbo.doRemoveByVO(resvo);
					}
					setActionMessage("��¼��ȫ��ɾ��!");
				}
				return doList();
			}
			//��ɾ���ѹ�ѡ�ļ�¼
			int i = 0;
			for (i = 0; i < selectArray.length; i++) {
				resvo.setPid(form.getPid());
				resvo.setResid(selectArray[i]);
				resbo.doRemoveByVO(resvo);
			}
			setActionMessage("ɾ���ɹ�!");
			return doList();
		} catch (Exception ex) {
			ex.printStackTrace();
			super.addActionError(ex.getMessage());
		}
		return "list";
	}
	
	@Override
	/**
	 * ����-�ж���Դ��ʶ�Ƿ����
	 */
	public String doSave() throws Exception {
		PpzlnresForm form = (PpzlnresForm) getForm();
		ComressmpBO bo = (ComressmpBO) BOFactory.build(ComressmpBO.class, getDBAccessUser());
		ComressmpDBParam param = new ComressmpDBParam();
		param.set_se_comresid(form.getResid());
		DataPackage dp = bo.doQuery(param);
		if(dp==null||dp.getDatas().size()==0){
			setActionMessage("¼�����Դ��ʶ������!");
			this.setCMD(WEB_CMD_NEW);
			return "content";
		}
		return super.doSave();
	}
}