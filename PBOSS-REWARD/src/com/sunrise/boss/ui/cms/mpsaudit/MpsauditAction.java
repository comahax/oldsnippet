/**
* auto-generated code
* Thu Oct 09 16:10:24 CST 2008
*/
package com.sunrise.boss.ui.cms.mpsaudit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.ui.base.*;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.iodaudit.persistent.IodauditVO;
import com.sunrise.boss.business.cms.mpsaudit.persistent.MpsauditListVO;
import com.sunrise.boss.business.cms.mpsaudit.persistent.MpsauditVO;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.cms.mpsaudit.MpsauditDelegate;

/**
 * <p>Title: MpsauditAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public class MpsauditAction extends BaseDelegateAction {
    public MpsauditAction() {
           //���¼��������Ǳ���� 
           //ָ��VO�� 
            setVoClass(MpsauditVO.class);
            //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ����� 
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "adtdate"; 
    }
    
    public ActionForward doExcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		CommonExportBean export = new CommonExportBean(user);
		export.setFileName("�ɼ�ƽ̨���Ż��˲�ѯ");
		export.addOutputProperty("adtdate");
		export.addOutputProperty("iodnum");
		export.addOutputProperty("mpsnum");
		export.addOutputProperty("mpsvalid");
		export.addOutputProperty("percent");
		export.addOutputProperty("successFlag",CommonExportBean.CODE2NAME, "#SUCCESSFLAG");

		export.voClassArray = new Class[] { MpsauditVO.class };
		
		response.setCharacterEncoding("GBK");
		response.setHeader("pragma", "no-cache");
		response.setHeader("Cache-control", "public");
		response.setHeader("Expires", "01 Apr 1995 01:10:10 GMT");
		String fn = "attachment; filename=" + export.getFileName() + ".txt";
		response.setHeader("Content-Disposition", new String(
				fn.getBytes("GBK"), "ISO-8859-1"));
		response.setContentType("text/plain;charset=gbk");
		export.writeTxtTitle(response.getOutputStream(), new String[] {
				"����", "IOD��Ч�׿���", "�ɼ�ƽ̨��Ч�׿���", "�ɼ�ƽ̨�ɹ�ƥ��iod��", "ƥ��ɹ���", "�Ƿ�ͨ��"});
		super.ExportQuery(actionMapping, actionForm, request, response, user,
				export);
		return actionMapping.findForward(null);
	}
}
