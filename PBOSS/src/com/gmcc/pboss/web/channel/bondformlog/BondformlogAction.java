/**
 * auto-generated code
 * Wed Jan 04 10:07:20 CST 2012
 */
 package com.gmcc.pboss.web.channel.bondformlog;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.channel.bondformlog.BondformlogDBParam;
import com.gmcc.pboss.business.channel.bondformlog.BondformlogVO;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.channel.bondformlog.Bondformlog;
import com.gmcc.pboss.control.channel.bondformlog.BondformlogBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;


/**
 * <p>Title: BondformlogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public class BondformlogAction extends BaseAction{
	
	public BondformlogAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new BondformlogForm());
		this.setParam(new BondformlogDBParam());

        //指定VO类
        setClsVO(BondformlogVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Bondformlog.class);
		this.setClsQueryParam(BondformlogDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	public String doList() {
		try{
		BondformlogBO bondformlogBO =(BondformlogBO)BOFactory.build(BondformlogBO.class, super.getDBAccessUser());
		BondformlogDBParam bondformlogDBParam = (BondformlogDBParam)super.getParam();
		bondformlogDBParam.setSelectFieldsString("opntime,countyid,wayid,wayname,starlevel,bailtype,bondtype,payamt,payno,receiptno,receiptamt");
		DataPackage dp = new DataPackage();  
		List datas = new ArrayList();
		dp=bondformlogBO.doBondformlogList(bondformlogDBParam);
		if(dp.getRowCount() > 0){
			for(int i=0; i<dp.getDatas().size(); i++){
				BondformlogVO bondformlogVO = new BondformlogVO();
				HashMap ooaVO = (HashMap)dp.getDatas().get(i);
				Date opntime = (Date)ooaVO.get("opntime");
				String countyid = (String)ooaVO.get("countyid");
				String wayid = (String)ooaVO.get("wayid");
				String wayname = (String)ooaVO.get("wayname");
				Long starlevel = (Long)ooaVO.get("starlevel");
				Short bailtype = (Short)ooaVO.get("bailtype");
				String bondtype = (String)ooaVO.get("bondtype"); 
				Double payamt = (Double)ooaVO.get("payamt");
				String payno = (String)ooaVO.get("payno");
				Double receiptamt = (Double)ooaVO.get("receiptamt");
				String receiptno = (String)ooaVO.get("receiptno");
				bondformlogVO.setOpntime(opntime);
				bondformlogVO.setCountyid(countyid);
				bondformlogVO.setWayid(wayid);
				bondformlogVO.setWayname(wayname);
				bondformlogVO.setStarlevel(starlevel);
				bondformlogVO.setBailtype(bailtype);
				bondformlogVO.setBondtype(bondtype);
				bondformlogVO.setPayamt(payamt);
				bondformlogVO.setPayno(payno); 
				bondformlogVO.setReceiptamt(receiptamt);
				bondformlogVO.setReceiptno(receiptno);
				datas.add(bondformlogVO);
			}
		} 
		dp.setDatas(datas);
		setDp(dp);
		}catch(Exception e){
			e.printStackTrace();
		}
		return WEB_RESULT_LIST;
	}
		
	 //导出excel的List方法 com.gmcc.pboss.business.channel.bondformlog.List
	public String doListForExcel() {
		try{
		BondformlogBO bondformlogBO =(BondformlogBO)BOFactory.build(BondformlogBO.class, super.getDBAccessUser());
		BondformlogDBParam bondformlogDBParam = (BondformlogDBParam)super.getParam();
		bondformlogDBParam.setSelectFieldsString("opntime,countyid,wayid,wayname,starlevel,bailtype,bondtype,payamt,payno,receiptno");
		DataPackage dp = new DataPackage();  
		List datas = new ArrayList();
		dp=bondformlogBO.doBondformlogListForExcel(bondformlogDBParam);
		if(dp.getRowCount() > 0){
			for(int i=0; i<dp.getDatas().size(); i++){
				BondformlogVO bondformlogVO = new BondformlogVO();
				HashMap ooaVO = (HashMap)dp.getDatas().get(i);
				Date opntime = (Date)ooaVO.get("opntime");
				String countyid = (String)ooaVO.get("countyid");
				String wayid = (String)ooaVO.get("wayid");
				String wayname = (String)ooaVO.get("wayname");
				Long starlevel = (Long)ooaVO.get("starlevel");
				Short bailtype = (Short)ooaVO.get("bailtype");
				String bondtype = (String)ooaVO.get("bondtype"); 
				Double payamt = (Double)ooaVO.get("payamt");
				String payno = (String)ooaVO.get("payno"); 
				String receiptno = (String)ooaVO.get("receiptno");
				bondformlogVO.setOpntime(opntime);
				bondformlogVO.setCountyid(countyid);
				bondformlogVO.setWayid(wayid);
				bondformlogVO.setWayname(wayname);
				bondformlogVO.setStarlevel(starlevel);
				bondformlogVO.setBailtype(bailtype);
				bondformlogVO.setBondtype(bondtype);
				bondformlogVO.setPayamt(payamt);
				bondformlogVO.setPayno(payno); 
				bondformlogVO.setReceiptno(receiptno);
				datas.add(bondformlogVO);
			}
		} 
		dp.setDatas(datas);
		setDp(dp);
		}catch(Exception e){
			e.printStackTrace();
		}
		return WEB_RESULT_LIST;
	}
	
	
	// 导出保证金申请excel
	public String doExportexcel() throws Exception {  
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);  
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("保证金申请导出");
		export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
		export.appendHeadLine(new String[] { "导出时间",format.format(new Date()) });
		export.addOutputProperty("opntime", "操作时间",export.DATE,"yyyy-MM-dd hh:mm:ss");
		export.addOutputProperty("countyid", "分公司",CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("wayid", "渠道编码");
		export.addOutputProperty("wayname", "渠道名称");
		export.addOutputProperty("starlevel", "星级",CommonExportBean.CODE2NAME, "$CH_STARLEVEL");
		export.addOutputProperty("bailtype", "保证金类型",CommonExportBean.CODE2NAME,"$CH_NEWBAILTYPE");
		export.addOutputProperty("bondtype", "申请单类型",CommonExportBean.CODE2NAME,"$CH_BONDTYPE"); 
	    export.addOutputProperty("payamt", "金额"); 
		export.addOutputProperty("receiptno", "收据编号"); 
		// 设置VO类 
		export.voClassArray = new Class[] { BondformlogVO.class };
		
		// 设置查询方法
		export.queryMethodName = "doListForExcel";
		
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		getParam().set_pagesize("0");
		
		return super.doExcel();
	}
}