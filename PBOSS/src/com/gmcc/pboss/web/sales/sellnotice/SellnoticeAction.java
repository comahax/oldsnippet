/**
 * auto-generated code
 * Thu Jan 26 11:26:19 CST 2012
 */
 package com.gmcc.pboss.web.sales.sellnotice;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.sales.sellnotice.SellnoticeDBParam;
import com.gmcc.pboss.business.sales.sellnotice.SellnoticeVO;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.sales.sellnotice.Sellnotice;
import com.gmcc.pboss.control.sales.sellnotice.SellnoticeBO;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * <p>Title: SellnoticeAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public class SellnoticeAction extends BaseAction{
	
	public SellnoticeAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new SellnoticeForm());
		this.setParam(new SellnoticeDBParam());

        //ָ��VO��
        setClsVO(SellnoticeVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"seqid"};
		this.setClsControl(Sellnotice.class);
		this.setClsQueryParam(SellnoticeDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	//�������۽��Ȳ�ѯ
	public String doWayList() {
		try{
			super.doList();
			DataPackage tmp = super.getDp();
			
			Sellnotice sellnoticeBO = (SellnoticeBO)BOFactory.build(SellnoticeBO.class,this.getDBAccessUser());
			tmp = sellnoticeBO.doWayList(tmp);
			
			this.setDp(tmp);
		}catch (Exception e) {
			e.printStackTrace();
			addActionError(e.getMessage());
		}
		return "wayList";
	}
	
	//�����������۽��Ȳ�ѯ
	public String doWayMagList() {
		try{
			param.setDataOnly(true);
			param.set_pagesize("0");
			super.doList();
			DataPackage tmp = super.getDp();
			
			Sellnotice sellnoticeBO = (SellnoticeBO)BOFactory.build(SellnoticeBO.class,this.getDBAccessUser());
			tmp = sellnoticeBO.doWayMagList(tmp);
			
			this.setDp(tmp);
		}catch (Exception e) {
			e.printStackTrace();
			addActionError(e.getMessage());
		}
		return "wayMagList";
	}
	
	//΢�������۽��Ȳ�ѯ
	public String doMareacodeList() {
		try{
			param.setDataOnly(true);
			param.set_pagesize("0");
			super.doList();
			DataPackage tmp = super.getDp();
			
			Sellnotice sellnoticeBO = (SellnoticeBO)BOFactory.build(SellnoticeBO.class,this.getDBAccessUser());
			tmp = sellnoticeBO.doMareacodeList(tmp);
			
			this.setDp(tmp);
		}catch (Exception e) {
			e.printStackTrace();
			addActionError(e.getMessage());
		}
		return "mareacodeList";
	}
	
	//�ֹ�˾���۽��Ȳ�ѯ
	public String doCountyList() {
		try{
			param.setDataOnly(true);
			param.set_pagesize("0");
			super.doList();
			DataPackage tmp = super.getDp();
			
			Sellnotice sellnoticeBO = (SellnoticeBO)BOFactory.build(SellnoticeBO.class,this.getDBAccessUser());
			tmp = sellnoticeBO.doCountyList(tmp);
			
			this.setDp(tmp);
		}catch (Exception e) {
			e.printStackTrace();
			addActionError(e.getMessage());
		}
		return "countyList";
	}
	
	public String doWayExcel() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		
		export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
		export.appendHeadLine(new String[] { "����ʱ��", PublicUtils.utilDateToStr(new Date()) });
		
		export.queryMethodName = "doWayList";
		
		export.setFileName("�������۽��Ȳ�ѯ");
		export.addOutputProperty("wayid", "�������");
		export.addOutputProperty("wayid", "��������", export.CODE2NAME,
			"#WAYIDINFO");
		export.addOutputProperty("countyid", "�ֹ�˾", export.CODE2NAME,
			"#CNTYCOMPANY");
		export.addOutputProperty("mareacode", "΢����", export.CODE2NAME,
			"#MICROAREA");
		export.addOutputProperty("starlevel", "�Ǽ�", export.CODE2NAME,
			"$CH_STARLEVEL");
		export.addOutputProperty("sellcount", "������");
		export.addOutputProperty("salesstd", "����ֵ");
		export.addOutputProperty("comrate", "����ʣ�%��");
		
		export.voClassArray = new Class[] { SellnoticeVO.class };
		SellnoticeDBParam params = (SellnoticeDBParam) super.getParam();
		params.set_pagesize("0");
		super.setParam(params);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
	
	public String doWayMagExcel() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		
		export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
		export.appendHeadLine(new String[] { "����ʱ��", PublicUtils.utilDateToStr(new Date()) });
		
		export.queryMethodName = "doWayMagList";
		
		export.setFileName("�����������۽��Ȳ�ѯ");
		export.addOutputProperty("countyid", "�ֹ�˾", export.CODE2NAME,
			"#CNTYCOMPANY");
		export.addOutputProperty("waymagcode", "��������", export.CODE2NAME,
			"#EMPLOYEE");
		export.addOutputProperty("sellcount", "������");
		export.addOutputProperty("salesstd", "����ֵ");
		export.addOutputProperty("comrate", "����ʣ�%��");
		
		export.voClassArray = new Class[] { SellnoticeVO.class };
		SellnoticeDBParam params = (SellnoticeDBParam) super.getParam();
		params.set_pagesize("0");
		super.setParam(params);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
	
	public String doMareacodeExcel() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		
		export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
		export.appendHeadLine(new String[] { "����ʱ��", PublicUtils.utilDateToStr(new Date()) });
		
		export.queryMethodName = "doMareacodeList";
		
		export.setFileName("΢�������۽��Ȳ�ѯ");
		export.addOutputProperty("countyid", "�ֹ�˾", export.CODE2NAME,
			"#CNTYCOMPANY");
		export.addOutputProperty("mareacode", "΢����", export.CODE2NAME,
			"#MICROAREA");
		export.addOutputProperty("sellcount", "������");
		export.addOutputProperty("salesstd", "����ֵ");
		export.addOutputProperty("comrate", "����ʣ�%��");
		
		export.voClassArray = new Class[] { SellnoticeVO.class };
		SellnoticeDBParam params = (SellnoticeDBParam) super.getParam();
		params.set_pagesize("0");
		super.setParam(params);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
	
	public String doCountyExcel() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		
		export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
		export.appendHeadLine(new String[] { "����ʱ��", PublicUtils.utilDateToStr(new Date()) });
		
		export.queryMethodName = "doCountyList";
		
		export.setFileName("�ֹ�˾���۽��Ȳ�ѯ");
		export.addOutputProperty("countyid", "�ֹ�˾", export.CODE2NAME,
			"#CNTYCOMPANY");
		export.addOutputProperty("sellcount", "������");
		export.addOutputProperty("salesstd", "����ֵ");
		export.addOutputProperty("comrate", "����ʣ�%��");
		
		export.voClassArray = new Class[] { SellnoticeVO.class };
		SellnoticeDBParam params = (SellnoticeDBParam) super.getParam();
		params.set_pagesize("0");
		super.setParam(params);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
}