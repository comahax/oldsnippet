/**
 * auto-generated code
 * Tue Oct 19 15:41:02 CST 2010
 */
 package com.gmcc.pboss.web.sales.waystockrecord;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaDBParam;
import com.gmcc.pboss.business.sales.waystockrecord.WaystockrecordDBParam;
import com.gmcc.pboss.business.sales.waystockrecord.WaystockrecordVO;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.resource.comcategoryrela.Comcategoryrela;
import com.gmcc.pboss.control.resource.comcategoryrela.ComcategoryrelaBO;
import com.gmcc.pboss.control.sales.waystockrecord.Waystockrecord;
import com.gmcc.pboss.control.sales.waystockrecord.WaystockrecordBO;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * <p>Title: WaystockrecordAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class WaystockrecordAction extends BaseAction{
	
	public WaystockrecordAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new WaystockrecordForm());
		this.setParam(new WaystockrecordDBParam());

        //ָ��VO��
        setClsVO(WaystockrecordVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"seqid"};
		this.setClsControl(Waystockrecord.class);
		this.setClsQueryParam(WaystockrecordDBParam.class) ;

	}
	
	private String stockrecordFlag = "true";
	private String restype ;
	
	@Override
	public String doList() throws Exception {
		WaystockrecordDBParam params = (WaystockrecordDBParam) getParam();
		String _se_comresid = params.get_se_comresid();
		if ((_se_comresid == null || "".equals(_se_comresid))
				&& StringUtils.isEmpty(params.get_dnl_stocktime())
				&& StringUtils.isEmpty(params.get_dnm_stocktime())) {
			String stockdate = PublicUtils.formatUtilDate(queryStockTime(),"yyyy-MM-dd")+" 00:00:00";
			String currdate = PublicUtils.formatUtilDate(queryStockTimeCurrent(),"yyyy-MM-dd")+" 23:59:59";
			params.set_dnl_stocktime(stockdate);
			params.set_dnm_stocktime(currdate);
		}
		
		String _se_restype = params.get_se_restype();
		if(_se_restype == null || "".equals(_se_restype)){//����ʱ��_se_restypeδ�ᴫֵ����
			_se_restype = restype;
			params.set_se_restype(restype);
		}
		stockrecordFlag = "true";
		if (this.isQuery){
			
			//ҳ��_se_comresid��ʾ���׿�����ֵ�����հ�SIM����������Ҫת��
			//���հ�simʱ����Ҫת����_se_emptyno�������_se_comresidֵ
			if("COMRESSMP".equals(_se_restype) || "COMRESCARD".equals(_se_restype)){
				stockrecordFlag = "true";
				
			}else{
				stockrecordFlag = "false";
				params.set_se_brand(null);//���Ʒ��
				params.set_se_comresid(null);
				params.set_se_emptyno(_se_comresid);
			}
			
			//��Դ���-->��Ʒ����
			chgResToComs(params);
			
			Waystockrecord snptbo = (Waystockrecord)BOFactory.build(WaystockrecordBO.class,getDBAccessUser());
			
			if (_se_comresid == null || "".equals(_se_comresid)) {
				Date ldate = new Date();
				Date mdate = new Date();
				SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd");
				ldate = myformat.parse(params.get_dnl_stocktime());
				mdate = myformat.parse(params.get_dnm_stocktime());
				Long day = (mdate.getTime() - ldate.getTime())/(1000*60*60*24);
				if(day>30){
					setActionMessage("���ʱ�������ܳ���30�졣");
					return "list";
				}else{
					params.set_dnl_stocktime(myformat.format(ldate)+" 00:00:00");
					params.set_dnm_stocktime(myformat.format(mdate)+" 23:59:59");
				}
			} else {
				params.set_dnl_stocktime(null);
				params.set_dnm_stocktime(null);
			}
			
			DataPackage dp = snptbo.doQuery(params);
			this.setDp(dp);
			 
		}
		return "list";
	}
	
	//��Դ���-->��Ʒ����
	private void chgResToComs(WaystockrecordDBParam params) throws Exception{
		String _se_restype = params.get_se_restype();
		Comcategoryrela comcategoryrelaBO = (ComcategoryrelaBO)BOFactory.build(ComcategoryrelaBO.class,getDBAccessUser());
		ComcategoryrelaDBParam comcategoryrelaDBParam = new ComcategoryrelaDBParam();
		comcategoryrelaDBParam.setSelectFieldsString("restype,comcategory");
		comcategoryrelaDBParam.set_pagesize("0");
		comcategoryrelaDBParam.setDataOnly(true);
		DataPackage rtc = comcategoryrelaBO.doQueryRestypeToComcategory(comcategoryrelaDBParam);
		List<String> listQuery = new ArrayList<String>();
		if (null != rtc && null != rtc.getDatas()) {
			List<Map> list = rtc.getDatas();
			for (Map map : list) {
				String restype = (String)map.get("restype");
				String comcategory = (String)map.get("comcategory");
				if(_se_restype != null && _se_restype.equals(restype)){
					listQuery.add(comcategory);
				}
			}
		}
		params.set_sin_comcategory(listQuery);
		params.set_se_restype(null);
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
	
	/**
	 * ��������ϸEXCEL����
	 * @return
	 * @throws Exception
	 */
	public String doExportstocksmprecord() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		WaystockrecordDBParam params = (WaystockrecordDBParam) getParam();
		String _se_restype = params.get_se_restype();
		
		//��Դ���-->��Ʒ����
		chgResToComs(params);
		
		export.setFileName("��������ϸ");
		export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
		export.appendHeadLine(new String[] { "����ʱ��", format.format(new Date()) });
		if("COMRESSMP".equals(_se_restype) || "COMRESCARD".equals(_se_restype)){
			export.addOutputProperty("comresid","��Ʒ��Դ���");
		}else{
			export.addOutputProperty("emptyno","�հ׿����к�");
		}
		
		export.addOutputProperty("stocktime","���ʱ��",export.DATE,
				"yyyy-MM-dd HH:mm:ss");
		
		export.addOutputProperty("countyid", "�ֹ�˾", CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("svccode","������������", CommonExportBean.CODE2NAME,"#SERVCENT");		
		export.addOutputProperty("mareacode", "΢����", CommonExportBean.CODE2NAME, "#MICROAREA");
		export.addOutputProperty("orderid","��������");
		export.addOutputProperty("wayid", "�������");
		export.addOutputProperty("wayname", "��������");
		export.addOutputProperty("starlevel","�Ǽ�", CommonExportBean.CODE2NAME,"$CH_STARLEVEL");
		if("COMRESSMP".equals(_se_restype) || "COMRESCARD".equals(_se_restype)){
			export.addOutputProperty("brand", "Ʒ��", CommonExportBean.CODE2NAME, "$FX_SMPBRAND");
		}
		export.addOutputProperty("comcategory","��Ʒ����", CommonExportBean.CODE2NAME,"$IM_FXCOMCATEGORY");
		
		// ����VO��
		export.voClassArray = new Class[] { WaystockrecordVO.class };
		
		// ���ò�ѯ����
		export.queryMethodName = "doList";
		params.setQueryAll(true);
		params.set_pagesize("10000");
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
	/**
	 * ��������ϸTXT����
	 * @return
	 * @throws Exception
	 */
	public String doExportstocksmprecordTxt() throws Exception {
		// TODO coding...
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		export.setFileName("��������ϸ");
		
		WaystockrecordDBParam params = (WaystockrecordDBParam) getParam();
		String _se_restype = params.get_se_restype();
		
		//��Դ���-->��Ʒ����
		chgResToComs(params);
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//		export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
//		export.appendHeadLine(new String[] { "����ʱ��", format.format(new Date()) });
		if("COMRESSMP".equals(_se_restype) || "COMRESCARD".equals(_se_restype)){
			export.addOutputProperty("comresid","��Ʒ��Դ���");
		}else{
			export.addOutputProperty("emptyno","�հ׿����к�");
		}
		export.addOutputProperty("stocktime","���ʱ��",export.DATE,
				"yyyy-MM-dd HH:mm:ss");
				
		export.addOutputProperty("countyid", "�ֹ�˾", CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("svccode","������������", CommonExportBean.CODE2NAME,"#SERVCENT");
		export.addOutputProperty("mareacode", "΢����", CommonExportBean.CODE2NAME, "#MICROAREA");
		export.addOutputProperty("orderid","��������");
		export.addOutputProperty("wayid", "�������");
		export.addOutputProperty("wayname", "��������");
		export.addOutputProperty("starlevel","�Ǽ�", CommonExportBean.CODE2NAME,"$CH_STARLEVEL");
		if("COMRESSMP".equals(_se_restype) || "COMRESCARD".equals(_se_restype)){
			export.addOutputProperty("brand", "Ʒ��", CommonExportBean.CODE2NAME, "$FX_SMPBRAND");
		}
		export.addOutputProperty("comcategory","��Ʒ����", CommonExportBean.CODE2NAME,"$IM_FXCOMCATEGORY");
		
		// ����VO��
		export.voClassArray = new Class[] { WaystockrecordVO.class };
		
		// ���ò�ѯ����
		export.queryMethodName = "doList";

		prepareResponse(export.getFileName());
		getParam().set_pagesize("0");
		if("COMRESSMP".equals(_se_restype) || "COMRESCARD".equals(_se_restype)){
			export.writeTxtTitle(getResponse().getOutputStream(), new String[] {
				"��Ʒ��Դ���", "���ʱ��","�ֹ�˾" ,"������������","΢����","��������","�������","��������","�Ǽ�","Ʒ��","��Ʒ����"});
		}else{
			export.writeTxtTitle(getResponse().getOutputStream(), new String[] {
				"�հ׿����к�", "���ʱ��","�ֹ�˾" ,"������������","΢����","��������","�������","��������","�Ǽ�","��Ʒ����"});
		}
		super.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
		return null;
	}
	private boolean isQuery;// �Ƿ�ͳ�Ʊ�ʶ��Ĭ�ϲ���ѯ

	public boolean getIsQuery() {
		return isQuery;
	}

	public void setIsQuery(boolean isQuery) {
		this.isQuery = isQuery;
	}

	public String getStockrecordFlag() {
		return stockrecordFlag;
	}

	public void setStockrecordFlag(String stockrecordFlag) {
		this.stockrecordFlag = stockrecordFlag;
	}

	public String getRestype() {
		return restype;
	}

	public void setRestype(String restype) {
		this.restype = restype;
	}
	
	
}