package com.sunrise.boss.ui.cms.zjty.zjtycitylvlrwd;



/**
 * auto-generated code
 * Tue May 01 13:34:19 CST 2007
 */

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.zjty.zjtycitylvlrwd.persistent.ZjtyCitylvlrwdListVO;
import com.sunrise.boss.business.cms.zjty.zjtycitylvlrwd.persistent.ZjtyCitylvlrwdVO;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.zjty.zjtycitylvlrwd.ZjtyCitylvlrwdDelegate;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>
 * Title: ZjtyOperationAction
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p> 
 * 
 * @author
 * @version 1.0
 */
public class ZjtyCitylvlrwdAction extends BaseDelegateAction {

	private static final Log log = LogFactory.getLog(ZjtyCitylvlrwdAction.class);

	public ZjtyCitylvlrwdAction() {
		// 以下几个方法是必须的
		// 指定VO类
		setVoClass(ZjtyCitylvlrwdVO.class);
		// 指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
		this.pkNameArray = new String[1];
		pkNameArray[0] = "cityid";
	}
	
	public ActionForward doSet(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		ZjtyCitylvlrwdForm form = (ZjtyCitylvlrwdForm) actionForm;
		
		ZjtyCitylvlrwdVO vo = new ZjtyCitylvlrwdVO(user.getCityid());
		ZjtyCitylvlrwdDelegate delegate = new ZjtyCitylvlrwdDelegate();
		vo = delegate.doFindByPk(vo.getCityid(), user);
		
		form.setCityid(user.getCityid());
		if(vo == null){
			form.setCmdState(WebConstant.COMMAND_STRING_NEW);
			return super.doNew(actionMapping, actionForm, request, response, user);
		}else{
			form.setRwdupper(vo.getRwdupper());
			form.setCmdState(WebConstant.COMMAND_STRING_EDIT);
			return actionMapping.findForward("content");
		}
		
	}
}
