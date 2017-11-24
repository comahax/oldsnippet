/**
 * auto-generated code
 * Tue Oct 13 14:18:20 CST 2009
 */
package com.gmcc.pboss.web.sales.wayassistant;

import java.io.OutputStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.sales.wayassistant.WayassistantVO;
import com.sunrise.jop.common.utils.i18n.I18nMessage;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.gmcc.pboss.business.sales.wayassistant.WayassistantDBParam;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.sales.wayassistant.Wayassistant;
import com.gmcc.pboss.control.sales.wayassistant.WayassistantBO;

/**
 * <p>
 * Title: WayassistantAction
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
public class WayassistantAction extends BaseAction {

	public WayassistantAction() {
		super();

		// ���¼��������Ǳ����
		this.setForm(new WayassistantForm());
		this.setParam(new WayassistantWebParam());

		// ָ��VO��
		setClsVO(WayassistantVO.class);
		// ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
		this.pkNameArray = new String[] { "wayid" };
		this.setClsControl(Wayassistant.class);
		this.setClsQueryParam(WayassistantDBParam.class);

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}

	protected void onDuplicatePk() {
		setActionMessage("�˺������Ѿ����ڶ���������Ϣ!");
	}

	@Override
	public String doList() throws Exception {

		WayassistantDBParam wayassistantdbparam = (WayassistantDBParam) this
				.getParam();
		// WayVO wayvo=new WayVO();
		
		List wayassistantlist = new ArrayList();

		WayDBParam waydbparam = new WayDBParam();
		boolean fg = false;
		if (wayassistantdbparam.get_ne_waystate() != null
				&& !wayassistantdbparam.get_ne_waystate().toString().equals("")) {
			waydbparam.set_ne_waystate(wayassistantdbparam.get_ne_waystate());
			fg = true;
		}
		if (wayassistantdbparam.get_se_svccode() != null
				&& !wayassistantdbparam.get_se_svccode().toString().equals("")) {
			waydbparam.set_se_svccode(wayassistantdbparam.get_se_svccode());
			fg = true;
		}
		if (wayassistantdbparam.get_se_mareacode() != null
				&& !wayassistantdbparam.get_se_mareacode().toString()
						.equals("")) {
			waydbparam.set_se_mareacode(wayassistantdbparam.get_se_mareacode());
			fg = true;
		}
		if (wayassistantdbparam.get_se_countyid() != null
				&& !wayassistantdbparam.get_se_countyid().toString().equals("")) {
			waydbparam.set_se_countyid(wayassistantdbparam.get_se_countyid());
			fg = true;
		}

		// �����Щ������ֵ�ȸ�����Щ�������ҵ������������������¼Ȼ���ڸ���wayid�����ǵ��������ҵ���¼
		//WayassistantDBParam wayassistantdb=new  WayassistantDBParam();
		if (fg == true) {
			DBAccessUser user = this.getDBAccessUser();
			WayBO waybo = (WayBO) BOFactory.build(WayBO.class, user);
			WayassistantBO wayassistantbo = (WayassistantBO) BOFactory.build(WayassistantBO.class, user);
			waydbparam.set_pageno("");
			waydbparam.set_pagesize("");
			DataPackage dp = waybo.doQuery(waydbparam);
//			if(wayassistantdbparam!=null){
//				 wayassistantdbparam.get_pageno();
//			}
			if (dp != null) {
				List list = dp.getDatas();
				if (list != null) {
					for (int i = 0; i < list.size(); i++) {
						WayVO wayvo = (WayVO) list.get(i);
						wayassistantdbparam.set_se_wayid(wayvo.getWayid());
						wayassistantdbparam.set_ne_waystate("");
						wayassistantdbparam.set_se_countyid("");
						wayassistantdbparam.set_se_svccode("");
						wayassistantdbparam.set_se_mareacode("");
						DataPackage	dpp=wayassistantbo.doQuery(wayassistantdbparam);
						List wayassislist=dpp.getDatas();
						if(wayassislist!=null){
							for(int j=0;j<wayassislist.size();j++){
								wayassistantlist.add(wayassislist.get(j));
							}
						}
					}
				}
			}
			
			dp.setDatas(wayassistantlist);
			//dp.setPageSize();
			dp.setRowCount(dp.getDatas().size());
			this.setDp(dp);
			return WEB_RESULT_LIST;
		}else{
			return super.doList();
		}
		
	}

	public String doWayassistantExportTxt() {
		try {
			// super.getParam().setQueryAll(true);
			// super.getParam().setSelectFieldsUseVOType(true);
			// super.getParam().set_selectitem(_selectitem)
			User user = (User) getDBAccessUser();
			CommonExportBean export = new CommonExportBean(user);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			export.setFileName("��Ʒ����������Ϣ����");


			export.addOutputProperty("wayid", "�����̱���");
			export
					.addOutputProperty("wayid", "����������", export.CODE2NAME,
							"#WAY");
			export.addOutputProperty("countyid", "�ֹ�˾", export.CODE2NAME,
					"#CNTYCOMPANY");
			export.addOutputProperty("svccode", "����Ӫ������", export.CODE2NAME,
					"#SERVCENT");
			export.addOutputProperty("mareacode", "΢����", export.CODE2NAME,
					"#MICROAREA");
			export.addOutputProperty("waystate", "����״̬", export.CODE2NAME,
					"$CH_VALIDFLAG");
			export.addOutputProperty("canorder", "�Ƿ��𶩹�", export.CODE2NAME,
					"$IM_YESNO10");
			export.addOutputProperty("printinvoice", "�Ƿ��ӡ��Ʊ",
					export.CODE2NAME, "$IM_YESNO10");
			export.addOutputProperty("paytype", "�ɷѷ�ʽ", export.CODE2NAME,
					"$FX_PAYTYPE");
			export.addOutputProperty("delitype", "�ͻ���ʽ", export.CODE2NAME,
					"$FX_DELITYPE");
			export.addOutputProperty("orderbetterno", "�Ƿ�ɶ�������",
					export.CODE2NAME, "$IM_YESNO10");

			export.voClassArray = new Class[] { WayassistantVO.class };
			prepareResponse(export.getFileName());

			export.writeTxtTitle(getResponse().getOutputStream(), new String[] {
					"�����̱���", "����������", "�ֹ�˾", "����Ӫ������", "΢����", "����״̬", "�Ƿ��𶩹�",
					"�Ƿ��ӡ��Ʊ", "�ɷѷ�ʽ", "�ͻ���ʽ", "�Ƿ�ɶ�������" });

			this.setParam(new WayassistantDBParam());
			this.getParam().set_pagesize("0");
			super.doList();
			export.queryMethodName = "doList";
			this.ExportQuery(getForm(), getRequest(), getResponse(), user,
					export);
		} catch (Exception e) {
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return null;
	}

	@Override
	public void ExportQuery(BaseVO actionForm, HttpServletRequest request,
			HttpServletResponse response, User user,
			CommonExportBean commonExportBean) throws Exception {
		// ��ѯ�������,��ҳ��ѯ
		BaseVO baseActionForm = (BaseVO) actionForm;
		// baseActionForm.set_pagesize(String.valueOf(CommonExportBean.EXCELOUT_PAGE_SIZE));
		ArrayList list = null;
		OutputStream os = response.getOutputStream();
		if ("0".equals(this.param.get_pagesize())) {// ��Ϊ�����������еĵ�������ΪЧ�ʣ����÷�ҳ�ķ�ʽ��������
			this.param.set_pagesize("" + CommonExportBean.EXCELOUT_PAGE_SIZE);// ����ÿ�����ļ�¼��
			this.param.setQueryAll(false);
		}
		for (int startindex = 1;; startindex++) {
			// baseActionForm.set_pageno(String.valueOf(startindex));
			this.param.set_pageno("" + startindex);// ���õ�����ҳ��
			WayassistantBO wayassistantbo = (WayassistantBO) BOFactory.build(
					WayassistantBO.class, user);

			list = (ArrayList) (getDp().getDatas());
			wayassistantbo.fill(list);
			if (list != null && !list.isEmpty()) {
				// ��ʱ��������һ�У�Ϊ����
				// System.out.println("���ԣ����ڵ���������excel����ǰʱ�䣺"+new
				// Date().toLocaleString());
				commonExportBean.write(os, list.iterator(),
						commonExportBean.voClassArray);
				if (list.size() < CommonExportBean.EXCELOUT_PAGE_SIZE
						|| ((this.getDp().getRowCount()
								+ CommonExportBean.EXCELOUT_PAGE_SIZE - 1) / CommonExportBean.EXCELOUT_PAGE_SIZE) <= startindex) {// �������һҳ
					break;
				}
			} else {// ��ҳû������
				break;
			}
			list.clear();
		}
	}

}