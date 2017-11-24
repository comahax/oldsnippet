/**
 * auto-generated code
 * Tue Aug 10 16:43:27 CST 2010
 */
package com.gmcc.pboss.web.resource.stkalarmct;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.base.sysparam.SysparamVO;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.resource.stkalarmct.StkalarmctDBParam;
import com.gmcc.pboss.business.resource.stkalarmct.StkalarmctVO;
import com.gmcc.pboss.business.resource.wayrcstat.WayrcstatDBParam;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.resource.stkalarmct.Stkalarmct;
import com.gmcc.pboss.control.resource.wayrcstat.Wayrcstat;
import com.gmcc.pboss.control.resource.wayrcstat.WayrcstatBO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * <p>
 * Title: StkalarmctAction
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
 * @author zhangsiwei
 * @version 1.0
 */
public class StkalarmctAction extends BaseAction {

	public StkalarmctAction() {
		super();

		// ���¼��������Ǳ����
		this.setForm(new StkalarmctForm());
		this.setParam(new StkalarmctDBParam());

		// ָ��VO��
		setClsVO(StkalarmctVO.class);
		// ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
		this.pkNameArray = new String[] { "seqid" };
		this.setClsControl(Stkalarmct.class);
		this.setClsQueryParam(StkalarmctDBParam.class);

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}

	@Override
	/**
	 * ����Excel - By LiZhaoLiang
	 */
	public String doExcel() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("�ֹ�˾���Ԥ��");
		export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
		export
				.appendHeadLine(new String[] { "����ʱ��",
						format.format(new Date()) });
		export.addOutputProperty("seqid", "���");
		export.addOutputProperty("statdate", "ͳ������", export.DATE,
				"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("countyid", "�ֹ�˾", export.CODE2NAME,
				"#CNTYCOMPANY");
		export.addOutputProperty("brand", "Ʒ��", export.CODE2NAME,
				"$FX_SMPBRAND");
		export.addOutputProperty("kcamount", "�����");
		export.addOutputProperty("realstock", "����ʵ�ʿ��");
		export.addOutputProperty("greenstock", "������ɫ���");
		export.addOutputProperty("yellowstock", "�����ɫ���");
		export.addOutputProperty("redstock", "�����ɫ���");
		export.addOutputProperty("greengap", "��ɫȱ��");
		export.addOutputProperty("yellowgap", "��ɫȱ��");
		export.addOutputProperty("redgap", "��ɫȱ��");
		export.addOutputProperty("saleamt", "ǰ"+this.getDay()+"�����");
		export.addOutputProperty("supportday", "֧������");
		export.addOutputProperty("greenstock", "������ɫ���");
		export.addOutputProperty("isalarm", "�Ƿ�Ԥ��", export.CODE2NAME,
				"$IM_YESNO10");

		export.voClassArray = new Class[] { StkalarmctVO.class };
		StkalarmctDBParam params = (StkalarmctDBParam) super.getParam();
		params.set_pagesize("0");
		super.setParam(params);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
	
	/**
	 * ����TXT - By LiZhaoLiang
	 */
	public String doTxt() throws Exception {
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		export.setFileName("�ֹ�˾���Ԥ��");
		export.addOutputProperty("seqid", "���");
		export.addOutputProperty("statdate", "ͳ������", export.DATE,
				"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("countyid", "�ֹ�˾", export.CODE2NAME,
				"#CNTYCOMPANY");
		export.addOutputProperty("brand", "Ʒ��", export.CODE2NAME,
				"$FX_SMPBRAND");
		export.addOutputProperty("kcamount", "�����");
		export.addOutputProperty("realstock", "����ʵ�ʿ��");
		export.addOutputProperty("greenstock", "������ɫ���");
		export.addOutputProperty("yellowstock", "�����ɫ���");
		export.addOutputProperty("redstock", "�����ɫ���");
		export.addOutputProperty("greengap", "��ɫȱ��");
		export.addOutputProperty("yellowgap", "��ɫȱ��");
		export.addOutputProperty("redgap", "��ɫȱ��");
		export.addOutputProperty("saleamt", "ǰ"+this.getDay()+"�����");
		export.addOutputProperty("supportday", "֧������");
		export.addOutputProperty("greenstock", "������ɫ���");
		export.addOutputProperty("isalarm", "�Ƿ�Ԥ��", export.CODE2NAME,
				"$IM_YESNO10");
		export.voClassArray = new Class[] { StkalarmctVO.class };
		prepareResponse(export.getFileName());
		StkalarmctDBParam params = (StkalarmctDBParam) super.getParam();
		params.set_pagesize("0");
		super.setParam(params);
		export.writeTxtTitle(getResponse().getOutputStream(),
				new String[] { "���", "ͳ������", "�ֹ�˾", "Ʒ��", "�����", "����ʵ�ʿ��","������ɫ���","�����ɫ���","�����ɫ���","��ɫȱ��","��ɫȱ��","��ɫȱ��","ǰ"+this.getDay()+"�����","֧������","������ɫ���", "�Ƿ�Ԥ��" });
		super.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
		return null;
	}
	
	
	//תlistҳ�浫����ѯ����
	public String toList() throws Exception{
	
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			Sysparam sysparam = (Sysparam) BOFactory.build(SysparamBO.class,
					getDBAccessUser());
			Serializable pkVO = new SysparamVO();
			BeanUtils.setProperty(pkVO, "systemid", "65");// ϵͳ��ʶ=63
			BeanUtils.setProperty(pkVO, "paramtype", "pboss_fx");// ��������==pboss_fx
			SysparamVO vo = sysparam.doFindByPk(pkVO);
			
			User user = (User) getDBAccessUser();
			String wayid = user.getWayid();
			Way way = (Way) BOFactory.build(WayBO.class, user);
			WayVO wayvo = way.doFindByPk(wayid);	
			request.setAttribute("countyidd",  wayvo.getCountyid());
			
			if(vo == null){
				vo = new SysparamVO();
			}
			if (vo != null && !StringUtils.isEmpty(vo.getParamvalue())) {
				String paramvalue = vo.getParamvalue();
				
			}else{
				vo.setParamvalue("7");
			}
			request.setAttribute("paramvalue", vo.getParamvalue());
		} catch (Exception ex) {
			setActionMessage(ex.getMessage());
		}
		
		StkalarmctDBParam params =	(StkalarmctDBParam)this.getParam();
	
		
		if(StringUtils.isEmpty(params.get_dnl_statdate())&&StringUtils.isEmpty(params.get_dnm_statdate())){
			String stockdate = PublicUtils.formatUtilDate(queryStockTime(),"yyyy-MM-dd")+" 00:00:00";
			String currdate = PublicUtils.formatUtilDate(queryStockTimeCurrent(),"yyyy-MM-dd")+" 23:59:59";
			params.set_dnl_statdate(stockdate);
			params.set_dnm_statdate(currdate);
		}
		
		
		return WEB_RESULT_LIST;
	}

	@Override
	public String doList() throws Exception {
		// TODO Auto-generated method stub		
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			Sysparam sysparam = (Sysparam) BOFactory.build(SysparamBO.class,
					getDBAccessUser());
			Serializable pkVO = new SysparamVO();
			BeanUtils.setProperty(pkVO, "systemid", "65");// ϵͳ��ʶ=63
			BeanUtils.setProperty(pkVO, "paramtype", "pboss_fx");// ��������==pboss_fx
			SysparamVO vo = sysparam.doFindByPk(pkVO);
			if(vo == null){
				vo = new SysparamVO();
			}
			if (vo != null && !StringUtils.isEmpty(vo.getParamvalue())) {
				String paramvalue = vo.getParamvalue();
			}else{
				vo.setParamvalue("7");
			}
			request.setAttribute("paramvalue", vo.getParamvalue());
		} catch (Exception ex) {
			setActionMessage(ex.getMessage());
		}
		
		StkalarmctDBParam params =	(StkalarmctDBParam)this.getParam();
	
		if(params.get_dnl_statdate()==null||params.get_dnl_statdate().equals("")||params.get_dnm_statdate()==null||params.get_dnm_statdate().equals("")){
			
			setActionMessage("���ʱ�䲻��Ϊ�գ�");
			return WEB_RESULT_LIST;
		}
		
		
		if(StringUtils.isEmpty(params.get_dnl_statdate())&&StringUtils.isEmpty(params.get_dnm_statdate())){
//			String stockdate = PublicUtils.formatUtilDate(queryStockTime(),"yyyy-MM-dd")+" 00:00:00";
//			String currdate = PublicUtils.formatUtilDate(queryStockTimeCurrent(),"yyyy-MM-dd")+" 23:59:59";
//			params.set_dnl_statdate(stockdate);
//			params.set_dnm_statdate(currdate);
		}else{
			Date ldate = new Date();
			Date mdate = new Date();
			SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd");
			ldate = myformat.parse(params.get_dnl_statdate());
			mdate = myformat.parse(params.get_dnm_statdate());
			Long day = (mdate.getTime() - ldate.getTime())/(1000*60*60*24);
			if(day>30){
				setActionMessage("���ʱ�������ܳ���30�졣");
				return WEB_RESULT_LIST;
			}
		}
//		String s = super.doList();
//		DataPackage dp = this.getDp();
		return super.doList();
	}
	
	private Date queryStockTimeCurrent() throws Exception {
		Calendar stocktime = Calendar.getInstance();
		stocktime.add(Calendar.DAY_OF_MONTH, 00);
		stocktime.set(Calendar.HOUR_OF_DAY, 00);
		stocktime.set(Calendar.MINUTE, 00);
		stocktime.set(Calendar.SECOND, 00);
		return stocktime.getTime();
	}
	
	private Date queryStockTime() throws Exception {
		Calendar stocktime = Calendar.getInstance();
		stocktime.add(Calendar.DAY_OF_MONTH,00);
		stocktime.set(Calendar.HOUR_OF_DAY, 23);
		stocktime.set(Calendar.MINUTE, 59);
		stocktime.set(Calendar.SECOND, 59);
		return stocktime.getTime();
	}
	
	//��ȡ��������
	private int getDay() throws Exception{
			Sysparam sysparam = (Sysparam) BOFactory.build(SysparamBO.class,
					getDBAccessUser());
			Serializable pkVO = new SysparamVO();
			BeanUtils.setProperty(pkVO, "systemid", "65");// ϵͳ��ʶ=63
			BeanUtils.setProperty(pkVO, "paramtype", "pboss_fx");// ��������==pboss_fx
			SysparamVO vo = sysparam.doFindByPk(pkVO);
			if(vo == null){
				return 7;
			}
			if (vo != null && !StringUtils.isEmpty(vo.getParamvalue())) {
				return Integer.parseInt(vo.getParamvalue());
				
			}else{
				return 7;
			}
	}
}