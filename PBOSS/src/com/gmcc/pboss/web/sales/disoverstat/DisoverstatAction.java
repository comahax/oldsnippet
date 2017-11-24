/**
 * auto-generated code
 * Mon Nov 14 15:52:02 CST 2011
 */
 package com.gmcc.pboss.web.sales.disoverstat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.channel.employee.EmployeeDBParam;
import com.gmcc.pboss.business.channel.employee.EmployeeVO;
import com.gmcc.pboss.business.sales.disoverdetail.DisoverdetailDBParam;
import com.gmcc.pboss.business.sales.disoverstat.DisoverstatDBParam;
import com.gmcc.pboss.business.sales.disoverstat.DisoverstatVO;
import com.gmcc.pboss.business.sales.salesstd.SalesstdDBParam;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.cooperator.CooperatorBO;
import com.gmcc.pboss.control.channel.employee.EmployeeBO;
import com.gmcc.pboss.control.sales.disoverdetail.DisoverdetailBO;
import com.gmcc.pboss.control.sales.disoverstat.Disoverstat;
import com.gmcc.pboss.control.sales.disoverstat.DisoverstatBO;
import com.gmcc.pboss.control.sales.salesstd.SalesstdBO;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * <p>Title: DisoverstatAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class DisoverstatAction extends BaseAction{
	
	public DisoverstatAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new DisoverstatForm());
		this.setParam(new DisoverstatDBParam());

        //指定VO类
        setClsVO(DisoverstatVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"seqid"};
		this.setClsControl(Disoverstat.class);
		this.setClsQueryParam(DisoverstatDBParam.class) ;

	}
	public String doShow() {
		Calendar cal = Calendar.getInstance();
		cal.add(cal.DAY_OF_MONTH, -1);
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
		String s = df1.format(cal.getTime()); 	
		
		try {
			Sysparam sysparam = (Sysparam)BOFactory.build(SysparamBO.class, getDBAccessUser());
			String paramValue66 = sysparam.doFindByID("66", "pboss_fx");
			String paramValue67 = sysparam.doFindByID("67", "pboss_fx");
			
			this.getRequest().getSession().setAttribute("count1", paramValue66);
			this.getRequest().getSession().setAttribute("count2", paramValue67);
			
			
			EmployeeBO employeeBO = (EmployeeBO)BOFactory.build(EmployeeBO.class, this.getDBAccessUser());
			EmployeeDBParam employeedbparam = new EmployeeDBParam();
			employeedbparam.set_se_wayid(((User)this.getDBAccessUser()).getWayid());
			DataPackage dp = employeeBO.doQuery(employeedbparam);
			
			DisoverstatDBParam disoverstatDBParam = (DisoverstatDBParam)this.getParam();
			disoverstatDBParam.set_de_statdate(s);	
			disoverstatDBParam.set_se_countyid(((EmployeeVO)dp.getDatas().get(0)).getCountyid());
			this.getRequest().setAttribute("countyid", ((EmployeeVO)dp.getDatas().get(0)).getCountyid());
		} catch (Exception e) {
			this.addActionError(e.getMessage());		
		}
		return "list";
	}
	public String doExcel() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("配送单超时预警统计查询");
		export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
		export.appendHeadLine(new String[] { "导出时间：",format.format(new Date()) });
		export.addOutputProperty("seqid", "编号");
		export.addOutputProperty("countyid", "分公司",export.CODE2NAME,"#CNTYCOMPANY");
		export.addOutputProperty("mareacode", "微区域",export.CODE2NAME,"#MICROAREA");
		export.addOutputProperty("statdate", "统计日期",export.DATE,"yyyy-MM-dd");
		export.addOutputProperty("countt1", "超时大于"+this.getRequest().getSession().getAttribute("count1")+"小时的订单数");
		export.addOutputProperty("countt2", "超时大于"+this.getRequest().getSession().getAttribute("count2")+"小时的订单数");
		getParam().set_pagesize("0");
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
	
	
	public String doShowdialog() throws Exception{
		DisoverdetailBO disoverdetailbo = (DisoverdetailBO)BOFactory.build(DisoverdetailBO.class, this.getDBAccessUser());
		DisoverdetailDBParam disoverdetailDBParam = new DisoverdetailDBParam();
		DisoverstatDBParam disoverstatDBParam =  (DisoverstatDBParam)this.getParam();
		String pk = disoverstatDBParam.get_pk();
		disoverdetailDBParam.set_ne_statseqid(pk);
		
		DisoverstatForm disoverstatForm = (DisoverstatForm)this.getForm();	
		
		HttpSession  session=this.getRequest().getSession();
		session.setAttribute("statseqid", pk);
		
		
		disoverdetailDBParam.set_pk(pk);
		disoverdetailDBParam.set_pageno(disoverstatDBParam.get_pageno());
		disoverdetailDBParam.set_pagesize(disoverstatDBParam.get_pagesize());
		
		
		if(disoverstatForm.getCountt1()!=null){
			disoverdetailDBParam.set_se_overtype("OVERT1");		
			session.setAttribute("overtype","OVERT1");
			session.setAttribute("countt1", "OVERT1");
		}else{
			disoverdetailDBParam.set_se_overtype("OVERT2");
			session.setAttribute("overtype","OVERT2");
			session.setAttribute("countt1", "OVERT2");
		}		
		this.setDp(disoverdetailbo.doQuery(disoverdetailDBParam));
		
		DisoverstatBO disoverstatbo = (DisoverstatBO)BOFactory.build(DisoverstatBO.class, this.getDBAccessUser());
		DisoverstatVO disoverstatVO = disoverstatbo.doFindByPk(Long.parseLong(pk));
		BeanUtils.copyProperties(this.getForm(), disoverstatVO);
		
		
		return "showdialog";
	}
	
	
	public String doExportExcel() throws Exception{
//		doExportExcel
		HttpSession  session=this.getRequest().getSession();
		String pk = (String)session.getAttribute("statseqid");
		String overtype = (String)session.getAttribute("overtype");
		
		DisoverdetailBO disoverdetailbo = (DisoverdetailBO)BOFactory.build(DisoverdetailBO.class, this.getDBAccessUser());
		DisoverdetailDBParam disoverdetailDBParam = new DisoverdetailDBParam();
		disoverdetailDBParam.set_ne_statseqid(pk);
		disoverdetailDBParam.set_se_overtype(overtype);		
		disoverdetailDBParam.set_pagesize("0");
		this.setDp(disoverdetailbo.doQuery(disoverdetailDBParam));
		
		DisoverstatBO disoverstatbo = (DisoverstatBO)BOFactory.build(DisoverstatBO.class, this.getDBAccessUser());
		DisoverstatVO disoverstatVO = disoverstatbo.doFindByPk(Long.parseLong(pk));
		BeanUtils.copyProperties(this.getForm(), disoverstatVO);
		
		return "ExportExcel";
	}
	@Override
	public String doList() throws Exception {
		DisoverstatDBParam disoverstatDBParam = (DisoverstatDBParam)this.getParam();
		if(disoverstatDBParam.get_de_statdate()!=null && !disoverstatDBParam.get_de_statdate().equals("")){
			disoverstatDBParam.set_dnl_statdate(disoverstatDBParam.get_de_statdate()+" 00:00:00");
			disoverstatDBParam.set_dnm_statdate(disoverstatDBParam.get_de_statdate()+" 23:59:59");
			disoverstatDBParam.set_de_statdate("");			
		}
		
		return super.doList();
	}
}