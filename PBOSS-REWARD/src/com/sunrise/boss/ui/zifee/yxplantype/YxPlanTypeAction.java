package com.sunrise.boss.ui.zifee.yxplantype;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.business.zifee.yxplantype.persistent.YxPlanTypeVO;
import com.sunrise.boss.delegate.zifee.yxplantype.YxPlanTypeDelegate;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: YxPlanGroupAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
public class YxPlanTypeAction extends BaseAction{
	public YxPlanTypeAction() {
        this.voClass = YxPlanTypeVO.class;
        // TODO: ������������������
        this.pkNameArray = new String[1];
        pkNameArray[0] = "yxplantypeid";
    }
    /**
     * ����
     */
    protected ActionForward doSave(ActionMapping actionMapping,
                                   ActionForm actionForm,
                                   HttpServletRequest request,
                                   HttpServletResponse response, User user) throws
            Exception {

    	YxPlanTypeVO contentVO = (YxPlanTypeVO)voClass.newInstance();
//        BeanUtils.copyProperties(contentVO, actionForm);

        setSaveVO(contentVO, actionForm); //�ڴ˸�ʽ������� vo �Ա���

        YxPlanTypeDelegate delegate = new YxPlanTypeDelegate();
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

}
