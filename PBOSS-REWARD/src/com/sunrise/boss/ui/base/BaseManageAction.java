package com.sunrise.boss.ui.base;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

public class BaseManageAction extends BaseAction {

	/**
	 * 删除
	 */
	protected ActionForward doDelete(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		String[] selectArray = ((BaseActionForm) actionForm).get_selectitem();
		CommonDelegate delegate = new CommonDelegate(voClass);
		for (int i = 0; i < selectArray.length; i++) {
			if (selectArray[0].indexOf('|') == -1) { // 单一主键
				delegate.doRemoveByPkWithManageLog(getDeletePK(selectArray[i]), user);
			} else { // 复合主键
				delegate.doRemoveByVoWithManageLog(getDeletePkVO(selectArray[i]), user);
			}
		}

		return doList(actionMapping, actionForm, request, response, user);
	}

	/**
	 * 保存
	 */
	protected ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		Object contentVO = voClass.newInstance();
		setSaveVO(contentVO, actionForm); // 在此格式化处理好 vo 以保存

		CommonDelegate delegate = new CommonDelegate(voClass);
		String cmdState = ((BaseActionForm) actionForm).getCmdState();
		if (WebConstant.COMMAND_STRING_EDIT.equals(cmdState)) {//更新
			delegate.doUpdateWithManageLog(contentVO, user);
			BeanUtils.copyProperties(actionForm, contentVO); //把更新后的值赋给form，用于web显示
            request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存成功");  
		} else {//保存
			Object vo = null;
        	if(pkNameArray.length==1){ //单一主键
        		Object pk = BeanUtils.getProperty(contentVO, pkNameArray[0]);
        		if(null!=pk){
        			vo = delegate.doFindByPk((Serializable) pk, user);
        		}	
        	}else{//复合主建
        		Object pkVO = voClass.newInstance();
        		BeanUtils.copyProperties(pkVO, contentVO);
        		vo = delegate.doFindByPk((Serializable) pkVO, user);	
        	}
            if(vo==null){
            	delegate.doCreateWithManageLog(contentVO, user);	
            	BeanUtils.copyProperties(actionForm, contentVO); //把更新后的值赋给form，用于web显示
                request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存成功");    	
            }else{
            	request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
            	request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存失败，失败原因：主键重复"); 
            } 
		}
		return (actionMapping.findForward("content"));
	}

}
