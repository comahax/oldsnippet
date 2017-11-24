package com.gmcc.pboss.web.resource.wayrcstat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.resource.wayrcstat.WayrcstatDBParam;
import com.gmcc.pboss.business.resource.wayrcstat.WayrcstatVO;
import com.gmcc.pboss.business.resource.wayrcstat.WayrcstatVO2;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.resource.wayrcstat.Wayrcstat;
import com.gmcc.pboss.control.resource.wayrcstat.WayrcstatBO;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * ��Action���Ӧ�������������: 1.������Դ��Ϣͳ��(ʵʱ) 2.������Դ��Ϣͳ��(��ʷ)
 * 
 * ��Actionδ����VO��, ��Ϊû��CRUD����, ֻ�в�ѯ, �����ǹ�����ѯ;
 * �ڵ���ʱ, ��Ҫ������Ӧ��doList����, ��������Ӧ��VO��
 * 
 * @author liang.qichao
 * @since 20100817
 *
 */
public class WayrcstatAction extends BaseAction {

	public WayrcstatAction() {
		super();

		//���¼��������Ǳ����
//		this.setForm(new WayrcstatForm());
		this.setParam(new WayrcstatDBParam());

        //ָ��VO��
//        setClsVO(WayrcstatVO.class);
//        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
//        this.pkNameArray=new String[]{"seqid"};
//		this.setClsControl(Stkalarmstat.class);
//		this.setClsQueryParam(StkalarmstatDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	// ʵʱ����ͳ��
	public String doReallist() throws Exception {
		if(this.isQuery){
		Wayrcstat bo = (Wayrcstat) BOFactory.build(WayrcstatBO.class, getDBAccessUser());
		DataPackage dp = bo.doQueryreal(getParam());
		this.setDp(dp);
		}
		return "reallist";
	}
	
	// ��ʷ����ͳ��
	public String doHistorylist() throws Exception {
		WayrcstatDBParam params = (WayrcstatDBParam) this.getParam();
		if (this.isQuery) {
			SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd");
			Date ldate = myformat.parse(params.get_dnl_statdate());
			Date mdate = myformat.parse(params.get_dnm_statdate());
			Long day = (mdate.getTime() - ldate.getTime()) / (1000 * 60 * 60 * 24);
			if (day > 30) {
				setActionMessage("�������ڼ�����ܳ���30�졣");
				return "historylist";
			}
			Wayrcstat bo = (Wayrcstat) BOFactory.build(WayrcstatBO.class, getDBAccessUser());
			DataPackage dp = bo.doQueryhistory(getParam());
			this.setDp(dp);
		} else {
			String stockdate = PublicUtils.utilDateToStr(queryStockTimeCurrent());
			String currdate = PublicUtils.utilDateToStr(queryStockTime());
			params.set_dnl_statdate(stockdate);
			params.set_dnm_statdate(currdate);
		}
		return "historylist";
	}
	
	// ����ʵʱ����txt
	public String doExportrealtxt() throws Exception {
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		export.setFileName("������Դ��Ϣͳ�Ƶ���(ʵʱ)");
		
		export.addOutputProperty("countyid", "�ֹ�˾", CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("mareacode", "΢����", CommonExportBean.CODE2NAME, "#MICROAREA");
		export.addOutputProperty("wayid", "�����̱���");
		export.addOutputProperty("wayname", "����������");
		export.addOutputProperty("brand", "Ʒ��", CommonExportBean.CODE2NAME, "$FX_SMPBRAND");
		export.addOutputProperty("cnt1", "�����");
		export.addOutputProperty("cnt2", "�����");
		export.addOutputProperty("cnt3", "������");
		
		// ����VO��
		export.voClassArray = new Class[] { WayrcstatVO.class };
		
		// ���ò�ѯ����
		export.queryMethodName = "doReallist";

		prepareResponse(export.getFileName());
		getParam().set_pagesize("0");
		export.writeTxtTitle(getResponse().getOutputStream(), new String[] {
				"�ֹ�˾", "΢����", "�����̱���", "����������", "Ʒ��" ,"�����","�����","������"});
		super.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
		return null;
	}
	
	// ����ʵʱ����xls
	public String doExportrealxls() throws Exception {
		
		// ����VO��
		//this.setClsVO(WayrcstatVO.class);
		
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		export.setFileName("������Դ��Ϣͳ�Ƶ���(ʵʱ)");
		export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
		export.appendHeadLine(new String[] { "����ʱ��", format.format(new Date()) });
		
		export.addOutputProperty("countyid", "�ֹ�˾", CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("mareacode", "΢����", CommonExportBean.CODE2NAME, "#MICROAREA");
		export.addOutputProperty("wayid", "�����̱���");
		export.addOutputProperty("wayname", "����������");
		export.addOutputProperty("brand", "Ʒ��", CommonExportBean.CODE2NAME, "$FX_SMPBRAND");
		export.addOutputProperty("cnt1", "�����");
		export.addOutputProperty("cnt2", "�����");
		export.addOutputProperty("cnt3", "������");
		
		// ����VO��
		export.voClassArray = new Class[] { WayrcstatVO.class };
		
		// ���ò�ѯ����
		export.queryMethodName = "doReallist";
		
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		getParam().set_pagesize("0");
		
		return super.doExcel();
	}
	
	// ������ʷ����txt
	public String doExporthistorytxt() throws Exception {
		WayrcstatDBParam params = (WayrcstatDBParam) this.getParam();
		SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd");
		Date ldate = myformat.parse(params.get_dnl_statdate());
		Date mdate = myformat.parse(params.get_dnm_statdate());
		Long day = (mdate.getTime() - ldate.getTime()) / (1000 * 60 * 60 * 24);
		if (day > 30) {
			setActionMessage("�������ڼ�����ܳ���30�졣");
			return "historylist";
		}
		// TODO coding...
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		export.setFileName("������Դ��Ϣͳ�Ƶ���(��ʷ)");
		
		export.addOutputProperty("statdate", "��������");
		export.addOutputProperty("countyid", "�ֹ�˾", CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("mareacode", "΢����", CommonExportBean.CODE2NAME, "#MICROAREA");
		export.addOutputProperty("waymagcode", "��������");
		export.addOutputProperty("wayid", "�������");
		export.addOutputProperty("wayname", "��������");
		export.addOutputProperty("starlevel", "�Ǽ�",CommonExportBean.CODE2NAME, "$CH_STARLEVEL");
		export.addOutputProperty("brand", "Ʒ��", CommonExportBean.CODE2NAME, "$FX_SMPBRAND");
		export.addOutputProperty("cnt3", "������");		
		export.addOutputProperty("cnt2", "�����");
		export.addOutputProperty("cnt1", "�����");
		export.addOutputProperty("maxstock", "��߿��");
		export.addOutputProperty("redvalue", "��ɫ��ֵ");
		export.addOutputProperty("yelvalue", "��ɫ��ֵ");
		export.addOutputProperty("alarmlevel", "Ԥ������",CommonExportBean.CODE2NAME, "$FX_STOCKALARMLEVEL");
		
		// ����VO��
		export.voClassArray = new Class[] { WayrcstatVO2.class };
		
		// ���ò�ѯ����
		export.queryMethodName = "doHistorylist";

		prepareResponse(export.getFileName());
		getParam().set_pagesize("0");
		export.writeTxtTitle(getResponse().getOutputStream(), new String[] {
				"��������", "�ֹ�˾", "΢����","��������","�������","��������","�Ǽ�","Ʒ��", "������", "�����", "�����" ,"��߿��","��ɫ��ֵ","��ɫ��ֵ","Ԥ������"});
		super.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
		return null;
	}
	
	// ������ʷ����xls
	public String doExporthistoryxls() throws Exception {
		WayrcstatDBParam params = (WayrcstatDBParam) this.getParam();
		SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd");
		Date ldate = myformat.parse(params.get_dnl_statdate());
		Date mdate = myformat.parse(params.get_dnm_statdate());
		Long day = (mdate.getTime() - ldate.getTime()) / (1000 * 60 * 60 * 24);
		if (day > 30) {
			setActionMessage("�������ڼ�����ܳ���30�졣");
			return "historylist";
		}
		// TODO coding...
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		export.setFileName("������Դ��Ϣͳ�Ƶ���(��ʷ)");
		export.addOutputProperty("statdate", "��������");
		export.addOutputProperty("countyid", "�ֹ�˾", CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("mareacode", "΢����", CommonExportBean.CODE2NAME, "#MICROAREA");
		export.addOutputProperty("waymagcode", "��������");
		export.addOutputProperty("wayid", "�������");
		export.addOutputProperty("wayname", "��������");
		export.addOutputProperty("starlevel", "�Ǽ�",CommonExportBean.CODE2NAME, "$CH_STARLEVEL");
		export.addOutputProperty("brand", "Ʒ��", CommonExportBean.CODE2NAME, "$FX_SMPBRAND");
		export.addOutputProperty("cnt3", "������");		
		export.addOutputProperty("cnt2", "�����");
		export.addOutputProperty("cnt1", "�����");
		export.addOutputProperty("maxstock", "��߿��");
		export.addOutputProperty("redvalue", "��ɫ��ֵ");
		export.addOutputProperty("yelvalue", "��ɫ��ֵ");
		export.addOutputProperty("alarmlevel", "Ԥ������",CommonExportBean.CODE2NAME, "$FX_STOCKALARMLEVEL");
		
		// ����VO��
		export.voClassArray = new Class[] { WayrcstatVO2.class };
		
		// ���ò�ѯ����
		export.queryMethodName = "doHistorylist";
		
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		getParam().set_pagesize("0");
		
		return super.doExcel();
	}
	
	
	private Date queryStockTimeCurrent() throws Exception {
		Calendar stocktime = Calendar.getInstance();
		stocktime.add(Calendar.DAY_OF_MONTH, -1);
		stocktime.set(Calendar.HOUR_OF_DAY, 00);
		stocktime.set(Calendar.MINUTE, 00);
		stocktime.set(Calendar.SECOND, 00);
		return stocktime.getTime();
	}
	
	private Date queryStockTime() throws Exception {
		Calendar stocktime = Calendar.getInstance();
		stocktime.add(Calendar.DAY_OF_MONTH, -1);
		stocktime.set(Calendar.HOUR_OF_DAY, 23);
		stocktime.set(Calendar.MINUTE, 59);
		stocktime.set(Calendar.SECOND, 59);
		return stocktime.getTime();
	}
	private boolean isQuery;// �Ƿ�ͳ�Ʊ�ʶ��Ĭ�ϲ���ѯ

	public boolean getIsQuery() {
		return isQuery;
	}

	public void setIsQuery(boolean isQuery) {
		this.isQuery = isQuery;
	}
	
}
