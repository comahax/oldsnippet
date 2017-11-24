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

		//���¼��������Ǳ����
		this.setForm(new InvoiceForm());
		this.setParam(new InvoiceDBParam());

        //ָ��VO��
        setClsVO(InvoiceVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"seqid"};
		this.setClsControl(Invoice.class);
		this.setClsQueryParam(InvoiceDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
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
	
	
	
	// ������Ʊ����excel
	public String doExportexcel() throws Exception {
		 
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);  
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("��Ʊ���쵼��");
		export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
		export.appendHeadLine(new String[] { "����ʱ��",format.format(new Date()) });
		export.addOutputProperty("wayid", "��������");
		export.addOutputProperty("wayname", "��������");
		export.addOutputProperty("applytime", "����ʱ��",export.DATE,"yyyy-MM-dd");
		export.addOutputProperty("momney", "������");
		export.addOutputProperty("information", "��Ʊ��Ϣ");
		export.addOutputProperty("oprcode", "������"); 
		export.addOutputProperty("oprtime", "����ʱ��",export.DATE,"yyyy-MM-dd");   
		export.addOutputProperty("state", "����״̬",CommonExportBean.CODE2NAME, "$CH_SENDTYPE"); 
		// ����VO��
		export.voClassArray = new Class[] { InvoiceVO.class };
		
		// ���ò�ѯ����
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
			  setActionMessage("�޸ĵķ�Ʊ�������ݲ����ڻ����ѱ�ɾ��");
		 }else {
			 Date date = new Date();
			 invoiceVO.setOprtime(date);
			 invoiceVO.setOprcode(getDBAccessUser().getOprcode());
			 super.doSave();
		 }
		 
		 return WEB_RESULT_CONTENT;
	 }
	
	
}