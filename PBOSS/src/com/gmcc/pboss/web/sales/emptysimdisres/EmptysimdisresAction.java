package com.gmcc.pboss.web.sales.emptysimdisres;

import com.gmcc.pboss.business.sales.orderresdet.VOrderresdetDBParam;
import com.gmcc.pboss.business.sales.orderresdet.VOrderresdetVO;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.sales.emptysimdisres.Emptysimdisres;
import com.gmcc.pboss.control.sales.emptysimdisres.EmptysimdisresBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

public class EmptysimdisresAction extends BaseAction {

	public EmptysimdisresAction() {
		super();

		// ���¼��������Ǳ����
		this.setForm(new EmptysimdisresForm());
		this.setParam(new VOrderresdetDBParam());

		// //ָ��VO��
		setClsVO(VOrderresdetVO.class);
		// //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
		// this.pkNameArray=new String[]{"emptyno"};
		this.setClsControl(Emptysimdisres.class);
		this.setClsQueryParam(VOrderresdetDBParam.class);

	}

	/** ��������ʱ�Ŀ�ѡ�����ֶ� */
	private String[][] optionFields = new String[][] { { "emptyno", "�հ׿����к�" },
			{ "countyid", "�ֹ�˾" }, { "svccode", "������������" },
			{ "mareacode", "΢����" }, { "orderid", "��������" }, { "wayid", "�������" },
			{ "wayname", "��������" }, { "starlevel", "�Ǽ�" },
			{ "orderstate", "״̬" }, { "comcategory", "�հ�SIM������" } };

	/**
	 * ����հ�SIM����������ѯ
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doList() throws Exception {
		VOrderresdetDBParam params = (VOrderresdetDBParam) getParam();
		Emptysimdisres emptysimdisres = (Emptysimdisres) BOFactory.build(
				EmptysimdisresBO.class, getDBAccessUser());
		DataPackage dp = emptysimdisres.doQueryEmptysimdisres(params);
		this.setDp(dp);
		return "list";
	}

	/**
	 * ����հ�SIM����������ѯ
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doFirstList() throws Exception {
		return "list";
	}


	// ����TXT
	public String doExportTxt() {
		try {
			User user = (User) getDBAccessUser();
			CommonExportBean export = new CommonExportBean(user);
			// super.getParam().setQueryAll(true);
			export.setFileName("�հ�SIM������������");
			String selectedFields = getRequest().getParameter("selectedFields");
			// sfArray���� ��ÿ����ѡ�ֶ���optionFields��һάԪ�ص��±�ֵ
			String[] sfArray = selectedFields.split(",");
			// titleArray ��ѡ�ֶ���������
			String[] titleArray = new String[sfArray.length];
			for (int i = 0; i < sfArray.length; i++) {
				int k = Integer.parseInt(sfArray[i]);
				if (k == (int) 6) {
					export.addOutputProperty(optionFields[k][0],
							optionFields[k][1], CommonExportBean.CODE2NAME,
							"#WAY");
					titleArray[i] = optionFields[k][1];
				}else if(k == (int) 1){
					export.addOutputProperty(optionFields[k][0],
							optionFields[k][1], CommonExportBean.CODE2NAME,
							"#CNTYCOMPANY");
					titleArray[i] = optionFields[k][1];				
				}else if(k == (int) 2){
					export.addOutputProperty(optionFields[k][0],
							optionFields[k][1], CommonExportBean.CODE2NAME,
							"#SERVCENT");
					titleArray[i] = optionFields[k][1];				
				}else if(k == (int) 3){
					export.addOutputProperty(optionFields[k][0],
							optionFields[k][1], CommonExportBean.CODE2NAME,
							"#MICROAREA");
					titleArray[i] = optionFields[k][1];				
				}else if(k == (int) 7){
					export.addOutputProperty(optionFields[k][0],
							optionFields[k][1], CommonExportBean.CODE2NAME,
							"$CH_STARLEVEL2");
					titleArray[i] = optionFields[k][1];				
				}else if(k == (int) 8){
					export.addOutputProperty(optionFields[k][0],
							optionFields[k][1], CommonExportBean.CODE2NAME,
							"$FX_ORDERFSTATE");
					titleArray[i] = optionFields[k][1];				
				}else if(k == (int) 9){
					export.addOutputProperty(optionFields[k][0],
							optionFields[k][1], CommonExportBean.CODE2NAME,
							"$IM_FXCOMCATEGORY");
					titleArray[i] = optionFields[k][1];				
				}else {
					export.addOutputProperty(optionFields[k][0],
							optionFields[k][1]);
					titleArray[i] = optionFields[k][1];
				}
			}
			export.voClassArray = new Class[] { VOrderresdetVO.class };
			prepareResponse(export.getFileName());
			export.queryMethodName = "doList";

			export.writeTxtTitle(getResponse().getOutputStream(), titleArray);
			super.ExportQuery(getForm(), getRequest(), getResponse(), user,
					export);
		} catch (Exception e) {
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return null;
	}

	// ����Excel
	public String doExportExcel() {
		try {
			User user = (User) getDBAccessUser();
			CommonExportBean export = new CommonExportBean(user);
			// super.getParam().setQueryAll(true);
			export.setFileName("�հ�SIM������������");
			String selectedFields = getRequest().getParameter("selectedFields");
			// sfArray���� ��ÿ����ѡ�ֶ���optionFields��һάԪ�ص��±�ֵ
			String[] sfArray = selectedFields.split(",");
			// titleArray ��ѡ�ֶ���������
			String[] titleArray = new String[sfArray.length];
			for (int i = 0; i < sfArray.length; i++) {
				int k = Integer.parseInt(sfArray[i]);
				if (k == (int) 6) {
					export.addOutputProperty(optionFields[k][0],
							optionFields[k][1], CommonExportBean.CODE2NAME,
							"#WAY");
					titleArray[i] = optionFields[k][1];
				}else if(k == (int) 1){
					export.addOutputProperty(optionFields[k][0],
							optionFields[k][1], CommonExportBean.CODE2NAME,
							"#CNTYCOMPANY");
					titleArray[i] = optionFields[k][1];				
				}else if(k == (int) 2){
					export.addOutputProperty(optionFields[k][0],
							optionFields[k][1], CommonExportBean.CODE2NAME,
							"#SERVCENT");
					titleArray[i] = optionFields[k][1];				
				}else if(k == (int) 3){
					export.addOutputProperty(optionFields[k][0],
							optionFields[k][1], CommonExportBean.CODE2NAME,
							"#MICROAREA");
					titleArray[i] = optionFields[k][1];				
				}else if(k == (int) 7){
					export.addOutputProperty(optionFields[k][0],
							optionFields[k][1], CommonExportBean.CODE2NAME,
							"$CH_STARLEVEL2");
					titleArray[i] = optionFields[k][1];				
				}else if(k == (int) 8){
					export.addOutputProperty(optionFields[k][0],
							optionFields[k][1], CommonExportBean.CODE2NAME,
							"$FX_ORDERFSTATE");
					titleArray[i] = optionFields[k][1];				
				}else if(k == (int) 9){
					export.addOutputProperty(optionFields[k][0],
							optionFields[k][1], CommonExportBean.CODE2NAME,
							"$IM_FXCOMCATEGORY");
					titleArray[i] = optionFields[k][1];				
				}else {
					export.addOutputProperty(optionFields[k][0],
							optionFields[k][1]);
					titleArray[i] = optionFields[k][1];
				}
			}
			export.voClassArray = new Class[] { VOrderresdetVO.class };
			export.queryMethodName = "doList";
			this.getRequest().setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT,
					export);
			super.doExcel();
		} catch (Exception e) {
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return null;
	}

}
