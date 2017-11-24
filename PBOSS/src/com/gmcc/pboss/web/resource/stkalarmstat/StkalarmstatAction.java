/**
 * auto-generated code
 * Tue Jul 27 12:08:11 CST 2010
 */
 package com.gmcc.pboss.web.resource.stkalarmstat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.resource.stkalarmstat.StkalarmstatDBParam;
import com.gmcc.pboss.business.resource.stkalarmstat.StkalarmstatVO;
import com.gmcc.pboss.business.resource.stkalarmstat.StkalarmstatshowVO;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.resource.stkalarmstat.Stkalarmstat;
import com.gmcc.pboss.control.resource.stkalarmstat.StkalarmstatBO;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * <p>Title: StkalarmstatAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class StkalarmstatAction extends BaseAction{
	
	public StkalarmstatAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new StkalarmstatForm());
		this.setParam(new StkalarmstatWebParam());

        //ָ��VO��
        setClsVO(StkalarmstatVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"seqid"};
		this.setClsControl(Stkalarmstat.class);
		this.setClsQueryParam(StkalarmstatDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	//����Ԥ����Ϣ��ϸ��ѯ
	public String doListdetail() throws Exception {
		// TODO Auto-generated method stub
		StkalarmstatDBParam param = (StkalarmstatDBParam) getParam();
		StkalarmstatForm form = (StkalarmstatForm) getForm();
		if(StringUtils.isBlank(form.getIsgiveup()))
			form.setIsgiveup("0");
		Stkalarmstat stkalarmstat = (Stkalarmstat) BOFactory.build(
				StkalarmstatBO.class, getDBAccessUser());
		DataPackage dp = new DataPackage();
		List<StkalarmstatVO> stkalarmstatList = new ArrayList<StkalarmstatVO>();
		if ("1".equals(form.getIsgiveup())) {
			dp = stkalarmstat.doQueryDetails1(param);
			List<StkalarmstatVO> list = dp.getDatas();
			for (StkalarmstatVO vo : list) {
				vo.setIsgiveup("1");
				stkalarmstatList.add(vo);
			}
		} else if ("0".equals(form.getIsgiveup())) {
			dp = stkalarmstat.doQueryDetails2(param);
			List<StkalarmstatVO> list = dp.getDatas();
			for (StkalarmstatVO vo : list) {
				vo.setIsgiveup("0");
				stkalarmstatList.add(vo);
			}
		}
		dp.setDatas(stkalarmstatList);
		setDp(dp);
		setForm(form);
		return "list";
	}
	
	//����Ԥ����Ϣ��ϸ����Excel
	public String doExceldetail() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		export.setFileName("����Ԥ����Ϣ��ϸ");
		export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
		export.appendHeadLine(new String[] { "����ʱ��",format.format(new Date()) });
		export.addOutputProperty("seqid", "���");
		export.addOutputProperty("alarmdate", "Ԥ������",export.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("wayid", "�����̱�ʶ");
		export.addOutputProperty("wayid", "����������",export.CODE2NAME, "#WAY");
		export.addOutputProperty("brand", "Ʒ��",export.CODE2NAME, "$FX_SMPBRAND");
		export.addOutputProperty("alarmlevel", "Ԥ������",export.CODE2NAME, "$FX_STOCKALARMLEVEL");
		export.addOutputProperty("crtstock", "��ʱ���");
		export.addOutputProperty("orderid", "�������");
		export.addOutputProperty("isgiveup", "��������", export.CODE2NAME, "$IM_YESNO10");
		export.voClassArray = new Class[] { StkalarmstatVO.class };
		export.queryMethodName = "doListdetail";
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		StkalarmstatDBParam param=(StkalarmstatDBParam)super.getParam();
		param.set_pagesize("0");
		super.setParam(param);
		return super.doExcel();
	}
	
	//����Ԥ����Ϣ��ϸ����txt
	public String doTxtdetail() throws Exception {
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("����Ԥ����Ϣ��ϸ");
		export.addOutputProperty("seqid", "���");
		export.addOutputProperty("alarmdate", "Ԥ������",export.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("wayid", "�����̱�ʶ");
		export.addOutputProperty("wayid", "����������",export.CODE2NAME, "#WAY");
		export.addOutputProperty("brand", "Ʒ��",export.CODE2NAME, "$FX_SMPBRAND");
		export.addOutputProperty("alarmlevel", "Ԥ������",export.CODE2NAME, "$FX_STOCKALARMLEVEL");
		export.addOutputProperty("crtstock", "��ʱ���");
		export.addOutputProperty("orderid", "�������");
		export.addOutputProperty("isgiveup", "��������", export.CODE2NAME, "$IM_YESNO10");
		export.voClassArray = new Class[] { StkalarmstatVO.class };
		export.queryMethodName = "doListdetail";
		
		prepareResponse(export.getFileName());
		StkalarmstatDBParam param=(StkalarmstatDBParam)super.getParam();
		param.set_pagesize("0");
		super.setParam(param);
		export.writeTxtTitle(getResponse().getOutputStream(), new String[] {
				"���","Ԥ������","�����̱�ʶ", "����������", "Ʒ��", "Ԥ������" ,"��ʱ���","�������","��������"});
		super.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
		return null;
	}
	
	//����Ԥ����Ϣͳ��
	public String doListstat() throws Exception {
		try {
			StkalarmstatDBParam params = (StkalarmstatDBParam) getParam();
			StkalarmstatForm form = (StkalarmstatForm)getForm();
			Stkalarmstat stkalarmstat = (Stkalarmstat) BOFactory.build(
					StkalarmstatBO.class, getDBAccessUser());
			DataPackage dp = stkalarmstat.doQueryStat(params);
			setDp(dp);
			Long totalred = 0L;
			Long totalyellow = 0L;
			List<StkalarmstatshowVO> list = dp.getDatas();
			for(StkalarmstatshowVO vo : list){
				Long redalarm = vo.getRedalarm();
				Long yelalarm = vo.getYelalarm();
				totalred = totalred + redalarm;
				totalyellow = totalyellow + yelalarm;
			}
			form.setTotalred(totalred);
			form.setTotalyellow(totalyellow);
		} catch (Exception e) {
			addActionError(e.getMessage());
		}
		return "stat";
	}
	
	//����Ԥ����Ϣͳ�Ƶ���Excel
	public String doExcelstat() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		export.setFileName("����Ԥ����Ϣͳ��");
		export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
		export.appendHeadLine(new String[] { "����ʱ��",format.format(new Date()) });
		//export.addOutputProperty("seqid", "���");
		export.addOutputProperty("countyid", "�ֹ�˾",export.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("mareacode", "΢����",export.CODE2NAME, "#MICROAREA");
		export.addOutputProperty("redalarm", "��ɫԤ��");
		export.addOutputProperty("yelalarm", "��ɫԤ��");
		export.voClassArray = new Class[] { StkalarmstatshowVO.class };
		export.queryMethodName = "doListstat";
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		StkalarmstatDBParam param=(StkalarmstatDBParam)super.getParam();
		param.set_pagesize("0");
		super.setParam(param);
		return super.doExcel();
	}
	
	//����Ԥ����Ϣͳ�Ƶ���txt
	public String doTxtstat() throws Exception {
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("����Ԥ����Ϣͳ��");
		//export.addOutputProperty("seqid", "���");
		export.addOutputProperty("countyid", "�ֹ�˾",export.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("mareacode", "΢����",export.CODE2NAME, "#MICROAREA");
		export.addOutputProperty("redalarm", "��ɫԤ��");
		export.addOutputProperty("yelalarm", "��ɫԤ��");
		export.voClassArray = new Class[] { StkalarmstatshowVO.class };
		export.queryMethodName = "doListstat";
		
		prepareResponse(export.getFileName());
		StkalarmstatDBParam param=(StkalarmstatDBParam)super.getParam();
		param.set_pagesize("0");
		super.setParam(param);
		export.writeTxtTitle(getResponse().getOutputStream(), new String[] {
				"�ֹ�˾","΢����","��ɫԤ��", "��ɫԤ��"});
		super.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
		return null;
	}
	
}