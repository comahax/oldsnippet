/**
 * auto-generated code
 * Fri Jun 25 10:41:22 CST 2010
 */
package com.gmcc.pboss.web.sales.alaordercol;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.sales.alaordercol.AlaordercolDBParam;
import com.gmcc.pboss.business.sales.alaordercol.AlaordercolVO;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.sales.alaordercol.Alaordercol;
import com.gmcc.pboss.control.sales.alaordercol.AlaordercolBO;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * <p>
 * Title: AlaordercolAction
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
 * @author LiZhaoLiang
 * @version 1.0
 */
public class AlaordercolAction extends BaseAction {

	public AlaordercolAction() {
		super();

		// ���¼��������Ǳ����
		this.setForm(new AlaordercolForm());
		this.setParam(new AlaordercolWebParam());

		// ָ��VO��
		setClsVO(AlaordercolVO.class);
		// ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
		this.pkNameArray = new String[] { "recid" };
		this.setClsControl(Alaordercol.class);
		this.setClsQueryParam(AlaordercolDBParam.class);

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}

	/**
	 * Ԥ�����䵥����Excel
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doExcel() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("Ԥ�����䵥����");
		export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
		export.appendHeadLine(new String[] { "����ʱ��",
						format.format(new Date()) });
		export.addOutputProperty("countyid", "�ֹ�˾", export.CODE2NAME,
				"#CNTYCOMPANY");
		export.addOutputProperty("svccode", "������������",export.CODE2NAME,
				"#SERVCENT");
		export.addOutputProperty("macode", "΢����",export.CODE2NAME,
				"#MICROAREA");
		export.addOutputProperty("starlevel", "�Ǽ�",export.CODE2NAME,
				"$CH_STARLEVEL");
		export.addOutputProperty("alarmlevel", "Ԥ������",export.CODE2NAME,
				"$FX_STOCKALARMLEVEL");
		export.addOutputProperty("brand", "Ʒ��",export.CODE2NAME,
				"$FX_SMPBRAND");
		export.addOutputProperty("amount", "�׿�����");
		export.addOutputProperty("orderamt", "Ԥ����������");
		export.addOutputProperty("cancelamt", "���϶�����");
		export.addOutputProperty("overamt", "��ɶ�����");
		
		export.voClassArray = new Class[] { AlaordercolVO.class };
		export.queryMethodName = "doExcelList";
		AlaordercolDBParam excelparams = (AlaordercolDBParam) getParam();
		super.setParam(excelparams);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}

	/**
	 * ��ѯҳ��
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doList() throws Exception {
		try {
			AlaordercolDBParam params = (AlaordercolDBParam) getParam();
			AlaordercolBO alabo = (AlaordercolBO) BOFactory.build(
					AlaordercolBO.class, getDBAccessUser());
			AlaordercolForm form = (AlaordercolForm)getForm();
			
			if(StringUtils.isEmpty(params.get_snl_coldate())&&StringUtils.isEmpty(params.get_snm_coldate())){
				String stockdate = PublicUtils.formatUtilDate(queryStockTime(),"yyyyMMdd");
				String currdate = PublicUtils.formatUtilDate(queryStockTimeCurrent(),"yyyyMMdd");
				params.set_snl_coldate(stockdate);
				params.set_snm_coldate(currdate);
			}else{
				Date ldate = new Date();
				Date mdate = new Date();
				SimpleDateFormat myformat = new SimpleDateFormat("yyyyMMdd");
				ldate = myformat.parse(params.get_snl_coldate());
				mdate = myformat.parse(params.get_snm_coldate());
				Long day = (mdate.getTime() - ldate.getTime())/(1000*60*60*24);
				if(day>30){
					setActionMessage("��ʼ����ֹ���ڼ�����ܳ���30�졣");
					return "list";
				}
			}
			params.set_pagesize("0");
			//DataPackage dp = alabo.doQuery(params);
			DataPackage dp = alabo.doGroupQuery(params);
			if (dp != null && dp.getDatas().size() > 0) {
				Long totalAmount = new Long(0);
				Integer totalOrderamt = new Integer(0);
				Integer totalCancelamt = new Integer(0);
				Integer totalOveramt = new Integer(0);
				List<AlaordercolVO> alaordercolList=new ArrayList<AlaordercolVO>();
				List<HashMap> mapList = dp.getDatas();
				AlaordercolVO vo=null;
				for (HashMap map : mapList) {
					// ��װ���󣬻�úϼ�
					vo=new AlaordercolVO();
					//countyid,svccode,macode,starlevel,alarmlevel,brand,amount,orderamt,cancelamt,overamt
					vo.setCountyid((String)map.get("countyid"));
					vo.setSvccode((String)map.get("svccode"));
					vo.setMacode((String)map.get("macode"));
					vo.setStarlevel((Short)map.get("starlevel"));
					vo.setAlarmlevel((String)map.get("alarmlevel"));
					vo.setBrand((String)map.get("brand"));
					vo.setAmount(map.get("amount")==null?0:(Long)map.get("amount"));
					vo.setOrderamt(map.get("orderamt")==null?0:(Integer)map.get("orderamt"));
					vo.setCancelamt(map.get("cancelamt")==null?0:(Integer)map.get("cancelamt"));
					vo.setOveramt(map.get("overamt")==null?0:(Integer)map.get("overamt"));
					totalAmount = totalAmount + (vo.getAmount()==null?0:vo.getAmount());
					totalOrderamt = totalOrderamt + (vo.getOrderamt()==null?0:vo.getOrderamt());
					totalCancelamt = totalCancelamt + (vo.getCancelamt()==null?0:vo.getCancelamt());
					totalOveramt = totalOveramt + (vo.getOveramt()==null?0:vo.getOveramt());
				}
				form.setTotalAmount(totalAmount);
				form.setTotalOrderamt(totalOrderamt);
				form.setTotalCancelamt(totalCancelamt);
				form.setTotalOveramt(totalOveramt);
			}
			this.setForm(form);
			this.setDp(dp);
		} catch (Exception ex) {
			setActionMessage(ex.getMessage());
		}
		return "list";
	}
	
	public String doExcelAlaordercol() throws Exception {
		try {
			AlaordercolDBParam params = (AlaordercolDBParam) getParam();
			AlaordercolBO alabo = (AlaordercolBO) BOFactory.build(
					AlaordercolBO.class, getDBAccessUser());
			AlaordercolForm form = (AlaordercolForm)getForm();
			
			if(StringUtils.isEmpty(params.get_snl_coldate())&&StringUtils.isEmpty(params.get_snm_coldate())){
				String stockdate = PublicUtils.formatUtilDate(queryStockTime(),"yyyyMMdd");
				String currdate = PublicUtils.formatUtilDate(queryStockTimeCurrent(),"yyyyMMdd");
				params.set_snl_coldate(stockdate);
				params.set_snm_coldate(currdate);
			}else{
				Date ldate = new Date();
				Date mdate = new Date();
				SimpleDateFormat myformat = new SimpleDateFormat("yyyyMMdd");
				ldate = myformat.parse(params.get_snl_coldate());
				mdate = myformat.parse(params.get_snm_coldate());
				Long day = (mdate.getTime() - ldate.getTime())/(1000*60*60*24);
				if(day>30){
					return this.doList();
				}
			}
			//DataPackage dp = alabo.doQuery(params);
			DataPackage dp = alabo.doGroupQuery(params);
			if (dp != null && dp.getDatas().size() > 0) {
				Long totalAmount = new Long(0);
				Integer totalOrderamt = new Integer(0);
				Integer totalCancelamt = new Integer(0);
				Integer totalOveramt = new Integer(0);
				List<AlaordercolVO> alaordercolList=new ArrayList<AlaordercolVO>();
				List<HashMap> mapList = dp.getDatas();
				AlaordercolVO vo=null;
				for (HashMap map : mapList) {
					// ��װ���󣬻�úϼ�
					vo=new AlaordercolVO();
					vo.setCountyid((String)map.get("countyid"));
					vo.setSvccode((String)map.get("svccode"));
					vo.setMacode((String)map.get("macode"));
					vo.setStarlevel((Short)map.get("starlevel"));
					vo.setAlarmlevel((String)map.get("alarmlevel"));
					vo.setBrand((String)map.get("brand"));
					vo.setAmount(map.get("amount")==null?0:(Long)map.get("amount"));
					vo.setOrderamt(map.get("orderamt")==null?0:(Integer)map.get("orderamt"));
					vo.setCancelamt(map.get("cancelamt")==null?0:(Integer)map.get("cancelamt"));
					vo.setOveramt(map.get("overamt")==null?0:(Integer)map.get("overamt"));
					totalAmount = totalAmount + (vo.getAmount()==null?0:vo.getAmount());
					totalOrderamt = totalOrderamt + (vo.getOrderamt()==null?0:vo.getOrderamt());
					totalCancelamt = totalCancelamt + (vo.getCancelamt()==null?0:vo.getCancelamt());
					totalOveramt = totalOveramt + (vo.getOveramt()==null?0:vo.getOveramt());
				}
				form.setTotalAmount(totalAmount);
				form.setTotalOrderamt(totalOrderamt);
				form.setTotalCancelamt(totalCancelamt);
				form.setTotalOveramt(totalOveramt);
			}
			this.setForm(form);
			this.setDp(dp);
		} catch (Exception ex) {
			setActionMessage(ex.getMessage());
		}
		return "excelalaordercol";
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
}