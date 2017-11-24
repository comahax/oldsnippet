/**
 * auto-generated code
 * Wed Dec 15 18:40:46 CST 2010
 */
 package com.gmcc.pboss.web.sales.orderstatecom;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.sales.orderstatecom.OrderstatecomDBParam;
import com.gmcc.pboss.business.sales.orderstatecom.OrderstatecomVO;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.common.utils.tools.DateUtil;
import com.gmcc.pboss.control.sales.orderstatecom.Orderstatecom;
import com.gmcc.pboss.control.sales.orderstatecom.OrderstatecomBO;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * <p>Title: OrderstatecomAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author YangDaRen
 * @version 1.0
 */
public class OrderstatecomAction extends BaseAction{
	
	public OrderstatecomAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new OrderstatecomForm());
		OrderstatecomDBParam orderDBParam = new OrderstatecomDBParam();
		orderDBParam.set_dnl_createtime(PublicUtils.formatUtilDate(new Date(),"yyyy-MM-dd")+" 00:00:00");
		orderDBParam.set_dnm_createtime(PublicUtils.formatUtilDate(new Date(),"yyyy-MM-dd")+" 23:59:59");
		this.setParam(orderDBParam);

        //ָ��VO��
        setClsVO(OrderstatecomVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"cntid"};
        this.setClsControl(Orderstatecom.class);
		this.setClsQueryParam(OrderstatecomDBParam.class) ;

	}
	
	@Override
	public String doList() throws Exception{		
		OrderstatecomDBParam param = (OrderstatecomDBParam)getParam();
		String starttimeStr = param.get_dnl_createtime();
		String endtimeStr = param.get_dnm_createtime();
		
		//���߲�಻�ܳ���30��
		if(!StringUtils.isEmpty(starttimeStr)&&!StringUtils.isEmpty(endtimeStr))
		{
			Date startdate = DateUtil.parseDate(starttimeStr,DateUtil.DateFormatType.SIMPLE_DATE_FORMAT_STR);
			Date enddate = DateUtil.parseDate(endtimeStr,DateUtil.DateFormatType.SIMPLE_DATE_FORMAT_STR);
			int diff = DateUtil.operationDate(enddate, startdate, DateUtil.DateOperationType.DIFF);
			if(diff>30)
			{
				setActionMessage("ʱ�������ܳ���30�졣");
				return WEB_RESULT_LIST;
			}
		}
		
		DataPackage dp = null;
		try{
			
			Orderstatecom ordercomBO = (OrderstatecomBO) BOFactory.build(OrderstatecomBO.class,super.getDBAccessUser());
			dp = ordercomBO.doQueryStatecom(param);
			//Ĭ�ϰ��������ʼʱ���ѯ
			if(null == param.get_dnl_createtime() )
				param.set_dnl_createtime(PublicUtils.formatUtilDate(new Date(),"yyyy-MM-dd")+" 00:00:00");
			if(null == param.get_dnm_createtime() )
				param.set_dnm_createtime(PublicUtils.formatUtilDate(new Date(),"yyyy-MM-dd")+" 23:59:59");
		}catch (Exception e) {
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		super.setDp(dp);
		return WEB_RESULT_LIST;
	}
	
	public String doExcel() throws Exception{
		try{
			HttpServletRequest request = ServletActionContext.getRequest();
			User user = (User) getDBAccessUser();
			CommonExportBean export = new CommonExportBean(user);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			export.setFileName("����״̬ͳ��[��ֵ��]");
			export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
			export
					.appendHeadLine(new String[] { "����ʱ��:",
							format.format(new Date()) });
			export.addOutputProperty("countyid", "�ֹ�˾",export.CODE2NAME, "#CNTYCOMPANY");
			export.addOutputProperty("svccode", "������������",export.CODE2NAME, "#SERVCENT");
			export.addOutputProperty("mareacode", "΢����",export.CODE2NAME,"#MICROAREA");
			//�Ǽ�
			export.addOutputProperty("starlevel", "�Ǽ�",export.CODE2NAME,"$CH_STARLEVEL");
			export.addOutputProperty("orderave", "����;��", export.CODE2NAME, "$FX_ORDERAVE");
			export.addOutputProperty("orderstate", "����״̬", export.CODE2NAME, "$FX_ORDERFSTATE");
			export.addOutputProperty("ordercount", "������");
			export.addOutputProperty("comcategory", "��Ʒ����",export.CODE2NAME,"$IM_FXCOMCATEGORY");
			export.addOutputProperty("orderamt", "����[��]");
						
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
			// ����ȡ�����в�ѯ��������
			OrderstatecomDBParam orderDBParam = (OrderstatecomDBParam) getParam();
			orderDBParam.setQueryAll(true);
			
			return super.doExcel();
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return null;
	}
}