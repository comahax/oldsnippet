/**
* auto-generated code
* Sat Aug 26 10:44:13 CST 2006
*/
package com.sunrise.boss.ui.cms.wayaccount;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.ui.base.*;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.business.cms.wayaccount.persistent.WayaccountListVO;
import com.sunrise.boss.business.cms.wayaccount.persistent.WayaccountVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.cms.wayaccount.WayaccountDelegate;

/**
 * <p>Title: WayaccountAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public class WayaccountAction extends BaseDelegateAction {
    public WayaccountAction() {
           //���¼��������Ǳ���� 
           //ָ��VO�� 
            setVoClass(WayaccountVO.class);
            //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ����� 
           this.pkNameArray = new String[2]; 
           pkNameArray[0] = "accid";
           pkNameArray[1] = "wayid"; 
    }
    
    /**
     * �½�
     */
    public ActionForward doNew(ActionMapping actionMapping,
                                  ActionForm actionForm,
                                  HttpServletRequest request,
                                  HttpServletResponse response, User user) throws
            Exception {
    	WayaccountForm form = (WayaccountForm) actionForm;
        String  command = getCommandString(request);
        form.setCmdState(command);
      	request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
    	return (actionMapping.findForward("content"));
    }
    
	public void onDuplicatePk(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) {
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
				"��ͬ�ʻ���ʶ�����������Ѿ�����, ������������ʶ");

	} 
    
	/**
	 * ��ѯ
	 */
	public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		
		WayaccountForm form = (WayaccountForm) actionForm;
		
		String wayid = null;
		if (form.getWayid()==null||form.getWayid().equals("")){
			wayid = request.getParameter(WebConstant.COMMAND_STRING_WAYID);
		}else{
			wayid = form.getWayid();
		}
			
		if (wayid==null||wayid.equals("")){
			form.setCmdState(WebConstant.COMMAND_STRING_ERROR);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "������������Ϊ��!");
		}else{
			form.setWayid(wayid);
			Page.setPageSize(request, form);
			WayaccountListVO listVO = new WayaccountListVO();
			setListVO(listVO, form); // ���ú�listVO����Ϊ��ѯ����
			listVO.set_se_wayid(wayid);
			WayaccountDelegate delegate = new WayaccountDelegate();
			DataPackage dp = delegate.doQuery(listVO, user);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		}

		return (actionMapping.findForward("list"));
	}

}
