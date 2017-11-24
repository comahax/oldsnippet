/**
 * auto-generated code
 * Wed Oct 07 20:21:59 CST 2009
 */
package com.gmcc.pboss.web.channel.fdauditdef;

import com.gmcc.pboss.business.channel.fdauditdef.FdauditdefDBParam;
import com.gmcc.pboss.business.channel.fdauditdef.FdauditdefVO;
import com.gmcc.pboss.control.channel.fdauditdef.Fdauditdef;
import com.gmcc.pboss.control.channel.fdauditdef.FdauditdefBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * <p>
 * Title: FdauditdefAction
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
 * @author Yedaoe
 * @version 1.0
 */
public class FdauditdefAction extends BaseAction {
	private String enable;

	public FdauditdefAction() {
		super();

		// ���¼��������Ǳ����
		this.setForm(new FdauditdefForm());
		this.setParam(new FdauditdefWebParam());

		// ָ��VO��
		setClsVO(FdauditdefVO.class);
		// ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
		this.pkNameArray = new String[] { "field", "tablename", "typename" };
		this.setClsControl(Fdauditdef.class);
		this.setClsQueryParam(FdauditdefDBParam.class);

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}

	protected void onDuplicatePk() {
		setActionMessage("�Ѿ�������ͬ�ļ�¼!");
	}

	public String doEnable() throws Exception {
		String[] selectArray = ((DBQueryParam) getParam()).get_selectitem();

		if (selectArray == null) {
			addActionError("�޷���ȡѡ����Ŀ��");
			return "list";
		}
		try {
			for (int i = 0; i < selectArray.length; i++) {
				FdauditdefVO vo = (FdauditdefVO) getSelectedPkVO(selectArray[i]);
				Fdauditdef fdauditdef = (Fdauditdef) BOFactory.build(
						FdauditdefBO.class, getDBAccessUser());
				vo = fdauditdef.doFindByPk(vo);
				if ("true".equals(this.enable)) {
					vo.setState(new Short("1"));
				} else {
					vo.setState(new Short("0"));
				}
				vo = fdauditdef.doUpdate(vo);
			}
		} catch (Exception e) {
			addActionError(e.getMessage());
		}
		return doList();
	}

	public String doList() throws Exception {
		DataPackage dp = null;
		try {
			FdauditdefWebParam param = (FdauditdefWebParam) getParam();
//			if (param.get_ne_state() == null) {
//				param.set_ne_state(new Short("0"));
//			}
			dp = (DataPackage) executeDlgMethod(METHOD_TYPE_QUERY, getParam());
		} catch (Exception e) {
			addActionError(e.getMessage());
		}
		setDp(dp);
		return WEB_RESULT_LIST;
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}
}