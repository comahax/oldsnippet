/**
* auto-generated code
* Tue Jul 31 17:05:40 CST 2012
*/
package com.sunrise.boss.ui.cms.et.chetadtrecord;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.et.chetadtrecord.persistent.ChEtAdtrecordListVO;
import com.sunrise.boss.business.cms.et.chetadtrecord.persistent.ChEtAdtrecordVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.cms.et.chetadtrecord.ChEtAdtrecordDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: ChEtAdtrecordAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public class ChEtAdtrecordAction extends BaseAction { 
	public ChEtAdtrecordAction() {
            setVoClass(ChEtAdtrecordVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "seq"; 
           //pkNameArray[1] = "srcseq"; 
    }
	//自营厅酬金成功明细查询
	public ActionForward doSuclist(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception { 
		try {
			Page.setPageSize(request, (BaseActionForm) actionForm);
			ChEtAdtrecordForm form = (ChEtAdtrecordForm) actionForm; 
			form.set_ne_adtflag("1");
			ChEtAdtrecordListVO listVO = new ChEtAdtrecordListVO();
			setListVO(listVO, form);  
			ChEtAdtrecordDelegate delegate = new ChEtAdtrecordDelegate();
			DataPackage pack = delegate.doQuery(listVO, user);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, pack);
			if(null == form.get_pageno() || "".equals(form.get_pageno())){
	    		form.set_pageno(String.valueOf(pack.getPageNo()));
	    	}
    	} catch (Exception e) {
    		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
    		return (actionMapping.findForward("success"));
		}
		return (actionMapping.findForward("success"));
	}
	
	//自营厅酬金失败明细查询
	public ActionForward doFaillist(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception { 
		try {
			Page.setPageSize(request, (BaseActionForm) actionForm);
			ChEtAdtrecordForm form = (ChEtAdtrecordForm) actionForm; 
			ChEtAdtrecordListVO listVO = new ChEtAdtrecordListVO();
			form.set_ne_adtflag("0"); 
			setListVO(listVO, form);  
			ChEtAdtrecordDelegate delegate = new ChEtAdtrecordDelegate();
			DataPackage pack = delegate.doQuery(listVO, user);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, pack);
			if(null == form.get_pageno() || "".equals(form.get_pageno())){
	    		form.set_pageno(String.valueOf(pack.getPageNo()));
	    	}
    	} catch (Exception e) {
    		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
    		return (actionMapping.findForward("fail"));
		}
		return (actionMapping.findForward("fail"));
	}
	
	 public ActionForward doSuctxt(ActionMapping actionMapping,
	    		ActionForm actionForm, HttpServletRequest request,
	    		HttpServletResponse response, User user) throws Exception {
	    	CommonExportBean export = new CommonExportBean(user);
			export.setFileName("自营厅酬金成功明细导出");
			
			ChEtAdtrecordForm form = (ChEtAdtrecordForm) actionForm;
			form.set_pagesize("0");
			
			export.addOutputProperty("seq", "序列号");
			export.addOutputProperty("srcseq","数据源序列号");
			export.addOutputProperty("oid","工单号");
			export.addOutputProperty("opnid","业务编码");
			export.addOutputProperty("calcmonth","结算月份");
			export.addOutputProperty("wayid","渠道编码");
			export.addOutputProperty("oprcode","办理工号");
			export.addOutputProperty("oprtime", "办理时间", CommonExportBean.DATE,"yyyy-MM-dd HH:mm:ss");
			export.addOutputProperty("mobile","办理号码");
			export.addOutputProperty("subsid","用户编码");
			export.addOutputProperty("brand","用户品牌");
			export.addOutputProperty("yxplanid","办理营销方案");
			export.addOutputProperty("startdate", "生效时间", CommonExportBean.DATE,"yyyy-MM-dd HH:mm:ss");
			export.addOutputProperty("ruleid","检验规则");
			export.addOutputProperty("ruleitemid","规则细项");
			export.addOutputProperty("noncyc","酬金期数");
			export.addOutputProperty("batchno","处理批次号");
			export.addOutputProperty("adtcode","校验代码");
			export.addOutputProperty("adtremark","校验代码解释");
			export.addOutputProperty("src","数据归属原文件");
			export.addOutputProperty("adtflag","校验标识");
			export.addOutputProperty("createtime", "创建时间", CommonExportBean.DATE,"yyyy-MM-dd HH:mm:ss");
			export.addOutputProperty("bakinfo","备注");	
			
			export.addOutputProperty("texe1","扩展字段1");  
			export.addOutputProperty("texe2","扩展字段2");  
			export.addOutputProperty("texe3","扩展字段3");  
			export.addOutputProperty("texe4","扩展字段4");  
			export.addOutputProperty("texe5","扩展字段5");  
			export.addOutputProperty("texe6","扩展字段6");  
			export.addOutputProperty("texe7","扩展字段7");  
			export.addOutputProperty("texe8","扩展字段8");  
			
			export.queryMethodName="doSuclist";
			export.voClassArray = new Class[]{ChEtAdtrecordVO.class};
			response.setHeader("pragma", "no-cache");
			response.setHeader("Cache-control", "public");
			String fn = "attachment; filename=" + export.getFileName() + ".txt";
			response.setHeader("Content-Disposition", new String(fn.getBytes("GBK"), "ISO-8859-1"));
			response.setContentType("text/plain");
			export.writeTxtTitle(response.getOutputStream(), new String[] {"序列号", "数据源序列号",
				"工单号", "业务编码", "结算月份", "渠道编码", "办理工号", "办理时间",
				"办理号码", "用户编码", "用户品牌", "办理营销方案",
				"生效时间", "检验规则", "规则细项",  "酬金期数", "批次号", "校验代码", 
				"校验代码解释", "数据归属原文件", "校验标识", "创建时间", "备注", 
				"扩展字段1", "扩展字段2", "扩展字段3", "扩展字段4","扩展字段5","扩展字段6","扩展字段7","扩展字段8"});
			
			super.ExportQuery(actionMapping, actionForm, request, response,	user, export);
			return actionMapping.findForward(null);
	    }
	 public ActionForward doFailtxt(ActionMapping actionMapping,
	    		ActionForm actionForm, HttpServletRequest request,
	    		HttpServletResponse response, User user) throws Exception {
	    	CommonExportBean export = new CommonExportBean(user);
			export.setFileName("自营厅酬金失败明细导出");
			
			ChEtAdtrecordForm form = (ChEtAdtrecordForm) actionForm;
			form.set_pagesize("0");
			
			export.addOutputProperty("seq", "序列号");
			export.addOutputProperty("srcseq","数据源序列号");
			export.addOutputProperty("oid","工单号");
			export.addOutputProperty("opnid","业务编码");
			export.addOutputProperty("calcmonth","结算月份");
			export.addOutputProperty("wayid","渠道编码");
			export.addOutputProperty("oprcode","办理工号");
			export.addOutputProperty("oprtime", "办理时间", CommonExportBean.DATE,"yyyy-MM-dd HH:mm:ss");
			export.addOutputProperty("mobile","办理号码");
			export.addOutputProperty("subsid","用户编码");
			export.addOutputProperty("brand","用户品牌");
			export.addOutputProperty("yxplanid","办理营销方案");
			export.addOutputProperty("startdate", "生效时间", CommonExportBean.DATE,"yyyy-MM-dd HH:mm:ss");
			export.addOutputProperty("ruleid","检验规则");
			export.addOutputProperty("ruleitemid","规则细项");
			export.addOutputProperty("noncyc","酬金期数");
			export.addOutputProperty("batchno","处理批次号");
			export.addOutputProperty("adtcode","校验代码");
			export.addOutputProperty("adtremark","校验代码解释");
			export.addOutputProperty("src","数据归属原文件");
			export.addOutputProperty("adtflag","校验标识");
			export.addOutputProperty("createtime", "创建时间", CommonExportBean.DATE,"yyyy-MM-dd HH:mm:ss");
			export.addOutputProperty("bakinfo","备注");	
			
			export.addOutputProperty("texe1","扩展字段1");  
			export.addOutputProperty("texe2","扩展字段2");  
			export.addOutputProperty("texe3","扩展字段3");  
			export.addOutputProperty("texe4","扩展字段4");  
			export.addOutputProperty("texe5","扩展字段5");  
			export.addOutputProperty("texe6","扩展字段6");  
			export.addOutputProperty("texe7","扩展字段7");  
			export.addOutputProperty("texe8","扩展字段8");  
			
			export.queryMethodName="doFaillist";
			export.voClassArray = new Class[]{ChEtAdtrecordVO.class};
			response.setHeader("pragma", "no-cache");
			response.setHeader("Cache-control", "public");
			String fn = "attachment; filename=" + export.getFileName() + ".txt";
			response.setHeader("Content-Disposition", new String(fn.getBytes("GBK"), "ISO-8859-1"));
			response.setContentType("text/plain");
			export.writeTxtTitle(response.getOutputStream(), new String[] {"序列号", "数据源序列号",
				"工单号", "业务编码", "结算月份", "渠道编码", "办理工号", "办理时间",
				"办理号码", "用户编码", "用户品牌", "办理营销方案",
				"生效时间", "检验规则", "规则细项",  "酬金期数", "批次号", "校验代码", 
				"校验代码解释", "数据归属原文件", "校验标识", "创建时间", "备注", 
				"扩展字段1", "扩展字段2", "扩展字段3", "扩展字段4","扩展字段5","扩展字段6","扩展字段7","扩展字段8"});
			
			super.ExportQuery(actionMapping, actionForm, request, response,	user, export);
			return actionMapping.findForward(null);
	    }
}
