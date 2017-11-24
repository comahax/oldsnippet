/**
* auto-generated code
* Wed Feb 29 11:21:28 CST 2012
*/
package com.sunrise.boss.ui.cms.zjty.zjtyfailrecord;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.zjty.zjtyfailrecord.persistent.ZjtyFailrecordVO;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: ZjtyFailrecordAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author qiuzhi
 * @version 1.0
 */
public class ZjtyFailrecordAction extends BaseDelegateAction {
    public ZjtyFailrecordAction() {
            setVoClass(ZjtyFailrecordVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "seq"; 
    }
    
    public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			ZjtyFailrecordForm form = (ZjtyFailrecordForm) actionForm;
			//form.set_se_cityid(user.getCityid());
			form.set_orderby("seq");
	    	return super.doList(actionMapping, actionForm, request, response, user);
		} catch (BusinessException e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
			return (actionMapping.findForward("list"));
		}
	}
    
    public ActionForward doTxt(ActionMapping actionMapping,
    		ActionForm actionForm, HttpServletRequest request,
    		HttpServletResponse response, User user) throws Exception {
    	CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("自建他营酬金失败明细");
		//export.addOutputProperty("seq", "序号");
		//export.addOutputProperty("oprtime", "业务发生时间", CommonExportBean.DATE,"yyyy-MM-dd HH:mm:ss");
		//export.addOutputProperty("rewardtype","酬金类型", CommonExportBean.CODE2NAME, "$CH_ZJTY_REWARDTYPE");
		export.addOutputProperty("seq","序列号");
		//export.addOutputProperty("srcseq","");
		//export.addOutputProperty("cityid","");
		export.addOutputProperty("opnid","业务编码");
		export.addOutputProperty("opnid","业务名称", CommonExportBean.CODE2NAME, "#ZJTY_OPERATION");
		export.addOutputProperty("wayid","渠道编码");
		export.addOutputProperty("wayid","渠道名称", CommonExportBean.CODE2NAME, "#WAY");
		export.addOutputProperty("oprcode","员工号码");
		export.addOutputProperty("oprtime","办理时间", CommonExportBean.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("mobile","手机号码");
		export.addOutputProperty("busivalue","业务量");
		export.addOutputProperty("brand","品牌");
		export.addOutputProperty("creattime","创建时间", CommonExportBean.DATE,"yyyy-MM-dd HH:mm:ss");
		//export.addOutputProperty("src","");
		export.addOutputProperty("ruleid","规则编码");
		export.addOutputProperty("ruleitemid","规则细项编码");
		export.addOutputProperty("adtcode","校验类型");
		export.addOutputProperty("adtremark","校验错误类型");
		export.addOutputProperty("oid","工单号");
		export.addOutputProperty("noncyc","期数");
		export.addOutputProperty("batchno","批次号");
		export.addOutputProperty("calcopnid","结算业务编码");
		export.addOutputProperty("calcmonth","结算月份");
		export.addOutputProperty("adtttime","稽核时间", CommonExportBean.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("adtflag","稽核结果标识");
		export.addOutputProperty("rewardtype","酬金类型", CommonExportBean.CODE2NAME, "$ZJTY_REWARDTYPE");
		export.addOutputProperty("bakinfo","IMEI");
		export.addOutputProperty("bakinfo2","商品ID");
		export.addOutputProperty("bakinfo3","协议价");
		export.addOutputProperty("wrapfee","承诺低消");
		export.addOutputProperty("bakinfo2","商品名称", CommonExportBean.CODE2NAME, "#IM_PR_COM");
		export.addOutputProperty("prodid","产品ID");
		export.addOutputProperty("bakinfo4","基准价");
		export.addOutputProperty("bakinfo5","酬金点数");
		export.addOutputProperty("bakinfo6","终端制式",CommonExportBean.CODE2NAME, "$ZD_SYSTEM"); 
		export.addOutputProperty("bakinfo7","流量");
		export.addOutputProperty("bakinfo8","ARPU值");
		export.addOutputProperty("bakinfo9","优质客户");
		export.addOutputProperty("bakinfo10","终端类型" ,CommonExportBean.CODE2NAME, "$ZD_TYPE");
		
		export.queryMethodName="doList";
		export.voClassArray = new Class[]{ZjtyFailrecordVO.class};
		response.setHeader("pragma", "no-cache");
		response.setHeader("Cache-control", "public");
		String fn = "attachment; filename=" + export.getFileName() + ".txt";
		response.setHeader("Content-Disposition", new String(fn.getBytes("GBK"), "ISO-8859-1"));
		response.setContentType("text/plain");
		export.writeTxtTitle(response.getOutputStream(), new String[] {"序列号", 
			"业务编码", "业务名称", "渠道编码", "渠道名称", "员工号码", "办理时间", "手机号码",
			"业务量", "品牌", "创建时间", "规则编码", "规则细项编码", "校验类型", "校验错误类型",
			"工单号", "期数", "批次号", "结算业务编码", "结算月份", "稽核时间", 
			"稽核结果标识", "酬金类型", "IMEI", "商品ID", "协议价", "承诺低消", "商品名称" ,"产品ID","基准价","酬金点数","终端制式","流量","ARPU值","优质客户","终端类型" });
		
		super.ExportQuery(actionMapping, actionForm, request, response,	user, export);
		return actionMapping.findForward(null);
    }
}
