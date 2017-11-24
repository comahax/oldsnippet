/**
* auto-generated code
* Tue Sep 18 14:59:25 CST 2012
*/
package com.sunrise.boss.ui.kdkhzld.chpwbroadlist;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.kdkhzld.chpwbroadlist.persistent.ChPwBroadlistVO;
import com.sunrise.boss.delegate.kdkhzld.chpwbroadlist.ChPwBroadlistDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: ChPwBroadlistAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxx
 * @version 1.0
 */
public class ChPwBroadlistAction extends BaseAction {
    public ChPwBroadlistAction() {
            setVoClass(ChPwBroadlistVO.class);
        // TODO: ������������������
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "mobile"; 
    }
    
    public ActionForward doSave(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
    	ChPwBroadlistDelegate chPwBroadlistDelegate = new ChPwBroadlistDelegate();
    	
    	ChPwBroadlistVO chPwBroadlistVO = new ChPwBroadlistVO();
    	setSaveVO(chPwBroadlistVO, actionForm); // �ڴ˸�ʽ������� vo �Ա���
    	chPwBroadlistDelegate.doCreate(chPwBroadlistVO, user);
    	request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ɹ�");
    	return (actionMapping.findForward("content"));
    }
    
    public ActionForward doDelete(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
    	ChPwBroadlistDelegate chPwBroadlistDelegate = new ChPwBroadlistDelegate();
    	
    	String[] selectArray = ((BaseActionForm) actionForm).get_selectitem();
    	for (int i = 0; i < selectArray.length; i++) {
    		String mobile = selectArray[i];
    		ChPwBroadlistVO chPwBroadlistVO = new ChPwBroadlistVO();
    		chPwBroadlistVO.setMobile(mobile);
	    	chPwBroadlistDelegate.doRemove(chPwBroadlistVO, user);
    	}
    	
    	return doList(actionMapping, actionForm, request, response, user);
    }
}
