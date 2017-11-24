/**
 * auto-generated code
 * Tue May 01 13:34:19 CST 2007
 */
package com.sunrise.boss.ui.cms.bbc.jfopnmap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.bbc.jfopnmap.persistent.JfopnmapVO;
import com.sunrise.boss.business.cms.bbc.operation.persistent.BBCoperationVO;
import com.sunrise.boss.delegate.cms.bbc.operation.BBCoperationDelegate;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>
 * Title: OpnacctmapAction
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
public class JfopnmapAction extends BaseDelegateAction {

	public JfopnmapAction() {
		// 以下几个方法是必须的
		// 指定VO类
		setVoClass(JfopnmapVO.class);
		// 指定主键数组
		this.pkNameArray = new String[3];
		pkNameArray[0] = "entid";
		pkNameArray[1] = "busiid";
		pkNameArray[2] = "opnid";
	}
	
	public ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		JfopnmapForm form=(JfopnmapForm)actionForm;
		
		try{
			BBCoperationVO vo=new BBCoperationVO();
			vo.setOpnid(form.getOpnid());
			vo=new BBCoperationDelegate().doFindByPk(vo.getOpnid(), user);
			if(null==vo){
				if (form.getBusiid().equals("")){
					((JfopnmapForm)actionForm).setBusiid("-1");
				}
			}
			super.doSave(actionMapping, actionForm, request, response, user);
		}catch(Exception e){
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
			e.printStackTrace();
		}
		return actionMapping.findForward("content");
	}
}
