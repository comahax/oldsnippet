/**
* auto-generated code
* Fri Aug 25 11:24:52 CST 2006
*/
package com.sunrise.boss.ui.cms.waytype;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.ui.base.*;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.business.cms.waytype.persistent.WaytypeListVO;
import com.sunrise.boss.business.cms.waytype.persistent.WaytypeVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.waytype.WaytypeDelegate;

/**
 * <p>Title: WaytypeAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author yjr
 * @version 1.0
 */
public class WaytypeAction extends BaseDelegateAction {
    public WaytypeAction() {
           //���¼��������Ǳ���� 
           //ָ��VO�� 
            setVoClass(WaytypeVO.class);
            //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ����� 
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "waytypecode"; 
    }
    
    public void onDuplicatePk(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) {
    	
    	request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "��ͬ�������������Ѿ�����, ��������������");
    }
    
    /**
     * ��ѯ
     */
    public ActionForward doTree(ActionMapping actionMapping,
                                   ActionForm actionForm,
                                   HttpServletRequest request,
                                   HttpServletResponse response, User user) throws
            Exception {
    	
    	WaytypeDelegate delegate = new WaytypeDelegate();
        WaytypeListVO listVO = new WaytypeListVO();
        //ȫ��һ���Բ�ѯ������_pagesize�Ȳ�������ΪInteger.MAX_VALUE��NULL
        listVO.set_pagesize(null);
        DataPackage dp = delegate.doQuery(listVO, user);
        request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
        return (actionMapping.findForward("tree"));
    }
    
    /**
     * ��ѯ
     */
    public ActionForward doList(ActionMapping actionMapping,
                                   ActionForm actionForm,
                                   HttpServletRequest request,
                                   HttpServletResponse response, User user) throws
            Exception {
    	
    	WaytypeDelegate delegate = new WaytypeDelegate();
        WaytypeListVO listVO = new WaytypeListVO();
        //ȫ��һ���Բ�ѯ������_pagesize�Ȳ�������ΪInteger.MAX_VALUE��NULL
        listVO.set_pagesize(null);
        DataPackage dp = delegate.doQuery(listVO, user);
        request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
        return (actionMapping.findForward("list"));
    }
    
    /**
     * �½�
     */
    public ActionForward doNew(ActionMapping actionMapping,
                                  ActionForm actionForm,
                                  HttpServletRequest request,
                                  HttpServletResponse response, User user) throws
            Exception {

        //�½�ʱ����form��Ĭ��ֵ
    	WaytypeForm waytypeForm = ((WaytypeForm)actionForm);
        if (waytypeForm.getWaytypecode()==null ||waytypeForm.getWaytypecode().equals("")){
        	waytypeForm.setUppercode("-1");
        }else{
        	waytypeForm.setUppercode(waytypeForm.getWaytypecode());
        }
    	waytypeForm.setWaytypecode("");
    	waytypeForm.setWaytypename("");
    	waytypeForm.setDesp("");
        String command = getCommandString(request);
        waytypeForm.setCmdState(command);
    	
        return (actionMapping.findForward("content"));
    } 
    
    /**
     * ɾ��
     */
    public ActionForward doDelete(ActionMapping actionMapping,
                                     ActionForm actionForm,
                                     HttpServletRequest request,
                                     HttpServletResponse response, User user) throws
            Exception {
    	WaytypeForm form = (WaytypeForm)actionForm;
		String path = "";
        String waytypecode = form.getWaytypecode();
        String uppercode = form.getUppercode();
        
        WaytypeDelegate delegate = new WaytypeDelegate();
    	
        try{
            WaytypeVO contentVO = delegate.doFindByPk(waytypecode, user);
            delegate.doRemove(contentVO,user);
            if (uppercode.equals("-1")){
            	form.setWaytypecode("");
            	return doNew(actionMapping,actionForm,request,response,user);
            }{
            	path = "/cms/waytype.do?CMD=VIEW&PK="+uppercode;
            	return new ActionForward(path);
            }
    	}catch(BusinessException ex){
    		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex.toString());
            path = "/cms/waytype.do?CMD=VIEW&PK="+waytypecode;
            return new ActionForward(path);
    	}catch(Exception e){
    		throw e;
    	}
    }
     
}
