package com.sunrise.boss.ui.zifee.yxplankind;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.zifee.yxplankind.persistent.YxPlanKindVO;
import com.sunrise.boss.delegate.zifee.yxplankind.YxPlanKindDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

public class YxPlanKindAction extends BaseAction{
	public YxPlanKindAction() {
        this.voClass = YxPlanKindVO.class;
        // TODO: ������������������
        this.pkNameArray = new String[1];
        pkNameArray[0] = "yxplankindid";
    }
    /**
     * ����
     */
    protected ActionForward doSave(ActionMapping actionMapping,
                                   ActionForm actionForm,
                                   HttpServletRequest request,
                                   HttpServletResponse response, User user) throws
            Exception {

    	YxPlanKindVO contentVO = (YxPlanKindVO)voClass.newInstance();
//        BeanUtils.copyProperties(contentVO, actionForm);

        setSaveVO(contentVO, actionForm); //�ڴ˸�ʽ������� vo �Ա���

        YxPlanKindDelegate delegate = new YxPlanKindDelegate();
        String cmdState = ((BaseActionForm)actionForm).getCmdState();
        if (WebConstant.COMMAND_STRING_EDIT.equals(cmdState)) {//����
            delegate.doUpdate(contentVO, user);
            BeanUtils.copyProperties(actionForm, contentVO); //�Ѹ��º��ֵ����form������web��ʾ
            request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ɹ�");  
        } else {//����
        	Object vo = null;
        	if(pkNameArray.length==1){ //��һ����
        		Object pk = BeanUtils.getProperty(contentVO, pkNameArray[0]);
        		if(pk!=null){
        			vo = delegate.doFindByPk((Serializable) pk, user);
        		}
        	}else{//��������
        		Object pkVO = voClass.newInstance();
        		BeanUtils.copyProperties(pkVO, contentVO);
        		vo = delegate.doFindByPk((Serializable) pkVO, user);	
        	}
            if(vo==null){
            	delegate.doCreate(contentVO, user);	
            	BeanUtils.copyProperties(actionForm, contentVO); //�Ѹ��º��ֵ����form������web��ʾ
                request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ɹ�");    	
            }else{
            	request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
            	request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ʧ��,�����ظ�"); 
            }    
        }
        return (actionMapping.findForward("content"));
    }
    
    /**
     * ɾ��
     */
    protected ActionForward doDelete(ActionMapping actionMapping,
                                     ActionForm actionForm,
                                     HttpServletRequest request,
                                     HttpServletResponse response, User user) throws
            Exception {
        String[] selectArray = ((BaseActionForm) actionForm).get_selectitem();
        YxPlanKindDelegate delegate = new YxPlanKindDelegate();
        for (int i = 0; i < selectArray.length; i++) {
            if (selectArray[0].indexOf('|') == -1) { //��һ����
                delegate.doRemoveByPK(getDeletePK(selectArray[i]), user);
            } else { //��������
                delegate.doRemoveByVO((YxPlanKindVO)getDeletePkVO(selectArray[i]), user);
            }
        }

        return doList(actionMapping, actionForm, request, response, user);
    }

}
