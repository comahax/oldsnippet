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
        // TODO: 给出主键的名字数组
        this.pkNameArray = new String[1];
        pkNameArray[0] = "yxplankindid";
    }
    /**
     * 保存
     */
    protected ActionForward doSave(ActionMapping actionMapping,
                                   ActionForm actionForm,
                                   HttpServletRequest request,
                                   HttpServletResponse response, User user) throws
            Exception {

    	YxPlanKindVO contentVO = (YxPlanKindVO)voClass.newInstance();
//        BeanUtils.copyProperties(contentVO, actionForm);

        setSaveVO(contentVO, actionForm); //在此格式化处理好 vo 以保存

        YxPlanKindDelegate delegate = new YxPlanKindDelegate();
        String cmdState = ((BaseActionForm)actionForm).getCmdState();
        if (WebConstant.COMMAND_STRING_EDIT.equals(cmdState)) {//更新
            delegate.doUpdate(contentVO, user);
            BeanUtils.copyProperties(actionForm, contentVO); //把更新后的值赋给form，用于web显示
            request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存成功");  
        } else {//新增
        	Object vo = null;
        	if(pkNameArray.length==1){ //单一主键
        		Object pk = BeanUtils.getProperty(contentVO, pkNameArray[0]);
        		if(pk!=null){
        			vo = delegate.doFindByPk((Serializable) pk, user);
        		}
        	}else{//复合主建
        		Object pkVO = voClass.newInstance();
        		BeanUtils.copyProperties(pkVO, contentVO);
        		vo = delegate.doFindByPk((Serializable) pkVO, user);	
        	}
            if(vo==null){
            	delegate.doCreate(contentVO, user);	
            	BeanUtils.copyProperties(actionForm, contentVO); //把更新后的值赋给form，用于web显示
                request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存成功");    	
            }else{
            	request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
            	request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存失败,主键重复"); 
            }    
        }
        return (actionMapping.findForward("content"));
    }
    
    /**
     * 删除
     */
    protected ActionForward doDelete(ActionMapping actionMapping,
                                     ActionForm actionForm,
                                     HttpServletRequest request,
                                     HttpServletResponse response, User user) throws
            Exception {
        String[] selectArray = ((BaseActionForm) actionForm).get_selectitem();
        YxPlanKindDelegate delegate = new YxPlanKindDelegate();
        for (int i = 0; i < selectArray.length; i++) {
            if (selectArray[0].indexOf('|') == -1) { //单一主键
                delegate.doRemoveByPK(getDeletePK(selectArray[i]), user);
            } else { //复合主键
                delegate.doRemoveByVO((YxPlanKindVO)getDeletePkVO(selectArray[i]), user);
            }
        }

        return doList(actionMapping, actionForm, request, response, user);
    }

}
