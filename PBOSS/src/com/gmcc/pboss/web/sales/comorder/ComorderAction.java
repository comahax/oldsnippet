/**
 * auto-generated code
 * Tue Oct 13 09:23:33 CST 2009
 */
package com.gmcc.pboss.web.sales.comorder;

import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.base.dictitem.DictitemVO;
import com.gmcc.pboss.business.channel.custwaytype.CustwaytypeVO;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.sales.activerate.ActiverateVO;
import com.gmcc.pboss.business.sales.comorder.ComorderConstant;
import com.gmcc.pboss.business.sales.comorder.ComorderVO;
import com.gmcc.pboss.business.sales.comorder.OrderCardVO;
import com.gmcc.pboss.business.sales.comorder.OrderMonthdayStockVO;
import com.gmcc.pboss.business.sales.comorder.OrderMonthdayStockalarm;
import com.gmcc.pboss.business.sales.comorder.OrderMonthdayVO;
import com.gmcc.pboss.business.sales.comorder.OrderStdstockVO;
import com.gmcc.pboss.business.sales.comorder.OrderStockalarmVO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.sales.comorder.Comorder;
import com.gmcc.pboss.control.sales.comorder.ComorderBO;
import com.gmcc.pboss.control.sales.comorder.ComorderCheck;
import com.gmcc.pboss.control.sales.comorder.ComorderCheckBO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.exception.business.SaleException;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.struts2.AAUtilsForStruts2;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.gmcc.pboss.control.resource.comcategoryrela.Comcategoryrela;
import com.gmcc.pboss.control.resource.comcategoryrela.ComcategoryrelaBO;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaDBParam;

/**
 * <p>
 * Title: BaseorderamtAction
 * </p> ;
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
 * @author
 * @version 1.0
 */
public class ComorderAction extends BaseAction {
	public static final Log log = LogFactory.getLog(ComorderAction.class);
	
	public static final String WEB_RESULT_STEP1 = "step1";
	public static final String WEB_RESULT_STEP2 = "step2";
	public static final String WEB_RESULT_STEP3 = "step3";

	public static final int EXIT = -1; // �˳�
	public static final int START = 1; // ��ʼ
	public static final int NEXT = 1; // ��һ��
	
	public String spePrice ;//��Ʒ�ۼ�ģʽ SPEPRICE-ָ���ۼ� SALEPLAN-�Żݷ���
	
	public Map<String,String> salePlanType = new LinkedHashMap<String,String>();
	
	private boolean isurgent=false;



	public boolean isIsurgent() {
		return isurgent;
	}

	public void setIsurgent(boolean isurgent) {
		this.isurgent = isurgent;
	}

	public ComorderAction() {
		this.setForm(new ComorderForm());
	}

	public String doStep1() throws Exception {
		return WEB_RESULT_STEP1;
	};

	public String doStep2() throws Exception {
		ComorderForm form = (ComorderForm) getForm();
		Comorder comorder = (Comorder) BOFactory.build(ComorderBO.class,
				getDBAccessUser());
		String wayid = form.getWayid();

		try {
			//��Ʒ�ۼ�ģʽ SPEPRICE-ָ���ۼ� SALEPLAN-�Żݷ���
			Sysparam sysparamBO = (SysparamBO)BOFactory.build(SysparamBO.class,getDBAccessUser());
			spePrice = sysparamBO.doFindByID("71", "pboss_fx");
			
			// ����������Ϣ
			WayVO wayVO = comorder.doCheckWay(wayid);
			// ���ú�������Ϣ
			form.setWayname(wayVO.getWayname());
			form.setCusttype(wayVO.getCusttype());
			Long starlevel = wayVO.getStarlevel();
			if (null != starlevel)
				form.setStarlevel(Short.valueOf(String.valueOf(starlevel)));
			form.setCityid(wayVO.getCityid());
			form.setCountyid(wayVO.getCountyid());
			form.setPaytype(wayVO.getPaytype());
			form.setDelitype(wayVO.getDelitype());

			// ��ȡ�׿�Ʒ�Ƽ���
			List<DictitemVO> brandlist = comorder.doGetBrandList(wayid);

			// �����׿���������Ϣ
			List<ActiverateVO> activerateList = comorder.doGetActiveList(wayid,
					brandlist);
			form.setActiveList(activerateList);

			// �׿�������Ϣ����ģʽ
			String mode = comorder.doGetOrderMode();

			// ���ó�ֵ��������Ϣ
			List<OrderCardVO> orderCardList = comorder
					.doGetOrderInfoByCard(wayVO);
			form.setOrderCardList(orderCardList);
			
			if (null != mode && mode.equals(ComorderConstant.MODE_MONDAYLIMIT)) {
				// ��ȡ�׿�������Ϣ����/�����ƣ�
				List<OrderMonthdayVO> orderMonthdayList = comorder
						.doGetOrderInfoByMonthDay(wayVO, brandlist);
				form.setOrderMonthdayList(orderMonthdayList);
				
			} else if (null != mode
					&& mode.equals(ComorderConstant.MODE_STDSTOCK)) {
				// ��ȡ�׿�������Ϣ����׼������ƣ�
				List<OrderStdstockVO> orderStdstockList = comorder
						.doGetOrderInfoByStdstock(wayVO, brandlist, activerateList);
				form.setOrderStdstockList(orderStdstockList);
			} else if (null != mode
					&& mode.equals(ComorderConstant.MODE_STOCKALARM)) {
				// ��ȡ�׿�������Ϣ��Ԥ����棩
				List<OrderStockalarmVO> orderStockalarmList = comorder
						.doGetOrderInfoByStockalarm(wayVO, brandlist);
				form.setOrderStockalarmList(orderStockalarmList);
			}else if (null != mode
					&& mode.equals(ComorderConstant.MODE_MONDAYSTOCK)) {
				//������Լ��ģʽ�����¿�����ģʽ��
				List<OrderMonthdayStockVO> orderMonthdayStockList = comorder
						.doGetOrderInfoByMonthdayStock(wayVO, brandlist, activerateList);
				form.setOrderMonthdayStockList(orderMonthdayStockList);
			}else if (null != mode
					&& mode.equals(ComorderConstant.MODE_MONDAYALARM)) {
				//�׿�������Ϣ������Ԥ��������ģʽ��
				
				// ��ȡ�׿�������Ϣ����/�����ƣ�
				List<OrderMonthdayVO> orderMonthdayList = comorder
				.doGetOrderInfoByMonthDay(wayVO, brandlist);
				
				// ��ȡ�׿�������Ϣ��Ԥ����棩
				List<OrderStockalarmVO> orderStockalarmList = comorder
						.doGetOrderInfoByStockalarm(wayVO, brandlist);
				
				List<OrderMonthdayStockalarm> orderMonthdayStockalarmList = comorder.doGetOrderMonthdayStockalarm(orderMonthdayList, orderStockalarmList);
				form.setOrderMonthdayStockalarmList(orderMonthdayStockalarmList);
			}

			// ��ȡ��Ʒ������ʾ��Ϣ
			String hint = comorder.doGetOrderHint();
			form.setHint(hint);

			// ���ú��������б�
			List<CustwaytypeVO> custwaytypeList = comorder
					.doGetCustwaytypeList();
			getRequest().setAttribute("custwaytypeList", custwaytypeList);

			
//			�հ�SIM��������Ϣ

			form.setOrderEmptyCardVOList(comorder.getEmptySimInfo(wayVO));
			
			
			try {
				// �¶����������
				ComorderBO.isurgent = this.isurgent;
				comorder.checkMonthBookTimes(wayid);
				// �Զ���ʱ�ν��м��
				ComorderCheck comorderCheck = (ComorderCheck) BOFactory.build(
						ComorderCheckBO.class, getDBAccessUser());
				comorderCheck.checkLimitTime(wayVO);
			} catch (SaleException se) {
				setActionMessage(se.getMessage());
				form.setButtonflag("disable");
				return WEB_RESULT_STEP2;
			} catch (Exception ex) {
				throw ex;
			}

			// �Ƿ���������϶���������ϵͳ����ȷ��
			boolean enable = comorder.isMixOrderEnabled();
			form.setMixOrderEnable(enable);
		} catch (Exception e) {
			setActionMessage(e.getMessage());
			return WEB_RESULT_STEP1;
		}
		return WEB_RESULT_STEP2;
	};

	public String doStep3() throws Exception {
		
		ComorderBO.isurgent = this.isurgent;
		ComorderForm form = (ComorderForm) getForm();
		Comorder comorder = (Comorder) BOFactory.build(ComorderBO.class,
				getDBAccessUser());
		Way way = (Way) BOFactory.build(WayBO.class, getDBAccessUser());

		// ���ú��������б�
		List<CustwaytypeVO> custwaytypeList = comorder.doGetCustwaytypeList();
		getRequest().setAttribute("custwaytypeList", custwaytypeList);

		try {
			// �׿�������Ϣ����ģʽ
			String mode = comorder.doGetOrderMode();

			// ��һ����ȷ��������Դ����
			String storarea = getStorArea();

			// �ڶ�������Ʒ�������
			Set<String> brandSet = comorder.comOrderCheck(form.getWayid(), form
					.getComorderList(), storarea);

			WayVO wayVO = way.doFindByPk(form.getWayid());
			BeanUtils.copyProperties(wayVO, form);

			// ��ȡ�������
			String orderid = comorder.doGetOrderId();
			form.setOrderid(orderid);

			// ��������
			comorder.doBuildOrder(orderid, wayVO, storarea, form
					.getComorderList(), brandSet,
					ComorderConstant.ORDERAVE_HALL, null);
			
			/*
			 * Log��־���ҳ���ύ����Ʒ������Ϣ
			 */
			log.info("����ID��" + orderid + ", ������Ʒ���ࣺ");
			List<ComorderVO> comorderList = form.getComorderList();
			for (ComorderVO comorderVO : comorderList) {
				log.info("[" + orderid + "]��Ʒ����=" + comorderVO.getComcategory() 
						+ ", ����������/�ţ�=" + comorderVO.getOrderamount() 
						+ ", ��Ʒ���ۣ�Ԫ��=" + comorderVO.getUnitprice() 
						+ ", ��Ʒ�ܼۣ�Ԫ��=" + comorderVO.getTotalprice());
			}

			// ������һ������
			try {
				comorder.doNextProcess(orderid);
			} catch (Exception e) {
			}

			// ��ȡ�׿�Ʒ�Ƽ���
			List<DictitemVO> brandlist = comorder.doGetBrandList(wayVO
					.getWayid());
			// �����׿���������Ϣ
			List<ActiverateVO> activerateList = comorder.doGetActiveList(wayVO
					.getWayid(), brandlist);
			form.setActiveList(activerateList);
			// ���»�ȡ�׿�������Ϣ
			if (null != mode && mode.equals(ComorderConstant.MODE_MONDAYLIMIT)) {
				// ��ȡ�׿�������Ϣ����/�����ƣ�
				List<OrderMonthdayVO> orderMonthdayList = comorder
						.doGetOrderInfoByMonthDay(wayVO, brandlist);
				form.setOrderMonthdayList(orderMonthdayList);
			} else if (null != mode
					&& mode.equals(ComorderConstant.MODE_STDSTOCK)) {
				// ��ȡ�׿�������Ϣ����׼������ƣ�
				List<OrderStdstockVO> orderStdstockList = comorder
						.doGetOrderInfoByStdstock(wayVO, brandlist,
								activerateList);
				form.setOrderStdstockList(orderStdstockList);
			} else if (null != mode
					&& mode.equals(ComorderConstant.MODE_STOCKALARM)) {
				// ��ȡ�׿�������Ϣ��Ԥ����棩
				List<OrderStockalarmVO> orderStockalarmList = comorder
						.doGetOrderInfoByStockalarm(wayVO, brandlist);
				form.setOrderStockalarmList(orderStockalarmList);
			}else if (null != mode
					&& mode.equals(ComorderConstant.MODE_MONDAYSTOCK)) {
				//������Լ��ģʽ�����¿�����ģʽ��
				List<OrderMonthdayStockVO> orderMonthdayStockList = comorder
						.doGetOrderInfoByMonthdayStock(wayVO, brandlist, activerateList);
				form.setOrderMonthdayStockList(orderMonthdayStockList);
			}

			setActionMessage("�ύ�ɹ�");
			return WEB_RESULT_STEP3;
		} catch (Exception e) {			
			String comcategory = form.getComcategory();
			if(comcategory != null && !"".equals(comcategory)){
				salePlanType = comorder.getSalePlanMap(comcategory);
			}
			addActionError(e.getMessage());
			return WEB_RESULT_STEP2;
		}
	};

	// ��һ����ȷ��������Դ����
	public String getStorArea() throws Exception {
		ComorderForm comorderform = (ComorderForm) getForm();
		Way way = (Way) BOFactory.build(WayBO.class, getDBAccessUser());
		WayVO wayvo = way.doFindByPk(comorderform.getWayid());

		ComorderBO comorder = (ComorderBO) BOFactory.build(ComorderBO.class,
				getDBAccessUser());
		return comorder.doGetStorArea(wayvo);
	}

	// ����ѡ�����Ʒ���࣬��ʾ��Ʒ������Ϣ�Ͷ���������Ϣ
	public String doGetOrderInfo() throws Exception {
		if (AAUtilsForStruts2.isAjaxRequest()) {
			ComorderForm form = (ComorderForm) getForm();
			String wayid = form.getWayid();
			String cityid = form.getCityid();
			String comcategory = form.getComcategory();
			form.setComorderList(null);
			Comorder comorder = (Comorder) BOFactory.build(ComorderBO.class,
					getDBAccessUser());

			// ���ú��������б�
			List<CustwaytypeVO> custwaytypeList = comorder
					.doGetCustwaytypeList();
			getRequest().setAttribute("custwaytypeList", custwaytypeList);

			try {
				if (!StringUtils.isEmpty(comcategory)) {
					// ��ȡ��Ʒ������Ϣ
					Double unitprice = comorder.doGetUnitprice(wayid,
							comcategory);
					form.setUnitprice(unitprice);

					// ��ȡ����������Ϣ
					String unitage = comorder.doGetUnitage(cityid, comcategory);
					form.setUnitage(unitage);
				} else {
					form.setUnitprice(null);
					form.setUnitage(null);
				}

			} catch (Exception e) {
				form.setUnitprice(null);
				form.setUnitage(null);

				AAUtilsForStruts2.addZonesToRefresh("errorZone");
				AAUtilsForStruts2.addZonesToRefresh("refreshTable");
				setActionMessage(e.getMessage());
				return WEB_RESULT_STEP2;
			}

			AAUtilsForStruts2.addZonesToRefresh("errorZone");
			AAUtilsForStruts2.addZonesToRefresh("refreshTable");
		}

		return WEB_RESULT_STEP2;
	};
	
	// ����ѡ�����Ʒ���࣬ѡ���Żݷ�����
	public String doGetOrderInfo1() throws Exception {
		if (AAUtilsForStruts2.isAjaxRequest()) {
			ComorderForm form = (ComorderForm) getForm();
			String comcategory = form.getComcategory();
			form.setComorderList(null);
			Comorder comorder = (Comorder) BOFactory.build(ComorderBO.class,
					getDBAccessUser());
			
			//��Ʒ�ۼ�ģʽ SPEPRICE-ָ���ۼ� SALEPLAN-�Żݷ���
			Sysparam sysparamBO = (SysparamBO)BOFactory.build(SysparamBO.class,getDBAccessUser());
			spePrice = sysparamBO.doFindByID("71", "pboss_fx");

			// ���ú��������б�
			List<CustwaytypeVO> custwaytypeList = comorder
					.doGetCustwaytypeList();
			getRequest().setAttribute("custwaytypeList", custwaytypeList);
			
			if(comcategory != null && !"".equals(comcategory)){
				salePlanType = comorder.getSalePlanMap(comcategory);
			}
			
			try {
				
				form.setUnitprice(null);
				form.setUnitage(null);
				

			} catch (Exception e) {
				form.setUnitprice(null);
				form.setUnitage(null);

				AAUtilsForStruts2.addZonesToRefresh("errorZone");
				AAUtilsForStruts2.addZonesToRefresh("refreshTable");
				setActionMessage(e.getMessage());
				return WEB_RESULT_STEP2;
			}

			AAUtilsForStruts2.addZonesToRefresh("errorZone");
			AAUtilsForStruts2.addZonesToRefresh("refreshTable");
		}

		return WEB_RESULT_STEP2;
	};
	
	//�����Żݷ�������ʾ��Ʒ������Ϣ�Ͷ���������Ϣ
	public String doCalOrderInfo1() throws Exception {
		if (AAUtilsForStruts2.isAjaxRequest()) {
			ComorderForm form = (ComorderForm) getForm();
			String comcategory = form.getComcategory();
			String planCode = form.getPlanCode();
			form.setComorderList(null);
			Comorder comorder = (Comorder) BOFactory.build(ComorderBO.class,
					getDBAccessUser());
			
			//��Ʒ�ۼ�ģʽ SPEPRICE-ָ���ۼ� SALEPLAN-�Żݷ���
			Sysparam sysparamBO = (SysparamBO)BOFactory.build(SysparamBO.class,getDBAccessUser());
			spePrice = sysparamBO.doFindByID("71", "pboss_fx");

			// ���ú��������б�
			List<CustwaytypeVO> custwaytypeList = comorder
					.doGetCustwaytypeList();
			getRequest().setAttribute("custwaytypeList", custwaytypeList);
						
			try {
				if(comcategory != null && !"".equals(comcategory)){
					salePlanType = comorder.getSalePlanMap(comcategory);
					
					String wayid = form.getWayid();
					
					Double unitprice = comorder.doGetUnitprice(wayid,comcategory,planCode);
					form.setUnitprice(unitprice);
					String cityid = form.getCityid();
					String unitage = comorder.doGetUnitage(cityid, comcategory);
					form.setUnitage(unitage);
				}else{
					form.setUnitprice(null);
					form.setUnitage(null);
				}
				
			} catch (Exception e) {
				form.setUnitprice(null);
				form.setUnitage(null);
				
				form.setButtonflag("disable");

				AAUtilsForStruts2.addZonesToRefresh("errorZone");
				AAUtilsForStruts2.addZonesToRefresh("refreshTable");
				setActionMessage(e.getMessage());
				return WEB_RESULT_STEP2;
			}

			AAUtilsForStruts2.addZonesToRefresh("errorZone");
			AAUtilsForStruts2.addZonesToRefresh("refreshTable");
		}
		
		return WEB_RESULT_STEP2;
	};
	

	/*
	 * ��Ӧǰ̨AJAX�����жϴ���ӵ���Ʒ���Ѿ���ӵ��б��е���Ʒ��Դ����Ƿ���ͬ
	 */
	public String doCheckRestypeEquality() throws Exception {
		try {
			Comcategoryrela comcategoryrela = (Comcategoryrela) BOFactory
					.build(ComcategoryrelaBO.class, this.getDBAccessUser());

			String comcate1 = ServletActionContext.getRequest().getParameter(
					"comcate1");
			String comcate2 = ServletActionContext.getRequest().getParameter(
					"comcate2");

			ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
			PrintWriter out = ServletActionContext.getResponse().getWriter();

			ComcategoryrelaDBParam params = new ComcategoryrelaDBParam();
			params.setSelectFieldsString("comcategory,restype");
			params.set_pagesize("0");
			params.setDataOnly(true);
			DataPackage dp = comcategoryrela.doLoadComCateAndResType(params);
			List comcateAndRestype = dp.getDatas();
			// key-comcategory��Ʒ����,value-restype��Դ����
			Map<String, String> cateAndRes = new HashMap<String, String>();
			if (comcateAndRestype.size() > 0) {
				for (Iterator it = comcateAndRestype.iterator(); it.hasNext();) {
					Map<String, String> temp = (Map<String, String>) it.next();
					cateAndRes
							.put(temp.get("comcategory"), temp.get("restype"));
				}
			}
			String restype1 = cateAndRes.get(comcate1);
			String restype2 = cateAndRes.get(comcate2);
			if (restype1.equals(restype2)) {
				out.write("YES");
			} else {
				out.write("NO");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getSpePrice() {
		return spePrice;
	}

	public void setSpePrice(String spePrice) {
		this.spePrice = spePrice;
	}

	public Map<String, String> getSalePlanType() {
		return salePlanType;
	}

	public void setSalePlanType(Map<String, String> salePlanType) {
		this.salePlanType = salePlanType;
	}
}