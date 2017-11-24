/**
* auto-generated code
* Mon Apr 08 15:52:02 CST 2013
*/
package com.sunrise.boss.ui.cms.zjty.chzjtyterewardstd;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.zjty.chzjtyterewardstd.persistent.ChZjtyTerewardstdVO;
import com.sunrise.boss.delegate.admin.acl.ACLDelegate;
import com.sunrise.boss.delegate.cms.zjty.chzjtyterewardstd.ChZjtyTerewardstdDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: ChZjtyTerewardstdAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public class ChZjtyTerewardstdAction extends BaseAction {
	public static final String CH_TERREWARDTYPE_PRO ="CH_TERREWARDTYPE_PRO";//省公司令牌
	
    public ChZjtyTerewardstdAction() {
            setVoClass(ChZjtyTerewardstdVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[3];
           pkNameArray[0] = "citycode";
           pkNameArray[1] = "comid";
           pkNameArray[2] = "rewardtype";
    }

	@Override
	protected ActionForward doEdit(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		getContentVO(request, user, actionForm);
		String command = getCommandString(request);
		
		ChZjtyTerewardstdForm form = (ChZjtyTerewardstdForm) actionForm;
		if (Short.toString(form.getCitycode()).equals("999")) {
			form.setRegion("999");
		} else {
			form.setRegion(Short.toString(form.getCitycode()));
		}
		
		((BaseActionForm) actionForm).setCmdState(command);
		request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
		return (actionMapping.findForward("content"));
	}

	@Override
	protected ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		ChZjtyTerewardstdForm form = (ChZjtyTerewardstdForm) actionForm;
		ACLDelegate aclDelegate = new ACLDelegate();
		boolean b = aclDelegate.checkPermission(user.getOpercode(), CH_TERREWARDTYPE_PRO);
		if (b) {
			if(form.get_ne_citycode() == null || form.get_ne_citycode().equals("")){
				form.set_ne_citycode("999");	
			}
			form.setRegion("999");
		} else {
			if(form.get_ne_citycode() == null || form.get_ne_citycode().equals("")){
				form.set_ne_citycode(user.getCityid());
			}
			form.setRegion(user.getCityid());
		}
		return super.doList(actionMapping, form, request, response, user);
	}

	@Override
	protected ActionForward doNew(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		ChZjtyTerewardstdForm form = (ChZjtyTerewardstdForm) actionForm;
		if (form.getRegion() != null && form.getRegion().equals("999")) {
			form.setCitycode(Short.parseShort("999"));
		} else {
			form.setCitycode(Short.parseShort(user.getCityid()));
		}
		form.setCreatetime(new Date());
		form.setCmdState(WebConstant.COMMAND_STRING_NEW);
		request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_NEW);
		return (actionMapping.findForward("content"));
	}
    
	@Override
	protected ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		ChZjtyTerewardstdForm form = (ChZjtyTerewardstdForm) actionForm;
		String command = form.getCmdState();
		if (command != null && command.equals("NEW")) {
			ChZjtyTerewardstdDelegate delegate = new ChZjtyTerewardstdDelegate();
			String pk = form.getCitycode() + "|" + form.getComid() + "|" + form.getRewardtype();
			ChZjtyTerewardstdVO vo = delegate.doFindByPk(getDeletePkVO(pk), user);
			if (vo != null) {
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "同个终端机型、同个酬金类型已存在相同记录!");				
				form.setCmdState(WebConstant.COMMAND_STRING_NEW);
				request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_NEW);
				return (actionMapping.findForward("content"));
			}
		}
		return super.doSave(actionMapping, actionForm, request, response, user);
	}

	public ActionForward doImport(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		return actionMapping.findForward("batch");
	}
}
