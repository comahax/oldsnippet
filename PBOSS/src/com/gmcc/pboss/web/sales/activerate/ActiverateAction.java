/**
 * auto-generated code
 * Mon Oct 19 19:01:28 CST 2009
 */
package com.gmcc.pboss.web.sales.activerate;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.sales.activerate.ActiverateVO;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;
import com.gmcc.pboss.business.sales.activerate.ActiverateDBParam;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.sales.activerate.Activerate;

/**
 * <p>
 * Title: ActiverateAction
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
public class ActiverateAction extends BaseAction {

	public ActiverateAction() {
		super();

		// ���¼��������Ǳ����
		this.setForm(new ActiverateForm());
		this.setParam(new ActiverateWebParam());

		// ָ��VO��
		setClsVO(ActiverateVO.class);
		// ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
		this.pkNameArray = new String[] { "brand", "wayid" };
		this.setClsControl(Activerate.class);
		this.setClsQueryParam(ActiverateDBParam.class);

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
		export.setFileName("�׿������ʲ�ѯ");
		export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
		export
				.appendHeadLine(new String[] { "����ʱ��",
						format.format(new Date()) });
		export.addOutputProperty("wayid", "�����̱���");
		export.addOutputProperty("wayid", "����������",CommonExportBean.CODE2NAME,"#WAY");
		export.addOutputProperty("brand", "�׿�Ʒ��",CommonExportBean.CODE2NAME,"$FX_SMPBRAND");
		export.addOutputProperty("rate", "������",export.RATE,"0.00");
		export.addOutputProperty("isachieve", "�Ƿ���", export.CODE2NAME, "$IM_YESNO10");
		export.addOutputProperty("difamt", "�����");
		export.addOutputProperty("chgtime", "����ʱ��", export.DATE, "yyyy-MM-dd HH:mm:ss");
		getParam().set_pagesize("0");
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
}