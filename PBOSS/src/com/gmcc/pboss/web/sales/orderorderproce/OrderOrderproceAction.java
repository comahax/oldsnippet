/**
 * auto-generated code
 * Wed Aug 10 16:07:59 CST 2011
 */
 package com.gmcc.pboss.web.sales.orderorderproce;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.base.dictitem.DictitemDBParam;
import com.gmcc.pboss.business.base.dictitem.DictitemVO;
import com.gmcc.pboss.business.channel.cntycompany.CntycompanyDBParam;
import com.gmcc.pboss.business.channel.cntycompany.CntycompanyVO;
import com.gmcc.pboss.business.channel.wayaccount.WayaccountDBParam;
import com.gmcc.pboss.business.channel.wayaccount.WayaccountVO;
import com.gmcc.pboss.business.sales.orderorderproce.OrderOrderproceVO ;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.sunrise.jop.ui.struts2.WebConstant;
import com.gmcc.pboss.business.sales.orderorderproce.OrderOrderproceDBParam;
import com.gmcc.pboss.business.sales.waystocksnpt.WaystocksnptVO;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.common.utils.tools.DateUtil;
import com.gmcc.pboss.control.base.dictitem.Dictitem;
import com.gmcc.pboss.control.base.dictitem.DictitemBO;
import com.gmcc.pboss.control.channel.cntycompany.Cntycompany;
import com.gmcc.pboss.control.channel.cntycompany.CntycompanyBO;
import com.gmcc.pboss.control.channel.wayaccount.Wayaccount;
import com.gmcc.pboss.control.channel.wayaccount.WayaccountBO;
import com.gmcc.pboss.control.sales.orderorderproce.OrderOrderproce ;
import com.gmcc.pboss.control.sales.orderorderproce.OrderOrderproceBO;

/**
 * <p>Title: OrderOrderproceAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class OrderOrderproceAction extends BaseAction{
	
	private Double dbDouble = 0D;
	
	
	public Double getDbDouble() {
		try {
			this.doListDetail();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dbDouble;
	}

	public void setDbDouble(Double dbDouble) {
		this.dbDouble = dbDouble;
	}

	public OrderOrderproceAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new OrderOrderproceForm());
		OrderOrderproceDBParam param=new OrderOrderproceDBParam();
		Date today = new Date();
		String todayStr = DateUtil.formatDate(today, DateUtil.DateFormatType.SIMPLE_DATE_FORMAT_STR);
		param.set_dnl_createtime(todayStr+ " 00:00:00");
		param.set_dnm_createtime(todayStr+ " 23:59:59");
		this.setParam(param);

        //指定VO类
        setClsVO(OrderOrderproceVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"rowcountid"};
		this.setClsControl(OrderOrderproce.class);
		this.setClsQueryParam(OrderOrderproceDBParam.class) ;

	}
	
	public String doShow() throws Exception {
		
		OrderOrderproceDBParam param =new OrderOrderproceDBParam();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String currentDate = format.format(new Date());
		param.set_dnl_createtime(currentDate + " 00:00:00");
		param.set_dnm_createtime(currentDate + " 23:59:59");

		return "list";
		
	}
	
	public String doList() throws Exception{
		
		OrderOrderproceDBParam params =(OrderOrderproceDBParam)getParam();
		String starttimeStr = params.get_dnl_createtime() ;
		String endtimeStr = params.get_dnm_createtime() ;
		
		Map<String,String> conditionMap = new HashMap<String, String>();
		//两者差距不能超过3天
		if(!StringUtils.isEmpty(starttimeStr)&&!StringUtils.isEmpty(endtimeStr))
		{
			Date startdate = DateUtil.parseDate(starttimeStr,DateUtil.DateFormatType.SIMPLE_DATE_FORMAT_STR);
			Date enddate = DateUtil.parseDate(endtimeStr,DateUtil.DateFormatType.SIMPLE_DATE_FORMAT_STR);
			int diff = DateUtil.operationDate(enddate, startdate, DateUtil.DateOperationType.DIFF);
			if(diff>2)
			{
				setActionMessage("时间间隔不能超过3天。");
				return WEB_RESULT_LIST;
			}
//			starttimeStr = starttimeStr + " 00:00:00";
//			endtimeStr = endtimeStr + " 23:59:59";
			
			conditionMap.put("starttimeStr", starttimeStr);
			conditionMap.put("endtimeStr", endtimeStr);
		}
		if(!StringUtils.isEmpty(params.get_se_countyid())){
			conditionMap.put("COUNTYID", params.get_se_countyid());
		}
		if(!StringUtils.isEmpty(params.get_se_paytype())){
			conditionMap.put("PAYTYPE", params.get_se_paytype());
		}
		OrderOrderproce orderOrderproce=(OrderOrderproce)BOFactory.build(OrderOrderproceBO.class,getDBAccessUser());
		String minTime =params.get_dnl_createtime();
		String maxTime=params.get_dnm_createtime();
		params.set_dnl_createtime(null);
		params.set_dnm_createtime(null);
//		params.setQueryAll(true);
		DataPackage dp=orderOrderproce.doQueryProce(conditionMap, params);
//		if(null==params.get_dnl_createtime()&&null==params.get_dnm_createtime()){
//			params.set_dnl_createtime(minTime);
//			params.set_dnm_createtime(maxTime);
//			
//		}
		List<OrderOrderproceVO> oopList=dp.getDatas();
		BigDecimal recamtFormat = null;
		BigDecimal recamtTotal = new BigDecimal("0");
		Long total=new Long(0);
		for(int i=0;i<oopList.size();i++){
			if(null!=oopList.get(i).getSumrecamt()){
				recamtFormat = new BigDecimal(oopList.get(i).getSumrecamt());
				recamtFormat = recamtFormat.setScale(2,BigDecimal.ROUND_HALF_EVEN);
				oopList.get(i).setSumrecamtFormat(recamtFormat.toString());
			}
			if(null!=oopList.get(i).getCountrecamt()){
				total+=oopList.get(i).getCountrecamt();
			}
			recamtTotal=recamtTotal.add(recamtFormat);
		}
		recamtTotal=recamtTotal.setScale(2,BigDecimal.ROUND_HALF_EVEN);
		
		OrderOrderproceVO orderproceVO=new OrderOrderproceVO();
		orderproceVO.setCountyid("合计");
		orderproceVO.setCountrecamt(total);
		orderproceVO.setSumrecamtFormat(recamtTotal.toString());
		oopList.add(orderproceVO);
		setDp(dp);
		
		return WEB_RESULT_LIST;
		
	}
	
	public String doExcel() throws Exception {
		
		OrderOrderproceDBParam params =(OrderOrderproceDBParam)getParam();
		String countycompname="";
		
		if(!"".equals(params.get_se_countyid())){
			CntycompanyDBParam cntycompanyDBParam=new CntycompanyDBParam();
			cntycompanyDBParam.set_se_countycompid(params.get_se_countyid());
			Cntycompany cc=(Cntycompany)BOFactory.build(CntycompanyBO.class,getDBAccessUser());
			DataPackage dataPackage=cc.doQuery(cntycompanyDBParam);
			if(dataPackage.getDatas().size()>0){
				List<CntycompanyVO> list=dataPackage.getDatas();
				countycompname=list.get(0).getCountycompname();
			}
			
			
		}
		Map<String,String> map=new HashMap<String, String>();
		map.put("ADPAY", "配送商垫资");
		map.put("CASH", "现金");
		map.put("POS", "POS机");
		map.put("BANK", "银行划扣");
		
		String paytype="";
		if(!"".equals(params.get_se_paytype())){
			DictitemDBParam param=new DictitemDBParam();
			param.set_se_groupid("FX_PAYTYPE");
			param.set_se_dictid(params.get_se_paytype());
			Dictitem d=(Dictitem)BOFactory.build(DictitemBO.class,getDBAccessUser());
			DataPackage dataPackage=d.doQuery(param);
			if(dataPackage.getDatas().size()>0){
				List<DictitemVO> list=dataPackage.getDatas();
				paytype=list.get(0).getDictname();
			}
//			paytype=map.get(params.get_se_paytype());
		}
		
		
		
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		export.setFileName("待收费订单查询明细导出");
		export.appendHeadLine(new String[] { "分公司:", countycompname,"缴费方式:",paytype  });
		export.appendHeadLine(new String[] { "创建时间>=:", params.get_dnl_createtime(),"创建时间<=:",params.get_dnm_createtime() });
		export.appendHeadLine(new String[] { "导出工号:", user.getOprcode(),"导出时间",format.format(new Date())  });
//		export.addOutputProperty("state.count", " 序号");
		export.addOutputProperty("orderid", "订单编号");
		export.addOutputProperty("wayid", "合作商编码");
		export.addOutputProperty("wayid", "合作商名称",export.CODE2NAME, "#WAYIDINFO");
		export.addOutputProperty("countyid", "分公司",CommonExportBean.CODE2NAME,"#CNTYCOMPANY");
		export.addOutputProperty("recamt", "应收金额（元）");
		export.addOutputProperty("deacctno", "银行账号");
		export.addOutputProperty("deacctname", "账号名称");
		export.addOutputProperty("debankid", "银行名称",export.CODE2NAME, "#BANK");
		export.appendEndLine(new String[] {"合计:",this.getDbDouble()+""});
		 
		
		// 设置VO类
		export.voClassArray = new Class[] { OrderOrderproceVO.class };
		
		// 设置查询方法
		export.queryMethodName = "doListDetail";
		
		getParam().set_pagesize("0");
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
	
	public String doListDetail() throws Exception {
		
		OrderOrderproceDBParam params =(OrderOrderproceDBParam)getParam();
		String starttimeStr = params.get_dnl_createtime() ;
		String endtimeStr = params.get_dnm_createtime() ;
		
		Map<String,String> conditionMap = new HashMap<String, String>();
		//两者差距不能超过3天
		if(!StringUtils.isEmpty(starttimeStr)&&!StringUtils.isEmpty(endtimeStr))
		{
			Date startdate = DateUtil.parseDate(starttimeStr,DateUtil.DateFormatType.SIMPLE_DATE_FORMAT_STR);
			Date enddate = DateUtil.parseDate(endtimeStr,DateUtil.DateFormatType.SIMPLE_DATE_FORMAT_STR);
			int diff = DateUtil.operationDate(enddate, startdate, DateUtil.DateOperationType.DIFF);
			if(diff>2)
			{
				setActionMessage("时间间隔不能超过3天。");
				return WEB_RESULT_LIST;
			}
//			starttimeStr = starttimeStr + " 00:00:00";
//			endtimeStr = endtimeStr + " 23:59:59";
			
			conditionMap.put("starttimeStr", starttimeStr);
			conditionMap.put("endtimeStr", endtimeStr);
		}
		if(!StringUtils.isEmpty(params.get_se_countyid())){
			conditionMap.put("COUNTYID", params.get_se_countyid());
		}
		if(!StringUtils.isEmpty(params.get_se_paytype())){
			conditionMap.put("PAYTYPE", params.get_se_paytype());
		}
		OrderOrderproce orderOrderproce=(OrderOrderproce)BOFactory.build(OrderOrderproceBO.class,getDBAccessUser());
		String minTime =params.get_dnl_createtime();
		String maxTime=params.get_dnm_createtime();
		params.set_dnl_createtime(null);
		params.set_dnm_createtime(null);
//		params.setQueryAll(true);
		DataPackage dp=orderOrderproce.doQueryProceDetail(conditionMap, params);
		if(null==params.get_dnl_createtime()&&null==params.get_dnm_createtime()){
			params.set_dnl_createtime(minTime);
			params.set_dnm_createtime(maxTime);
			
		}
		List<OrderOrderproceVO> oopList=dp.getDatas();
		
		Wayaccount wayaccount =(Wayaccount)BOFactory.build(WayaccountBO.class,getDBAccessUser());
		WayaccountDBParam param=new WayaccountDBParam();
//		param.set_se_wayid(_se_wayid)
		
		
		
		for(int i=0;i<oopList.size();i++){
//			Map map = (Map)oopList.get(i);
//			if("BANK".equals(oopList.get(i).getPaytype())){
				param.set_se_wayid(oopList.get(i).getWayid());
				DataPackage wcdp=wayaccount.doQuery(param);
				List<WayaccountVO> wcVO=wcdp.getDatas();
				if(wcVO.size()>0){
					oopList.get(i).setDeacctno(wcVO.get(0).getDeacctno());
					oopList.get(i).setDeacctname(wcVO.get(0).getDeacctname());
					oopList.get(i).setDebankid(wcVO.get(0).getDebankid());
				}
				
//			}
			dbDouble += oopList.get(i).getRecamt();
			
		}
		
		setDp(dp);
		
		return "list";
		
	}
	
}