/**
 * auto-generated code
 * Tue Apr 03 12:44:47 CST 2012
 */
 package com.gmcc.pboss.web.sales.vorderdisdetail;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.sales.disformintervaltime.DisformintervaltimeDBParam;
import com.gmcc.pboss.business.sales.vorderdisdetail.VOrderdisdetailVO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.sunrise.jop.ui.struts2.WebConstant;
import com.gmcc.pboss.business.sales.vorderdisdetail.VOrderdisdetailDBParam;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.sales.vorderdisdetail.VOrderdisdetail ;
import com.gmcc.pboss.control.sales.vorderdisdetail.VOrderdisdetailBO;

/**
 * <p>Title: VOrderdisdetailAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public class VOrderdisdetailAction extends BaseAction{
	
	public VOrderdisdetailAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new VOrderdisdetailForm());
		this.setParam(new VOrderdisdetailDBParam());

        //指定VO类
        setClsVO(VOrderdisdetailVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"orderid"};
		this.setClsControl(VOrderdisdetail.class);
		this.setClsQueryParam(VOrderdisdetailDBParam.class) ;

	}
	
	public String doTolist() throws Exception {
		VOrderdisdetailDBParam params = new VOrderdisdetailDBParam();
		SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.set(Calendar.DAY_OF_MONTH, 1);
		String nl = myformat.format(c.getTime())+" 00:00:00";
		c.set(Calendar.MONTH, c.get(Calendar.MONTH)+1);
		c.set(Calendar.DAY_OF_MONTH,c.get(Calendar.DAY_OF_MONTH)-1);
		String nm = myformat.format(c.getTime())+" 23:59:59";
		params.set_dnl_createtime(nl);
		params.set_dnm_createtime(nm);		
		this.setParam(params);
		return "list";
	}
	
	public String doList() throws Exception{
		try{
			VOrderdisdetailDBParam params = (VOrderdisdetailDBParam)this.getParam();
//			Date ldate = new Date();
//			Date mdate = new Date();
//			SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd");
//			ldate = myformat.parse(params.get_dnl_createtime());
//			mdate = myformat.parse(params.get_dnm_createtime());
//			Long day = (mdate.getTime() - ldate.getTime())
//					/ (1000 * 60 * 60 * 24);
//			if (day > 30) {
//				setActionMessage("创建时间间隔不能超过31天。");
//				return "list";
//			}
			params.set_orderby("orderid");
			
			VOrderdisdetail bo =(VOrderdisdetailBO)BOFactory.build(VOrderdisdetailBO.class, this.getDBAccessUser());
			DataPackage dp = bo.doQuery(params);
			this.setDp(dp);			
		}catch(Exception e){
			this.addActionMessage(e.getMessage());
		}
		
		return "list";
	}
	
	public String doExcel() throws Exception{
		try{
			HttpServletRequest request = ServletActionContext.getRequest();
			User user = (User) getDBAccessUser();
			CommonExportBean export = new CommonExportBean(user);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			export.setFileName("配送单超时明细");
			export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
			export.appendHeadLine(new String[] { "导出时间",	format.format(new Date()) });
			export.addOutputProperty("orderid", "订单号");
			export.addOutputProperty("countyid", "分公司",export.CODE2NAME,"#CNTYCOMPANY");
			export.addOutputProperty("mareacode", "微区域",export.CODE2NAME,"#MICROAREA");
			export.addOutputProperty("starlevel", "星级",export.CODE2NAME,"$CH_STARLEVEL");
			export.addOutputProperty("recid", "配送单号");
			export.addOutputProperty("createtime", "配送开始时间", export.DATE, "yyyy-MM-dd hh:mm:ss");
			export.addOutputProperty("disovertime", "配送结束时间", export.DATE, "yyyy-MM-dd hh:mm:ss");
			export.addOutputProperty("intervaltime", "配送时长(天)");		
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
			VOrderdisdetailDBParam params = (VOrderdisdetailDBParam)super.getParam();
//			Date ldate = new Date();
//			Date mdate = new Date();
//			SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd");
//			ldate = myformat.parse(params.get_dnl_createtime());
//			mdate = myformat.parse(params.get_dnm_createtime());
//			Long day = (mdate.getTime() - ldate.getTime())
//					/ (1000 * 60 * 60 * 24);
//			if (day > 30) {
//				setActionMessage("创建时间间隔不能超过31天。");
//				return "list";
//			}
			params.set_pagesize("0");
			super.setParam(params);
		}catch(Exception e){
			this.addActionMessage(e.getMessage());
		}
		
		return super.doExcel();
	}
	
}