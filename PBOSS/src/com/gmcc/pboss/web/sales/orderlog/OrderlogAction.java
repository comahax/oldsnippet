/**
 * auto-generated code
 * Tue Apr 24 15:01:18 CST 2012
 */
 package com.gmcc.pboss.web.sales.orderlog;

import java.io.OutputStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.resource.emptysim.EmptysimDBParam;
import com.gmcc.pboss.business.resource.emptysim.EmptysimVO;
import com.gmcc.pboss.business.sales.order.OrderDBParam;
import com.gmcc.pboss.business.sales.orderlog.OrderlogVO ;
import com.sunrise.jop.common.utils.lang.InterfaceUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.filter.PermissionChecker;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.sunrise.jop.ui.struts2.WebConstant;
import com.gmcc.pboss.business.sales.orderlog.OrderlogDBParam; 
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.common.export.CommonExportBeanClass;
import com.gmcc.pboss.control.base.operright.Operright;
import com.gmcc.pboss.control.base.operright.OperrightBO;
import com.gmcc.pboss.control.sales.disformprint.DisformprintBO;
import com.gmcc.pboss.control.sales.orderlog.Orderlog ;
import com.gmcc.pboss.control.sales.orderlog.OrderlogBO;

/**
 * <p>Title: OrderlogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class OrderlogAction extends BaseAction{
	private boolean flag = false;
	public OrderlogAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new OrderlogForm());
		this.setParam(new OrderlogDBParam());

        //指定VO类
        setClsVO(OrderlogVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Orderlog.class);
		this.setClsQueryParam(OrderlogDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	public String doList() throws Exception {
		OrderlogDBParam orderlogDBParam = (OrderlogDBParam) getParam(); 
		if( null == orderlogDBParam.get_se_orderstate()){//默认按己抽取
			orderlogDBParam.set_se_orderstate("EXTRAED");//
		}
		if (null == orderlogDBParam.get_se_oprcode()) {   //默认工号为当前操作工号
			orderlogDBParam.set_se_oprcode(super.getDBAccessUser().getOprcode());
		} 
		if(null != orderlogDBParam.get_dnl_optime() && !("").equals(orderlogDBParam.get_dnl_optime())) {
			String date_nl = orderlogDBParam.get_dnl_optime()+" 00:00:00";
			orderlogDBParam.set_dnl_optime(date_nl);
		}
		if (null != orderlogDBParam.get_dnm_optime() && !("").equals(orderlogDBParam.get_dnm_optime())) {
			String date_nm = orderlogDBParam.get_dnm_optime()+" 23:59:59";
			orderlogDBParam.set_dnm_optime(date_nm);
		}
		return super.doList();
	}
	
	//导出txt 导出excel 查询方法 
	public String doListForExport() throws Exception {
		OrderlogDBParam orderlogDBParam = (OrderlogDBParam) getParam();  
		Orderlog orderlog = (OrderlogBO)BOFactory.build(OrderlogBO.class, getDBAccessUser());
	    orderlogDBParam.set_pagesize("0");
	    if(null != orderlogDBParam.get_dnl_optime() && !("").equals(orderlogDBParam.get_dnl_optime())) {
			String date_nl = orderlogDBParam.get_dnl_optime()+" 00:00:00";
			orderlogDBParam.set_dnl_optime(date_nl);
		}
		if (null != orderlogDBParam.get_dnm_optime() && !("").equals(orderlogDBParam.get_dnm_optime())) {
			String date_nm = orderlogDBParam.get_dnm_optime()+" 23:59:59";
			orderlogDBParam.set_dnm_optime(date_nm);
		}
	    //判断是否有操作工号的权限
	    Operright operright = (Operright) BOFactory.build(OperrightBO.class, getDBAccessUser().getInnerUser());
		boolean flag = true;
		flag=operright.doCheckPermission(getDBAccessUser().getOprcode(), "FX_ORDERMG_ORDERLOG");  
		if (false==flag){ 
			orderlogDBParam.set_se_oprcode(getDBAccessUser().getOprcode());
		} 
	    orderlogDBParam.set_sql_condition(" rownum <=10000");
		DataPackage dp = orderlog.doExportList(orderlogDBParam);  
		this.setDp(dp); 
		return "list";
	} 
	//导出txt文件
	public String doTxt() throws Exception { 
		User user = (User) getDBAccessUser();
		CommonExportBeanClass export = new CommonExportBeanClass(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("订单日志导出");
		export.addOutputProperty("logid", "日志标识");
		export.addOutputProperty("optime", "操作时间",export.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("oprcode", "操作工号",export.CODE2NAME, "#OPERATOR");
		export.addOutputProperty("oprtype", "日志操作类型",export.CODE2NAME, "$OPRTYPE");
		export.addOutputProperty("success", "操作状态",export.CODE2NAME, "SUCCESS");
		export.addOutputProperty("orderid", "订单编码");
		export.addOutputProperty("flowid", "订购流程编码");
		export.addOutputProperty("wayid", "合作商编码"); 
		export.addOutputProperty("countyid", "分公司",export.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("starlevel", "星级",export.CODE2NAME, "$CH_STARLEVEL");
		export.addOutputProperty("orderave", "订购途径",export.CODE2NAME, "$FX_ORDERAVE");
		export.addOutputProperty("storarea", "订购资源库区",export.CODE2NAME,"$IM_FXSTORAREA");
		export.addOutputProperty("createtime", "创建时间",export.DATE,"yyyy-MM-dd HH:mm:ss");  
		export.addOutputProperty("orderstate", "订单状态",export.CODE2NAME, "$FX_ORDERFSTATE"); 
		export.addOutputProperty("statechgtime", "状态变更时间",export.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("paytype", "缴费方式",export.CODE2NAME, "$FX_PAYTYPE"); 
		export.addOutputProperty("delitype", "送货方式",export.CODE2NAME, "$FX_DELITYPE");  
		export.addOutputProperty("recamt", "应收金额");
		export.addOutputProperty("actamt", "实收金额");
		export.addOutputProperty("posstream", "POS机流水号");
		export.addOutputProperty("bossworkfid", "BOSS工单编号");
		export.addOutputProperty("memo", "备注");
		export.addOutputProperty("discomcode", "配送商",export.CODE2NAME, "#WAYIDINFO");
		export.addOutputProperty("paytime", "到账时间",export.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("deductstate", "划扣状态",export.CODE2NAME,"$FX_DEDUCTSTATE");
		export.addOutputProperty("signstate", "签收状态",export.CODE2NAME,"$FX_SIGNSTATE");
		export.addOutputProperty("alarmlevel", "预警级别",export.CODE2NAME,"$FX_STOCKALARMLEVEL");
		export.addOutputProperty("confirmflag", "是否确认",export.CODE2NAME,"$IM_YESNO10");
		export.addOutputProperty("mareacode", "微区域",export.CODE2NAME, "#MICROAREA");
		export.addOutputProperty("signtime", "签收时间",export.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("recordtime", "入账时间",export.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("disovertime", "配送完成时间",export.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("signtype", "签收方式",export.CODE2NAME, "$FX_SIGNTYPE");
		export.addOutputProperty("smssignno", "短信签收号码");
		export.addOutputProperty("reviewstate", "复核状态",export.CODE2NAME, "$FX_REVIEWSTATE");  
		export.queryMethodName = "doListForExport";
		export.voClassArray = new Class[] { OrderlogVO.class }; 
		prepareResponse(export.getFileName());
		OrderlogDBParam params = (OrderlogDBParam)super.getParam();
		params.set_pageno("0");
		super.setParam(params);
		export.writeTxtTitle(getResponse().getOutputStream(), new String[] {
				"日志标识","操作时间","操作工号", "日志操作类型", "操作状态", "订单编码" ,"订购流程编码","合作商编码","分公司","星级","订购途径","订购资源库区",
				"创建时间","订单状态","状态变更时间","缴费方式","送货方式","应收金额","实收金额","POS机流水号","BOSS工单编号","备注","配送商","到账时间","划扣状态",
				"签收状态","预警级别","是否确认","微区域","签收时间","入账时间","配送完成时间","签收方式","短信签收号码","复核状态"});
		this.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
		return null;
	} 
	//导出excel文件
	public String doExcel() throws Exception { 
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBeanClass export = new CommonExportBeanClass(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("订单日志导出");
		export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
		export.appendHeadLine(new String[] { "导出时间",format.format(new Date()) });
		export.addOutputProperty("logid", "日志标识");
		export.addOutputProperty("optime", "操作时间",export.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("oprcode", "操作工号",export.CODE2NAME, "#OPERATOR");
		export.addOutputProperty("oprtype", "日志操作类型",export.CODE2NAME, "$OPRTYPE");
		export.addOutputProperty("success", "操作状态",export.CODE2NAME, "SUCCESS");
		export.addOutputProperty("orderid", "订单编码");
		export.addOutputProperty("flowid", "订购流程编码");
		export.addOutputProperty("wayid", "合作商编码"); 
		export.addOutputProperty("countyid", "分公司",export.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("starlevel", "星级",export.CODE2NAME, "$CH_STARLEVEL");
		export.addOutputProperty("orderave", "订购途径",export.CODE2NAME, "$FX_ORDERAVE");
		export.addOutputProperty("storarea", "订购资源库区",export.CODE2NAME,"$IM_FXSTORAREA");
		export.addOutputProperty("createtime", "创建时间",export.DATE,"yyyy-MM-dd HH:mm:ss");  
		export.addOutputProperty("orderstate", "订单状态",export.CODE2NAME, "$FX_ORDERFSTATE"); 
		export.addOutputProperty("statechgtime", "状态变更时间",export.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("paytype", "缴费方式",export.CODE2NAME, "$FX_PAYTYPE"); 
		export.addOutputProperty("delitype", "送货方式",export.CODE2NAME, "$FX_DELITYPE");  
		export.addOutputProperty("recamt", "应收金额");
		export.addOutputProperty("actamt", "实收金额");
		export.addOutputProperty("posstream", "POS机流水号");
		export.addOutputProperty("bossworkfid", "BOSS工单编号");
		export.addOutputProperty("memo", "备注");
		export.addOutputProperty("discomcode", "配送商",export.CODE2NAME, "#WAYIDINFO");
		export.addOutputProperty("paytime", "到账时间",export.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("deductstate", "划扣状态",export.CODE2NAME,"$FX_DEDUCTSTATE");
		export.addOutputProperty("signstate", "签收状态",export.CODE2NAME,"$FX_SIGNSTATE");
		export.addOutputProperty("alarmlevel", "预警级别",export.CODE2NAME,"$FX_STOCKALARMLEVEL");
		export.addOutputProperty("confirmflag", "是否确认",export.CODE2NAME,"$IM_YESNO10");
		export.addOutputProperty("mareacode", "微区域",export.CODE2NAME, "#MICROAREA");
		export.addOutputProperty("signtime", "签收时间",export.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("recordtime", "入账时间",export.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("disovertime", "配送完成时间",export.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("signtype", "签收方式",export.CODE2NAME, "$FX_SIGNTYPE");
		export.addOutputProperty("smssignno", "短信签收号码");
		export.addOutputProperty("reviewstate", "复核状态",export.CODE2NAME, "$FX_REVIEWSTATE");  
		export.queryMethodName = "doListForExport";
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		OrderlogDBParam params = (OrderlogDBParam)super.getParam();
		params.set_pagesize("0");
		super.setParam(params); 
		return doExcels(); 
	}
	public void ExportQuery(BaseVO actionForm, HttpServletRequest request,
			HttpServletResponse response, User user,
			CommonExportBeanClass commonExportBean) throws Exception {
		// 查询数据输出,分页查询
		BaseVO baseActionForm = (BaseVO) actionForm;
		// baseActionForm.set_pagesize(String.valueOf(CommonExportBean.EXCELOUT_PAGE_SIZE));
		ArrayList list;
		OutputStream os = response.getOutputStream();
		if("0".equals(this.param.get_pagesize())){//因为导出都是所有的导出，但为效率，采用分页的方式导出数据
			this.param.set_pagesize(""+CommonExportBeanClass.EXCELOUT_PAGE_SIZE);//设置每面最多的记录数
			this.param.setQueryAll(false);
		}
		for (int startindex = 1;; startindex++) {
			// baseActionForm.set_pageno(String.valueOf(startindex));
			this.param.set_pageno(""+startindex);//设置导出的页码
			if ("doList".equals(commonExportBean.queryMethodName)) {
				doList();
				
			} else {
				Method method = this.getClass().getMethod(
						commonExportBean.queryMethodName, null);
				method.invoke(this, null);
			}
			list = (ArrayList) (getDp().getDatas());	
			if (list != null && !list.isEmpty()) {
				//临时加上下面一行，为测试
				//System.out.println("测试：正在导出数据至excel，当前时间："+new Date().toLocaleString());
				commonExportBean.write(os, list.iterator(),
						commonExportBean.voClassArray);
				if (list.size() < CommonExportBeanClass.EXCELOUT_PAGE_SIZE 
						|| ((this.getDp().getRowCount()+CommonExportBeanClass.EXCELOUT_PAGE_SIZE-1)/CommonExportBeanClass.EXCELOUT_PAGE_SIZE)<=startindex) {// 代表最后一页
					break;
				}
			} else {// 该页没有数据
				break;
			}
			list.clear();
		}
	}	
	
	public String doExcels() throws Exception{
		CommonExportBeanClass commonExportBean = (CommonExportBeanClass)getRequest()
				.getAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT);
		if(commonExportBean.voClassArray==null)
			commonExportBean.voClassArray = new Class[] { OrderlogVO.class };
		// commonExportBean.queryMethodName = "doList";
		if (commonExportBean.headtitle == null) {
			commonExportBean.headtitle = commonExportBean.getFileName();
		}
		commonExportBean.buildExcelPage(getForm(), getRequest(), getResponse(),
				(User) getDBAccessUser(), this);
		return null;
	}
}