/**
 * auto-generated code
 * Fri Dec 30 09:40:47 CST 2011
 */
 package com.gmcc.pboss.web.channel.invoice;

import java.text.SimpleDateFormat;
import java.util.Date; 
import javax.servlet.http.HttpServletRequest; 
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;  
import com.gmcc.pboss.business.channel.invoice.InvoiceVO ;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.sunrise.jop.ui.struts2.WebConstant;
import com.gmcc.pboss.business.channel.invoice.InvoiceDBParam;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.channel.invoice.Invoice ;
import com.gmcc.pboss.control.channel.invoice.InvoiceBO;

/**
 * <p>Title: InvoiceAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public class InvoiceAction extends BaseAction{
	
	public InvoiceAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new InvoiceForm());
		this.setParam(new InvoiceDBParam());

        //指定VO类
        setClsVO(InvoiceVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"seqid"};
		this.setClsControl(Invoice.class);
		this.setClsQueryParam(InvoiceDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	
	public String doList() throws Exception {
		try {
			InvoiceDBParam invoiceDBParam = (InvoiceDBParam) super.getParam();
			if (StringUtils.isBlank(invoiceDBParam.get_se_countyid()) ) {
				super.doList();
			}else {
				InvoiceBO invoiceBO = (InvoiceBO)  BOFactory.build(InvoiceBO.class, super.getDBAccessUser());
				DataPackage dp = new DataPackage(); 
				dp =  invoiceBO.doInvoiceList(invoiceDBParam, invoiceDBParam.get_se_countyid()); 
				setDp(dp);
			} 
		} catch (Exception e) {
			throw new Exception(e);
		} 
		return WEB_RESULT_LIST;
	}
	
	
	
	// 导出发票请领excel
	public String doExportexcel() throws Exception {
		 
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);  
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("发票请领导出");
		export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
		export.appendHeadLine(new String[] { "导出时间",format.format(new Date()) });
		export.addOutputProperty("wayid", "渠道编码");
		export.addOutputProperty("wayname", "渠道名称");
		export.addOutputProperty("applytime", "请领时间",export.DATE,"yyyy-MM-dd");
		export.addOutputProperty("momney", "请领金额");
		export.addOutputProperty("information", "发票信息");
		export.addOutputProperty("oprcode", "处理人"); 
		export.addOutputProperty("oprtime", "处理时间",export.DATE,"yyyy-MM-dd");   
		export.addOutputProperty("state", "配送状态",CommonExportBean.CODE2NAME, "$CH_SENDTYPE"); 
		// 设置VO类
		export.voClassArray = new Class[] { InvoiceVO.class };
		
		// 设置查询方法
		export.queryMethodName = "doList";
		
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		getParam().set_pagesize("0");
		
		return super.doExcel();
	}
	
	 public String doSave() throws Exception{
		 InvoiceDBParam invoiceDBParam = new InvoiceDBParam();
		 InvoiceVO invoiceVO = (InvoiceVO) getForm();
		 invoiceDBParam.set_ne_state(invoiceVO.getState().toString());
		 invoiceDBParam.set_ne_information(invoiceVO.getInformation());
		 Invoice  invoiceBO = (Invoice) BOFactory.build(InvoiceBO.class,getDBAccessUser()); 
		 DataPackage dp = invoiceBO.doQuery(invoiceDBParam);
		 if(null==dp){
			  setActionMessage("修改的发票请领数据不存在或者已被删除");
		 }else {
			 Date date = new Date();
			 invoiceVO.setOprtime(date);
			 invoiceVO.setOprcode(getDBAccessUser().getOprcode());
			 super.doSave();
		 }
		 
		 return WEB_RESULT_CONTENT;
	 }
	
	
}