/**
 * auto-generated code
 * Sat Dec 18 20:30:45 CST 2010
 */
 package com.gmcc.pboss.web.sales.orderresdetwayorderdetail;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.sales.order.OrderDBParam;
import com.gmcc.pboss.business.sales.order.OrderVO;
import com.gmcc.pboss.business.sales.orderlog.OrderlogDBParam;
import com.gmcc.pboss.business.sales.orderlog.OrderlogVO;
import com.gmcc.pboss.business.sales.orderresdetwayorderdetail.OrderresdetWayOrderDetailDBParam;
import com.gmcc.pboss.business.sales.orderresdetwayorderdetail.OrderresdetWayOrderDetailVO;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.common.utils.tools.DateUtil;
import com.gmcc.pboss.control.sales.order.Order;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.gmcc.pboss.control.sales.orderlog.Orderlog;
import com.gmcc.pboss.control.sales.orderlog.OrderlogBO;
import com.gmcc.pboss.control.sales.orderresdetwayorderdetail.OrderresdetWayOrderDetail;
import com.gmcc.pboss.control.sales.orderresdetwayorderdetail.OrderresdetWayOrderDetailBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * <p>Title: OrderresdetWayOrderDetailAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class OrderresdetWayOrderDetailAction extends BaseAction{
	
	public OrderresdetWayOrderDetailAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new OrderresdetWayOrderDetailForm());
		//日期不初始化,会查出所有的数据
		OrderresdetWayOrderDetailDBParam detailDBParam =new OrderresdetWayOrderDetailDBParam();
		Date today = new Date();
		String todayStr = DateUtil.formatDate(today, DateUtil.DateFormatType.SIMPLE_DATE_FORMAT_STR);
		detailDBParam.set_dnl_recordtime(todayStr+ " 00:00:00");
		detailDBParam.set_dnm_recordtime(todayStr+ " 23:59:59");
		this.setParam(detailDBParam);

        //指定VO类
        setClsVO(OrderresdetWayOrderDetailVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
//        this.pkNameArray=new String[]{"countyid"};
        this.pkNameArray=new String[]{"rowcountid"};
		this.setClsControl(OrderresdetWayOrderDetail.class);
		this.setClsQueryParam(OrderresdetWayOrderDetailDBParam.class) ;

	}
	
	public String doList() throws Exception{
		OrderresdetWayOrderDetailDBParam param = (OrderresdetWayOrderDetailDBParam)getParam();
		String starttimeStr = param.get_dnl_recordtime() ;
		String endtimeStr = param.get_dnm_recordtime() ;
		Map<String,String> conditionMap = new HashMap<String, String>();
		
		//两者差距不能超过30天
		if(!StringUtils.isEmpty(starttimeStr)&&!StringUtils.isEmpty(endtimeStr))
		{
//			Date startdate = DateUtil.parseDate(starttimeStr,DateUtil.DateFormatType.SIMPLE_DATE_FORMAT_STR);
//			Date enddate = DateUtil.parseDate(endtimeStr,DateUtil.DateFormatType.SIMPLE_DATE_FORMAT_STR);
			Date startdate = DateUtil.parseDate(starttimeStr,DateUtil.DateFormatType.SIMPLE_DATE_FORMAT_STR);
			Date enddate = DateUtil.parseDate(endtimeStr,DateUtil.DateFormatType.SIMPLE_DATE_FORMAT_STR);
			int diff = DateUtil.operationDate(enddate, startdate, DateUtil.DateOperationType.DIFF);
			if(diff>30)
			{
				setActionMessage("时间间隔不能超过30天。");
				return WEB_RESULT_LIST;
			}
//			starttimeStr = starttimeStr + " 00:00:00";
//			endtimeStr = endtimeStr + " 23:59:59";
			
			conditionMap.put("starttimeStr", starttimeStr);
			conditionMap.put("endtimeStr", endtimeStr);
		}
		
		if(!StringUtils.isEmpty(param.get_se_countyid()))
		{
			conditionMap.put("COUNTYID", param.get_se_countyid());
		}
		if(!StringUtils.isEmpty(param.get_se_svccode()))
		{
			conditionMap.put("SVCCODE", param.get_se_svccode());
		}
		if(!StringUtils.isEmpty(param.get_se_mareacode()))
		{
			conditionMap.put("MAREACODE", param.get_se_mareacode());
		}
		if(!StringUtils.isEmpty(param.get_se_wayid()))
		{
			conditionMap.put("WAYID", param.get_se_wayid());
		}
		if(!StringUtils.isEmpty(param.get_se_orderid()))
		{
			conditionMap.put("ORDERID", param.get_se_orderid());
		}
		if(!StringUtils.isEmpty(param.get_se_comcategory()))
		{
			conditionMap.put("COMCATEGORY", param.get_se_comcategory());
		}
//		WayFxSwOrder fxSwOrder = (WayFxSwOrder)BOFactory.build(WayFxSwOrderBO.class, getDBAccessUser());
		OrderresdetWayOrderDetail orderDetail = (OrderresdetWayOrderDetail)BOFactory.build(OrderresdetWayOrderDetailBO.class, getDBAccessUser());
		
		String minTime=param.get_dnl_recordtime();
		String maxTime=param.get_dnm_recordtime();
		param.set_dnl_recordtime(null);
		param.set_dnm_recordtime(null);
		
//		param.setQueryAll(true);
		DataPackage dp=orderDetail.doQueryOrderresdetWayOrderDetail(conditionMap, param);
		//当第一次的时候,设置默认的时间,当前时间,在action初始化的值,已经放在form中立
		if(null==param.get_dnl_recordtime()&&null==param.get_dnm_recordtime())
		{
//			Date today = new Date();
//			String todayStr = DateUtil.formatDate(today, DateUtil.DateFormatType.SIMPLE_DATE_FORMAT_STR);
//			starttimeStr = todayStr + " 00:00:00";
//			endtimeStr = todayStr + " 23:59:59";
			param.set_dnl_recordtime(minTime);
			param.set_dnm_recordtime(maxTime);
		}
		
		List<OrderresdetWayOrderDetailVO> owoList=dp.getDatas();
		//获取应收和实收
		Double oriprice = null;//应收总和(一行)
		Double relprice = null;//实收总和(一行)
		Long amount = null;
		for(int i=0; i<owoList.size(); i++)
		{
			oriprice = owoList.get(i).getComprice();
			relprice = owoList.get(i).getActprice();
//			System.out.println("----i-----"+i+"---oriprice---"+oriprice);
//			System.out.println("----i-----"+i+"---relprice---"+relprice);
			amount = owoList.get(i).getCountvalue();
			if(null!=amount)
			{	//有可能表中的价格字段没有值,就是null,必须设置汇总的值为0.00，格式化一下
				if(null==oriprice){
					owoList.get(i).setComcamt(0.00);
				}else{
					owoList.get(i).setComcamt(oriprice*amount);
				}
				if(null==relprice){
					owoList.get(i).setActamt(0.00);
				}else{
					owoList.get(i).setActamt(relprice*amount);
				}
//				if(null!=oriprice)owoList.get(i).setComcamt(oriprice*amount);
//				if(null!=relprice)owoList.get(i).setActamt(relprice*amount);
			}
		}
		//格式化数据
		BigDecimal recamtFormat = null;//应收总和(一行)
		BigDecimal actamtFormat = null;//实收总和(一行)
		
		for(int i=0; i<owoList.size(); i++)
		{
			if(null!=owoList.get(i).getActamt()||!("".equals(owoList.get(i).getActamt())))//实收一行的总价
			{
				actamtFormat = new BigDecimal(owoList.get(i).getActamt());
				actamtFormat = actamtFormat.setScale(2,BigDecimal.ROUND_HALF_EVEN);
				owoList.get(i).setActamtFormat(actamtFormat.toString());
			}else{
			
				actamtFormat = new BigDecimal(0.0);
				actamtFormat = actamtFormat.setScale(2,BigDecimal.ROUND_HALF_EVEN);
				owoList.get(i).setActamtFormat(actamtFormat.toString());
			}
			if(null!=owoList.get(i).getComcamt()||!("".equals(owoList.get(i).getComcamt())))//应收一行的总价
			{
				recamtFormat = new BigDecimal(owoList.get(i).getComcamt());
				recamtFormat = recamtFormat.setScale(2,BigDecimal.ROUND_HALF_EVEN);
				owoList.get(i).setComcamtFormat(recamtFormat.toString());
			}else{
			
				recamtFormat = new BigDecimal(0.0);
				recamtFormat = recamtFormat.setScale(2,BigDecimal.ROUND_HALF_EVEN);
				owoList.get(i).setActamtFormat(recamtFormat.toString());
			}
		}
		//入账时间：根据订单编号（ORDERID）查询订单表（FX_SW_ORDER）获取入账时间（RECORDTIME）
		Order  order=(Order)BOFactory.build(OrderBO.class ,getDBAccessUser());	
		DataPackage dp1 = new DataPackage();
		OrderDBParam orderDBParam =new OrderDBParam();
		String orderid="";
		for(int i=0; i<owoList.size(); i++)
		{
			orderid=owoList.get(i).getOrderid();
			if(!StringUtils.isEmpty(orderid))
			{
				orderDBParam.set_se_orderid(orderid);
				dp1=order.doQuery(orderDBParam);
				if(dp1.getRowCount()>0)
				{
					Date orderrecordtime=((List<OrderVO>)dp1.getDatas()).get(0).getRecordtime();
//					System.out.println("---------orderrecordtime---------"+orderrecordtime);
					SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String dateStr1 = sdf1.format(orderrecordtime); 
					owoList.get(i).setOrderrecordtime((dateStr1));
				}
			}
		}
//		入账工号：根据订单编号（ORDERID）、订单状态为已完成（即ORDERSTATE='FINISHED'）
//		查询订单日志表（FX_SW_ORDERLOG）获取操作员工号（OPRCODE），如有多条取第一条即可。
		Orderlog  orderlog=(Orderlog)BOFactory.build(OrderlogBO.class ,getDBAccessUser());	
		DataPackage dp2 = new DataPackage();
		OrderlogDBParam orderlogDBParam =new OrderlogDBParam();
		for(int i=0; i<owoList.size(); i++)
		{
			orderid=owoList.get(i).getOrderid();
//			System.out.println("----orderid---000-----"+orderid);
			if(!StringUtils.isEmpty(orderid))
			{
				orderlogDBParam.set_se_orderid(orderid);
//				System.out.println("----orderid---1111-----"+orderid);
				orderlogDBParam.set_se_orderstate("FINISHED");
				dp2=orderlog.doQuery(orderlogDBParam);
				if(dp2.getRowCount()>0)
				{
					String oprcode=((List<OrderlogVO>)dp2.getDatas()).get(0).getOprcode();
					owoList.get(i).setOprcode(oprcode);
				}
			}
		}
		setDp(dp);
//    	WayFxSwOrderDAO dao = (WayFxSwOrderDAO) DAOFactory.build(WayFxSwOrderDAO.class,getDBAccessUser());
//    	dao.query(param);
//		return WebConstant.PAGE_ATTRIBUTE_LIST;返回的页面时LIST,而不是list
		return WEB_RESULT_LIST;
	}
	
	public String doExcel() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("营收明细");
		export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
		export
				.appendHeadLine(new String[] { "导出时间",
						format.format(new Date()) });
//		export.addOutputProperty("state.count", " 序号");
		export.addOutputProperty("orderid", "订单编号");
		export.addOutputProperty("countyid", "分公司",CommonExportBean.CODE2NAME,"#CNTYCOMPANY");
		export.addOutputProperty("svccode", "服务营销中心",CommonExportBean.CODE2NAME,"#SERVCENT");
		export.addOutputProperty("mareacode", "微区域",CommonExportBean.CODE2NAME,"#MICROAREA");
		export.addOutputProperty("starlevel", "星级",CommonExportBean.CODE2NAME,"$CH_STARLEVEL");
		export.addOutputProperty("wayid", "网点编码");
		export.addOutputProperty("wayid", "网点名称",CommonExportBean.CODE2NAME,"#WAYIDINFO");
		export.addOutputProperty("comid", "商品名称",CommonExportBean.CODE2NAME,"#COMSYSTEM");
		export.addOutputProperty("countvalue", "数量(套/张)");
		export.addOutputProperty("comcamtFormat", "应收（元）");
		export.addOutputProperty("actamtFormat", "实收（元）");
		export.addOutputProperty("orderrecordtime", "入账时间");
		export.addOutputProperty("oprcode", "入账工号");
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		
		OrderresdetWayOrderDetailDBParam orderDBParam = (OrderresdetWayOrderDetailDBParam) getParam();
		orderDBParam.setQueryAll(true);
		export.queryMethodName = "doList";
//		orderDBParam.set_pagesize("65535");
//		getParam().set_pagesize("65535");
//		OrderresdetWayOrderDetailDBParam detailDBParam =new OrderresdetWayOrderDetailDBParam();
//		detailDBParam.setQueryAll(true);
		
		return super.doExcel();
	}
	
	
}