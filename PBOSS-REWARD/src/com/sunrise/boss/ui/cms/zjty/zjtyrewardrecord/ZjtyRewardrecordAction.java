/**
* auto-generated code
* Tue Feb 28 17:21:47 CST 2012
*/
package com.sunrise.boss.ui.cms.zjty.zjtyrewardrecord;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.zjty.zjtyrewardrecord.persistent.ZjtyRewardrecordVO;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: ZjtyRewardrecordAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author qiuzhi
 * @version 1.0
 */
public class ZjtyRewardrecordAction extends BaseDelegateAction {
    public ZjtyRewardrecordAction() {
            setVoClass(ZjtyRewardrecordVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "rewardlistid"; 
    }
    
    public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			ZjtyRewardrecordForm form = (ZjtyRewardrecordForm) actionForm;
			form.set_orderby("rewardlistid");
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
		export.setFileName("自建他营酬金成功明细");
		//export.addOutputProperty("seq", "序号");
		//export.addOutputProperty("oprtime", "业务发生时间", CommonExportBean.DATE,"yyyy-MM-dd HH:mm:ss");
		//export.addOutputProperty("rewardtype", "酬金类型", CommonExportBean.CODE2NAME, "$CH_BBCREWARDTYPE");
		export.addOutputProperty("rewardlistid","序列值");
		export.addOutputProperty("operseq","来源序列号");
		export.addOutputProperty("opnid","业务编码");
		export.addOutputProperty("opnid","业务名称", CommonExportBean.CODE2NAME, "#ZJTY_OPERATION");
		export.addOutputProperty("wayid","渠道编码");
		export.addOutputProperty("wayid","渠道名称", CommonExportBean.CODE2NAME, "#WAY");
		export.addOutputProperty("wayoprcode","办理工号");
		export.addOutputProperty("totalsum","计算金额");
		export.addOutputProperty("paysum","支付金额");
		export.addOutputProperty("coef1","管理考核系数");
		export.addOutputProperty("coef2","综合排名系数");
		export.addOutputProperty("coef3","否决系数");
		export.addOutputProperty("coef4","合作商竞标系数");
		export.addOutputProperty("batchno","处理批次号");
		export.addOutputProperty("runtime","处理时间", CommonExportBean.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("mobile","业务发生号码");
		export.addOutputProperty("oid","工单号码");
		export.addOutputProperty("ruleid","规则编码");
		export.addOutputProperty("rewardid","酬金标识");
		export.addOutputProperty("rewardtype","酬金类型", CommonExportBean.CODE2NAME, "$ZJTY_REWARDTYPE");
		export.addOutputProperty("rewardstd","酬金标准");
		export.addOutputProperty("rewardmonth","结算月份");
		export.addOutputProperty("isbudget","预估标志");
		export.addOutputProperty("paymonth1","一期发放月份");
		export.addOutputProperty("paymoney1","一期应发金额");
		export.addOutputProperty("paymonth2","二期发放月份");
		export.addOutputProperty("paymoney2","二期应发金额");
		export.addOutputProperty("paymonth3","三期发放月份");
		export.addOutputProperty("paymoney3","三期应发金额");
		export.addOutputProperty("acctype","计算酬方式");
		export.addOutputProperty("assegrade","考核系数");
		export.addOutputProperty("oprtime","业务发生时间", CommonExportBean.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("busivalue","业务量");
		export.addOutputProperty("rewardflag","酬金计算标志");
		export.addOutputProperty("noncyc","结算期数");
		export.addOutputProperty("bakinfo","IMEI");
		export.addOutputProperty("bakinfo2","商品ID");
		export.addOutputProperty("bakinfo3","协议价");
		export.addOutputProperty("wrapfee","承诺低消");
		export.addOutputProperty("adtflag","稽核结果标识");
		export.addOutputProperty("assegrade2","考核系数2");
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
		export.voClassArray = new Class[]{ZjtyRewardrecordVO.class};
		response.setHeader("pragma", "no-cache");
		response.setHeader("Cache-control", "public");
		String fn = "attachment; filename=" + export.getFileName() + ".txt";
		response.setHeader("Content-Disposition", new String(fn.getBytes("GBK"), "ISO-8859-1"));
		response.setContentType("text/plain");
		export.writeTxtTitle(response.getOutputStream(), new String[] { "序列值",
				"来源序列号", "业务编码", "业务名称", "渠道编码", "渠道名称", "办理工号", "计算金额",
				"支付金额", "管理考核系数", "综合排名系数", "否决系数", "合作商竞标系数", "处理批次号", "处理时间",
				"业务发生号码", "工单号码", "规则编码", "酬金标识", "酬金类型", "酬金标准", "结算月份",
				"预估标志", "一期发放月份", "一期应发金额", "二期发放月份", "二期应发金额", "三期发放月份",
				"三期应发金额", "计算酬方式", "考核系数", "业务发生时间", "业务量", "酬金计算标志", "结算期数",
				"IMEI", "商品ID", "协议价", "承诺低消", "稽核结果标识", "考核系数2", "商品名称","产品ID","基准价","酬金点数","终端制式","流量","ARPU值","优质客户","终端类型" });
		
		super.ExportQuery(actionMapping, actionForm, request, response,	user, export);
		return actionMapping.findForward(null);
    }
}
