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
	 * ɾ��
	 */
	protected ActionForward doDelete(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		String[] selectArray = ((BaseActionForm) actionForm).get_selectitem();
		CommonDelegate delegate = new CommonDelegate(voClass);
		for (int i = 0; i < selectArray.length; i++) {
			if (selectArray[0].indexOf('|') == -1) { // ��һ����
				delegate.doRemoveByPkWithManageLog(getDeletePK(selectArray[i]), user);
			} else { // ��������
				delegate.doRemoveByVoWithManageLog(getDeletePkVO(selectArray[i]), user);
			}
		}

		return doList(actionMapping, actionForm, request, response, user);
	}

	/**
	 * ����
	 */
	protected ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		Object contentVO = voClass.newInstance();
		setSaveVO(contentVO, actionForm); // �ڴ˸�ʽ������� vo �Ա���

		CommonDelegate delegate = new CommonDelegate(voClass);
		String cmdState = ((BaseActionForm) actionForm).getCmdState();
		if (WebConstant.COMMAND_STRING_EDIT.equals(cmdState)) {//����
			delegate.doUpdateWithManageLog(contentVO, user);
			BeanUtils.copyProperties(actionForm, contentVO); //�Ѹ��º��ֵ����form������web��ʾ
            request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ɹ�");  
		} else {//����
			Object vo = null;
        	if(pkNameArray.length==1){ //��һ����
        		Object pk = BeanUtils.getProperty(contentVO, pkNameArray[0]);
        		if(null!=pk){
        			vo = delegate.doFindByPk((Serializable) pk, user);
        		}	
        	}else{//��������
        		Object pkVO = voClass.newInstance();
        		BeanUtils.copyProperties(pkVO, contentVO);
        		vo = delegate.doFindByPk((Serializable) pkVO, user);	
        	}
            if(vo==null){
            	delegate.doCreateWithManageLog(contentVO, user);	
            	BeanUtils.copyProperties(actionForm, contentVO); //�Ѹ��º��ֵ����form������web��ʾ
                request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ɹ�");    	
            }else{
            	request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
            	request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ʧ�ܣ�ʧ��ԭ�������ظ�"); 
            } 
		}
		return (actionMapping.findForward("content"));
	}

}
