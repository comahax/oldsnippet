/**
* auto-generated code
* Wed May 18 15:47:28 CST 2011
*/
package com.sunrise.boss.ui.cms.reward.creditstd;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.reward.creditstd.persistent.CreditstdListVO;
import com.sunrise.boss.business.cms.reward.creditstd.persistent.CreditstdVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.cms.reward.creditstd.CreditstdDelegate;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: CreditstdAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
public class CreditstdproAction extends BaseDelegateAction {
    public CreditstdproAction() {
            setVoClass(CreditstdVO.class);
        // TODO: ������������������
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "seq"; 
    }
    
    // ��ѯ
	public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		// �趨��ѯ����
		CreditstdForm form = (CreditstdForm)actionForm;
		form.set_ne_cityid("999");
		return super.doList(actionMapping, actionForm, request, response, user);
	}
	
	// ����
	public ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		// ȡ��ʡ��˾���õ��������
		CreditstdForm form = (CreditstdForm)actionForm;
		CreditstdDelegate delegate = new CreditstdDelegate();
		// ͬ������ͬһ�������ʶ��ͬһ���Ǽ���ͬһ���Ǽ��ֲ㲻�ܴ���ͬһ����¼
		String cmdState = form.getCmdState();
		if (WebConstant.COMMAND_STRING_NEW.equals(cmdState)) {
//			form.setCityid(Short.valueOf(user.getCityid()));			
			CreditstdListVO listvo = new CreditstdListVO();
			listvo.set_ne_cityid("999");
			listvo.set_ne_slv(form.getSlv().toString());
			listvo.set_ne_adtypecode(form.getAdtypecode().toString());
			DataPackage dp = delegate.doQuery(listvo, user);
			if (dp != null && dp.getDatas().size() > 0) {
				request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
           		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "ͬ���Ǽ�,ͬ���������ͣ�ֻ����һ������׼��"); 
           		return (actionMapping.findForward("content"));
			}
		}
		
		return super.doSave(actionMapping, actionForm, request, response, user);
	}
}
