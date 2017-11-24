/**
 * auto-generated code
 * Mon Oct 12 14:56:43 CST 2009
 */
 package com.gmcc.pboss.web.sales.order;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.base.dictitem.DictitemDBParam;
import com.gmcc.pboss.business.base.sysparam.SysparamVO;
import com.gmcc.pboss.business.channel.custwaytype.CustwaytypeVO;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.resource.cityrescode.CityrescodeDBParam;
import com.gmcc.pboss.business.sales.audit.AuditDBParam;
import com.gmcc.pboss.business.sales.audit.AuditVO;
import com.gmcc.pboss.business.sales.ordcomlog.OrdcomlogDBParam;
import com.gmcc.pboss.business.sales.ordcomlog.OrdcomlogVO;
import com.gmcc.pboss.business.sales.order.AuxilaryActalarmVO;
import com.gmcc.pboss.business.sales.order.AuxiliaryInfoVO;
import com.gmcc.pboss.business.sales.order.NextProcessResult;
import com.gmcc.pboss.business.sales.order.OrderDBParam;
import com.gmcc.pboss.business.sales.order.OrderVO;
import com.gmcc.pboss.business.sales.ordercomcate.OrdercomcateDBParam;
import com.gmcc.pboss.business.sales.ordercomcate.OrdercomcateVO;
import com.gmcc.pboss.business.sales.orderlog.OrderlogDBParam;
import com.gmcc.pboss.business.sales.orderlog.OrderlogVO;
import com.gmcc.pboss.business.sales.orderproce.OrderproceDBParam;
import com.gmcc.pboss.business.sales.orderproce.OrderproceVO;
import com.gmcc.pboss.business.sales.orderresdet.OrderresdetDBParam;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.base.dictitem.DictitemBO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.custwaytype.CustwaytypeBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.resource.cityrescode.CityrescodeBO;
import com.gmcc.pboss.control.sales.audit.Audit;
import com.gmcc.pboss.control.sales.audit.AuditBO;
import com.gmcc.pboss.control.sales.bankdeduct.Bankdeduct;
import com.gmcc.pboss.control.sales.bankdeduct.BankdeductBO;
import com.gmcc.pboss.control.sales.comprice.Comprice;
import com.gmcc.pboss.control.sales.comprice.CompriceBO;
import com.gmcc.pboss.control.sales.ordcomlog.Ordcomlog;
import com.gmcc.pboss.control.sales.ordcomlog.OrdcomlogBO;
import com.gmcc.pboss.control.sales.order.Order;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.gmcc.pboss.control.sales.ordercomcate.Ordercomcate;
import com.gmcc.pboss.control.sales.ordercomcate.OrdercomcateBO;
import com.gmcc.pboss.control.sales.orderlog.Orderlog;
import com.gmcc.pboss.control.sales.orderlog.OrderlogBO;
import com.gmcc.pboss.control.sales.orderproce.Orderproce;
import com.gmcc.pboss.control.sales.orderproce.OrderproceBO;
import com.gmcc.pboss.control.sales.orderresdet.Orderresdet;
import com.gmcc.pboss.control.sales.orderresdet.OrderresdetBO;
import com.gmcc.pboss.control.sales.smsconfirm.Smsconfirm;
import com.gmcc.pboss.control.sales.smsconfirm.SmsconfirmBO;
import com.gmcc.pboss.web.common.webservice.CRMService;
import com.opensymphony.xwork2.ActionContext;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * <p>Title: OrderAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class OrderAction extends BaseAction{
	private String outstate;
	
	//��һ����������һ�����ݷ��ؽ��������һ����
	List<NextProcessResult> nextProcessResults;

	public String getOutstate() {
		return outstate;
	}

	public void setOutstate(String outstate) {
		this.outstate = outstate;
	}

	public OrderAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new OrderForm());
		this.setParam(new OrderWebParam());

        //ָ��VO��
        setClsVO(OrderVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"orderid"};
		this.setClsControl(Order.class);
		this.setClsQueryParam(OrderDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	
	@Override
	public String doList() throws Exception {
		// TODO Auto-generated method stub
		try{
			//first time not query
			OrderDBParam orderDBParam = (OrderDBParam) getParam();
			if("true".equals(super.getRequest().getParameter("backFlag")) && null != super.getRequest().getSession().getAttribute("ORDERSEACHPARAM")){
				orderDBParam = (OrderDBParam) super.getRequest().getSession().getAttribute("ORDERSEACHPARAM");
				orderDBParam.set_pk(null);
				super.setParam(orderDBParam);
			}
					
					
			//Ĭ�ϰ��������ʼʱ���ѯ
			if(null == orderDBParam.get_dnl_createtime() )
				orderDBParam.set_dnl_createtime(PublicUtils.formatUtilDate(new Date(),"yyyy-MM-dd")+" 00:00:00");
			if(null == orderDBParam.get_dnm_createtime() )
				orderDBParam.set_dnm_createtime(PublicUtils.formatUtilDate(new Date(),"yyyy-MM-dd")+" 23:59:59");
			if( null == orderDBParam.get_se_orderstate()){//Ĭ�ϰ�����ȡ
				orderDBParam.set_se_orderstate("EXTRAED");
			}
			//Ĭ�ϰ���������ʱ������
			if( null == orderDBParam.get_orderby()){
				orderDBParam.set_orderby("createtime");
				orderDBParam.set_desc("1");
			}
			if( null == orderDBParam.get_se_countyid()){
				User user = (User)super.getRequest().getSession().getAttribute(WebConstant.SESSION_ATTRIBUTE_USER);
				Way wayBO = (WayBO) BOFactory.build(WayBO.class,super.getDBAccessUser());
				WayVO wayvo = wayBO.doFindByPk(user.getWayid());
				orderDBParam.set_se_countyid(wayvo.getCountyid());
			}
			OrderForm orderForm = (OrderForm)super.getForm();
			
			super.getRequest().getSession().setAttribute("ORDERSEACHPARAM", orderDBParam);
			if(!orderForm.isFirstDisplay()){
				Order orderBO = (OrderBO) BOFactory.build(OrderBO.class,super.getDBAccessUser());
				DataPackage dp = orderBO.doList(orderDBParam);
				
				if(dp.getRowCount() > 0){
					List<OrderVO> list = dp.getDatas();
					for (OrderVO vo : list) {
						String bossworkfid = vo.getBossworkfid();
						String orderstate = vo.getOrderstate();
						if("FINISHED".equals(orderstate)){
							if("0".equals(bossworkfid)){
								vo.setCrmstate("CRM���˴�����");
							}else{
								if("-1".equals(bossworkfid)){
									vo.setCrmstate("����ʧ��");
								}else if ("1".equals(bossworkfid)) {
									vo.setCrmstate("��CRM����");
								}else{
									vo.setCrmstate("���˳ɹ�");
								}
							}
						}
					}
				}
				
				super.setDp(dp);
				//�������һ�л�������
				orderForm.setAllactamt(orderBO.getAllActAmt(dp));
				orderForm.setAllbrand(orderBO.getAllBrandInfo(dp));
			}
			orderForm.setFirstDisplay(false);
			Sysparam sysBO = (Sysparam) BOFactory.build(SysparamBO.class, getDBAccessUser());
			String param44 = sysBO.doFindByID("44", "pboss_fx");//����鿪�أ�������ˣ�
			
			orderForm.setParam44(param44);
			super.setForm(orderForm);
			
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return WEB_RESULT_LIST;
	}


	
	
	public String doBossSupplyList() {
		try{
			OrderDBParam param = (OrderDBParam) super.getParam();
			param.set_sne_orderstate("CANCEL");
			//param.set_se_bossworkfid("-1");
			ArrayList<String> bossworkfid_in = new ArrayList<String>();
			bossworkfid_in.add("-1");
			bossworkfid_in.add("1");
			param.set_sin_bossworkfid(bossworkfid_in);

			if( null == param.get_se_countyid()){
				User user = (User)super.getRequest().getSession().getAttribute(WebConstant.SESSION_ATTRIBUTE_USER);
				Way wayBO = (WayBO) BOFactory.build(WayBO.class,super.getDBAccessUser());
				WayVO wayvo = wayBO.doFindByPk(user.getWayid());
				param.set_se_countyid(wayvo.getCountyid());
			}
			
			if( null == param.get_orderby()){
				param.set_orderby("createtime");
				param.set_desc("1");
			}
			super.doList();
			
		}catch(Exception e){
			super.addActionError(e.getMessage());
		}
		return "bosssupplylist";
	}
	
	public String doExcel() throws Exception{
		try{
			HttpServletRequest request = ServletActionContext.getRequest();
			User user = (User) getDBAccessUser();
			CommonExportBean export = new CommonExportBean(user);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			export.setFileName("������Ϣ");
			export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
			export
					.appendHeadLine(new String[] { "����ʱ��",
							format.format(new Date()) });
			export.addOutputProperty("orderid", "�������");
			export.addOutputProperty("wayid", "�����̱���");
			export.addOutputProperty("wayid", "����������",export.CODE2NAME, "#WAYIDINFO");
			export.addOutputProperty("countyid", "�ֹ�˾",export.CODE2NAME, "#CNTYCOMPANY");
			export.addOutputProperty("mareacode", "΢����",export.CODE2NAME,"#MICROAREA");
			//�Ǽ�
			export.addOutputProperty("starlevel", "�Ǽ�",export.CODE2NAME,"$CH_STARLEVEL");
			export.addOutputProperty("orderave", "����;��", export.CODE2NAME, "$FX_ORDERAVE");
			export.addOutputProperty("createtime", "����ʱ��",export.DATE,"yyyy-MM-dd HH:mm:ss");
			export.addOutputProperty("orderstate", "����״̬", export.CODE2NAME, "$FX_ORDERFSTATE");
			export.addOutputProperty("crmstate", "BOSS/CRM״̬");
			export.addOutputProperty("paytype", "�ɷѷ�ʽ", export.CODE2NAME, "$FX_PAYTYPE");
			export.addOutputProperty("recamt", "Ӧ�ս��(Ԫ)",export.EXPRESSION,null);
			export.addOutputProperty("actamt", "ʵ�ս��(Ԫ)",export.EXPRESSION,null);
			export.addOutputProperty("paytime", "����ʱ��",export.DATE,"yyyy-MM-dd HH:mm:ss");
			//����ʱ��
			export.addOutputProperty("recordtime", "����ʱ��",export.DATE,"yyyy-MM-dd HH:mm:ss");
			export.addOutputProperty("deductstate", "����״̬", export.CODE2NAME, "$FX_DEDUCTSTATE");
			export.addOutputProperty("orderInfo", "������Ϣ");
			//Ʒ����Ϣ
			export.addOutputProperty("brandInfo", "Ʒ����Ϣ");
			export.addOutputProperty("discomcode", "������", export.CODE2NAME, "#WAYIDINFO");
			//�������ʱ��
			export.addOutputProperty("disovertime", "�������ʱ��",export.DATE,"yyyy-MM-dd HH:mm:ss");
			export.addOutputProperty("alarmlevel", "Ԥ������",export.CODE2NAME,"$FX_STOCKALARMLEVEL");
			export.addOutputProperty("confirmflag", "�Ƿ�ȷ��",export.CODE2NAME,"$IM_YESNO10");
			export.addOutputProperty("signstate", "ǩ��״̬", export.CODE2NAME, "$FX_SIGNSTATE");
			//ǩ��ʱ��
			export.addOutputProperty("signtime", "ǩ��ʱ��",export.DATE,"yyyy-MM-dd HH:mm:ss");
			//ǩ�շ�ʽ
			export.addOutputProperty("signtype", "ǩ�շ�ʽ",export.CODE2NAME,"$FX_SIGNTYPE");
			//����ǩ�պ���
			export.addOutputProperty("smssignno", "����ǩ�պ���");
//			
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
			Comprice comprice = (Comprice)BOFactory.build(CompriceBO.class,getDBAccessUser());
			List<CustwaytypeVO> custwaytypeList = comprice.doGetCustwaytypeList();
			getRequest().setAttribute("custwaytypeList", custwaytypeList);
			Map<Thread,List<CustwaytypeVO>> map = new HashMap<Thread,List<CustwaytypeVO>>();
			map.put(Thread.currentThread(), custwaytypeList);
			OrderVO.setCustwaytypeMap(map);
			OrderDBParam orderDBParam = (OrderDBParam) getParam();
			orderDBParam.setQueryAll(true);
			if(null == orderDBParam.get_dnl_createtime() )
				orderDBParam.set_dnl_createtime(PublicUtils.formatUtilDate(new Date(),"yyyy-MM-dd")+" 00:00:00");
			if(null == orderDBParam.get_dnm_createtime() )
				orderDBParam.set_dnm_createtime(PublicUtils.formatUtilDate(new Date(),"yyyy-MM-dd")+" 23:59:59");
			//Ĭ�ϰ���������ʱ������
			if( null == orderDBParam.get_orderby()){
				orderDBParam.set_orderby("createtime");
				orderDBParam.set_desc("1");
			}
			return super.doExcel();
//			super.doList();
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public String doExcelRes() throws Exception {
		User user = (User) getDBAccessUser();
		CityrescodeBO cityrescodeBO = (CityrescodeBO) BOFactory.build(
				CityrescodeBO.class, getDBAccessUser());
		Order orderBO = (OrderBO) BOFactory.build(OrderBO.class, user);
		CityrescodeDBParam cityrescodeDBParam = new CityrescodeDBParam();
		cityrescodeDBParam.set_se_cityid(this.getDBAccessUser().getCityid());

		DataPackage dpp = cityrescodeBO.doQuery(cityrescodeDBParam);

		DictitemBO dictitemBO = (DictitemBO) BOFactory.build(DictitemBO.class,
				getDBAccessUser());

		// ��ѯ��Ʒ����
		if (dpp == null || dpp.getDatas().size() == 0) {
			DictitemDBParam dictitemDBParam = new DictitemDBParam();
			dictitemDBParam.set_se_groupid("IM_FXCOMCATEGORY");
			dictitemDBParam.set_orderby("dictname");
			dictitemDBParam.set_orderby("1");
			dpp = dictitemBO.doQuery(dictitemDBParam);

		} else {
			dpp.setDatas(dictitemBO.doQueryDictBySql());
		}

		// ͳ�ƶ�Ӧ������Դ��
		this.getParam().set_pagesize("0");
		List list = orderBO.doExcelRes((OrderDBParam) this.getParam());

		for(Iterator<Map> it = list.iterator();it.hasNext();){
			Map map = it.next();
			String strcomcategory = map.get("comcategory")+"";
			String strorderamt = map.get("orderamt")+"";
			String [] strarrcomcategory = strcomcategory.split(";");
			String [] strarrorderamt = strorderamt.split(";");
			for(int i = 1 ;i<strarrcomcategory.length;i++){
				map.put(strarrcomcategory[i], strarrorderamt[i]);
			}
		}
		
		


		this.getRequest().setAttribute("FXCOMCATEGORY", dpp.getDatas());
		this.getRequest().setAttribute("orderResCount", list);
		this.getRequest().setAttribute("usercity", user.getCityid());
		return "ExcelRes";
	}
	
	//����BOSS���˵���Excel
	public String doExportboss() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("����BOSS����");
		export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
		export.appendHeadLine(new String[] { "����ʱ��", format.format(new Date())});
		export.addOutputProperty("orderid", "�������");
		export.addOutputProperty("wayid", "�����̱���");
		export.addOutputProperty("wayid", "����������", CommonExportBean.CODE2NAME, "#WAYIDINFO");
		export.addOutputProperty("countyid", "�ֹ�˾", CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("mareacode", "΢����", CommonExportBean.CODE2NAME, "#MICROAREA");
		export.addOutputProperty("orderave", "����;��", CommonExportBean.CODE2NAME, "$FX_ORDERAVE");
		export.addOutputProperty("createtime", "����ʱ��", export.DATE, "yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("orderstate", "����״̬", CommonExportBean.CODE2NAME, "$FX_ORDERFSTATE");
		export.addOutputProperty("paytype", "�ɷѷ�ʽ", CommonExportBean.CODE2NAME, "$FX_PAYTYPE");
		export.addOutputProperty("memo", "��ע");
		
		// ���ò�ѯ����
		export.queryMethodName = "doBossSupplyList";
		OrderDBParam param = (OrderDBParam) super.getParam();
		param.setQueryAll(true);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
	
	public String doGoRemove(){
		try{
			String[] selectItem = super.getParam().get_selectitem();
			System.out.println(selectItem);
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return "remove";
	}
	
	
	
	//��������
	public String doRemove() throws IOException{
		try{
			OrderDBParam param = (OrderDBParam) super.getParam();
			OrderForm orderForm = (OrderForm)super.getForm();
			String[] selectItem = param.get_selectitem();
			selectItem[0] = selectItem[0].replaceAll("\\s", "");
			String[] pk = selectItem[0].split(",");
			
			Order orderBO = (OrderBO) BOFactory.build(OrderBO.class,super.getDBAccessUser());
			String result = orderBO.cancleOrder(pk, orderForm.getCancelReason(), orderForm.getCancelDes());
			
			//�������Ϻ󣬶���֪ͨ,�漰���ݿ��������Ĳ���Ҫ�������һ�������У�
			//�������������޸ġ�ʵʱ���������¡�������Դ�ͷš����͵����ϵȲ��衣
			//���������Ͷ���֪ͨ
			orderBO.doSmsAfterCancel(pk, orderForm.getCancelReason(), orderForm.getCancelDes());
			super.addActionMessage("������� "+result);
						
			super.getResponse().getWriter().write(result);
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError(e.getMessage());
			super.getResponse().getWriter().write(e.getMessage());
		}
		return null;
	}
	
	public String doDeletebosssupply() throws Exception {
		String[] selectItem = param.get_selectitem();
		Order orderBO = (OrderBO) BOFactory.build(OrderBO.class,super.getDBAccessUser());
		orderBO.doDeletebosssupply(selectItem);
		super.addActionMessage("ɾ�����������!");
		return this.doBossSupplyList();
	}
	
	/*
	 * ��ת����ǩҳ
	 */
	public String doGoFrame(){
		return "orderlineframe";
	}
	
	@Override
	public String doEdit() throws Exception {
		// TODO Auto-generated method stub
		try{
			super.doEdit();
			OrderForm orderForm = (OrderForm)super.getForm();
			//��ȡ������������
			CustwaytypeBO  custwaytypeBO = (CustwaytypeBO) BOFactory.build(CustwaytypeBO.class,super.getDBAccessUser());
			CustwaytypeVO custwaytypeVO = new CustwaytypeVO();
			custwaytypeVO.setCustwaytypecode(orderForm.getCooptype());
			custwaytypeVO.setCitycompid(super.getDBAccessUser().getCityid());
			custwaytypeVO = custwaytypeBO.doFindByPk(custwaytypeVO); 
			if( null != custwaytypeVO){
				orderForm.setCustwaytypename(custwaytypeVO.getCustwaytypename());
			}else{
				orderForm.setCustwaytypename(orderForm.getCooptype());
			}
			//ȡ������Ϣ ���ݶ�����Ų�ѯ������Ʒ���� (FX_SW_ORDERCOMCATE)��
//			��ͬ��Ʒ����Ķ������������ۼӣ������ա���Ʒ����A������������Ʒ����B����������������ϡ�
			Order orderBO = (OrderBO) BOFactory.build(OrderBO.class,super.getDBAccessUser());
			orderForm.setOrderInfo(orderBO.doGetOrderInfo(orderForm.getOrderid()));
			
			//���ʱ�䣺��ѯ������־��FX_SW_ORDERLOG����
			//ƥ�䶩����źͶ���״̬Ϊ����ˣ�AUDITED����
			//���ʱ��ȡ״̬���ʱ�䣨STATECHGTIME�����������������ʾ
			Orderlog orderlog = (OrderlogBO) BOFactory.build(OrderlogBO.class,super.getDBAccessUser());
			OrderlogDBParam orderlogDB = new OrderlogDBParam();
			orderlogDB.set_se_orderid(orderForm.getOrderid());//�������
			orderlogDB.set_se_orderstate("AUDITED");//����״̬Ϊ�����
			DataPackage orderlogdp = orderlog.doQuery(orderlogDB);
			if (null == orderlogdp
					|| null == orderlogdp.getDatas()
					|| orderlogdp.getDatas().size() < 1){
				
			}else{
				OrderlogVO orderlogVO =(OrderlogVO)orderlogdp.getDatas().get(0);
				orderForm.setAuditTime(orderlogVO.getStatechgtime());
			}
		}catch(Exception e){
			e.printStackTrace();
		}		
		return "baseinfo";
	}
	/**
	 * ��������б�
	 * @return
	 * @throws Exception
	 */
	public String doAppList() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		//��ȡ������Ϣ
		OrderDBParam orderDBParam = (OrderDBParam) getParam();
		Order bo = (Order)BOFactory.build(OrderBO.class,getDBAccessUser());
		OrderVO vo=bo.doFindByPk(orderDBParam.get_se_orderid());
//		setForm(vo);
		OrderForm orderForm = (OrderForm)super.getForm();
		BeanUtils.copyProperties(orderForm, vo);
		orderForm.setOrderInfo(bo.doGetOrderInfo(orderForm.getOrderid()));
		setForm(orderForm);
		CustwaytypeBO  custwaytypeBO = (CustwaytypeBO) BOFactory.build(CustwaytypeBO.class,super.getDBAccessUser());
		CustwaytypeVO custwaytypeVO = new CustwaytypeVO();
		custwaytypeVO.setCustwaytypecode(orderForm.getCooptype());
		custwaytypeVO.setCitycompid(super.getDBAccessUser().getCityid());
		custwaytypeVO = custwaytypeBO.doFindByPk(custwaytypeVO); 
		if( null != custwaytypeVO){
			orderForm.setCustwaytypename(custwaytypeVO.getCustwaytypename());
		}else{
			orderForm.setCustwaytypename(orderForm.getCooptype());
		}
		//��ȡ������Ʒ�۸���Ϣ
		Ordercomcate ordercomcateBO = (Ordercomcate)BOFactory.build(OrdercomcateBO.class,getDBAccessUser());
		OrdercomcateDBParam ordercomcateDBParam=new OrdercomcateDBParam();
		ordercomcateDBParam.set_se_orderid(vo.getOrderid());
		ordercomcateDBParam.set_desc(orderDBParam.get_desc());
		ordercomcateDBParam.set_orderby(orderDBParam.get_orderby());
		ordercomcateDBParam.set_pageno(orderDBParam.get_pageno());
		ordercomcateDBParam.set_pagesize(orderDBParam.get_pagesize());
		DataPackage dp =ordercomcateBO.doQuery(ordercomcateDBParam);
		
		//��ȡ�Ƿ����������ʶ
		List<OrdercomcateVO> ordercomcateList = dp.getDatas();
		
		Ordcomlog ordcomlog = (Ordcomlog)BOFactory.build(OrdcomlogBO.class, getDBAccessUser());
		OrdcomlogDBParam param = new OrdcomlogDBParam();
		param.set_se_orderid(vo.getOrderid());
		param.set_pagesize("0");
		DataPackage dp2 = ordcomlog.doQuery(param);
		List<OrdcomlogVO> ordcomlogVOList = dp2.getDatas();
		Set<Long> ordcomidSet = new HashSet<Long>();
		for(OrdcomlogVO ordcomlogVO : ordcomlogVOList)
		{
			ordcomidSet.add(ordcomlogVO.getOrdcomid());
		}
			
		for(OrdercomcateVO ordercomcateVO : ordercomcateList)
		{
			if(ordcomidSet.contains(ordercomcateVO.getRecid()))
			{
				ordercomcateVO.setChangeFlag("YES");
			}else{
				ordercomcateVO.setChangeFlag("NO");
			}
		}
		
		setDp(dp);
		Orderproce orderproceBO = (Orderproce)BOFactory.build(OrderproceBO.class,getDBAccessUser());
		OrderproceDBParam orderproceDBParam=new OrderproceDBParam();
		orderproceDBParam.set_ne_flowid(String.valueOf(vo.getFlowid()));
		orderproceDBParam.set_se_instate(vo.getOrderstate());
		DataPackage data=orderproceBO.doQuery(orderproceDBParam);
		List<OrderproceVO> list=data.getDatas();
		for(OrderproceVO obj:list){
			this.setOutstate(obj.getOutstate());
			break;
		}
		//��ѯ�Ƿ���������Ϣ
		Audit auditBO = (Audit)BOFactory.build(AuditBO.class,getDBAccessUser());
		AuditDBParam auditDBParam=new AuditDBParam();
		auditDBParam.set_se_orderid(vo.getOrderid());
		auditDBParam.set_orderby("smsntime");
		auditDBParam.set_desc("1");
	
		//����������˱�[FX_SW_AUDIT]�Ͷ��������ϸ��[FX_SW_AUDITDET]��������ڵ�ǰ������������״̬Ϊ������ˡ��ļ�¼���򽫰�ť��Ϊ������
		auditDBParam.set_se_state("0");
		List<AuditVO> auditlist=auditBO.doGetAuditInfo(auditDBParam).getDatas();
		if(auditlist.size()>0){
			orderForm.setHasAudit("Y");
		}
		//����������˱�[FX_SW_AUDIT]�Ͷ��������ϸ��[FX_SW_AUDITDET]��������ڶ�Ӧ�Ķ�����������µġ����״̬��Ϊ�ǡ�ͨ��[1]������ť�����á�
		auditDBParam.set_se_state(null);
		auditlist=auditBO.doGetAuditInfo(auditDBParam).getDatas();
		if(auditlist.size()>0){
			if(!"1".equals(auditlist.get(0).getState())){
				orderForm.setHasWaitAudit("Y");
			}
		}
		/*
		//��ѯ�Ƿ���ڴ����0״̬�������Ϣ
		List<AuditVO> auditlist=auditBO.doQuery(auditDBParam).getDatas();
		if(auditlist.size()>0){
			orderForm.setHasAudit("Y");
			orderForm.setHasWaitAudit("Y");
		}
		//��ѯ�Ƿ����δͨ�����2״̬�������Ϣ
		auditDBParam.set_se_state(null);
		auditlist=auditBO.doQuery(auditDBParam).getDatas();
		if(auditlist.size()>0){
			for(AuditVO auditvo:auditlist){
				if("2".equals(auditvo.getState())){
					orderForm.setHasWaitAudit("Y");
				}
				break;
			}
		}*/
		
		//��˽��渨����Ϣ��ʾ
		Sysparam sysparamBO=(Sysparam)BOFactory.build(SysparamBO.class,getDBAccessUser());
		String sysparamvalue59=sysparamBO.doFindByID("59", "pboss_fx");
		if(!StringUtils.isEmpty(sysparamvalue59)&& "1".equals(sysparamvalue59)){
			String sysparamvalue60=sysparamBO.doFindByID("60", "pboss_fx");
			if(!StringUtils.isEmpty(sysparamvalue60)){
				orderForm.setShowAus(true);;//��Ϊչʾ������Ϣ
				orderForm.setMonthParam(sysparamvalue60);//����������ϵͳ����
				orderForm.setGiveCount(bo.doGetGiveCount(vo.getWayid(), sysparamvalue60));//��ȡ����������
				// ���ҷ�װ��˸�����Ϣ
				List<AuxiliaryInfoVO> auxInfoList=bo.doGetAuxiliaryInfo(vo);
				orderForm.setAuxInfoList(auxInfoList);
				orderForm.setStattypes(getStattypes(auxInfoList));
			}
		}
		Sysparam sysBO = (Sysparam) BOFactory.build(SysparamBO.class, getDBAccessUser());
		String param44 = sysBO.doFindByID("44", "pboss_fx");//����鿪�أ�������ˣ�
		orderForm.setParam44(param44);
		super.setForm(orderForm);
		return "applist";
	}
	/**
	 * �����༶�����չʾ��������б�
	 * @return
	 * @throws Exception
	 */
	public String doShowAppList() throws Exception {
		//��ȡ������Ϣ
		OrderDBParam orderDBParam = (OrderDBParam) getParam();
		Order bo = (Order)BOFactory.build(OrderBO.class,getDBAccessUser());
		OrderVO vo=bo.doFindByPk(orderDBParam.get_se_orderid());
		OrderForm orderForm = (OrderForm)super.getForm();
		BeanUtils.copyProperties(orderForm, vo);
		orderForm.setOrderInfo(bo.doGetOrderInfo(orderForm.getOrderid()));
		setForm(orderForm);
		CustwaytypeBO  custwaytypeBO = (CustwaytypeBO) BOFactory.build(CustwaytypeBO.class,super.getDBAccessUser());
		CustwaytypeVO custwaytypeVO = new CustwaytypeVO();
		custwaytypeVO.setCustwaytypecode(orderForm.getCooptype());
		custwaytypeVO.setCitycompid(super.getDBAccessUser().getCityid());
		custwaytypeVO = custwaytypeBO.doFindByPk(custwaytypeVO); 
		if( null != custwaytypeVO){
			orderForm.setCustwaytypename(custwaytypeVO.getCustwaytypename());
		}else{
			orderForm.setCustwaytypename(orderForm.getCooptype());
		}
		//��ȡ������Ʒ�۸���Ϣ
		Ordercomcate ordercomcateBO = (Ordercomcate)BOFactory.build(OrdercomcateBO.class,getDBAccessUser());
		OrdercomcateDBParam ordercomcateDBParam=new OrdercomcateDBParam();
		ordercomcateDBParam.set_se_orderid(vo.getOrderid());
		ordercomcateDBParam.set_desc(orderDBParam.get_desc());
		ordercomcateDBParam.set_orderby(orderDBParam.get_orderby());
		ordercomcateDBParam.set_pageno(orderDBParam.get_pageno());
		ordercomcateDBParam.set_pagesize(orderDBParam.get_pagesize());
		DataPackage dp =ordercomcateBO.doQuery(ordercomcateDBParam);
		
		//��ȡ�Ƿ����������ʶ
		List<OrdercomcateVO> ordercomcateList = dp.getDatas();
		
		Ordcomlog ordcomlog = (Ordcomlog)BOFactory.build(OrdcomlogBO.class, getDBAccessUser());
		OrdcomlogDBParam param = new OrdcomlogDBParam();
		param.set_se_orderid(vo.getOrderid());
		param.set_pagesize("0");
		DataPackage dp2 = ordcomlog.doQuery(param);
		List<OrdcomlogVO> ordcomlogVOList = dp2.getDatas();
		Set<Long> ordcomidSet = new HashSet<Long>();
		for(OrdcomlogVO ordcomlogVO : ordcomlogVOList)
		{
			ordcomidSet.add(ordcomlogVO.getOrdcomid());
		}
			
		for(OrdercomcateVO ordercomcateVO : ordercomcateList)
		{
			if(ordcomidSet.contains(ordercomcateVO.getRecid()))
			{
				ordercomcateVO.setChangeFlag("YES");
			}else{
				ordercomcateVO.setChangeFlag("NO");
			}
		}
		
		setDp(dp);
		
		//��˽��渨����Ϣ��ʾ
		Sysparam sysparamBO=(Sysparam)BOFactory.build(SysparamBO.class,getDBAccessUser());
		String sysparamvalue59=sysparamBO.doFindByID("59", "pboss_fx");
		if(!StringUtils.isEmpty(sysparamvalue59)&& "1".equals(sysparamvalue59)){
			String sysparamvalue60=sysparamBO.doFindByID("60", "pboss_fx");
			if(!StringUtils.isEmpty(sysparamvalue60)){
				orderForm.setShowAus(true);;//��Ϊչʾ������Ϣ
				orderForm.setMonthParam(sysparamvalue60);//����������ϵͳ����
				orderForm.setGiveCount(bo.doGetGiveCount(vo.getWayid(), sysparamvalue60));//��ȡ����������
				// ���ҷ�װ��˸�����Ϣ
				List<AuxiliaryInfoVO> auxInfoList=bo.doGetAuxiliaryInfo(vo);
				orderForm.setAuxInfoList(auxInfoList);
				orderForm.setStattypes(getStattypes(auxInfoList));
			}
		}
		
		super.setForm(orderForm);
		return "showapplist";
	}
	private String[] getStattypes(List<AuxiliaryInfoVO> auxInfoList){
		List<String> list=new ArrayList<String>();
		for(AuxiliaryInfoVO auxInfo:auxInfoList){
			for(AuxilaryActalarmVO actVO:auxInfo.getAuxilaryActalarmList()){
				if(!list.contains(actVO.getStattype())){
					list.add(actVO.getStattype());
				}
			}
		}
		String[] stattypes=new String[list.size()];
		int i=0;
		for(String l:list){
			stattypes[i]=l;
			i++;
		}
		Arrays.sort(stattypes);
		return stattypes;
	}
	
	/**
	 * ����������ϸ�б�
	 * @return
	 * @throws Exception
	 */
	public String doAppadjlist() throws Exception {
		OrderForm form = (OrderForm)super.getForm();
		String ordcomid = form.getOrdcomid();
		Ordcomlog ordcomlog = (Ordcomlog)BOFactory.build(OrdcomlogBO.class, getDBAccessUser());
		OrdcomlogDBParam param = new OrdcomlogDBParam();
		param.set_ne_ordcomid(ordcomid);
		param.set_pagesize("0");
		param.set_orderby("optime");
		param.set_desc("1");
		DataPackage dp = null;
		try{
			dp = ordcomlog.doQuery(param);
			List<OrdcomlogVO> ordcomlogList = dp.getDatas();
			for(int i=0; i<ordcomlogList.size(); i++)
			{
				OrdcomlogVO ordcomlogVO = ordcomlogList.get(i);
				ordcomlogVO.setId(i+1);
			}
		}catch (Exception e) {
			addActionError(e.getMessage());
		}
		setDp(dp);
		return "appadjlist";
	}
	
	/**
	 * ���ͨ������
	 */
	public String doAppPass()throws Exception {
		try{
		OrderDBParam orderDBParam = (OrderDBParam) getParam();
		Order bo = (Order)BOFactory.build(OrderBO.class,getDBAccessUser());
		OrderVO vo=bo.doFindByPk(orderDBParam.get_se_orderid());
		bo.doAudit(vo.getOrderid());
//		vo.setOrderstate("AUDITED");
//		bo.doUpdate(vo);
		//���á�������һ�������÷����������жϴ�����
		bo.doNextProcess(orderDBParam.get_se_orderid());
		setActionMessage("����[" + orderDBParam.get_se_orderid() + "]�����!");
		}catch(Exception ex){
			setActionMessage(ex.getMessage());
		}
		
		return doAppList();
	}
	/**
	 * ���ͨ����������ʾ��Ϣ
	 */
	public String doAppPassStockInfo()throws Exception {
		OrderDBParam orderDBParam = (OrderDBParam) getParam();
		Order bo = (Order)BOFactory.build(OrderBO.class,getDBAccessUser());
		OrderVO vo=bo.doFindByPk(orderDBParam.get_se_orderid());
		String[] orderids=new String[1];
		orderids[0]=vo.getOrderid();
		Map map=bo.doFindStockInfo(orderids);
		DataPackage dp=(DataPackage)map.get("DP");
		super.setDp(dp);
		OrderForm orderForm = (OrderForm)super.getForm();
		orderForm.setAppPass((Boolean)map.get("isAppPass"));
		super.setForm(orderForm);
		return "stockInfo";
	}
	/**
	 * �������ͨ����������ʾ��Ϣ
	 */
	public String doBatchAppPassStockInfo()throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String orderids=request.getParameter("orderids");
		String[] pks = orderids.split(",");
		Order bo = (Order)BOFactory.build(OrderBO.class,getDBAccessUser());
		Map map=bo.doFindStockInfo(pks);
		DataPackage dp=(DataPackage)map.get("DP");
		super.setDp(dp);
		OrderForm orderForm = (OrderForm)super.getForm();
		orderForm.setAppPass((Boolean)map.get("isAppPass"));
		super.setForm(orderForm);
		return "stockInfo";
	}
	//�������ͨ������
	public String doBatchAppPass()throws Exception{
		try{
			String[] selectItem = super.getParam().get_selectitem();
			String[] pks = new String[selectItem.length];
			for(int i=selectItem.length-1; i>=0;i--){
				pks[i] = selectItem[i].split("\\|")[0];
			}
			Order orderBO = (OrderBO) BOFactory.build(OrderBO.class,super.getDBAccessUser());
			orderBO.doBatchAudit(pks);
			for(String pk:pks){
				orderBO.doNextProcess(pk);//���á�������һ�������÷����������жϴ�����
			}
			setActionMessage("������˳ɹ�!");
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return doList();
	}
	/**
	 * ��ѡ������Ʒ�����������޸ġ�
	 * @return ���ض��������ѯ���档
	 * @throws Exception
	 */
	public String doAmtadjSave() throws Exception{
		try {
			Ordercomcate bo = (Ordercomcate)BOFactory.build(OrdercomcateBO.class,getDBAccessUser());
			HttpServletRequest request = ServletActionContext.getRequest();
			String recid=request.getParameter("recid");
			String orderamt=request.getParameter("orderamt");
			String memo=request.getParameter("memo");
			bo.doAmtadjSave(recid, orderamt,memo);
			setActionMessage("���������ɹ�!");
		} catch (Exception ex) {
			super.setActionMessage(ex.getMessage());
			ex.printStackTrace();
		}
		return doAppList();
	}
	
//	//��������һ������
//	public String doNextProcess() throws IOException{
//		try{
//			Order bo = (Order)BOFactory.build(OrderBO.class,getDBAccessUser());
//			OrderForm form = (OrderForm)super.getForm();
//			//����result[0] :0���˹�ģʽ���Խ�����һ��ҳ�桡�������̨�Զ�������������һ���������Ҳ���������Ϣ
//			
//			String[] result = bo.doUpdateNextProcess(form.getOrderid());
//			ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
//			
//			if( null != result && "0".equals(result[0])){
//				RequestDispatcher dispatcher = ServletActionContext.getRequest().getRequestDispatcher("/sales/orderresdet_drawList.do");
//				dispatcher.forward(ServletActionContext.getRequest(), ServletActionContext.getResponse());
//			}else if(null != result ){
//				ServletActionContext.getResponse().getWriter().write(result[1]);
//			}
//			ServletActionContext.getResponse().getWriter().write(result[0]+","+result[1]);
//		}catch(Exception e){
//			e.printStackTrace();
//			super.addActionError(e.getMessage());
//			ServletActionContext.getResponse().getWriter().write(e.getMessage());
//		}
//		return null;
//	}
	
	
	//��������һ������
	public String doNextProcess(){
		try{
			Order bo = (Order)BOFactory.build(OrderBO.class,getDBAccessUser());
			OrderForm form = (OrderForm)super.getForm();
			String[] result = bo.doNextProcess(form.getOrderid());
			ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
			ServletActionContext.getResponse().getWriter().write(result[0]+","+result[1]);
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return null;
	}
	//��������һ������
	public String doNextBatchProcess(){
		try{
			String selectitems=ServletActionContext.getRequest().getParameter("selectitems");
			String[] pks =selectitems.split("\\|");
			Order bo = (Order)BOFactory.build(OrderBO.class,getDBAccessUser());
			this.nextProcessResults = bo.doNextProcess(pks);
			//���ս����ʶ����
			NextProcessResult[] temp = this.nextProcessResults.toArray(new NextProcessResult[]{new NextProcessResult()});
			Arrays.sort(temp);
			this.nextProcessResults = Arrays.asList(temp);
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return "nextbatchprocess";
	}
	
	/**
	 * ȡ�ö���������Ϣ�����������̲��� ,��������������
	 * @param orderid
	 * @return
	 * @throws Exception
	 */
	public OrderForm getOrder(String orderid,String outState) throws Exception{
		Order bo = (Order)BOFactory.build(OrderBO.class,getDBAccessUser());
		OrderVO orderVO = bo.doFindByPk(orderid);
		OrderForm form = new OrderForm();
		BeanUtils.copyProperties(form,orderVO);
		form.setCustwaytypename(this.getCustwaytypename(form.getCooptype()));
		if(null != orderVO.getFlowid()){
			Orderproce orderproceBO = (OrderproceBO)BOFactory.build(OrderproceBO.class,getDBAccessUser());
			OrderproceDBParam orderproceParam = new OrderproceDBParam();
			orderproceParam.set_ne_flowid(orderVO.getFlowid().toString());
			orderproceParam.set_se_instate(orderVO.getOrderstate());
			orderproceParam.set_se_outstate(outState);
			DataPackage dp = orderproceBO.doQuery(orderproceParam);
			
			if( null != dp && null != dp.getDatas() && dp.getDatas().size()>0){
				OrderproceVO orderproceVO = (OrderproceVO)dp.getDatas().get(0);					
				form.setFlowOutstate(orderproceVO.getOutstate());
			}
		}
		return form;
	}
	
	//���շ�ҳ��
	public String doGoCharge(){
		try{
			OrderForm form = this.getOrder(super.getParam().get_pk(),"CHARGED");
			Order bo = (Order)BOFactory.build(OrderBO.class,getDBAccessUser());
			form.setOrderInfo(bo.doGetOrderInfo(form.getOrderid()));
			super.setForm(form);			
		}catch(Exception e){
			super.addActionError(e.getMessage());
		}
		return "charge";
	}
	
	//�����շ�
	public String doCharge(){
		try{
			Order bo = (Order)BOFactory.build(OrderBO.class,getDBAccessUser());
			OrderForm form = (OrderForm) super.getForm();
			form.setOrderInfo(bo.doGetOrderInfo(form.getOrderid()));
			OrderVO vo = new OrderVO();
			vo = bo.doFindByPk(form.getOrderid());
			vo.setPaytype(form.getPaytype());
			vo.setPosstream(form.getPosstream());
			vo.setActamt(form.getActamt());
			//BeanUtils.copyProperties(vo,form);
			bo.doPay(vo);
			
			//���á�������һ�������÷����������жϴ���������ʾ�����շ�����ɡ�
			bo.doNextProcess(vo.getOrderid());
			
			super.addActionMessage("�����շ������");
			this.doGoCharge();
			super.CMD = WEB_CMD_SAVE;
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError("����"+e.getMessage());
		}
		return this.doGoCharge();
	}
	
	//������ҳ��
	public String doGoRecorded(){
		try{
			OrderForm form = this.getOrder(super.getParam().get_pk(),"FINISHED");
			Order bo = (Order)BOFactory.build(OrderBO.class,getDBAccessUser());
			form.setOrderInfo(bo.doGetOrderInfo(form.getOrderid()));
			super.setForm(form);
		}catch(Exception e){
			super.addActionError(e.getMessage());
		}
		return "recorded";
	}
	
	/**
	 * ����
	 * 
	 * @return
	 */
	public String doRecorded() {
		try {
			this.doGoRecorded();
			OrderForm form = (OrderForm) getForm();
			form.setBossworkfid("-1");
			form.setStep("2");

			DBAccessUser user = (DBAccessUser) ActionContext.getContext()
					.getSession().get(WebConstant.SESSION_ATTRIBUTE_USER);
			Sysparam sysparam = (Sysparam) BOFactory.build(SysparamBO.class,
					user);
			String paramValue = sysparam.doFindByID("9", "pboss_fx");
			if (null == paramValue)
				paramValue = "120";
			form.setDelaySeconds(paramValue);

			User loginUser = (User) ActionContext.getContext().getSession()
					.get(WebConstant.SESSION_ATTRIBUTE_USER);
			String wayid = loginUser.getWayid();
			Order bo = (Order) BOFactory
					.build(OrderBO.class, getDBAccessUser());
			OrderVO orderVO = bo.recorded(super.getParam().get_pk(), wayid,"-1");
			if (new CRMService().isCRMCityPort(getDBAccessUser().getCityid())) {
				addActionMessage("ϵͳ���˳ɹ������ڵ���NGCRM���˽ӿڣ����Ժ򡭡�");
			} else {
				addActionMessage("ϵͳ���˳ɹ������ڵ���BOSS���˽ӿڣ����Ժ򡭡�");
			}
			super.CMD = WEB_CMD_SAVE;
		} catch (Exception e) {
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return "recorded";
	}

	/**
	 * ���ʣ�boss�ӿڣ�
	 * 
	 * @return
	 */
	public String doRecordByBoss() {
		Order bo = null;
		try {
			bo = (Order) BOFactory.build(OrderBO.class,getDBAccessUser());
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		this.doGoRecorded();
		OrderForm form = (OrderForm) getForm();
		try {
			form.setStep("3");
			Orderresdet orderdet = (OrderresdetBO) BOFactory.build(
					OrderresdetBO.class, this.getDBAccessUser());

			// ���ݶ�����ź���Դ��𲻵��ڿհ�SIM��Ϊ������ѯ������Դ��ϸ��FX_SW_ORDERRESDET�����û���ݣ���������BOSS/CRM���˲�����
			OrderresdetDBParam orderresdet = new OrderresdetDBParam();
			orderresdet.setQueryAll(true);
			orderresdet.setDataOnly(true);
			orderresdet.set_se_orderid(form.getOrderid());
			orderresdet.set_sne_restype("EMPTYSIM");
			DataPackage orderresdetdp = orderdet.doQuery(orderresdet);
			if (orderresdetdp != null && orderresdetdp.getDatas() != null
					&& orderresdetdp.getDatas().size() > 0) {

				DBAccessUser user = (DBAccessUser) ActionContext.getContext()
						.getSession().get(WebConstant.SESSION_ATTRIBUTE_USER);
				Sysparam sysparam = (Sysparam) BOFactory.build(
						SysparamBO.class, user);
				String paramValue = sysparam.doFindByID("9", "pboss_fx");
				if (null == paramValue)
					paramValue = "120";

				if (new CRMService().isCRMCityPort(getDBAccessUser()
						.getCityid())) {
					// CRM����Ҫ��ʱ
				} else {
					// BOSS��Ҫ��ʱ��Ĭ��120��
					int dss = Integer.parseInt(paramValue) * 1000;
					//Thread.sleep(dss);
					Thread.currentThread().join(dss);
				}

				User loginUser = (User) ActionContext.getContext().getSession()
						.get(WebConstant.SESSION_ATTRIBUTE_USER);
				String wayid = loginUser.getWayid();
				
				OrderVO orderVO = bo.recordByBoss(super.getParam().get_pk(),
						wayid);
				if (new CRMService().isCRMCityPort(getDBAccessUser()
						.getCityid())) {
					addActionMessage("�Ѿ��ύNGCRM����");
				} else {
					addActionMessage("BOSS���˳ɹ�");
				}
				if (!new CRMService().isCRMCityPort(getDBAccessUser()
						.getCityid())) {
					// �����ۿ�����
					Order boSms = (Order) BOFactory.build(OrderBO.class,
							getDBAccessUser());
					boSms.doSmsForSale(orderVO);
				}
				
			}
			super.CMD = WEB_CMD_SAVE;
		} catch (Exception e) {
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return "recorded";
	}
	
	//boss ��������
	public String doSupplyRecorded(){
		try{
			User loginUser = (User) ActionContext.getContext().getSession().get(
					WebConstant.SESSION_ATTRIBUTE_USER);
			Order bo = (Order)BOFactory.build(OrderBO.class,getDBAccessUser());
			String result[] = bo.bossSupplyRecorded(super.getParam().get_selectitem(),loginUser.getWayid() );
			this.doBossSupplyList();
			
			super.addActionMessage(result[0]);
			
			/*if(result[0].trim().length() > 0)
			{
			super.addActionMessage("���ͳɹ�[ "+result[0]+" ]");
			//�����ۿ�����
			Order boSms = (Order) BOFactory.build(OrderBO.class,
						getDBAccessUser());
				String ids[] = super.getParam().get_selectitem();
				for (String orderid : ids) {
					OrderVO orderVO = null;
					orderVO = boSms.doFindByPk(orderid);
					if (orderVO != null) {
						boSms.doSmsForSale(orderVO);
					}
				}
			}
			if(result[1].trim().length() > 0)
			super.addActionMessage("����ʧ��[ "+result[1]+" ]");*/
		}catch(Exception e){
			super.addActionError(e.getMessage());
		}
		return "bosssupplylist";
	}
	
	//��ȡ������������
	private String getCustwaytypename(String cooptype){	
		if( null == cooptype )
			return "";
		try{
			CustwaytypeBO  custwaytypeBO = (CustwaytypeBO) BOFactory.build(CustwaytypeBO.class,super.getDBAccessUser());
			CustwaytypeVO custwaytypeVO = new CustwaytypeVO();
			custwaytypeVO.setCustwaytypecode(cooptype);
			custwaytypeVO.setCitycompid(super.getDBAccessUser().getCityid());
			custwaytypeVO = custwaytypeBO.doFindByPk(custwaytypeVO); 
			if( null != custwaytypeVO){
				return custwaytypeVO.getCustwaytypename();
			}else{
				return cooptype;
			}
		}catch(Exception e){
			return cooptype;
		}		
	}
	/**
	 * �ط�����ȷ��
	 * @return
	 * @throws Exception
	 */
	public String doSecondConfirm() throws Exception{
		String[] selectItem = super.getParam().get_selectitem();
		String[] pk = new String[selectItem.length];
		for(int i=selectItem.length-1; i>=0;i--){
			pk[i] = selectItem[i].split("\\|")[0];
		}
		Smsconfirm smsconfirmBO = (Smsconfirm) BOFactory.build(SmsconfirmBO.class,super.getDBAccessUser());
		smsconfirmBO.doSecondConfirm(pk);//�ط�����ȷ��
		super.setActionMessage("����ȷ�϶����ط��ɹ���");
		return this.doList();
	}
	/**
	 * �ύ���
	 * @return
	 */
	public String doBatchSubmitAudit()throws Exception{
		try{
			String auditor=ServletActionContext.getRequest().getParameter("operid");
			String[] selectItem = super.getParam().get_selectitem();
			String[] pks = new String[selectItem.length];
			for(int i=selectItem.length-1; i>=0;i--){
				pks[i] = selectItem[i].split("\\|")[0];
			}
			Audit auditBO = (Audit) BOFactory.build(AuditBO.class,super.getDBAccessUser());
			auditBO.doBatchSubmitAudit(pks, auditor);
			setActionMessage("�����ύ��˳ɹ�!");
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return doList();
	}
	/**
	 * �ύ���
	 * @return
	 */
	public String doSubmitAudit()throws Exception{
		try{
			String auditor=ServletActionContext.getRequest().getParameter("operid");
			OrderDBParam orderDBParam = (OrderDBParam) getParam();
			Audit auditBO = (Audit) BOFactory.build(AuditBO.class,super.getDBAccessUser());
			auditBO.doSubmitAudit(orderDBParam.get_se_orderid(), auditor,true);
			setActionMessage("�ύ��˳ɹ�!");
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return doAppList();
	}
	/**
	 * ��������
	 * @return
	 */
	public String doDeduct()throws Exception{
		try{
			String orderid = getRequest().getParameter("orderid");
			Order orderBO = (OrderBO) BOFactory.build(OrderBO.class,getDBAccessUser());
			OrderVO vo = orderBO.doFindByPk(orderid);
			Bankdeduct bo = (Bankdeduct)BOFactory.build(BankdeductBO.class,getDBAccessUser());
			bo.doDeduct(vo);
			setActionMessage("����["+orderid+"]�����л����Ѵ�����");
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return doList();
	}
	
	//��������
	public String doBatchReview()throws Exception{
		try{
			String orderid = getRequest().getParameter("orderid");
			Order orderBO = (OrderBO) BOFactory.build(OrderBO.class,getDBAccessUser());
			
			String ois[] = orderid.split("\\|");
			for(int i=0 ; i<ois.length ; i++) {
				String oi = ois[i];
				orderBO.doReview(oi);
			}
			setActionMessage("���˳ɹ���");
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return doList();
	}
	//��������(��ϸ����) 
	public String doReview()throws Exception{
		try{
			OrderForm form = (OrderForm)super.getForm();
			
			String orderid = form.getOrderid();
			Order orderBO = (OrderBO) BOFactory.build(OrderBO.class,getDBAccessUser());
			
			orderBO.doReview(orderid);
			
			ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
			ServletActionContext.getResponse().getWriter().write("���˳ɹ�");
			
		}catch(Exception e){
			e.printStackTrace();
			ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
			ServletActionContext.getResponse().getWriter().write(e.getMessage());
			super.addActionError(e.getMessage());
		}
		return null;
	}
	
	//��Ʊ��ӡ
	public void doAjaxPrint(){
//		��ӡ���ڣ���ǰ���ڣ���ȷ��ʱ����
//		�������ţ���ǰ��������
//		�ܼƴ�д��������Ӧ�ս��ת���ɴ�д��
//		�ܼ�Сд������Ӧ�ս��
//		��Ʒ��Ϣ��
		String orderid = this.getRequest().getParameter("orderid");
		Order orderBO;
		PrintWriter out = null;
		this.getResponse().setContentType("text/html;charset=utf-8");
		try {
			orderBO = (OrderBO) BOFactory.build(OrderBO.class,getDBAccessUser());
			JSONArray jsonarray = orderBO.doAjaxPrint(orderid);
			out = this.getResponse().getWriter();
			out.print(jsonarray);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//ҵ�񵥴�ӡ
	public void doAjaxPrintBusiness(){
		String orderid = this.getRequest().getParameter("orderid");
		Order orderBO;
		PrintWriter out = null;
		this.getResponse().setContentType("text/html;charset=utf-8");
//		��ѯϵͳ�������ñ�IB_GL_SYSPARAM����ƥ���������Ϊ��pboss_fx����������ʶΪ��82����
//		��ȡҵ��������ӡ���������ж϶������������ӡ�����Ƿ񳬹�����ӡ�����������򷵻���ʾ��Ϣ���ѳ���ҵ��������ӡ��������
		try {
			orderBO = (OrderBO) BOFactory.build(OrderBO.class,getDBAccessUser());
			OrderVO ordervo = orderBO.doFindByPk(orderid);
			SysparamBO sysparamBO = (SysparamBO)BOFactory.build(SysparamBO.class,getDBAccessUser());
			SysparamVO sysparamVO = new SysparamVO();
			sysparamVO.setSystemid(new Long(82));
			sysparamVO.setParamtype("pboss_fx");
			sysparamVO = sysparamBO.doFindByPk(sysparamVO);
			if(sysparamVO != null && sysparamVO.getParamvalue() != null && !"".equals(sysparamVO.getParamvalue().trim())){				
				Integer accepprintamt = Integer.parseInt(sysparamVO.getParamvalue());
				ordervo.setAccepprintamt(ordervo.getAccepprintamt() == null ?0:ordervo.getAccepprintamt());
				if(ordervo.getAccepprintamt() > accepprintamt){
					throw new Exception("�ѳ���ҵ��������ӡ����!");
				}	
			}
			//���ϵͳû������ϵͳ�����أ�
			JSONArray jsonarray = orderBO.doAjaxPrintBusiness(orderid, ordervo);
			out = this.getResponse().getWriter();
			out.print(jsonarray);
			out.flush();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
//		����������������ӡ������1��Ϊ��ʱ����Ϊ1.
	}
	
	//�޸�ҵ�񵥴�ӡ����
	public void doUpdatePrintCount(){
		String orderid = this.getRequest().getParameter("orderid");
		Order orderBO;
		try {
			orderBO = (OrderBO) BOFactory.build(OrderBO.class,getDBAccessUser());
			OrderVO ordervo = orderBO.doFindByPk(orderid);
			ordervo.setAccepprintamt(ordervo.getAccepprintamt()==null?0:ordervo.getAccepprintamt()+1);
			orderBO.doUpdate(ordervo);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	
	
	public List<NextProcessResult> getNextProcessResults() {
		return nextProcessResults;
	}

	public void setNextProcessResults(List<NextProcessResult> nextProcessResults) {
		this.nextProcessResults = nextProcessResults;
	}
}