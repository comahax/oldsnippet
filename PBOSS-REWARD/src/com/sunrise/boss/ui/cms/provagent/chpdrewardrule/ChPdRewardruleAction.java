/**
* auto-generated code
* Wed Sep 04 16:35:49 CST 2013
*/
package com.sunrise.boss.ui.cms.provagent.chpdrewardrule;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.sunrise.boss.business.cms.provagent.chpdrewardrule.persistent.ChPdRewardruleListVO;
import com.sunrise.boss.business.cms.provagent.chpdrewardrule.persistent.ChPdRewardruleVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.cms.provagent.chpdrewardrule.ChPdRewardruleDelegate;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: ChPdRewardruleAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public class ChPdRewardruleAction extends BaseDelegateAction {
    public ChPdRewardruleAction() {
            setVoClass(ChPdRewardruleVO.class);
        // TODO: ������������������
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "ruleid"; 
    }

	protected ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		ChPdRewardruleForm form = (ChPdRewardruleForm) actionForm;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		ChPdRewardruleListVO params = new ChPdRewardruleListVO();
		params.set_ne_coopertype(form.getCoopertype()+"");
		params.set_se_subcategory(form.getSubcategory());
		StringBuffer conditions = new StringBuffer();
		
		conditions.append(" ( ");
		conditions.append(" (to_date('" + sdf.format(form.getInusetime()) + "', 'yyyy-mm-dd') between inusetime and outusetime) ");
		conditions.append(" or (to_date('" + sdf.format(form.getOutusetime()) + "', 'yyyy-mm-dd') between inusetime and outusetime) ");
		conditions.append(" or (inusetime between to_date('" + sdf.format(form.getInusetime()) + "', 'yyyy-mm-dd') and to_date('" 
				+ sdf.format(form.getOutusetime()) + "', 'yyyy-mm-dd')) ");
		conditions.append(" ) ");
		if (form.getRuleid() != null && form.getRuleid() > 0) {
			conditions.append(" and ruleid != " + form.getRuleid());
		}
		params.set_sql_condition(conditions.toString());
		ChPdRewardruleDelegate delegate = new ChPdRewardruleDelegate();
		DataPackage dp = delegate.doQuery(params, user);
		if (dp.getRowCount() > 0) {
			ChPdRewardruleVO vo = (ChPdRewardruleVO) dp.getDatas().iterator().next();
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "�����мƳ���� " + vo.getRuleid() + " ��Чʱ��γ�ͻ");
			if (form.getRuleid() != null && form.getRuleid() > 0) {
				((BaseActionForm)actionForm).setCmdState(WebConstant.COMMAND_STRING_EDIT);
				request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
			} else {
				((BaseActionForm)actionForm).setCmdState(WebConstant.COMMAND_STRING_NEW);
				request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_NEW);
			}
			return actionMapping.findForward("content");
		}
		
		if (form.getRuleid() != null && form.getRuleid() > 0) {
			form.setVersion(form.getVersion()+0.1f);
		} else {
			form.setVersion(1.0f);
		}
		return super.doSave(actionMapping, actionForm, request, response, user);
	}

	public ActionForward doExcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("�����̼Ƴ�������");
		export.appendHeadLine(new String[] { "��������:", user.getOpercode() });
		export.appendHeadLine(new String[] { "����ʱ��:", format.format(new Date()) });
		export.addOutputProperty("ruleid", "���");
		export.addOutputProperty("coopertype", "��������", export.CODE2NAME, "$PD_HZLX");
		export.addOutputProperty("cooperrate", "�������ͱ���");
		export.addOutputProperty("subcategory", "��Ʒ������", export.CODE2NAME, "$PD_JTCPZLX");
		export.addOutputProperty("phase1", "һ�׶η�ֵ");
		export.addOutputProperty("phase1rate", "һ�׶γ�����");
		export.addOutputProperty("phase2", "���׶η�ֵ");
		export.addOutputProperty("phase2rate", "���׶γ�����");
		export.addOutputProperty("phase3rate", "���׶γ�����");
		export.addOutputProperty("inusetime", "��Чʱ��", CommonExportBean.DATE, "yyyy-MM-dd");
		export.addOutputProperty("outusetime", "ʧЧʱ��", CommonExportBean.DATE, "yyyy-MM-dd");
		export.addOutputProperty("version", "�汾��");
		
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		export.voClassArray = new Class[] {voClass};
		export.queryMethodName = "doList";
		if (export.headtitle == null) {
			export.headtitle = export.getFileName();
		}
		export.buildExcelPage(actionMapping, actionForm, request, response, user, this);
    	return null;
	}
    
}
