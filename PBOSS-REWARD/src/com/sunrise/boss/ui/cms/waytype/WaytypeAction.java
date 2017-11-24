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
           //以下几个方法是必须的 
           //指定VO类 
            setVoClass(WaytypeVO.class);
            //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称 
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "waytypecode"; 
    }
    
    public void onDuplicatePk(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) {
    	
    	request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "相同编码的渠道类别已经存在, 请输入其他编码");
    }
    
    /**
     * 查询
     */
    public ActionForward doTree(ActionMapping actionMapping,
                                   ActionForm actionForm,
                                   HttpServletRequest request,
                                   HttpServletResponse response, User user) throws
            Exception {
    	
    	WaytypeDelegate delegate = new WaytypeDelegate();
        WaytypeListVO listVO = new WaytypeListVO();
        //全部一次性查询出来，_pagesize等参数设置为Integer.MAX_VALUE或NULL
        listVO.set_pagesize(null);
        DataPackage dp = delegate.doQuery(listVO, user);
        request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
        return (actionMapping.findForward("tree"));
    }
    
    /**
     * 查询
     */
    public ActionForward doList(ActionMapping actionMapping,
                                   ActionForm actionForm,
                                   HttpServletRequest request,
                                   HttpServletResponse response, User user) throws
            Exception {
    	
    	WaytypeDelegate delegate = new WaytypeDelegate();
        WaytypeListVO listVO = new WaytypeListVO();
        //全部一次性查询出来，_pagesize等参数设置为Integer.MAX_VALUE或NULL
        listVO.set_pagesize(null);
        DataPackage dp = delegate.doQuery(listVO, user);
        request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
        return (actionMapping.findForward("list"));
    }
    
    /**
     * 新建
     */
    public ActionForward doNew(ActionMapping actionMapping,
                                  ActionForm actionForm,
                                  HttpServletRequest request,
                                  HttpServletResponse response, User user) throws
            Exception {

        //新建时设置form的默认值
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
     * 删除
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
