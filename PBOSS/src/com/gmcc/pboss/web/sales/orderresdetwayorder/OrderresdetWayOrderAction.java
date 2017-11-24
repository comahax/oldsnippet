/**
 * auto-generated code
 * Sat Dec 18 09:48:51 CST 2010
 */
 package com.gmcc.pboss.web.sales.orderresdetwayorder;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.sales.orderresdetwayorder.OrderresdetWayOrderVO ;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.sunrise.jop.ui.struts2.WebConstant;
import com.gmcc.pboss.business.sales.orderresdetwayorder.OrderresdetWayOrderDBParam;
import com.gmcc.pboss.business.sales.ressum.RessumVO;
import com.gmcc.pboss.business.sales.wayfxsworder.WayFxSwOrderDBParam;
import com.gmcc.pboss.business.sales.wayfxsworder.WayFxSwOrderVO;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.common.utils.tools.DateUtil;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.sales.orderresdetwayorder.OrderresdetWayOrder ;
import com.gmcc.pboss.control.sales.orderresdetwayorder.OrderresdetWayOrderBO;
import com.gmcc.pboss.control.sales.wayfxsworder.WayFxSwOrder;
import com.gmcc.pboss.control.sales.wayfxsworder.WayFxSwOrderBO;

/**
 * <p>Title: OrderresdetWayOrderAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class OrderresdetWayOrderAction extends BaseAction{
	
	public OrderresdetWayOrderAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new OrderresdetWayOrderForm());
		//日期不初始化,会查出所有的数据
		OrderresdetWayOrderDBParam orderDBParam =new OrderresdetWayOrderDBParam();
		Date today = new Date();
		String todayStr = DateUtil.formatDate(today, DateUtil.DateFormatType.SIMPLE_DATE_FORMAT_STR);
		orderDBParam.set_dnl_recordtime(todayStr+ " 00:00:00");
		orderDBParam.set_dnm_recordtime(todayStr+ " 23:59:59");
		this.setParam(orderDBParam);

        //指定VO类
        setClsVO(OrderresdetWayOrderVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
//        this.pkNameArray=new String[]{"countyid"};
        this.pkNameArray=new String[]{"rowcountid"};
		this.setClsControl(OrderresdetWayOrder.class);
		this.setClsQueryParam(OrderresdetWayOrderDBParam.class) ;

	}
	public String doList() throws Exception{
		OrderresdetWayOrderDBParam param = (OrderresdetWayOrderDBParam)getParam();
		String starttimeStr = param.get_dnl_recordtime() ;
		String endtimeStr = param.get_dnm_recordtime() ;
		
		Map<String,String> conditionMap = new HashMap<String, String>();
		
		//两者差距不能超过30天
		if(!StringUtils.isEmpty(starttimeStr)&&!StringUtils.isEmpty(endtimeStr))
		{
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
		
		if(!StringUtils.isEmpty(param.get_ne_countyid()))
		{
			conditionMap.put("COUNTYID", param.get_ne_countyid());
		}
		if(!StringUtils.isEmpty(param.get_ne_svccode()))
		{
			conditionMap.put("SVCCODE", param.get_ne_svccode());
		}
		if(!StringUtils.isEmpty(param.get_ne_mareacode()))
		{
			conditionMap.put("MAREACODE", param.get_ne_mareacode());
		}
		if(!StringUtils.isEmpty(param.get_ne_starlevel()))
		{
			conditionMap.put("STARLEVEL", param.get_ne_starlevel());
		}
//		WayFxSwOrder fxSwOrder = (WayFxSwOrder)BOFactory.build(WayFxSwOrderBO.class, getDBAccessUser());
		OrderresdetWayOrder fxSwOrder = (OrderresdetWayOrder)BOFactory.build(OrderresdetWayOrderBO.class, getDBAccessUser());
		
		String minTime=param.get_dnl_recordtime();
		String maxTime=param.get_dnm_recordtime();
		param.set_dnl_recordtime(null);
		param.set_dnm_recordtime(null);
		param.setQueryAll(true);
		DataPackage dp=fxSwOrder.doQueryOrderresdetWayOrder(conditionMap, param);
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
		List<OrderresdetWayOrderVO> owoList=dp.getDatas();
		//获取应收和实收
		Double oriprice = null;//应收总和(一行)
		Double relprice = null;//实收总和(一行)
		Long amount = null;
		for(int i=0; i<owoList.size(); i++)
		{
			oriprice = owoList.get(i).getComprice();
			relprice = owoList.get(i).getActprice();
			amount = owoList.get(i).getCountvalue();
			if(null!=amount)
			{	//有可能表中的价格字段没有值,就是null,必须设置汇总的值为0.00，格式化一下
//				if(null!=oriprice)owoList.get(i).setComcamt(oriprice*amount);
//				if(null!=relprice)owoList.get(i).setActamt(relprice*amount);
				if(null==oriprice){
					owoList.get(i).setComcamt(0.00);
				}else{
					owoList.get(i).setComcamt(oriprice*amount);
					System.out.println("owoList.get(i).setComcamt(oriprice*amount)"+owoList.get(i).getComcamt());
				}
				if(null==relprice){
					owoList.get(i).setActamt(0.00);
				}else{
					owoList.get(i).setActamt(relprice*amount);
					System.out.println("owoList.get(i).setActamt(oriprice*amount)"+owoList.get(i).getActamt());
				}
			}
		}
		//格式化数据
		BigDecimal oripriceFormat = null;//应收单价
		BigDecimal relpriceFormat = null;//实收单价
		BigDecimal recamtFormat = null;//应收总和(一行)
		BigDecimal actamtFormat = null;//实收总和(一行)
		
		Long amountTotal = 0L;//数量总和(所有的行)
		BigDecimal recamtTotal = new BigDecimal("0");//应收总和(所有的行)
		BigDecimal actamtTotal = new BigDecimal("0");//实收总和(所有的行)
		
		for(int i=0; i<owoList.size(); i++)
		{
			if(null!=owoList.get(i).getComprice())//应收单价
			{
				oripriceFormat = new BigDecimal(owoList.get(i).getComprice());
				oripriceFormat = oripriceFormat.setScale(2,BigDecimal.ROUND_HALF_EVEN);
				owoList.get(i).setCompriceFormat(oripriceFormat.toString());
//				System.out.println("owoList.get(i).getComprice()应收单价:"+owoList.get(i).getCompriceFormat());
			}
			if(null!=owoList.get(i).getActprice())//实收单价
			{
				relpriceFormat = new BigDecimal(owoList.get(i).getActprice());
				relpriceFormat = relpriceFormat.setScale(2,BigDecimal.ROUND_HALF_EVEN);
				owoList.get(i).setActpriceFormat(relpriceFormat.toString());
//				System.out.println("owoList.get(i).getActprice()实收单价:"+owoList.get(i).getActpriceFormat());
			}
			if(null!=owoList.get(i).getActamt()||!("".equals(owoList.get(i).getActamt())))//实收一行的总价
			{
				actamtFormat = new BigDecimal(owoList.get(i).getActamt());
				actamtFormat = actamtFormat.setScale(2,BigDecimal.ROUND_HALF_EVEN);
				owoList.get(i).setActamtFormat(actamtFormat.toString());
//				System.out.println("owoList.get(i).getActamtFormat 实收一行的总价 "+owoList.get(i).getActamtFormat());
			}else{
			
				actamtFormat = new BigDecimal(0.0);
				actamtFormat = actamtFormat.setScale(2,BigDecimal.ROUND_HALF_EVEN);
				owoList.get(i).setActamtFormat(actamtFormat.toString());
//				System.out.println("owoList.get(i).getActamtFormat 实收一行的总价 "+owoList.get(i).getActamtFormat());
			}
			if(null!=owoList.get(i).getComcamt()||!("".equals(owoList.get(i).getComcamt())))//应收一行的总价
			{
				recamtFormat = new BigDecimal(owoList.get(i).getComcamt());
				recamtFormat = recamtFormat.setScale(2,BigDecimal.ROUND_HALF_EVEN);
				owoList.get(i).setComcamtFormat(recamtFormat.toString());
//				System.out.println("owoList.get(i).getComcamt 应收一行的总价 "+owoList.get(i).getComcamtFormat());
			}else{
			
				recamtFormat = new BigDecimal(0.0);
				recamtFormat = recamtFormat.setScale(2,BigDecimal.ROUND_HALF_EVEN);
				owoList.get(i).setActamtFormat(recamtFormat.toString());
//				System.out.println("owoList.get(i).getComcamt 应收一行的总价 "+owoList.get(i).getComcamtFormat());
			}
			
			amountTotal = amountTotal + owoList.get(i).getCountvalue();
			recamtTotal = recamtTotal.add(recamtFormat);//应收总和(所有的行)
			actamtTotal = actamtTotal.add(actamtFormat);//实收总和(所有的行)
			
		}
		
		OrderresdetWayOrderVO orderresdetWayOrderVO = new OrderresdetWayOrderVO();
		orderresdetWayOrderVO.setCountyid("合计");
		orderresdetWayOrderVO.setCountvalue(amountTotal);
		recamtTotal = recamtTotal.setScale(2,BigDecimal.ROUND_HALF_EVEN);
		actamtTotal = actamtTotal.setScale(2,BigDecimal.ROUND_HALF_EVEN);
		orderresdetWayOrderVO.setComcamtFormat(recamtTotal.toString());
		orderresdetWayOrderVO.setActamtFormat(actamtTotal.toString());
		owoList.add(orderresdetWayOrderVO);
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
		export.setFileName("营收汇总[星级]资源汇总");
		export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
		export
				.appendHeadLine(new String[] { "导出时间",
						format.format(new Date()) });
//		export.addOutputProperty("state.count", " 序号");
		export.addOutputProperty("countyid", "分公司",CommonExportBean.CODE2NAME,"#CNTYCOMPANY");
		export.addOutputProperty("svccode", "服务营销中心",CommonExportBean.CODE2NAME,"#SERVCENT");
		export.addOutputProperty("mareacode", "微区域",CommonExportBean.CODE2NAME,"#MICROAREA");
		export.addOutputProperty("starlevel", "星级",CommonExportBean.CODE2NAME,"$CH_STARLEVEL");
		export.addOutputProperty("comid", "商品名称",CommonExportBean.CODE2NAME,"#COMSYSTEM");
		export.addOutputProperty("countvalue", "数量(套/张)");
		export.addOutputProperty("compriceFormat", "原价（元）");
		export.addOutputProperty("actpriceFormat", "实价（元）");
		export.addOutputProperty("comcamtFormat", "应收（元）");
		export.addOutputProperty("actamtFormat", "实收（元）");
		getParam().set_pagesize("0");
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
	
}