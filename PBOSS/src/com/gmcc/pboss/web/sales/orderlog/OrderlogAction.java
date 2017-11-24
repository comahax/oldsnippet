/**
 * auto-generated code
 * Tue Apr 24 15:01:18 CST 2012
 */
 package com.gmcc.pboss.web.sales.orderlog;

import java.io.OutputStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.resource.emptysim.EmptysimDBParam;
import com.gmcc.pboss.business.resource.emptysim.EmptysimVO;
import com.gmcc.pboss.business.sales.order.OrderDBParam;
import com.gmcc.pboss.business.sales.orderlog.OrderlogVO ;
import com.sunrise.jop.common.utils.lang.InterfaceUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.filter.PermissionChecker;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.sunrise.jop.ui.struts2.WebConstant;
import com.gmcc.pboss.business.sales.orderlog.OrderlogDBParam; 
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.common.export.CommonExportBeanClass;
import com.gmcc.pboss.control.base.operright.Operright;
import com.gmcc.pboss.control.base.operright.OperrightBO;
import com.gmcc.pboss.control.sales.disformprint.DisformprintBO;
import com.gmcc.pboss.control.sales.orderlog.Orderlog ;
import com.gmcc.pboss.control.sales.orderlog.OrderlogBO;

/**
 * <p>Title: OrderlogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class OrderlogAction extends BaseAction{
	private boolean flag = false;
	public OrderlogAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new OrderlogForm());
		this.setParam(new OrderlogDBParam());

        //ָ��VO��
        setClsVO(OrderlogVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Orderlog.class);
		this.setClsQueryParam(OrderlogDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	public String doList() throws Exception {
		OrderlogDBParam orderlogDBParam = (OrderlogDBParam) getParam(); 
		if( null == orderlogDBParam.get_se_orderstate()){//Ĭ�ϰ�����ȡ
			orderlogDBParam.set_se_orderstate("EXTRAED");//
		}
		if (null == orderlogDBParam.get_se_oprcode()) {   //Ĭ�Ϲ���Ϊ��ǰ��������
			orderlogDBParam.set_se_oprcode(super.getDBAccessUser().getOprcode());
		} 
		if(null != orderlogDBParam.get_dnl_optime() && !("").equals(orderlogDBParam.get_dnl_optime())) {
			String date_nl = orderlogDBParam.get_dnl_optime()+" 00:00:00";
			orderlogDBParam.set_dnl_optime(date_nl);
		}
		if (null != orderlogDBParam.get_dnm_optime() && !("").equals(orderlogDBParam.get_dnm_optime())) {
			String date_nm = orderlogDBParam.get_dnm_optime()+" 23:59:59";
			orderlogDBParam.set_dnm_optime(date_nm);
		}
		return super.doList();
	}
	
	//����txt ����excel ��ѯ���� 
	public String doListForExport() throws Exception {
		OrderlogDBParam orderlogDBParam = (OrderlogDBParam) getParam();  
		Orderlog orderlog = (OrderlogBO)BOFactory.build(OrderlogBO.class, getDBAccessUser());
	    orderlogDBParam.set_pagesize("0");
	    if(null != orderlogDBParam.get_dnl_optime() && !("").equals(orderlogDBParam.get_dnl_optime())) {
			String date_nl = orderlogDBParam.get_dnl_optime()+" 00:00:00";
			orderlogDBParam.set_dnl_optime(date_nl);
		}
		if (null != orderlogDBParam.get_dnm_optime() && !("").equals(orderlogDBParam.get_dnm_optime())) {
			String date_nm = orderlogDBParam.get_dnm_optime()+" 23:59:59";
			orderlogDBParam.set_dnm_optime(date_nm);
		}
	    //�ж��Ƿ��в������ŵ�Ȩ��
	    Operright operright = (Operright) BOFactory.build(OperrightBO.class, getDBAccessUser().getInnerUser());
		boolean flag = true;
		flag=operright.doCheckPermission(getDBAccessUser().getOprcode(), "FX_ORDERMG_ORDERLOG");  
		if (false==flag){ 
			orderlogDBParam.set_se_oprcode(getDBAccessUser().getOprcode());
		} 
	    orderlogDBParam.set_sql_condition(" rownum <=10000");
		DataPackage dp = orderlog.doExportList(orderlogDBParam);  
		this.setDp(dp); 
		return "list";
	} 
	//����txt�ļ�
	public String doTxt() throws Exception { 
		User user = (User) getDBAccessUser();
		CommonExportBeanClass export = new CommonExportBeanClass(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("������־����");
		export.addOutputProperty("logid", "��־��ʶ");
		export.addOutputProperty("optime", "����ʱ��",export.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("oprcode", "��������",export.CODE2NAME, "#OPERATOR");
		export.addOutputProperty("oprtype", "��־��������",export.CODE2NAME, "$OPRTYPE");
		export.addOutputProperty("success", "����״̬",export.CODE2NAME, "SUCCESS");
		export.addOutputProperty("orderid", "��������");
		export.addOutputProperty("flowid", "�������̱���");
		export.addOutputProperty("wayid", "�����̱���"); 
		export.addOutputProperty("countyid", "�ֹ�˾",export.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("starlevel", "�Ǽ�",export.CODE2NAME, "$CH_STARLEVEL");
		export.addOutputProperty("orderave", "����;��",export.CODE2NAME, "$FX_ORDERAVE");
		export.addOutputProperty("storarea", "������Դ����",export.CODE2NAME,"$IM_FXSTORAREA");
		export.addOutputProperty("createtime", "����ʱ��",export.DATE,"yyyy-MM-dd HH:mm:ss");  
		export.addOutputProperty("orderstate", "����״̬",export.CODE2NAME, "$FX_ORDERFSTATE"); 
		export.addOutputProperty("statechgtime", "״̬���ʱ��",export.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("paytype", "�ɷѷ�ʽ",export.CODE2NAME, "$FX_PAYTYPE"); 
		export.addOutputProperty("delitype", "�ͻ���ʽ",export.CODE2NAME, "$FX_DELITYPE");  
		export.addOutputProperty("recamt", "Ӧ�ս��");
		export.addOutputProperty("actamt", "ʵ�ս��");
		export.addOutputProperty("posstream", "POS����ˮ��");
		export.addOutputProperty("bossworkfid", "BOSS�������");
		export.addOutputProperty("memo", "��ע");
		export.addOutputProperty("discomcode", "������",export.CODE2NAME, "#WAYIDINFO");
		export.addOutputProperty("paytime", "����ʱ��",export.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("deductstate", "����״̬",export.CODE2NAME,"$FX_DEDUCTSTATE");
		export.addOutputProperty("signstate", "ǩ��״̬",export.CODE2NAME,"$FX_SIGNSTATE");
		export.addOutputProperty("alarmlevel", "Ԥ������",export.CODE2NAME,"$FX_STOCKALARMLEVEL");
		export.addOutputProperty("confirmflag", "�Ƿ�ȷ��",export.CODE2NAME,"$IM_YESNO10");
		export.addOutputProperty("mareacode", "΢����",export.CODE2NAME, "#MICROAREA");
		export.addOutputProperty("signtime", "ǩ��ʱ��",export.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("recordtime", "����ʱ��",export.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("disovertime", "�������ʱ��",export.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("signtype", "ǩ�շ�ʽ",export.CODE2NAME, "$FX_SIGNTYPE");
		export.addOutputProperty("smssignno", "����ǩ�պ���");
		export.addOutputProperty("reviewstate", "����״̬",export.CODE2NAME, "$FX_REVIEWSTATE");  
		export.queryMethodName = "doListForExport";
		export.voClassArray = new Class[] { OrderlogVO.class }; 
		prepareResponse(export.getFileName());
		OrderlogDBParam params = (OrderlogDBParam)super.getParam();
		params.set_pageno("0");
		super.setParam(params);
		export.writeTxtTitle(getResponse().getOutputStream(), new String[] {
				"��־��ʶ","����ʱ��","��������", "��־��������", "����״̬", "��������" ,"�������̱���","�����̱���","�ֹ�˾","�Ǽ�","����;��","������Դ����",
				"����ʱ��","����״̬","״̬���ʱ��","�ɷѷ�ʽ","�ͻ���ʽ","Ӧ�ս��","ʵ�ս��","POS����ˮ��","BOSS�������","��ע","������","����ʱ��","����״̬",
				"ǩ��״̬","Ԥ������","�Ƿ�ȷ��","΢����","ǩ��ʱ��","����ʱ��","�������ʱ��","ǩ�շ�ʽ","����ǩ�պ���","����״̬"});
		this.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
		return null;
	} 
	//����excel�ļ�
	public String doExcel() throws Exception { 
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBeanClass export = new CommonExportBeanClass(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("������־����");
		export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
		export.appendHeadLine(new String[] { "����ʱ��",format.format(new Date()) });
		export.addOutputProperty("logid", "��־��ʶ");
		export.addOutputProperty("optime", "����ʱ��",export.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("oprcode", "��������",export.CODE2NAME, "#OPERATOR");
		export.addOutputProperty("oprtype", "��־��������",export.CODE2NAME, "$OPRTYPE");
		export.addOutputProperty("success", "����״̬",export.CODE2NAME, "SUCCESS");
		export.addOutputProperty("orderid", "��������");
		export.addOutputProperty("flowid", "�������̱���");
		export.addOutputProperty("wayid", "�����̱���"); 
		export.addOutputProperty("countyid", "�ֹ�˾",export.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("starlevel", "�Ǽ�",export.CODE2NAME, "$CH_STARLEVEL");
		export.addOutputProperty("orderave", "����;��",export.CODE2NAME, "$FX_ORDERAVE");
		export.addOutputProperty("storarea", "������Դ����",export.CODE2NAME,"$IM_FXSTORAREA");
		export.addOutputProperty("createtime", "����ʱ��",export.DATE,"yyyy-MM-dd HH:mm:ss");  
		export.addOutputProperty("orderstate", "����״̬",export.CODE2NAME, "$FX_ORDERFSTATE"); 
		export.addOutputProperty("statechgtime", "״̬���ʱ��",export.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("paytype", "�ɷѷ�ʽ",export.CODE2NAME, "$FX_PAYTYPE"); 
		export.addOutputProperty("delitype", "�ͻ���ʽ",export.CODE2NAME, "$FX_DELITYPE");  
		export.addOutputProperty("recamt", "Ӧ�ս��");
		export.addOutputProperty("actamt", "ʵ�ս��");
		export.addOutputProperty("posstream", "POS����ˮ��");
		export.addOutputProperty("bossworkfid", "BOSS�������");
		export.addOutputProperty("memo", "��ע");
		export.addOutputProperty("discomcode", "������",export.CODE2NAME, "#WAYIDINFO");
		export.addOutputProperty("paytime", "����ʱ��",export.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("deductstate", "����״̬",export.CODE2NAME,"$FX_DEDUCTSTATE");
		export.addOutputProperty("signstate", "ǩ��״̬",export.CODE2NAME,"$FX_SIGNSTATE");
		export.addOutputProperty("alarmlevel", "Ԥ������",export.CODE2NAME,"$FX_STOCKALARMLEVEL");
		export.addOutputProperty("confirmflag", "�Ƿ�ȷ��",export.CODE2NAME,"$IM_YESNO10");
		export.addOutputProperty("mareacode", "΢����",export.CODE2NAME, "#MICROAREA");
		export.addOutputProperty("signtime", "ǩ��ʱ��",export.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("recordtime", "����ʱ��",export.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("disovertime", "�������ʱ��",export.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("signtype", "ǩ�շ�ʽ",export.CODE2NAME, "$FX_SIGNTYPE");
		export.addOutputProperty("smssignno", "����ǩ�պ���");
		export.addOutputProperty("reviewstate", "����״̬",export.CODE2NAME, "$FX_REVIEWSTATE");  
		export.queryMethodName = "doListForExport";
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		OrderlogDBParam params = (OrderlogDBParam)super.getParam();
		params.set_pagesize("0");
		super.setParam(params); 
		return doExcels(); 
	}
	public void ExportQuery(BaseVO actionForm, HttpServletRequest request,
			HttpServletResponse response, User user,
			CommonExportBeanClass commonExportBean) throws Exception {
		// ��ѯ�������,��ҳ��ѯ
		BaseVO baseActionForm = (BaseVO) actionForm;
		// baseActionForm.set_pagesize(String.valueOf(CommonExportBean.EXCELOUT_PAGE_SIZE));
		ArrayList list;
		OutputStream os = response.getOutputStream();
		if("0".equals(this.param.get_pagesize())){//��Ϊ�����������еĵ�������ΪЧ�ʣ����÷�ҳ�ķ�ʽ��������
			this.param.set_pagesize(""+CommonExportBeanClass.EXCELOUT_PAGE_SIZE);//����ÿ�����ļ�¼��
			this.param.setQueryAll(false);
		}
		for (int startindex = 1;; startindex++) {
			// baseActionForm.set_pageno(String.valueOf(startindex));
			this.param.set_pageno(""+startindex);//���õ�����ҳ��
			if ("doList".equals(commonExportBean.queryMethodName)) {
				doList();
				
			} else {
				Method method = this.getClass().getMethod(
						commonExportBean.queryMethodName, null);
				method.invoke(this, null);
			}
			list = (ArrayList) (getDp().getDatas());	
			if (list != null && !list.isEmpty()) {
				//��ʱ��������һ�У�Ϊ����
				//System.out.println("���ԣ����ڵ���������excel����ǰʱ�䣺"+new Date().toLocaleString());
				commonExportBean.write(os, list.iterator(),
						commonExportBean.voClassArray);
				if (list.size() < CommonExportBeanClass.EXCELOUT_PAGE_SIZE 
						|| ((this.getDp().getRowCount()+CommonExportBeanClass.EXCELOUT_PAGE_SIZE-1)/CommonExportBeanClass.EXCELOUT_PAGE_SIZE)<=startindex) {// �������һҳ
					break;
				}
			} else {// ��ҳû������
				break;
			}
			list.clear();
		}
	}	
	
	public String doExcels() throws Exception{
		CommonExportBeanClass commonExportBean = (CommonExportBeanClass)getRequest()
				.getAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT);
		if(commonExportBean.voClassArray==null)
			commonExportBean.voClassArray = new Class[] { OrderlogVO.class };
		// commonExportBean.queryMethodName = "doList";
		if (commonExportBean.headtitle == null) {
			commonExportBean.headtitle = commonExportBean.getFileName();
		}
		commonExportBean.buildExcelPage(getForm(), getRequest(), getResponse(),
				(User) getDBAccessUser(), this);
		return null;
	}
}