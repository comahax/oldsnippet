/**
 * auto-generated code
 * Tue Dec 14 14:53:32 CST 2010
 */
 package com.gmcc.pboss.web.sales.orderstate;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.sales.orderstate.OrderstateDBParam;
import com.gmcc.pboss.business.sales.orderstate.OrderstateVO;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.common.utils.tools.DateUtil;
import com.gmcc.pboss.control.sales.orderstate.Orderstate;
import com.gmcc.pboss.control.sales.orderstate.OrderstateBO;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * <p>Title: OrderstateAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author YangDaRen
 * @version 1.0
 */
public class OrderstateAction extends BaseAction{
	
	public OrderstateAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new OrderstateForm());
		OrderstateWebParam orderDBParam = new OrderstateWebParam();
		orderDBParam.set_dnl_createtime(PublicUtils.formatUtilDate(new Date(),"yyyy-MM-dd")+" 00:00:00");
		orderDBParam.set_dnm_createtime(PublicUtils.formatUtilDate(new Date(),"yyyy-MM-dd")+" 23:59:59");
		this.setParam(orderDBParam);

        //指定VO类
        setClsVO(OrderstateVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"cntid"};
        this.setClsControl(Orderstate.class);
		this.setClsQueryParam(OrderstateDBParam.class);

	}
	
	@Override
	public String doList() throws Exception{		
		OrderstateDBParam param = (OrderstateDBParam)getParam();
		String starttimeStr = param.get_dnl_createtime();
		String endtimeStr = param.get_dnm_createtime();
		
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
		}
		
		DataPackage dp = null;
		try{
			Orderstate orderBO = (OrderstateBO) BOFactory.build(OrderstateBO.class,super.getDBAccessUser());
			dp = orderBO.doQueryState(param);
			//默认按当天的起始时间查询
			if(null == param.get_dnl_createtime() )
				param.set_dnl_createtime(PublicUtils.formatUtilDate(new Date(),"yyyy-MM-dd")+" 00:00:00");
			if(null == param.get_dnm_createtime() )
				param.set_dnm_createtime(PublicUtils.formatUtilDate(new Date(),"yyyy-MM-dd")+" 23:59:59");
		}catch (Exception e) {
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		super.setDp(dp);
		return WEB_RESULT_LIST;
	}
	
	public String doExcel() throws Exception{
		try{
			HttpServletRequest request = ServletActionContext.getRequest();
			User user = (User) getDBAccessUser();
			CommonExportBean export = new CommonExportBean(user);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			export.setFileName("订单状态统计[套卡]");
			export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
			export
					.appendHeadLine(new String[] { "导出时间:",
							format.format(new Date()) });
			export.addOutputProperty("countyid", "分公司",export.CODE2NAME, "#CNTYCOMPANY");
			export.addOutputProperty("svccode", "服务销售中心",export.CODE2NAME, "#SERVCENT");
			export.addOutputProperty("mareacode", "微区域",export.CODE2NAME,"#MICROAREA");
			//星级
			export.addOutputProperty("starlevel", "星级",export.CODE2NAME,"$CH_STARLEVEL");
			export.addOutputProperty("orderave", "订购途径", export.CODE2NAME, "$FX_ORDERAVE");
			export.addOutputProperty("alarmlevel", "预警级别",export.CODE2NAME,"$FX_STOCKALARMLEVEL");
			export.addOutputProperty("orderstate", "订单状态", export.CODE2NAME, "$FX_ORDERFSTATE");
			export.addOutputProperty("ordercount", "订单数");
			export.addOutputProperty("brand", "品牌",export.CODE2NAME,"$FX_SMPBRAND");
			export.addOutputProperty("comcategory", "商品种类",export.CODE2NAME,"$IM_FXCOMCATEGORY");
			export.addOutputProperty("orderamt", "数量[套]");
						
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
			// 设置取出所有查询到的数据
			OrderstateDBParam orderDBParam = (OrderstateDBParam) getParam();
			orderDBParam.setQueryAll(true);
			
			return super.doExcel();
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return null;
	}
}