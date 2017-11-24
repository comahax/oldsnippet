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
	
	//下一步处理：处理一批数据返回结果（多于一条）
	List<NextProcessResult> nextProcessResults;

	public String getOutstate() {
		return outstate;
	}

	public void setOutstate(String outstate) {
		this.outstate = outstate;
	}

	public OrderAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new OrderForm());
		this.setParam(new OrderWebParam());

        //指定VO类
        setClsVO(OrderVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"orderid"};
		this.setClsControl(Order.class);
		this.setClsQueryParam(OrderDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
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
					
					
			//默认按当天的起始时间查询
			if(null == orderDBParam.get_dnl_createtime() )
				orderDBParam.set_dnl_createtime(PublicUtils.formatUtilDate(new Date(),"yyyy-MM-dd")+" 00:00:00");
			if(null == orderDBParam.get_dnm_createtime() )
				orderDBParam.set_dnm_createtime(PublicUtils.formatUtilDate(new Date(),"yyyy-MM-dd")+" 23:59:59");
			if( null == orderDBParam.get_se_orderstate()){//默认按己抽取
				orderDBParam.set_se_orderstate("EXTRAED");
			}
			//默认按订单创建时间排序
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
								vo.setCrmstate("CRM入账处理中");
							}else{
								if("-1".equals(bossworkfid)){
									vo.setCrmstate("入账失败");
								}else if ("1".equals(bossworkfid)) {
									vo.setCrmstate("待CRM入账");
								}else{
									vo.setCrmstate("入账成功");
								}
							}
						}
					}
				}
				
				super.setDp(dp);
				//构造最后一行汇总数据
				orderForm.setAllactamt(orderBO.getAllActAmt(dp));
				orderForm.setAllbrand(orderBO.getAllBrandInfo(dp));
			}
			orderForm.setFirstDisplay(false);
			Sysparam sysBO = (Sysparam) BOFactory.build(SysparamBO.class, getDBAccessUser());
			String param44 = sysBO.doFindByID("44", "pboss_fx");//库存检查开关（订单审核）
			
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
			export.setFileName("订单信息");
			export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
			export
					.appendHeadLine(new String[] { "导出时间",
							format.format(new Date()) });
			export.addOutputProperty("orderid", "订单编号");
			export.addOutputProperty("wayid", "合作商编码");
			export.addOutputProperty("wayid", "合作商名称",export.CODE2NAME, "#WAYIDINFO");
			export.addOutputProperty("countyid", "分公司",export.CODE2NAME, "#CNTYCOMPANY");
			export.addOutputProperty("mareacode", "微区域",export.CODE2NAME,"#MICROAREA");
			//星级
			export.addOutputProperty("starlevel", "星级",export.CODE2NAME,"$CH_STARLEVEL");
			export.addOutputProperty("orderave", "订购途径", export.CODE2NAME, "$FX_ORDERAVE");
			export.addOutputProperty("createtime", "创建时间",export.DATE,"yyyy-MM-dd HH:mm:ss");
			export.addOutputProperty("orderstate", "订单状态", export.CODE2NAME, "$FX_ORDERFSTATE");
			export.addOutputProperty("crmstate", "BOSS/CRM状态");
			export.addOutputProperty("paytype", "缴费方式", export.CODE2NAME, "$FX_PAYTYPE");
			export.addOutputProperty("recamt", "应收金额(元)",export.EXPRESSION,null);
			export.addOutputProperty("actamt", "实收金额(元)",export.EXPRESSION,null);
			export.addOutputProperty("paytime", "到帐时间",export.DATE,"yyyy-MM-dd HH:mm:ss");
			//入账时间
			export.addOutputProperty("recordtime", "入账时间",export.DATE,"yyyy-MM-dd HH:mm:ss");
			export.addOutputProperty("deductstate", "划扣状态", export.CODE2NAME, "$FX_DEDUCTSTATE");
			export.addOutputProperty("orderInfo", "订单信息");
			//品牌信息
			export.addOutputProperty("brandInfo", "品牌信息");
			export.addOutputProperty("discomcode", "配送商", export.CODE2NAME, "#WAYIDINFO");
			//配送完成时间
			export.addOutputProperty("disovertime", "配送完成时间",export.DATE,"yyyy-MM-dd HH:mm:ss");
			export.addOutputProperty("alarmlevel", "预警级别",export.CODE2NAME,"$FX_STOCKALARMLEVEL");
			export.addOutputProperty("confirmflag", "是否确认",export.CODE2NAME,"$IM_YESNO10");
			export.addOutputProperty("signstate", "签收状态", export.CODE2NAME, "$FX_SIGNSTATE");
			//签收时间
			export.addOutputProperty("signtime", "签收时间",export.DATE,"yyyy-MM-dd HH:mm:ss");
			//签收方式
			export.addOutputProperty("signtype", "签收方式",export.CODE2NAME,"$FX_SIGNTYPE");
			//短信签收号码
			export.addOutputProperty("smssignno", "短信签收号码");
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
			//默认按订单创建时间排序
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

		// 查询商品种类
		if (dpp == null || dpp.getDatas().size() == 0) {
			DictitemDBParam dictitemDBParam = new DictitemDBParam();
			dictitemDBParam.set_se_groupid("IM_FXCOMCATEGORY");
			dictitemDBParam.set_orderby("dictname");
			dictitemDBParam.set_orderby("1");
			dpp = dictitemBO.doQuery(dictitemDBParam);

		} else {
			dpp.setDatas(dictitemBO.doQueryDictBySql());
		}

		// 统计对应订单资源数
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
	
	//补送BOSS入账导出Excel
	public String doExportboss() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("补送BOSS入账");
		export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
		export.appendHeadLine(new String[] { "导出时间", format.format(new Date())});
		export.addOutputProperty("orderid", "订单编号");
		export.addOutputProperty("wayid", "合作商编码");
		export.addOutputProperty("wayid", "合作商名称", CommonExportBean.CODE2NAME, "#WAYIDINFO");
		export.addOutputProperty("countyid", "分公司", CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("mareacode", "微区域", CommonExportBean.CODE2NAME, "#MICROAREA");
		export.addOutputProperty("orderave", "订购途径", CommonExportBean.CODE2NAME, "$FX_ORDERAVE");
		export.addOutputProperty("createtime", "创建时间", export.DATE, "yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("orderstate", "订单状态", CommonExportBean.CODE2NAME, "$FX_ORDERFSTATE");
		export.addOutputProperty("paytype", "缴费方式", CommonExportBean.CODE2NAME, "$FX_PAYTYPE");
		export.addOutputProperty("memo", "备注");
		
		// 设置查询方法
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
	
	
	
	//订单作废
	public String doRemove() throws IOException{
		try{
			OrderDBParam param = (OrderDBParam) super.getParam();
			OrderForm orderForm = (OrderForm)super.getForm();
			String[] selectItem = param.get_selectitem();
			selectItem[0] = selectItem[0].replaceAll("\\s", "");
			String[] pk = selectItem[0].split(",");
			
			Order orderBO = (OrderBO) BOFactory.build(OrderBO.class,super.getDBAccessUser());
			String result = orderBO.cancleOrder(pk, orderForm.getCancelReason(), orderForm.getCancelDes());
			
			//订购作废后，短信通知,涉及数据库变更操作的步骤要求包含在一个事务中，
			//包括订单数据修改、实时订购量更新、订单资源释放、配送单作废等步骤。
			//不包括发送短信通知
			orderBO.doSmsAfterCancel(pk, orderForm.getCancelReason(), orderForm.getCancelDes());
			super.addActionMessage("操作完成 "+result);
						
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
		super.addActionMessage("删除操作已完成!");
		return this.doBossSupplyList();
	}
	
	/*
	 * 跳转到标签页
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
			//获取合作类型名称
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
			//取订单信息 根据订单编号查询订单商品种类 (FX_SW_ORDERCOMCATE)，
//			将同商品种类的订购数量进行累加，并按照“商品种类A（数量），商品种类B（数量）”进行组合。
			Order orderBO = (OrderBO) BOFactory.build(OrderBO.class,super.getDBAccessUser());
			orderForm.setOrderInfo(orderBO.doGetOrderInfo(orderForm.getOrderid()));
			
			//审核时间：查询订单日志表（FX_SW_ORDERLOG），
			//匹配订单编号和订单状态为已审核（AUDITED），
			//审核时间取状态变更时间（STATECHGTIME）。如果无数据则不显示
			Orderlog orderlog = (OrderlogBO) BOFactory.build(OrderlogBO.class,super.getDBAccessUser());
			OrderlogDBParam orderlogDB = new OrderlogDBParam();
			orderlogDB.set_se_orderid(orderForm.getOrderid());//订单编号
			orderlogDB.set_se_orderstate("AUDITED");//订单状态为已审核
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
	 * 订单审核列表
	 * @return
	 * @throws Exception
	 */
	public String doAppList() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		//获取订单信息
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
		//获取订单商品价格信息
		Ordercomcate ordercomcateBO = (Ordercomcate)BOFactory.build(OrdercomcateBO.class,getDBAccessUser());
		OrdercomcateDBParam ordercomcateDBParam=new OrdercomcateDBParam();
		ordercomcateDBParam.set_se_orderid(vo.getOrderid());
		ordercomcateDBParam.set_desc(orderDBParam.get_desc());
		ordercomcateDBParam.set_orderby(orderDBParam.get_orderby());
		ordercomcateDBParam.set_pageno(orderDBParam.get_pageno());
		ordercomcateDBParam.set_pagesize(orderDBParam.get_pagesize());
		DataPackage dp =ordercomcateBO.doQuery(ordercomcateDBParam);
		
		//获取是否调整数量标识
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
		//查询是否存在审核信息
		Audit auditBO = (Audit)BOFactory.build(AuditBO.class,getDBAccessUser());
		AuditDBParam auditDBParam=new AuditDBParam();
		auditDBParam.set_se_orderid(vo.getOrderid());
		auditDBParam.set_orderby("smsntime");
		auditDBParam.set_desc("1");
	
		//关联订单审核表[FX_SW_AUDIT]和订单审核明细表[FX_SW_AUDITDET]，如果存在当前订单编号且审核状态为“待审核”的记录，则将按钮置为不可用
		auditDBParam.set_se_state("0");
		List<AuditVO> auditlist=auditBO.doGetAuditInfo(auditDBParam).getDatas();
		if(auditlist.size()>0){
			orderForm.setHasAudit("Y");
		}
		//关联订单审核表[FX_SW_AUDIT]和订单审核明细表[FX_SW_AUDITDET]，如果存在对应的订单编号且最新的“审核状态”为非“通过[1]”，则按钮不可用。
		auditDBParam.set_se_state(null);
		auditlist=auditBO.doGetAuditInfo(auditDBParam).getDatas();
		if(auditlist.size()>0){
			if(!"1".equals(auditlist.get(0).getState())){
				orderForm.setHasWaitAudit("Y");
			}
		}
		/*
		//查询是否存在待审核0状态的审核信息
		List<AuditVO> auditlist=auditBO.doQuery(auditDBParam).getDatas();
		if(auditlist.size()>0){
			orderForm.setHasAudit("Y");
			orderForm.setHasWaitAudit("Y");
		}
		//查询是否存在未通过审核2状态的审核信息
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
		
		//审核界面辅助信息显示
		Sysparam sysparamBO=(Sysparam)BOFactory.build(SysparamBO.class,getDBAccessUser());
		String sysparamvalue59=sysparamBO.doFindByID("59", "pboss_fx");
		if(!StringUtils.isEmpty(sysparamvalue59)&& "1".equals(sysparamvalue59)){
			String sysparamvalue60=sysparamBO.doFindByID("60", "pboss_fx");
			if(!StringUtils.isEmpty(sysparamvalue60)){
				orderForm.setShowAus(true);;//设为展示辅助信息
				orderForm.setMonthParam(sysparamvalue60);//主动放弃数系统参数
				orderForm.setGiveCount(bo.doGetGiveCount(vo.getWayid(), sysparamvalue60));//获取主动发起数
				// 查找封装审核辅助信息
				List<AuxiliaryInfoVO> auxInfoList=bo.doGetAuxiliaryInfo(vo);
				orderForm.setAuxInfoList(auxInfoList);
				orderForm.setStattypes(getStattypes(auxInfoList));
			}
		}
		Sysparam sysBO = (Sysparam) BOFactory.build(SysparamBO.class, getDBAccessUser());
		String param44 = sysBO.doFindByID("44", "pboss_fx");//库存检查开关（订单审核）
		orderForm.setParam44(param44);
		super.setForm(orderForm);
		return "applist";
	}
	/**
	 * 订单多级审核中展示订单审核列表
	 * @return
	 * @throws Exception
	 */
	public String doShowAppList() throws Exception {
		//获取订单信息
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
		//获取订单商品价格信息
		Ordercomcate ordercomcateBO = (Ordercomcate)BOFactory.build(OrdercomcateBO.class,getDBAccessUser());
		OrdercomcateDBParam ordercomcateDBParam=new OrdercomcateDBParam();
		ordercomcateDBParam.set_se_orderid(vo.getOrderid());
		ordercomcateDBParam.set_desc(orderDBParam.get_desc());
		ordercomcateDBParam.set_orderby(orderDBParam.get_orderby());
		ordercomcateDBParam.set_pageno(orderDBParam.get_pageno());
		ordercomcateDBParam.set_pagesize(orderDBParam.get_pagesize());
		DataPackage dp =ordercomcateBO.doQuery(ordercomcateDBParam);
		
		//获取是否调整数量标识
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
		
		//审核界面辅助信息显示
		Sysparam sysparamBO=(Sysparam)BOFactory.build(SysparamBO.class,getDBAccessUser());
		String sysparamvalue59=sysparamBO.doFindByID("59", "pboss_fx");
		if(!StringUtils.isEmpty(sysparamvalue59)&& "1".equals(sysparamvalue59)){
			String sysparamvalue60=sysparamBO.doFindByID("60", "pboss_fx");
			if(!StringUtils.isEmpty(sysparamvalue60)){
				orderForm.setShowAus(true);;//设为展示辅助信息
				orderForm.setMonthParam(sysparamvalue60);//主动放弃数系统参数
				orderForm.setGiveCount(bo.doGetGiveCount(vo.getWayid(), sysparamvalue60));//获取主动发起数
				// 查找封装审核辅助信息
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
	 * 订单调整明细列表
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
	 * 审核通过功能
	 */
	public String doAppPass()throws Exception {
		try{
		OrderDBParam orderDBParam = (OrderDBParam) getParam();
		Order bo = (Order)BOFactory.build(OrderBO.class,getDBAccessUser());
		OrderVO vo=bo.doFindByPk(orderDBParam.get_se_orderid());
		bo.doAudit(vo.getOrderid());
//		vo.setOrderstate("AUDITED");
//		bo.doUpdate(vo);
		//调用【订单下一步处理公用方法】，不判断处理结果
		bo.doNextProcess(orderDBParam.get_se_orderid());
		setActionMessage("订单[" + orderDBParam.get_se_orderid() + "]已审核!");
		}catch(Exception ex){
			setActionMessage(ex.getMessage());
		}
		
		return doAppList();
	}
	/**
	 * 审核通过分配量提示信息
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
	 * 批量审核通过分配量提示信息
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
	//批量审核通过功能
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
				orderBO.doNextProcess(pk);//调用【订单下一步处理公用方法】，不判断处理结果
			}
			setActionMessage("批量审核成功!");
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return doList();
	}
	/**
	 * 对选定的商品订购量进行修改。
	 * @return 返回订单管理查询界面。
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
			setActionMessage("数量调整成功!");
		} catch (Exception ex) {
			super.setActionMessage(ex.getMessage());
			ex.printStackTrace();
		}
		return doAppList();
	}
	
//	//订单的下一步处理
//	public String doNextProcess() throws IOException{
//		try{
//			Order bo = (Order)BOFactory.build(OrderBO.class,getDBAccessUser());
//			OrderForm form = (OrderForm)super.getForm();
//			//返回result[0] :0表人工模式可以进入下一步页面　１：表后台自动处理　２表无下一步操作或找不到订单信息
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
	
	
	//订单的下一步处理
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
	//订单的下一步处理
	public String doNextBatchProcess(){
		try{
			String selectitems=ServletActionContext.getRequest().getParameter("selectitems");
			String[] pks =selectitems.split("\\|");
			Order bo = (Order)BOFactory.build(OrderBO.class,getDBAccessUser());
			this.nextProcessResults = bo.doNextProcess(pks);
			//按照结果标识排序
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
	 * 取得订单基本信息包括订单流程步骤 ,及合作类型名称
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
	
	//到收费页面
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
	
	//订单收费
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
			
			//调用【订单下一步处理公用方法】，不判断处理结果，提示订单收费已完成。
			bo.doNextProcess(vo.getOrderid());
			
			super.addActionMessage("订单收费已完成");
			this.doGoCharge();
			super.CMD = WEB_CMD_SAVE;
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError("错误："+e.getMessage());
		}
		return this.doGoCharge();
	}
	
	//到入帐页面
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
	 * 入帐
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
				addActionMessage("系统入账成功，正在调用NGCRM入账接口，请稍候……");
			} else {
				addActionMessage("系统入账成功，正在调用BOSS入账接口，请稍候……");
			}
			super.CMD = WEB_CMD_SAVE;
		} catch (Exception e) {
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return "recorded";
	}

	/**
	 * 入帐（boss接口）
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

			// 根据订单编号和资源类别不等于空白SIM卡为条件查询订单资源明细表（FX_SW_ORDERRESDET）如果没数据，跳过以下BOSS/CRM入账操作。
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
					// CRM不需要延时
				} else {
					// BOSS需要延时，默认120秒
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
					addActionMessage("已经提交NGCRM入帐");
				} else {
					addActionMessage("BOSS入账成功");
				}
				if (!new CRMService().isCRMCityPort(getDBAccessUser()
						.getCityid())) {
					// 发送售卡短信
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
	
	//boss 补送入帐
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
			super.addActionMessage("补送成功[ "+result[0]+" ]");
			//发送售卡短信
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
			super.addActionMessage("补送失败[ "+result[1]+" ]");*/
		}catch(Exception e){
			super.addActionError(e.getMessage());
		}
		return "bosssupplylist";
	}
	
	//获取合作类型名称
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
	 * 重发订购确认
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
		smsconfirmBO.doSecondConfirm(pk);//重发订购确认
		super.setActionMessage("订购确认短信重发成功。");
		return this.doList();
	}
	/**
	 * 提交审核
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
			setActionMessage("批量提交审核成功!");
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return doList();
	}
	/**
	 * 提交审核
	 * @return
	 */
	public String doSubmitAudit()throws Exception{
		try{
			String auditor=ServletActionContext.getRequest().getParameter("operid");
			OrderDBParam orderDBParam = (OrderDBParam) getParam();
			Audit auditBO = (Audit) BOFactory.build(AuditBO.class,super.getDBAccessUser());
			auditBO.doSubmitAudit(orderDBParam.get_se_orderid(), auditor,true);
			setActionMessage("提交审核成功!");
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return doAppList();
	}
	/**
	 * 触发划扣
	 * @return
	 */
	public String doDeduct()throws Exception{
		try{
			String orderid = getRequest().getParameter("orderid");
			Order orderBO = (OrderBO) BOFactory.build(OrderBO.class,getDBAccessUser());
			OrderVO vo = orderBO.doFindByPk(orderid);
			Bankdeduct bo = (Bankdeduct)BOFactory.build(BankdeductBO.class,getDBAccessUser());
			bo.doDeduct(vo);
			setActionMessage("订单["+orderid+"]的银行划扣已触发。");
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return doList();
	}
	
	//批量复核
	public String doBatchReview()throws Exception{
		try{
			String orderid = getRequest().getParameter("orderid");
			Order orderBO = (OrderBO) BOFactory.build(OrderBO.class,getDBAccessUser());
			
			String ois[] = orderid.split("\\|");
			for(int i=0 ; i<ois.length ; i++) {
				String oi = ois[i];
				orderBO.doReview(oi);
			}
			setActionMessage("复核成功。");
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return doList();
	}
	//批量复核(明细复核) 
	public String doReview()throws Exception{
		try{
			OrderForm form = (OrderForm)super.getForm();
			
			String orderid = form.getOrderid();
			Order orderBO = (OrderBO) BOFactory.build(OrderBO.class,getDBAccessUser());
			
			orderBO.doReview(orderid);
			
			ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
			ServletActionContext.getResponse().getWriter().write("复核成功");
			
		}catch(Exception e){
			e.printStackTrace();
			ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
			ServletActionContext.getResponse().getWriter().write(e.getMessage());
			super.addActionError(e.getMessage());
		}
		return null;
	}
	
	//发票打印
	public void doAjaxPrint(){
//		打印日期：当前日期，精确到时分秒
//		操作工号：当前操作工号
//		总计大写：将订单应收金额转换成大写。
//		总计小写：订单应收金额
//		商品信息：
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
	
	//业务单打印
	public void doAjaxPrintBusiness(){
		String orderid = this.getRequest().getParameter("orderid");
		Order orderBO;
		PrintWriter out = null;
		this.getResponse().setContentType("text/html;charset=utf-8");
//		查询系统参数配置表（IB_GL_SYSPARAM），匹配参数类型为“pboss_fx”，参数标识为“82”，
//		获取业务受理单打印最大次数。判断订单表的受理单打印数量是否超过最大打印次数，超过则返回提示信息“已超出业务受理单打印次数。”
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
					throw new Exception("已超出业务受理单打印次数!");
				}	
			}
			//如果系统没有设置系统参数呢？
			JSONArray jsonarray = orderBO.doAjaxPrintBusiness(orderid, ordervo);
			out = this.getResponse().getWriter();
			out.print(jsonarray);
			out.flush();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
//		将订单表中受理单打印次数加1，为空时更新为1.
	}
	
	//修改业务单打印数量
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