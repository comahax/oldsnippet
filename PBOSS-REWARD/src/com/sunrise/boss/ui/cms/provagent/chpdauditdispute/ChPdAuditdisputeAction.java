/**
* auto-generated code
* Tue Sep 03 20:54:50 CST 2013
*/
package com.sunrise.boss.ui.cms.provagent.chpdauditdispute;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.sunrise.boss.business.cms.provagent.chpdauditdispute.persistent.ChPdAuditdisputeListVO;
import com.sunrise.boss.business.cms.provagent.chpdauditdispute.persistent.ChPdAuditdisputeVO;
import com.sunrise.boss.business.cms.provagent.chpdauditdispute.persistent.VChPdAuditdisputeVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.cms.provagent.chpdauditdispute.ChPdAuditdisputeDelegate;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: ChPdAuditdisputeAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public class ChPdAuditdisputeAction extends BaseDelegateAction {
    public ChPdAuditdisputeAction() {
            setVoClass(ChPdAuditdisputeVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "disputeid"; 
    }

	protected ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		ChPdAuditdisputeForm listForm = (ChPdAuditdisputeForm) actionForm;
		if (listForm.isQuery()) {
			ChPdAuditdisputeListVO params = new ChPdAuditdisputeListVO();
			setListVO(params, listForm);
			ChPdAuditdisputeDelegate delegate = new ChPdAuditdisputeDelegate();
			DataPackage dp = delegate.doQuery(params, user);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		}
		return actionMapping.findForward("list");
	}

	public ActionForward doExcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("审核争议管理");
		export.appendHeadLine(new String[] { "导出工号:", user.getOpercode() });
		export.appendHeadLine(new String[] { "导出时间:", format.format(new Date()) });
		export.addOutputProperty("disputeid", "序号");
		export.addOutputProperty("cityid", "地市标识", export.CODE2NAME, "#REGIONNAME");
		export.addOutputProperty("rewardid", "酬金序号");
		export.addOutputProperty("provagentid", "代理商编码");
		export.addOutputProperty("provagentid", "代理商名称", export.CODE2NAME, "#CH_PD_AGENT");
		export.addOutputProperty("prodno", "集团产品编号");
		export.addOutputProperty("prodid", "集团产品标识");
		export.addOutputProperty("prodname", "集团产品名称");
		export.addOutputProperty("custid", "集团编码");
		export.addOutputProperty("custname", "集团名称");
		export.addOutputProperty("phase", "期数");
		export.addOutputProperty("rewardmonth", "计酬月份");
		export.addOutputProperty("rewardmoney", "结算酬金");
		export.addOutputProperty("auditrole", "争议发起方", export.CODE2NAME, "$PD_AUDITROLE");
		export.addOutputProperty("content", "争议内容");
		export.addOutputProperty("auditeename", "联系人姓名");
		export.addOutputProperty("telephone", "联系人电话");
		export.addOutputProperty("isaccepted", "是否接受争议", export.CODE2NAME, "#PD_YESORNO");
		export.addOutputProperty("isdealed", "是否已处理争议", export.CODE2NAME, "#PD_YESORNO");
		export.addOutputProperty("dealtype", "处理方式", export.CODE2NAME, "$PD_DEALTYPE");
		export.addOutputProperty("suppleseq", "补算酬金序号");
		export.addOutputProperty("incomstime", "COMS入库时间", CommonExportBean.DATE, "yyyy-MM-dd HH:mm:ss");
		
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		export.voClassArray = new Class[] {VChPdAuditdisputeVO.class};
		export.queryMethodName = "doList";
		if (export.headtitle == null) {
			export.headtitle = export.getFileName();
		}
		export.buildExcelPage(actionMapping, actionForm, request, response, user, this);
    	return null;
	}
}
