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
        // TODO: ������������������
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
		export.setFileName("����������");
		export.appendHeadLine(new String[] { "��������:", user.getOpercode() });
		export.appendHeadLine(new String[] { "����ʱ��:", format.format(new Date()) });
		export.addOutputProperty("disputeid", "���");
		export.addOutputProperty("cityid", "���б�ʶ", export.CODE2NAME, "#REGIONNAME");
		export.addOutputProperty("rewardid", "������");
		export.addOutputProperty("provagentid", "�����̱���");
		export.addOutputProperty("provagentid", "����������", export.CODE2NAME, "#CH_PD_AGENT");
		export.addOutputProperty("prodno", "���Ų�Ʒ���");
		export.addOutputProperty("prodid", "���Ų�Ʒ��ʶ");
		export.addOutputProperty("prodname", "���Ų�Ʒ����");
		export.addOutputProperty("custid", "���ű���");
		export.addOutputProperty("custname", "��������");
		export.addOutputProperty("phase", "����");
		export.addOutputProperty("rewardmonth", "�Ƴ��·�");
		export.addOutputProperty("rewardmoney", "������");
		export.addOutputProperty("auditrole", "���鷢��", export.CODE2NAME, "$PD_AUDITROLE");
		export.addOutputProperty("content", "��������");
		export.addOutputProperty("auditeename", "��ϵ������");
		export.addOutputProperty("telephone", "��ϵ�˵绰");
		export.addOutputProperty("isaccepted", "�Ƿ��������", export.CODE2NAME, "#PD_YESORNO");
		export.addOutputProperty("isdealed", "�Ƿ��Ѵ�������", export.CODE2NAME, "#PD_YESORNO");
		export.addOutputProperty("dealtype", "����ʽ", export.CODE2NAME, "$PD_DEALTYPE");
		export.addOutputProperty("suppleseq", "���������");
		export.addOutputProperty("incomstime", "COMS���ʱ��", CommonExportBean.DATE, "yyyy-MM-dd HH:mm:ss");
		
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
