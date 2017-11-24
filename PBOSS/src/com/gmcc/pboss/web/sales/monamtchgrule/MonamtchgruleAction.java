/**
 * auto-generated code
 * Tue Oct 13 14:27:11 CST 2009
 */
package com.gmcc.pboss.web.sales.monamtchgrule;

import com.gmcc.pboss.business.sales.monamtchgrule.MonamtchgruleDBParam;
import com.gmcc.pboss.business.sales.monamtchgrule.MonamtchgruleVO;
import com.gmcc.pboss.control.sales.monamtchgrule.Monamtchgrule;
import com.gmcc.pboss.control.sales.monamtchgrule.MonamtchgruleBO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.exception.BusinessException;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * <p>
 * Title: MonamtchgruleAction
 * </p>
 * ;
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
public class MonamtchgruleAction extends BaseAction {

	public MonamtchgruleAction() {
		super();

		// ���¼��������Ǳ����
		this.setForm(new MonamtchgruleForm());
		this.setParam(new MonamtchgruleWebParam());

		// ָ��VO��
		setClsVO(MonamtchgruleVO.class);
		// ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
		this.pkNameArray = new String[] { "ruleid" };
		this.setClsControl(Monamtchgrule.class);
		this.setClsQueryParam(MonamtchgruleDBParam.class);

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}

	public String doList() throws Exception {
		String cityid = getDBAccessUser().getCityid();
		//getRequest().setAttribute("cityid", cityid);
		MonamtchgruleDBParam param = (MonamtchgruleDBParam)getParam();
		param.set_se_cityid(cityid);
		super.doList();
		return WEB_RESULT_LIST;
	}

	public String doNew() throws Exception {
		super.doNew();
		String cityid = getDBAccessUser().getCityid();
		//getRequest().setAttribute("cityid", cityid);
		return WEB_RESULT_CONTENT;
	}

	public String doEdit() throws Exception {
		super.doEdit();
		String cityid = getDBAccessUser().getCityid();
		//getRequest().setAttribute("cityid", cityid);
		return WEB_RESULT_CONTENT;
	}

	public String doSave() throws Exception {
		String cityid = getDBAccessUser().getCityid();
		getRequest().setAttribute("cityid", cityid);
		try {
			MonamtchgruleForm form = (MonamtchgruleForm) getForm();
			MonamtchgruleVO vo = new MonamtchgruleVO();
			BeanUtils.copyProperties(vo, form);
			MonamtchgruleDBParam param = new MonamtchgruleDBParam();
			param.set_se_cityid(form.getCityid());
			param.set_ne_starlevel(form.getStarlevel().toString());
			param.set_se_brand(form.getBrand());
			param.set_ne_effective(form.getEffective().toString());
			Monamtchgrule control = (Monamtchgrule) BOFactory.build(
					MonamtchgruleBO.class, getDBAccessUser());
			if (WEB_CMD_NEW.equals(CMD)) {
				DataPackage dp = control.doQuery(param);
				if (dp.getRowCount() > 0 && !control.doCheckActrate(vo, dp)) {
					throw new BusinessException("��ͬ��¼�Ѿ����ڣ����顣");
				}
				super.doSave();
			} else {
				param.set_nne_ruleid(form.getRuleid().toString());
				DataPackage dp = control.doQuery(param);
				if (dp.getRowCount() > 0 && !control.doCheckActrate(vo, dp)) {
					throw new BusinessException("��ͬ��¼�Ѿ����ڣ����顣");
				}
				super.doSave();
			}
		} catch (Exception e) {
			addActionError(e.getMessage());
		}
		return WEB_RESULT_CONTENT;
	}
}