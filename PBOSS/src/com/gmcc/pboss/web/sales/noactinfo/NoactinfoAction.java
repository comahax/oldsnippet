/**
 * auto-generated code
 * Fri Oct 23 15:23:36 CST 2009
 */
package com.gmcc.pboss.web.sales.noactinfo;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.sales.noactinfo.NoactinfoVO;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;
import com.gmcc.pboss.business.sales.noactinfo.NoactinfoDBParam;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.sales.noactinfo.Noactinfo;

/**
 * <p>
 * Title: NoactinfoAction
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
public class NoactinfoAction extends BaseAction {

	public NoactinfoAction() {
		super();

		// ���¼��������Ǳ����
		this.setForm(new NoactinfoForm());
		this.setParam(new NoactinfoWebParam());

		// ָ��VO��
		setClsVO(NoactinfoVO.class);
		// ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
		this.pkNameArray = new String[] { "recid" };
		this.setClsControl(Noactinfo.class);
		this.setClsQueryParam(NoactinfoDBParam.class);

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}

	public String doExcel() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("�׿��������ݲ�ѯ");
		export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
		export
				.appendHeadLine(new String[] { "����ʱ��",
						format.format(new Date()) });
		export.addOutputProperty("recid", "���");
		export.addOutputProperty("mobileno", "����");
		export.addOutputProperty("activedate", "��������", CommonExportBean.DATE,
				"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("creattime", "¼��ʱ��", CommonExportBean.DATE,
				"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("memo", "��ע");
		getParam().set_pagesize("0");
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
}