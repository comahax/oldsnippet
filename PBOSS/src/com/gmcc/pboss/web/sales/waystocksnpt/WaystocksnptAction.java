/**
 * auto-generated code
 * Wed Sep 08 16:30:03 CST 2010
 */
 package com.gmcc.pboss.web.sales.waystocksnpt;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.sales.activedetail.ActivedetailVO;
import com.gmcc.pboss.business.sales.comrescarddetail.ComrescarddetailVO;
import com.gmcc.pboss.business.sales.comressdetail.ComressdetailVO;
import com.gmcc.pboss.business.sales.waystocksnpt.RWaystocksnptVO;
import com.gmcc.pboss.business.sales.waystocksnpt.SWaystocksnptVO;
import com.gmcc.pboss.business.sales.waystocksnpt.WaystocksnptDBParam;
import com.gmcc.pboss.business.sales.waystocksnpt.WaystocksnptVO;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.sales.activedetail.Activedetail;
import com.gmcc.pboss.control.sales.activedetail.ActivedetailBO;
import com.gmcc.pboss.control.sales.comrescarddetail.Comrescarddetail;
import com.gmcc.pboss.control.sales.comrescarddetail.ComrescarddetailBO;
import com.gmcc.pboss.control.sales.comressdetail.Comressdetail;
import com.gmcc.pboss.control.sales.comressdetail.ComressdetailBO;
import com.gmcc.pboss.control.sales.waystocksnpt.Waystocksnpt;
import com.gmcc.pboss.control.sales.waystocksnpt.WaystocksnptBO;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * <p>Title: WaystocksnptAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class WaystocksnptAction extends BaseAction{
	
	public WaystocksnptAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new WaystocksnptForm());
		this.setParam(new WaystocksnptDBParam());

        //ָ��VO��
        setClsVO(WaystocksnptVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"seqid"};
		this.setClsControl(Waystocksnpt.class);
		this.setClsQueryParam(WaystocksnptDBParam.class) ;

	}
	
	private String stocklistsmpFlag = "true";
	
	/**
	 * ��������ͳ��
	 * @return
	 * @throws Exception
	 */
	public String doStocklistsmp() throws Exception {
		WaystocksnptDBParam params = (WaystocksnptDBParam) getParam();
		if(StringUtils.isEmpty(params.get_dnl_stocktime())&&StringUtils.isEmpty(params.get_dnm_stocktime())){
			String stockdate = PublicUtils.formatUtilDate(queryStockTime(),"yyyy-MM-dd")+" 00:00:00";
			String currdate = PublicUtils.formatUtilDate(queryStockTimeCurrent(),"yyyy-MM-dd")+" 23:59:59";
			params.set_dnl_stocktime(stockdate);
			params.set_dnm_stocktime(currdate);
		}
		if(this.isQuery){ 
		Waystocksnpt snptbo = (Waystocksnpt) BOFactory.build(WaystocksnptBO.class, getDBAccessUser());
		String _se_restype = params.get_se_restype();
		if("COMRESSMP".equals(_se_restype)){
			stocklistsmpFlag = "true";
		}else{
			stocklistsmpFlag = "false";
		}
		Date ldate = new Date();
		Date mdate = new Date();
		SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd");
		ldate = myformat.parse(params.get_dnl_stocktime());
		mdate = myformat.parse(params.get_dnm_stocktime());
		Long day = (mdate.getTime() - ldate.getTime())/(1000*60*60*24);
		if(day>30){
			setActionMessage("���ʱ�������ܳ���30�졣");
			return "stocksmplist";
		} 
		DataPackage dp = snptbo.doQuery(params);
		this.setDp(dp);
		}
		return "stocksmplist";
	}
	
	/**
	 * �����ֵ�������ͳ��
	 * @return
	 * @throws Exception
	 */
//	public String doStocklistcard() throws Exception {
//		WaystocksnptDBParam params = (WaystocksnptDBParam) getParam();
//		Waystocksnpt snptbo = (Waystocksnpt) BOFactory.build(WaystocksnptBO.class, getDBAccessUser());
//		params.set_se_restype("COMRESCARD");
//		if(StringUtils.isEmpty(params.get_dnl_stocktime())&&StringUtils.isEmpty(params.get_dnm_stocktime())){
//			String stockdate = PublicUtils.formatUtilDate(queryStockTime(),"yyyy-MM-dd")+" 00:00:00";
//			String currdate = PublicUtils.formatUtilDate(queryStockTimeCurrent(),"yyyy-MM-dd")+" 23:59:59";
//			params.set_dnl_stocktime(stockdate);
//			params.set_dnm_stocktime(currdate);
//		}
//		DataPackage dp = snptbo.doQuery(params);
//		this.setDp(dp);
//		return "stockcardlist";
//	}
	
	/**
	 * �����׿��������ϸ
	 * @return
	 * @throws Exception
	 */
	public String doStockrecordsmp() throws Exception{
		WaystocksnptDBParam params = (WaystocksnptDBParam) getParam();
		Waystocksnpt snptbo = (Waystocksnpt) BOFactory.build(WaystocksnptBO.class, getDBAccessUser());
		DataPackage dp = snptbo.doQueryStockSmpRecord(params);
		this.setDp(dp);
		return "stockrecordsmp";
	}
	
	/**
	 * �����ֵ���������ϸ
	 * @return
	 * @throws Exception
	 */
//	public String doStockrecordcard() throws Exception{
//		WaystocksnptDBParam params = (WaystocksnptDBParam) getParam();
//		Waystocksnpt snptbo = (Waystocksnpt) BOFactory.build(WaystocksnptBO.class, getDBAccessUser());
//		DataPackage dp = snptbo.doQueryStockCardRecord(params);
//		this.setDp(dp);
//		return "stockrecordcard";
//	}
	
	/**
	 * �����׿�������ͳ��
	 * @return
	 * @throws Exception
	 */
	public String doSalesmplist() throws Exception{
		if (this.isQuery){
		WaystocksnptDBParam params = (WaystocksnptDBParam) getParam();
		Waystocksnpt snptbo = (Waystocksnpt) BOFactory.build(WaystocksnptBO.class, getDBAccessUser());
		
		
		//ֻ�ܲ�ѯ������ǰ������
		if(StringUtils.isEmpty(params.get_dnm_createtime())){
			this.setActionMessage("����ʱ��<=:����Ϊ��!");
			return "salesmplist";
		}else{
			String stockdate = PublicUtils.formatUtilDate(new Date(),"yyyy-MM-dd")+" 00:00:00";
			Date ldate = PublicUtils.UtilStrToDate(params.get_dnm_createtime()+" 23:59:59");
			Date curdate = PublicUtils.UtilStrToDate(stockdate);
			if(curdate.before(ldate)){
				this.setActionMessage("ֻ�ܲ�ѯ������ǰ������,[����ʱ��<=:]��ֵ����ȡ����!");
				return "salesmplist";
			}
		}
		
		
		DataPackage dp = snptbo.doQuerySalesSmplist(params);
		this.setDp(dp);
		}
		return "salesmplist";
	}
	
	/**
	 * �����ֵ��������ͳ��
	 * @return
	 * @throws Exception
	 */
	public String doSalecardlist() throws Exception{
		if (this.isQuery) {
		WaystocksnptDBParam params = (WaystocksnptDBParam) getParam();
		Waystocksnpt snptbo = (Waystocksnpt) BOFactory.build(WaystocksnptBO.class, getDBAccessUser());
		
		//ֻ�ܲ�ѯ������ǰ������
		
		if(StringUtils.isEmpty(params.get_dnm_createtime())){
			this.setActionMessage("����ʱ��<=:����Ϊ��!");
			return "salecardlist";
		}else{
			String stockdate = PublicUtils.formatUtilDate(new Date(),"yyyy-MM-dd")+" 00:00:00";
			Date ldate = PublicUtils.UtilStrToDate(params.get_dnm_createtime()+" 23:59:59");
			Date curdate = PublicUtils.UtilStrToDate(stockdate);
			if(curdate.before(ldate)){
				this.setActionMessage("ֻ�ܲ�ѯ������ǰ������,[����ʱ��<=:]��ֵ����ȡ����!");
				return "salecardlist";
			}
		}
		
		DataPackage dp = snptbo.doQuerySalesCardlist(params);
		this.setDp(dp);
		}
		return "salecardlist";
	}
	
	/**
	 * �����׿���������ϸ
	 * @return
	 * @throws Exception
	 */
	public String doSalerecordsmp() throws Exception{
		//Comressdetail
		//���¼��������Ǳ����
		//this.setParam(new ComressdetailDBParam());

        //ָ��VO��
        setClsVO(ComressdetailVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        //this.pkNameArray=new String[]{"seqid"};
		this.setClsControl(Comressdetail.class);
		//this.setClsQueryParam(ComressdetailDBParam.class) ;
		WaystocksnptDBParam params = (WaystocksnptDBParam) getParam();
//		ComressdetailDBParam params = (ComressdetailDBParam) getParam();
//		Waystocksnpt snptbo = (Waystocksnpt) BOFactory.build(WaystocksnptBO.class, getDBAccessUser());
		Comressdetail snptbo = (Comressdetail) BOFactory.build(ComressdetailBO.class, getDBAccessUser());
		String _se_comresid = params.get_se_comresid();
		if ((_se_comresid == null || "".equals(_se_comresid))
				&& StringUtils.isEmpty(params.get_dnl_stocktime())
				&& StringUtils.isEmpty(params.get_dnm_stocktime())) {
			String stockdate = PublicUtils.formatUtilDate(queryStockTime(),"yyyy-MM-dd")+" 00:00:00";
			String currdate = PublicUtils.formatUtilDate(queryStockTimeCurrent(),"yyyy-MM-dd")+" 23:59:59";
			params.set_dnl_stocktime(stockdate);
			params.set_dnm_stocktime(currdate);
		}
		if (this.isQuery){
			if (_se_comresid == null || "".equals(_se_comresid)) {
				Date ldate = new Date();
				Date mdate = new Date();
				SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd");
				ldate = myformat.parse(params.get_dnl_stocktime());
				mdate = myformat.parse(params.get_dnm_stocktime());
				Long day = (mdate.getTime() - ldate.getTime())/(1000*60*60*24);
				if(day>30){
					setActionMessage("����ʱ�������ܳ���30�졣");
					return "salerecordsmp";
				}else{
					params.set_dnl_stocktime(myformat.format(ldate)+" 00:00:00");
					params.set_dnm_stocktime(myformat.format(mdate)+" 23:59:59");
				}
			} else {
				params.set_dnl_stocktime(null);
				params.set_dnm_stocktime(null);
			}
//			DataPackage dp = snptbo.doQuerySalesSmpRecord(params);
			DataPackage dp = snptbo.doQuery(params);
			this.setDp(dp);
		}
		return "salerecordsmp";
	}
	
	/**
	 * �����ֵ����������ϸ
	 * @return
	 * @throws Exception
	 */
	public String doSalerecordcard() throws Exception{
		
		 //ָ��VO��
        setClsVO(ComrescarddetailVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
		this.setClsControl(Comrescarddetail.class);
		
		WaystocksnptDBParam params = (WaystocksnptDBParam) getParam();
		Comrescarddetail snptbo = (Comrescarddetail) BOFactory.build(ComrescarddetailBO.class, getDBAccessUser());
		String _se_comresid = params.get_se_comresid();
		if ((_se_comresid == null || "".equals(_se_comresid))
				&& StringUtils.isEmpty(params.get_dnl_stocktime())
				&& StringUtils.isEmpty(params.get_dnm_stocktime())) {
			String stockdate = PublicUtils.formatUtilDate(queryStockTime(),"yyyy-MM-dd")+" 00:00:00";
			String currdate = PublicUtils.formatUtilDate(queryStockTimeCurrent(),"yyyy-MM-dd")+" 23:59:59";
			params.set_dnl_stocktime(stockdate);
			params.set_dnm_stocktime(currdate);
		}
		if(this.isQuery){
			if (_se_comresid == null || "".equals(_se_comresid)) {
				Date ldate = new Date();
				Date mdate = new Date();
				SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd");
				ldate = myformat.parse(params.get_dnl_stocktime());
				mdate = myformat.parse(params.get_dnm_stocktime());
				Long day = (mdate.getTime() - ldate.getTime())/(1000*60*60*24);
				if(day>30){
					setActionMessage("����ʱ�������ܳ���30�졣");
					return "salerecordcard";
				}else{
					params.set_dnl_stocktime(myformat.format(ldate)+" 00:00:00");
					params.set_dnm_stocktime(myformat.format(mdate)+" 23:59:59");
				}
			} else {
				params.set_dnl_stocktime(null);
				params.set_dnm_stocktime(null);
			}
//			DataPackage dp = snptbo.doQuerySalesCardRecord(params);
			DataPackage dp = snptbo.doQuery(params);
			this.setDp(dp);
		}
		return "salerecordcard";
	}
	/**
	 * �����׿�����ͳ��LIST
	 * @return
	 * @throws Exception
	 */
	public String doActivelistsmplist() throws Exception{
		//if (this.isQuery) {
		WaystocksnptDBParam params = (WaystocksnptDBParam) getParam(); 
		if(StringUtils.isEmpty(params.get_dnl_acttime())&&StringUtils.isEmpty(params.get_dnm_acttime())){
			String stockdate = PublicUtils.formatUtilDate(queryStockTime(),"yyyy-MM-dd")+" 00:00:00";
			String currdate = PublicUtils.formatUtilDate(queryStockTimeCurrent(),"yyyy-MM-dd")+" 23:59:59";
			params.set_dnl_acttime(stockdate);
			params.set_dnm_acttime(currdate);
		}  
		//}
		return "activesmplist";
	}
	
	/**
	 * �����׿�����ͳ��
	 * @return
	 * @throws Exception
	 */
	public String doActivelistsmp() throws Exception{
		WaystocksnptDBParam params = (WaystocksnptDBParam) getParam();
		Waystocksnpt snptbo = (Waystocksnpt) BOFactory.build(WaystocksnptBO.class, getDBAccessUser());  
		Date ldate = new Date();
		Date mdate = new Date();
		SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd"); 
		ldate = myformat.parse(params.get_dnl_acttime());
		mdate = myformat.parse(params.get_dnm_acttime());
		Long day = (mdate.getTime() - ldate.getTime())/(1000*60*60*24);
		if(StringUtils.isEmpty(params.get_dnl_acttime()) || StringUtils.isEmpty(params.get_dnm_acttime())){ 
			setActionMessage("����ʱ�������ܳ���30���Ҳ���Ϊ��"); 
			return "activesmplist";
			
		}else if (day<0){
			setActionMessage("����ʱ�������ڿ�ʼʱ��");
			return "activesmplist";
			
		}else { 
			
		if(day>30){
			setActionMessage("����ʱ�������ܳ���30��");
			return "activesmplist";
		}else{
				String stockdate = PublicUtils.formatUtilDate(new Date(),"yyyy-MM-dd")+" 00:00:00";
				Date lldate = PublicUtils.UtilStrToDate(params.get_dnm_acttime());
				Date curdate = PublicUtils.UtilStrToDate(stockdate);
				if(curdate.before(lldate)){
					this.setActionMessage("ֻ�ܲ�ѯ������ǰ������,[����ʱ��<=:]��ֵ����ȡ����!");
					return "activesmplist";
				}else{
					params.set_dnm_acttime(myformat.format(mdate)+" 23:59:59");
				}
					params.set_dnl_acttime(myformat.format(ldate)+" 00:00:00");
		}
		}
		DataPackage dp = snptbo.doQueryActiveSmpList(params);  
		this.setDp(dp);
		return "activesmplist";
	}
	
	/**
	 * �����׿�����ͳ��2---���ڵ���
	 * @return
	 * @throws Exception
	 */
	public String doActivelistsmp2() throws Exception{
		WaystocksnptDBParam params = (WaystocksnptDBParam) getParam();
		Waystocksnpt snptbo = (Waystocksnpt) BOFactory.build(WaystocksnptBO.class, getDBAccessUser());
		DataPackage dp = snptbo.doQueryActiveSmpList2(params);
		this.setDp(dp);
		return "activesmplist";
	}
	
	/**
	 * �����׿�������ϸ
	 * @return
	 * @throws Exception
	 */
	public String doActivesmprecord() throws Exception{
		 //ָ��VO��
        setClsVO(ActivedetailVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
		this.setClsControl(Activedetail.class);
		
		WaystocksnptDBParam params = (WaystocksnptDBParam) getParam();
		Activedetail snptbo = (Activedetail) BOFactory.build(ActivedetailBO.class, getDBAccessUser());
		String _se_comresid = params.get_se_comresid();
		if ((_se_comresid == null || "".equals(_se_comresid))
				&& StringUtils.isEmpty(params.get_dnl_acttime())
				&& StringUtils.isEmpty(params.get_dnm_acttime())) {
			String stockdate = PublicUtils.formatUtilDate(queryStockTime(),"yyyy-MM-dd")+" 00:00:00";
			String currdate = PublicUtils.formatUtilDate(queryStockTimeCurrent(),"yyyy-MM-dd")+" 23:59:59";
			params.set_dnl_acttime(stockdate);
			params.set_dnm_acttime(currdate);
		}
		if (this.isQuery){
			if (_se_comresid == null || "".equals(_se_comresid)) {
				Date ldate = new Date();
				Date mdate = new Date();
				SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd");
				ldate = myformat.parse(params.get_dnl_acttime());
				mdate = myformat.parse(params.get_dnm_acttime());
				Long day = (mdate.getTime() - ldate.getTime())/(1000*60*60*24);
				if(day>30){
					setActionMessage("����ʱ�������ܳ���30�졣");
					return "activerecordsmp";
				}else{
					params.set_dnl_acttime(myformat.format(ldate)+" 00:00:00");
					params.set_dnm_acttime(myformat.format(mdate)+" 23:59:59");
				}
			} else {
				params.set_dnl_acttime(null);
				params.set_dnm_acttime(null);
			}
//			DataPackage dp = snptbo.doQueryActiveSmpRecord(params);
			DataPackage dp = snptbo.doQuery(params);
			this.setDp(dp);
		}
		return "activerecordsmp";
	}
	
	/**
	 * ����հ�SIM��������ͳ��
	 * @return
	 * @throws Exception
	 */
	public String doSalestatistic() throws Exception {
		WaystocksnptDBParam params = (WaystocksnptDBParam) getParam();
		if (this.isQuery) {
			Waystocksnpt snptbo = (Waystocksnpt) BOFactory.build(WaystocksnptBO.class, getDBAccessUser());
			DataPackage dp = snptbo.doQuerySaleStatistic(params);
			this.setDp(dp);
		} else {
			params.set_dnm_createtime(PublicUtils.formatUtilDate(new Date(), "yyyy-MM-dd"));
		}
		return "salestatistic";
	}
	
	/**
	 * ����հ�SIM����������ϸ
	 * @return
	 * @throws Exception
	 */
	public String doSalerecord() throws Exception {
		WaystocksnptDBParam params = (WaystocksnptDBParam) getParam();
		if (this.isQuery) {
			setClsVO(SWaystocksnptVO.class);
			Waystocksnpt snptbo = (Waystocksnpt) BOFactory.build(WaystocksnptBO.class, getDBAccessUser());
			DataPackage dp = snptbo.doQuerySaleRecord(params);
			this.setDp(dp);
		} else {
			params.set_dnm_stocktime(PublicUtils.formatUtilDate(new Date(), "yyyy-MM-dd"));
		}
		return "salerecord";
	}
	
	/**
	 * ����հ�SIM��ʹ����ͳ��
	 * @return
	 * @throws Exception
	 */
	public String doUsedstatistic() throws Exception {
		WaystocksnptDBParam params = (WaystocksnptDBParam) getParam();
		if (this.isQuery) {
			Waystocksnpt snptbo = (Waystocksnpt) BOFactory.build(WaystocksnptBO.class, getDBAccessUser());
			DataPackage dp = snptbo.doQueryUsedStatistic(params);
			this.setDp(dp);
		} else {
			params.set_dnm_changetime(PublicUtils.formatUtilDate(new Date(), "yyyy-MM-dd"));
		}
		return "usedstatistic";
	}
	
	/**
	 * ����հ�SIM��ʹ������ϸ
	 * @return
	 * @throws Exception
	 */
	public String doUsedrecord() throws Exception {
		WaystocksnptDBParam params = (WaystocksnptDBParam) getParam();
		if (this.isQuery) {
			setClsVO(SWaystocksnptVO.class);
			Waystocksnpt snptbo = (Waystocksnpt) BOFactory.build(WaystocksnptBO.class, getDBAccessUser());
			DataPackage dp = snptbo.doQueryUsedRecord(params);
			this.setDp(dp);
		} else {
			params.set_dnm_changetime(PublicUtils.formatUtilDate(new Date(), "yyyy-MM-dd"));
		}
		return "usedrecord";
	}
	
	/**
	 * �����׿����ͳ��EXCEL����
	 * @return
	 * @throws Exception
	 */
	public String doExportstocksmplist() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("������ͳ��");
		export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
		export.appendHeadLine(new String[] { "����ʱ��", format.format(new Date()) });
		export.addOutputProperty("countyid", "�ֹ�˾", CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("svccode","������������", CommonExportBean.CODE2NAME,"#SERVCENT");
		export.addOutputProperty("mareacode", "΢����", CommonExportBean.CODE2NAME, "#MICROAREA");
		export.addOutputProperty("orderid","��������");
		export.addOutputProperty("wayid", "�������");
		export.addOutputProperty("wayname", "��������");
		export.addOutputProperty("starlevel","�Ǽ�", CommonExportBean.CODE2NAME,"$CH_STARLEVEL");
		
		WaystocksnptDBParam params = (WaystocksnptDBParam) getParam();
		String _se_restype = params.get_se_restype();
		if("COMRESSMP".equals(_se_restype)){
			export.addOutputProperty("brand", "Ʒ��", CommonExportBean.CODE2NAME, "$FX_SMPBRAND");
		}else{
			
		}
		
		export.addOutputProperty("comcategory","��Ʒ����", CommonExportBean.CODE2NAME,"$IM_FXCOMCATEGORY");
		export.addOutputProperty("stocknum","�������");
		export.addOutputProperty("stocktime","���ʱ��",export.DATE,
				"yyyy-MM-dd");
		
		// ����VO��
		export.voClassArray = new Class[] { WaystocksnptVO.class };
		
		// ���ò�ѯ����
		export.queryMethodName = "doStocklistsmp";
		params.setQueryAll(true);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
	
	/**
	 * �����׿����ͳ��TXT����
	 * @return
	 * @throws Exception
	 */
	public String doExportstocksmplistTxt() throws Exception {
		// TODO coding...
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		export.setFileName("������ͳ��");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//		export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
//		export.appendHeadLine(new String[] { "����ʱ��", format.format(new Date()) });
		export.addOutputProperty("countyid", "�ֹ�˾", CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("svccode","������������", CommonExportBean.CODE2NAME,"#SERVCENT");
		export.addOutputProperty("mareacode", "΢����", CommonExportBean.CODE2NAME, "#MICROAREA");
		export.addOutputProperty("orderid","��������");
		export.addOutputProperty("wayid", "�������");
		export.addOutputProperty("wayname", "��������");
		export.addOutputProperty("starlevel","�Ǽ�", CommonExportBean.CODE2NAME,"$CH_STARLEVEL");
		
		WaystocksnptDBParam params = (WaystocksnptDBParam) getParam();
		String _se_restype = params.get_se_restype();
		if("COMRESSMP".equals(_se_restype)){
			export.addOutputProperty("brand", "Ʒ��", CommonExportBean.CODE2NAME, "$FX_SMPBRAND");
		}else{
			
		}
		
		export.addOutputProperty("comcategory","��Ʒ����", CommonExportBean.CODE2NAME,"$IM_FXCOMCATEGORY");
		export.addOutputProperty("stocknum","�������");
		export.addOutputProperty("stocktime","���ʱ��",export.DATE,
				"yyyy-MM-dd");
		
		// ����VO��
		export.voClassArray = new Class[] { WaystocksnptVO.class };
		
		// ���ò�ѯ����
		export.queryMethodName = "doStocklistsmp";

		prepareResponse(export.getFileName());
		getParam().set_pagesize("0");
		if("COMRESSMP".equals(_se_restype)){
			export.writeTxtTitle(getResponse().getOutputStream(), new String[] {
				 "�ֹ�˾", "������������", "΢����", "��������" ,"�������","��������","�Ǽ�","Ʒ��","��Ʒ����","�������","���ʱ��"});
		}else {
			export.writeTxtTitle(getResponse().getOutputStream(), new String[] {
				 "�ֹ�˾", "������������", "΢����", "��������" ,"�������","��������","�Ǽ�","��Ʒ����","�������","���ʱ��"});
		}
		super.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
		return null;
	}
	
	/**
	 * �����׿������ϸEXCEL����
	 * @return
	 * @throws Exception
	 */
	public String doExportstocksmprecord() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("�����׿������ϸ");
		export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
		export.appendHeadLine(new String[] { "����ʱ��", format.format(new Date()) });
		export.addOutputProperty("comresid","�׿�����");
		export.addOutputProperty("stocktime","����ʱ��",export.DATE,
				"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("countyid", "�ֹ�˾", CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("svccode","������������", CommonExportBean.CODE2NAME,"#SERVCENT");		
		
		export.addOutputProperty("mareacode", "΢����", CommonExportBean.CODE2NAME, "#MICROAREA");
		export.addOutputProperty("orderid","��������");
		export.addOutputProperty("wayid", "�������");
		export.addOutputProperty("wayname", "��������");
		export.addOutputProperty("starlevel","�Ǽ�", CommonExportBean.CODE2NAME,"$CH_STARLEVEL");
		export.addOutputProperty("brand", "Ʒ��", CommonExportBean.CODE2NAME, "$FX_SMPBRAND");
		export.addOutputProperty("comcategory","��Ʒ����", CommonExportBean.CODE2NAME,"$IM_FXCOMCATEGORY");
		
		// ����VO��
		export.voClassArray = new Class[] { RWaystocksnptVO.class };
		
		// ���ò�ѯ����
		export.queryMethodName = "doStockrecordsmp";
		WaystocksnptDBParam params = (WaystocksnptDBParam) getParam();
		params.setQueryAll(true);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
	
	/**
	 * �����ֵ�����ͳ��EXCEL����
	 * @return
	 * @throws Exception
	 */
	public String doExportstocklistcard() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("�����ֵ�����ͳ��");
		export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
		export.appendHeadLine(new String[] { "����ʱ��", format.format(new Date()) });		
		export.addOutputProperty("countyid", "�ֹ�˾", CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("svccode","������������", CommonExportBean.CODE2NAME,"#SERVCENT");
		export.addOutputProperty("mareacode", "΢����", CommonExportBean.CODE2NAME, "#MICROAREA");
		export.addOutputProperty("orderid","��������");
		export.addOutputProperty("wayid", "�������");
		export.addOutputProperty("wayname", "��������");
		export.addOutputProperty("starlevel","�Ǽ�", CommonExportBean.CODE2NAME,"$CH_STARLEVEL");
		export.addOutputProperty("comcategory","��Ʒ����", CommonExportBean.CODE2NAME,"$IM_FXCOMCATEGORY");
		export.addOutputProperty("stocknum","�������");
		export.addOutputProperty("stocktime","���ʱ��",export.DATE,
				"yyyy-MM-dd");
		
		// ����VO��
		export.voClassArray = new Class[] { WaystocksnptVO.class };
		
		// ���ò�ѯ����
		export.queryMethodName = "doStocklistcard";
		WaystocksnptDBParam params = (WaystocksnptDBParam) getParam();
		params.setQueryAll(true);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
	
	/**
	 * �����ֵ�������ϸEXCEL����
	 * @return
	 * @throws Exception
	 */
	public String doExportstockcardrecord() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("�����ֵ�������ϸ");
		export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
		export.appendHeadLine(new String[] { "����ʱ��", format.format(new Date()) });
		export.addOutputProperty("comresid","�׿�����");
		export.addOutputProperty("stocktime","����ʱ��",export.DATE,
				"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("countyid", "�ֹ�˾", CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("svccode","������������", CommonExportBean.CODE2NAME,"#SERVCENT");		
		
		export.addOutputProperty("mareacode", "΢����", CommonExportBean.CODE2NAME, "#MICROAREA");
		export.addOutputProperty("orderid","��������");
		export.addOutputProperty("wayid", "�������");
		export.addOutputProperty("wayname", "��������");
		export.addOutputProperty("starlevel","�Ǽ�", CommonExportBean.CODE2NAME,"$CH_STARLEVEL");
		export.addOutputProperty("comcategory","��Ʒ����", CommonExportBean.CODE2NAME,"$IM_FXCOMCATEGORY");
		
		// ����VO��
		export.voClassArray = new Class[] { RWaystocksnptVO.class };
		
		// ���ò�ѯ����
		export.queryMethodName = "doStockrecordcard";
		WaystocksnptDBParam params = (WaystocksnptDBParam) getParam();
		params.setQueryAll(true);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
	
	/**
	 * �����׿�������ͳ��
	 * @return
	 * @throws Exception
	 */
	public String doExportsalelistsmp() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("�����׿�������ͳ��");
		export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
		export.appendHeadLine(new String[] { "����ʱ��", format.format(new Date()) });		
		export.addOutputProperty("countyid", "�ֹ�˾", CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("svccode","������������", CommonExportBean.CODE2NAME,"#SERVCENT");
		export.addOutputProperty("mareacode", "΢����", CommonExportBean.CODE2NAME, "#MICROAREA");
		export.addOutputProperty("wayid", "�������");
		export.addOutputProperty("wayname", "��������");
		export.addOutputProperty("starlevel","�Ǽ�", CommonExportBean.CODE2NAME,"$CH_STARLEVEL");
		export.addOutputProperty("brand", "Ʒ��", CommonExportBean.CODE2NAME, "$FX_SMPBRAND");		
		export.addOutputProperty("comcategory","��Ʒ����", CommonExportBean.CODE2NAME,"$IM_FXCOMCATEGORY");
		export.addOutputProperty("stocknum","��������");
		export.addOutputProperty("upperwayid","�ϼ�����",CommonExportBean.CODE2NAME,"#WAY");
		export.addOutputProperty("waymagcode","������������");
		
		// ����VO��
		export.voClassArray = new Class[] { SWaystocksnptVO.class };
		
		// ���ò�ѯ����
		export.queryMethodName = "doSalesmplist";
		WaystocksnptDBParam params = (WaystocksnptDBParam) getParam();
		params.setQueryAll(true);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
	
	
	/**
	 * �����׿�������ͳ�Ƶ���Txt
	 * @return
	 * @throws Exception
	 */
	public String doExportsalelistsmpTxt() throws Exception {
		this.getRequest().getSession().setAttribute("currenttime", System.currentTimeMillis());
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		export.setFileName("�����׿�������ͳ��");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//		export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
//		export.appendHeadLine(new String[] { "����ʱ��", format.format(new Date()) });		
		export.addOutputProperty("countyid", "�ֹ�˾", CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("svccode","������������", CommonExportBean.CODE2NAME,"#SERVCENT");
		export.addOutputProperty("mareacode", "΢����", CommonExportBean.CODE2NAME, "#MICROAREA");
		export.addOutputProperty("wayid", "�������");
		export.addOutputProperty("wayname", "��������");
		export.addOutputProperty("starlevel","�Ǽ�", CommonExportBean.CODE2NAME,"$CH_STARLEVEL");
		export.addOutputProperty("brand", "Ʒ��", CommonExportBean.CODE2NAME, "$FX_SMPBRAND");		
		export.addOutputProperty("comcategory","��Ʒ����", CommonExportBean.CODE2NAME,"$IM_FXCOMCATEGORY");
		export.addOutputProperty("stocknum","��������");
		export.addOutputProperty("upperwayid","�ϼ�����",CommonExportBean.CODE2NAME,"#WAY");
		export.addOutputProperty("waymagcode","������������");
		
		// ����VO��
		export.voClassArray = new Class[] { SWaystocksnptVO.class };
		
		// ���ò�ѯ����
		export.queryMethodName = "doSalesmplist";

		prepareResponse(export.getFileName());
		getParam().set_pagesize("0");
		export.writeTxtTitle(getResponse().getOutputStream(), new String[] {
				"�ֹ�˾", "������������", "΢����", "�������" ,"��������","�Ǽ�","Ʒ��","��Ʒ����","��������","�ϼ�����","������������"});
		super.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
		
		return null;
	}
	
	/**
	 * �����׿���������ϸEXCEL����
	 * @return
	 * @throws Exception
	 */
	public String doExportsalesmprecord() throws Exception {
		 //ָ��VO��
        setClsVO(ComressdetailVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
		this.setClsControl(Comressdetail.class);
		
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("�����׿���������ϸ");
		export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
		export.appendHeadLine(new String[] { "����ʱ��", format.format(new Date()) });
		export.addOutputProperty("comresid","�׿�����");
		export.addOutputProperty("stocktime","����ʱ��",export.DATE,
				"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("countyid", "�ֹ�˾", CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("svccode","������������", CommonExportBean.CODE2NAME,"#SERVCENT");		
		
		export.addOutputProperty("mareacode", "΢����", CommonExportBean.CODE2NAME, "#MICROAREA");
		export.addOutputProperty("orderid","��������");
		export.addOutputProperty("wayid", "�������");
		export.addOutputProperty("wayname", "��������");
		export.addOutputProperty("starlevel","�Ǽ�", CommonExportBean.CODE2NAME,"$CH_STARLEVEL");
		export.addOutputProperty("brand", "Ʒ��", CommonExportBean.CODE2NAME, "$FX_SMPBRAND");
		export.addOutputProperty("comcategory","��Ʒ����", CommonExportBean.CODE2NAME,"$IM_FXCOMCATEGORY");
		export.addOutputProperty("iccid","SIM����");
		export.addOutputProperty("upperwayid","�ϼ�����",CommonExportBean.CODE2NAME,"#WAY");
		export.addOutputProperty("waymagcode","������������");
		// ����VO��
//		export.voClassArray = new Class[] { RWaystocksnptVO.class };
		export.voClassArray = new Class[] { ComressdetailVO.class };
		
		// ���ò�ѯ����
		export.queryMethodName = "doSalerecordsmp";
		WaystocksnptDBParam params = (WaystocksnptDBParam) getParam();
		params.setQueryAll(true);
		params.set_pagesize("10000");
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
	
	
	
	/**
	 * �����׿���������ϸTxt����
	 * @return
	 * @throws Exception
	 */
	public String doExportsalesmprecordTxt() throws Exception {

		User user = (User) getDBAccessUser();
				CommonExportBean export = new CommonExportBean(user);
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				export.setFileName("�����׿���������ϸ");
//				export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
//				export.appendHeadLine(new String[] { "����ʱ��", format.format(new Date()) });
				export.addOutputProperty("comresid","�׿�����");
				export.addOutputProperty("stocktime","����ʱ��",export.DATE,
						"yyyy-MM-dd HH:mm:ss");
				export.addOutputProperty("countyid", "�ֹ�˾", CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
				export.addOutputProperty("svccode","������������", CommonExportBean.CODE2NAME,"#SERVCENT");		
				
				export.addOutputProperty("mareacode", "΢����", CommonExportBean.CODE2NAME, "#MICROAREA");
				export.addOutputProperty("orderid","��������");
				export.addOutputProperty("wayid", "�������");
				export.addOutputProperty("wayname", "��������");
				export.addOutputProperty("starlevel","�Ǽ�", CommonExportBean.CODE2NAME,"$CH_STARLEVEL");
				export.addOutputProperty("brand", "Ʒ��", CommonExportBean.CODE2NAME, "$FX_SMPBRAND");
				export.addOutputProperty("comcategory","��Ʒ����", CommonExportBean.CODE2NAME,"$IM_FXCOMCATEGORY");
				export.addOutputProperty("iccid","SIM����");
				export.addOutputProperty("upperwayid","�ϼ�����",CommonExportBean.CODE2NAME,"#WAY");
				export.addOutputProperty("waymagcode","������������");
				// ����VO��
				//export.voClassArray = new Class[] { RWaystocksnptVO.class };
				export.voClassArray = new Class[] { ComressdetailVO.class };
				
				// ���ò�ѯ����
				export.queryMethodName = "doSalerecordsmp";

				prepareResponse(export.getFileName());
				getParam().set_pagesize("0");
				export.writeTxtTitle(getResponse().getOutputStream(), new String[] {
						"�׿�����", "����ʱ��","�ֹ�˾","������������","΢����","��������","�������","��������","�Ǽ�","Ʒ��","��Ʒ����","SIM����","�ϼ�����","��������"});
				super.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
				return null;

	}
	
	
	
	
	/**
	 * �����ֵ��������ͳ��EXCEL����
	 * @return
	 * @throws Exception
	 */
	public String doExportsalelistcard() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("�����ֵ��������ͳ��");
		export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
		export.appendHeadLine(new String[] { "����ʱ��", format.format(new Date()) });		
		export.addOutputProperty("countyid", "�ֹ�˾", CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("svccode","������������", CommonExportBean.CODE2NAME,"#SERVCENT");
		export.addOutputProperty("mareacode", "΢����", CommonExportBean.CODE2NAME, "#MICROAREA");
		export.addOutputProperty("wayid", "�������");
		export.addOutputProperty("wayname", "��������");
		export.addOutputProperty("starlevel","�Ǽ�", CommonExportBean.CODE2NAME,"$CH_STARLEVEL");
		export.addOutputProperty("comcategory","��Ʒ����", CommonExportBean.CODE2NAME,"$IM_FXCOMCATEGORY");
		export.addOutputProperty("stocknum","��������");
		
		// ����VO��
		export.voClassArray = new Class[] { SWaystocksnptVO.class };
		
		// ���ò�ѯ����
		export.queryMethodName = "doSalecardlist";
		WaystocksnptDBParam params = (WaystocksnptDBParam) getParam();
		params.setQueryAll(true);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
	
	
	/**
	 * �����ֵ��������ͳ��Txt����
	 * @return
	 * @throws Exception
	 */
	public String doExportsalelistcardTxt() throws Exception {
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("�����ֵ��������ͳ��");
//		export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
//		export.appendHeadLine(new String[] { "����ʱ��", format.format(new Date()) });		
		export.addOutputProperty("countyid", "�ֹ�˾", CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("svccode","������������", CommonExportBean.CODE2NAME,"#SERVCENT");
		export.addOutputProperty("mareacode", "΢����", CommonExportBean.CODE2NAME, "#MICROAREA");
		export.addOutputProperty("wayid", "�������");
		export.addOutputProperty("wayname", "��������");
		export.addOutputProperty("starlevel","�Ǽ�", CommonExportBean.CODE2NAME,"$CH_STARLEVEL");
		export.addOutputProperty("comcategory","��Ʒ����", CommonExportBean.CODE2NAME,"$IM_FXCOMCATEGORY");
		export.addOutputProperty("stocknum","��������");
		
		// ����VO��
		export.voClassArray = new Class[] { SWaystocksnptVO.class };
		
		// ���ò�ѯ����
		export.queryMethodName = "doSalecardlist";

		prepareResponse(export.getFileName());
		getParam().set_pagesize("0");
		export.writeTxtTitle(getResponse().getOutputStream(), new String[] {
				"�ֹ�˾", "������������", "΢����", "�������" ,"��������","�Ǽ�","��Ʒ����","��������"});
		super.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
		return null;
	}
	
	/**
	 * �����ֵ��������ϸEXCEL����
	 * @return
	 * @throws Exception
	 */
	public String doExportsalecardrecord() throws Exception {
		
		 //ָ��VO��
        setClsVO(ComrescarddetailVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
		this.setClsControl(Comrescarddetail.class);
		
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("�����ֵ����������ϸ");
		export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
		export.appendHeadLine(new String[] { "����ʱ��", format.format(new Date()) });
		export.addOutputProperty("comresid","�׿�����");
		export.addOutputProperty("stocktime","����ʱ��",export.DATE,
				"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("countyid", "�ֹ�˾", CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("svccode","������������", CommonExportBean.CODE2NAME,"#SERVCENT");		
		
		export.addOutputProperty("mareacode", "΢����", CommonExportBean.CODE2NAME, "#MICROAREA");
		export.addOutputProperty("orderid","��������");
		export.addOutputProperty("wayid", "�������");
		export.addOutputProperty("wayname", "��������");
		export.addOutputProperty("starlevel","�Ǽ�", CommonExportBean.CODE2NAME,"$CH_STARLEVEL");
		export.addOutputProperty("comcategory","��Ʒ����", CommonExportBean.CODE2NAME,"$IM_FXCOMCATEGORY");
		
		// ����VO��
//		export.voClassArray = new Class[] { RWaystocksnptVO.class };
		export.voClassArray = new Class[] { ComrescarddetailVO.class };
		
		// ���ò�ѯ����
		export.queryMethodName = "doSalerecordcard";
		WaystocksnptDBParam params = (WaystocksnptDBParam) getParam();
		params.setQueryAll(true);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
	
	
	
	/**
	 * �����ֵ��������ϸTxt����
	 * @return
	 * @throws Exception
	 */
	public String doExportsalecardrecordTxt() throws Exception {
		 //ָ��VO��
        setClsVO(ComrescarddetailVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
		this.setClsControl(Comrescarddetail.class);
		
		User user = (User) getDBAccessUser();
				CommonExportBean export = new CommonExportBean(user);
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				export.setFileName("�����ֵ����������ϸ");
//				export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
//				export.appendHeadLine(new String[] { "����ʱ��", format.format(new Date()) });
				export.addOutputProperty("comresid","�׿�����");
				export.addOutputProperty("stocktime","����ʱ��",export.DATE,
						"yyyy-MM-dd HH:mm:ss");
				export.addOutputProperty("countyid", "�ֹ�˾", CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
				export.addOutputProperty("svccode","������������", CommonExportBean.CODE2NAME,"#SERVCENT");		
				
				export.addOutputProperty("mareacode", "΢����", CommonExportBean.CODE2NAME, "#MICROAREA");
				export.addOutputProperty("orderid","��������");
				export.addOutputProperty("wayid", "�������");
				export.addOutputProperty("wayname", "��������");
				export.addOutputProperty("starlevel","�Ǽ�", CommonExportBean.CODE2NAME,"$CH_STARLEVEL");
				export.addOutputProperty("comcategory","��Ʒ����", CommonExportBean.CODE2NAME,"$IM_FXCOMCATEGORY");
				
				// ����VO��
				export.voClassArray = new Class[] { ComrescarddetailVO.class };
				
				// ���ò�ѯ����
				export.queryMethodName = "doSalerecordcard";

				prepareResponse(export.getFileName());
				getParam().set_pagesize("0");
				export.writeTxtTitle(getResponse().getOutputStream(), new String[] {
						"�׿�����", "����ʱ��",  "�ֹ�˾" ,"������������","΢����","��������","�������","��������","�Ǽ�","��Ʒ����"});
				super.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
				return null;
	}
	
	
	
	/**
	 * �����׿�������ͳ��EXCEL����
	 * @return
	 * @throws Exception
	 */
	public String doExportactivesmplist() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("�����׿�������ͳ��");
		export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
		export.appendHeadLine(new String[] { "����ʱ��", format.format(new Date()) });
		export.addOutputProperty("countyid", "�ֹ�˾", CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("svccode","������������", CommonExportBean.CODE2NAME,"#SERVCENT");
		export.addOutputProperty("mareacode", "΢����", CommonExportBean.CODE2NAME, "#MICROAREA");
		export.addOutputProperty("wayid", "�������");
		export.addOutputProperty("wayname", "��������");
		export.addOutputProperty("starlevel","�Ǽ�", CommonExportBean.CODE2NAME,"$CH_STARLEVEL");
		export.addOutputProperty("brand", "Ʒ��", CommonExportBean.CODE2NAME, "$FX_SMPBRAND");
		export.addOutputProperty("comcategory","��Ʒ����", CommonExportBean.CODE2NAME,"$IM_FXCOMCATEGORY");
		export.addOutputProperty("stocknum","��������");
		export.addOutputProperty("actrate", "������", CommonExportBean.RATE,"0.00");
		export.addOutputProperty("upperwayid","�ϼ�����",CommonExportBean.CODE2NAME,"#WAY");
		// ����VO��
		export.voClassArray = new Class[] { SWaystocksnptVO.class };
		
		// ���ò�ѯ����
		export.queryMethodName = "doActivelistsmp2";
		WaystocksnptDBParam params = (WaystocksnptDBParam) getParam();
		params.setQueryAll(true);
		params.set_pagesize("0");
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
	
	/**
	 * �����׿�������ͳ��Txt����
	 * @return
	 * @throws Exception
	 */
	public String doExportactivesmplistTxt() throws Exception {
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("�����׿�������ͳ��");
//		export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
//		export.appendHeadLine(new String[] { "����ʱ��", format.format(new Date()) });
		export.addOutputProperty("countyid", "�ֹ�˾", CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("svccode","������������", CommonExportBean.CODE2NAME,"#SERVCENT");
		export.addOutputProperty("mareacode", "΢����", CommonExportBean.CODE2NAME, "#MICROAREA");
		export.addOutputProperty("wayid", "�������");
		export.addOutputProperty("wayname", "��������");
		export.addOutputProperty("starlevel","�Ǽ�", CommonExportBean.CODE2NAME,"$CH_STARLEVEL");
		export.addOutputProperty("brand", "Ʒ��", CommonExportBean.CODE2NAME, "$FX_SMPBRAND");
		export.addOutputProperty("comcategory","��Ʒ����", CommonExportBean.CODE2NAME,"$IM_FXCOMCATEGORY");
		export.addOutputProperty("stocknum","��������");
		export.addOutputProperty("actrate", "������", CommonExportBean.RATE,"0.00");
		export.addOutputProperty("upperwayid","�ϼ�����",CommonExportBean.CODE2NAME,"#WAY");
		// ����VO��
		export.voClassArray = new Class[] { SWaystocksnptVO.class };
		
		// ���ò�ѯ����
		export.queryMethodName = "doActivelistsmp2";

		prepareResponse(export.getFileName());
		getParam().set_pagesize("0");
		export.writeTxtTitle(getResponse().getOutputStream(), new String[] {
				"�ֹ�˾", "������������", "΢����", "�������" ,"��������","�Ǽ�","Ʒ��","��Ʒ����","��������","������","�ϼ�����"});
		super.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
		return null;
	}
	
	
	
	/**
	 * �����׿���������ϸEXCEL����
	 * @return
	 * @throws Exception
	 */
	public String doExportactivesmprecord() throws Exception {
		 //ָ��VO��
        setClsVO(ActivedetailVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
		this.setClsControl(Activedetail.class);
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("�����׿���������ϸ");
		export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
		export.appendHeadLine(new String[] { "����ʱ��", format.format(new Date()) });
		export.addOutputProperty("comresid","��Ʒ��Դ���");
		export.addOutputProperty("acttime","����ʱ��",export.DATE,
				"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("countyid", "�ֹ�˾", CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("svccode","������������", CommonExportBean.CODE2NAME,"#SERVCENT");		
		
		export.addOutputProperty("mareacode", "΢����", CommonExportBean.CODE2NAME, "#MICROAREA");
		export.addOutputProperty("orderid","��������");
		export.addOutputProperty("wayid", "�������");
		export.addOutputProperty("wayname", "��������");
		export.addOutputProperty("starlevel","�Ǽ�", CommonExportBean.CODE2NAME,"$CH_STARLEVEL");
		export.addOutputProperty("brand", "Ʒ��", CommonExportBean.CODE2NAME, "$FX_SMPBRAND");
		export.addOutputProperty("comcategory","��Ʒ����", CommonExportBean.CODE2NAME,"$IM_FXCOMCATEGORY");
		export.addOutputProperty("upperwayid","�ϼ�����",CommonExportBean.CODE2NAME,"#WAY");
		
		// ����VO��
		export.voClassArray = new Class[] { ActivedetailVO.class };
		
		// ���ò�ѯ����
		export.queryMethodName = "doActivesmprecord";
		WaystocksnptDBParam params = (WaystocksnptDBParam) getParam();
		params.setQueryAll(true);
		params.set_pagesize("10000");
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
	
	
	/**
	 * �����׿���������ϸTxt����
	 * @return
	 * @throws Exception
	 */
	public String doExportactivesmprecordTxt() throws Exception {
		 //ָ��VO��
        setClsVO(ActivedetailVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
		this.setClsControl(Activedetail.class);
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("�����׿���������ϸ");
//		export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
//		export.appendHeadLine(new String[] { "����ʱ��", format.format(new Date()) });
		export.addOutputProperty("comresid","��Ʒ��Դ���");
		export.addOutputProperty("acttime","����ʱ��",export.DATE,
				"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("countyid", "�ֹ�˾", CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("svccode","������������", CommonExportBean.CODE2NAME,"#SERVCENT");		
		
		export.addOutputProperty("mareacode", "΢����", CommonExportBean.CODE2NAME, "#MICROAREA");
		export.addOutputProperty("orderid","��������");
		export.addOutputProperty("wayid", "�������");
		export.addOutputProperty("wayname", "��������");
		export.addOutputProperty("starlevel","�Ǽ�", CommonExportBean.CODE2NAME,"$CH_STARLEVEL");
		export.addOutputProperty("brand", "Ʒ��", CommonExportBean.CODE2NAME, "$FX_SMPBRAND");
		export.addOutputProperty("comcategory","��Ʒ����", CommonExportBean.CODE2NAME,"$IM_FXCOMCATEGORY");
		export.addOutputProperty("upperwayid","�ϼ�����",CommonExportBean.CODE2NAME,"#WAY");
		
		// ����VO��
		export.voClassArray = new Class[] { ActivedetailVO.class };
		
		// ���ò�ѯ����
		export.queryMethodName = "doActivesmprecord";

		prepareResponse(export.getFileName());
		getParam().set_pagesize("0");
		export.writeTxtTitle(getResponse().getOutputStream(), new String[] {
				"��Ʒ��Դ���", "����ʱ��", "�ֹ�˾" ,"������������","΢����","��������","�������","��������","�Ǽ�","Ʒ��","��Ʒ����","�ϼ�����"});
		super.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
		return null;
	}
	
	/**
	 * ����հ�SIM��������ͳ�Ƶ���Excel
	 * @return
	 * @throws Exception
	 */
	public String doExportsalestatistic() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("����հ�SIM��������ͳ��");
		export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
		export.appendHeadLine(new String[] { "����ʱ��", format.format(new Date())});
		export.addOutputProperty("countyid", "�ֹ�˾", CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("svccode", "������������", CommonExportBean.CODE2NAME, "#SERVCENT");
		export.addOutputProperty("mareacode", "΢����", CommonExportBean.CODE2NAME, "#MICROAREA");
		export.addOutputProperty("wayid", "�������");
		export.addOutputProperty("wayname", "��������");
		export.addOutputProperty("starlevel", "�Ǽ�", CommonExportBean.CODE2NAME, "$CH_STARLEVEL");
		export.addOutputProperty("comcategory", "��Ʒ����", CommonExportBean.CODE2NAME, "$IM_FXCOMCATEGORY");
		export.addOutputProperty("stocknum", "����");
		export.addOutputProperty("upperwayid", "�ϼ�����",CommonExportBean.CODE2NAME, "#WAY");
		export.addOutputProperty("waymagcode", "������������");
		
		// ����VO��
		export.voClassArray = new Class[] { SWaystocksnptVO.class };
		
		// ���ò�ѯ����
		export.queryMethodName = "doSalestatistic";
		WaystocksnptDBParam params = (WaystocksnptDBParam) getParam();
		params.setQueryAll(true);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
	
	
	/**
	 * ����հ�SIM��������ͳ�Ƶ���Txt
	 * @return
	 * @throws Exception
	 */
	public String doExportsalestatisticTxt() throws Exception {
		this.getRequest().getSession().setAttribute("currenttime", System.currentTimeMillis());
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		export.setFileName("����հ�SIM��������ͳ��");
		export.addOutputProperty("countyid", "�ֹ�˾", CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("svccode", "������������", CommonExportBean.CODE2NAME, "#SERVCENT");
		export.addOutputProperty("mareacode", "΢����", CommonExportBean.CODE2NAME, "#MICROAREA");
		export.addOutputProperty("wayid", "�������");
		export.addOutputProperty("wayname", "��������");
		export.addOutputProperty("starlevel", "�Ǽ�", CommonExportBean.CODE2NAME, "$CH_STARLEVEL");
		export.addOutputProperty("comcategory", "��Ʒ����", CommonExportBean.CODE2NAME, "$IM_FXCOMCATEGORY");
		export.addOutputProperty("stocknum", "����");
		export.addOutputProperty("upperwayid", "�ϼ�����",CommonExportBean.CODE2NAME, "#WAY");
		export.addOutputProperty("waymagcode", "������������");
		
		// ����VO��
		export.voClassArray = new Class[] { SWaystocksnptVO.class };
		
		// ���ò�ѯ����
		export.queryMethodName = "doSalestatistic";

		prepareResponse(export.getFileName());
		getParam().set_pagesize("0");
		export.writeTxtTitle(getResponse().getOutputStream(), new String[] {
				"�ֹ�˾", "������������", "΢����", "�������", "��������", "�Ǽ�", 
				"��Ʒ����", "����", "�ϼ�����", "������������" });
		super.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
		return null;
	}
	
	/**
	 * ����հ�SIM����������ϸ����Excel
	 * @return
	 * @throws Exception
	 */
	public String doExportsalerecord() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("����հ�SIM����������ϸ");
		export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
		export.appendHeadLine(new String[] { "����ʱ��", format.format(new Date())});
		export.addOutputProperty("emptyno", "�հ׿����к�");
		export.addOutputProperty("stocktime", "����ʱ��", export.DATE, "yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("countyid", "�ֹ�˾", CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("svccode", "������������", CommonExportBean.CODE2NAME, "#SERVCENT");
		export.addOutputProperty("mareacode", "΢����", CommonExportBean.CODE2NAME, "#MICROAREA");
		export.addOutputProperty("orderid", "��������");
		export.addOutputProperty("wayid", "�������");
		export.addOutputProperty("wayname", "��������");
		export.addOutputProperty("starlevel", "�Ǽ�", CommonExportBean.CODE2NAME, "$CH_STARLEVEL");
		export.addOutputProperty("comcategory", "��Ʒ����", CommonExportBean.CODE2NAME, "$IM_FXCOMCATEGORY");
		export.addOutputProperty("upperwayid", "�ϼ�����",CommonExportBean.CODE2NAME, "#WAY");
		export.addOutputProperty("waymagcode", "������������");
		
		// ����VO��
		export.voClassArray = new Class[] { RWaystocksnptVO.class };
		
		// ���ò�ѯ����
		export.queryMethodName = "doSalerecord";
		WaystocksnptDBParam params = (WaystocksnptDBParam) getParam();
		params.setQueryAll(true);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
	
	
	/**
	 * ����հ�SIM����������ϸ����Txt
	 * @return
	 * @throws Exception
	 */
	public String doExportsalerecordTxt() throws Exception {
		this.getRequest().getSession().setAttribute("currenttime", System.currentTimeMillis());
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		export.setFileName("����հ�SIM����������ϸ");
		export.addOutputProperty("emptyno", "�հ׿����к�");
		export.addOutputProperty("stocktime", "����ʱ��", export.DATE, "yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("countyid", "�ֹ�˾", CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("svccode", "������������", CommonExportBean.CODE2NAME, "#SERVCENT");
		export.addOutputProperty("mareacode", "΢����", CommonExportBean.CODE2NAME, "#MICROAREA");
		export.addOutputProperty("orderid", "��������");
		export.addOutputProperty("wayid", "�������");
		export.addOutputProperty("wayname", "��������");
		export.addOutputProperty("starlevel", "�Ǽ�", CommonExportBean.CODE2NAME, "$CH_STARLEVEL");
		export.addOutputProperty("comcategory", "��Ʒ����", CommonExportBean.CODE2NAME, "$IM_FXCOMCATEGORY");
		export.addOutputProperty("upperwayid", "�ϼ�����", CommonExportBean.CODE2NAME, "#WAY");
		export.addOutputProperty("waymagcode", "������������");
		
		// ����VO��
		export.voClassArray = new Class[] { RWaystocksnptVO.class };
		
		// ���ò�ѯ����
		export.queryMethodName = "doSalerecord";

		prepareResponse(export.getFileName());
		getParam().set_pagesize("0");
		export.writeTxtTitle(getResponse().getOutputStream(), new String[] {
			"�հ׿����к�", "����ʱ��", "�ֹ�˾", "������������", "΢����", "��������", 
			"�������", "��������", "�Ǽ�", "��Ʒ����", "�ϼ�����", "������������"});
		super.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
		return null;
	}
	
	/**
	 * ����հ�SIM��ʹ����ͳ�Ƶ���Excel
	 * @return
	 * @throws Exception
	 */
	public String doExportusedstatistic() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("����հ�SIM��ʹ����ͳ��");
		export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
		export.appendHeadLine(new String[] { "����ʱ��", format.format(new Date())});
		export.addOutputProperty("countyid", "�ֹ�˾", CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("svccode", "������������", CommonExportBean.CODE2NAME, "#SERVCENT");
		export.addOutputProperty("mareacode", "΢����", CommonExportBean.CODE2NAME, "#MICROAREA");
		export.addOutputProperty("orderid", "��������");
		export.addOutputProperty("wayid", "�������");
		export.addOutputProperty("wayname", "��������");
		export.addOutputProperty("starlevel", "�Ǽ�", CommonExportBean.CODE2NAME, "$CH_STARLEVEL");
		export.addOutputProperty("comcategory", "��Ʒ����", CommonExportBean.CODE2NAME, "$IM_FXCOMCATEGORY");
		export.addOutputProperty("stocknum", "����");
		export.addOutputProperty("upperwayid", "�ϼ�����", CommonExportBean.CODE2NAME, "#WAY");
		
		// ����VO��
		export.voClassArray = new Class[] { SWaystocksnptVO.class };
		
		// ���ò�ѯ����
		export.queryMethodName = "doUsedstatistic";
		WaystocksnptDBParam params = (WaystocksnptDBParam) getParam();
		params.setQueryAll(true);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
	
	
	/**
	 * ����հ�SIM��ʹ����ͳ�Ƶ���Txt
	 * @return
	 * @throws Exception
	 */
	public String doExportusedstatisticTxt() throws Exception {
		this.getRequest().getSession().setAttribute("currenttime", System.currentTimeMillis());
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		export.setFileName("����հ�SIM��ʹ����ͳ��");
		export.addOutputProperty("countyid", "�ֹ�˾", CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("svccode", "������������", CommonExportBean.CODE2NAME, "#SERVCENT");
		export.addOutputProperty("mareacode", "΢����", CommonExportBean.CODE2NAME, "#MICROAREA");
		export.addOutputProperty("orderid", "��������");
		export.addOutputProperty("wayid", "�������");
		export.addOutputProperty("wayname", "��������");
		export.addOutputProperty("starlevel", "�Ǽ�", CommonExportBean.CODE2NAME, "$CH_STARLEVEL");
		export.addOutputProperty("comcategory", "��Ʒ����", CommonExportBean.CODE2NAME, "$IM_FXCOMCATEGORY");
		export.addOutputProperty("stocknum", "����");
		export.addOutputProperty("upperwayid", "�ϼ�����", CommonExportBean.CODE2NAME, "#WAY");
		
		// ����VO��
		export.voClassArray = new Class[] { SWaystocksnptVO.class };
		
		// ���ò�ѯ����
		export.queryMethodName = "doUsedstatistic";

		prepareResponse(export.getFileName());
		getParam().set_pagesize("0");
		export.writeTxtTitle(getResponse().getOutputStream(), new String[] {
			"�ֹ�˾", "������������", "΢����", "��������", "�������", 
			"��������", "�Ǽ�", "��Ʒ����", "����", "�ϼ�����"});
		super.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
		return null;
	}
	
	/**
	 * ����հ�SIM��ʹ������ϸ����Excel
	 * @return
	 * @throws Exception
	 */
	public String doExportusedrecord() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("����հ�SIM��ʹ������ϸ");
		export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
		export.appendHeadLine(new String[] { "����ʱ��", format.format(new Date())});
		export.addOutputProperty("emptyno", "�հ׿����к�");
		export.addOutputProperty("changetime", "״̬���ʱ��", export.DATE, "yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("countyid", "�ֹ�˾", CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("svccode", "������������", CommonExportBean.CODE2NAME, "#SERVCENT");
		export.addOutputProperty("mareacode", "΢����", CommonExportBean.CODE2NAME, "#MICROAREA");
		export.addOutputProperty("orderid", "��������");
		export.addOutputProperty("wayid", "�������");
		export.addOutputProperty("wayname", "��������");
		export.addOutputProperty("starlevel", "�Ǽ�", CommonExportBean.CODE2NAME, "$CH_STARLEVEL");
		export.addOutputProperty("comcategory", "��Ʒ����", CommonExportBean.CODE2NAME, "$IM_FXCOMCATEGORY");
		export.addOutputProperty("state", "״̬", CommonExportBean.CODE2NAME, "$FX_CHANGESTATE");
		export.addOutputProperty("upperwayid", "�ϼ�����", CommonExportBean.CODE2NAME, "#WAY");
		
		// ����VO��
		export.voClassArray = new Class[] { RWaystocksnptVO.class };
		
		// ���ò�ѯ����
		export.queryMethodName = "doUsedrecord";
		WaystocksnptDBParam params = (WaystocksnptDBParam) getParam();
		params.setQueryAll(true);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
	
	
	/**
	 * ����հ�SIM��ʹ������ϸ����Txt
	 * @return
	 * @throws Exception
	 */
	public String doExportusedrecordTxt() throws Exception {
		this.getRequest().getSession().setAttribute("currenttime", System.currentTimeMillis());
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		export.setFileName("����հ�SIM��ʹ������ϸ");
		export.addOutputProperty("emptyno", "�հ׿����к�");
		export.addOutputProperty("changetime", "״̬���ʱ��", export.DATE, "yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("countyid", "�ֹ�˾", CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("svccode", "������������", CommonExportBean.CODE2NAME, "#SERVCENT");
		export.addOutputProperty("mareacode", "΢����", CommonExportBean.CODE2NAME, "#MICROAREA");
		export.addOutputProperty("orderid", "��������");
		export.addOutputProperty("wayid", "�������");
		export.addOutputProperty("wayname", "��������");
		export.addOutputProperty("starlevel", "�Ǽ�", CommonExportBean.CODE2NAME, "$CH_STARLEVEL");
		export.addOutputProperty("comcategory", "��Ʒ����", CommonExportBean.CODE2NAME, "$IM_FXCOMCATEGORY");
		export.addOutputProperty("state", "״̬", CommonExportBean.CODE2NAME, "$FX_CHANGESTATE");
		export.addOutputProperty("upperwayid", "�ϼ�����", CommonExportBean.CODE2NAME, "#WAY");
		
		// ����VO��
		export.voClassArray = new Class[] { RWaystocksnptVO.class };
		
		// ���ò�ѯ����
		export.queryMethodName = "doUsedrecord";

		prepareResponse(export.getFileName());
		getParam().set_pagesize("0");
		export.writeTxtTitle(getResponse().getOutputStream(), new String[] {
				"�հ׿����к�", "״̬���ʱ��", "�ֹ�˾", "������������", "΢����", "��������", 
				"�������", "��������", "�Ǽ�", "��Ʒ����", "״̬", "�ϼ�����"});
		super.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
		return null;
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

	public String getStocklistsmpFlag() {
		return stocklistsmpFlag;
	}

	public void setStocklistsmpFlag(String stocklistsmpFlag) {
		this.stocklistsmpFlag = stocklistsmpFlag;
	}
}