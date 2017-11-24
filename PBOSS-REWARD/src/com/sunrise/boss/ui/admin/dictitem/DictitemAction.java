/**
* auto-generated code
* Thu Sep 21 16:09:09 CST 2006
*/
package com.sunrise.boss.ui.admin.dictitem;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.business.admin.dictitem.persistent.DictitemListVO;
import com.sunrise.boss.business.admin.dictitem.persistent.DictitemVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.admin.dictitem.DictitemDelegate;


/**
 * <p>Title: DictitemAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author eboxdisc
 * @version 1.0
 */
public class DictitemAction extends BaseAction {
    public DictitemAction() {
           //以下几个方法是必须的 
           //指定VO类 
            setVoClass(DictitemVO.class);
            //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称 
           this.pkNameArray = new String[2]; 
           pkNameArray[0] = "dictid"; 
           pkNameArray[1] = "groupid"; 
    }
    public ActionForward doList(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
    	DictitemForm form  = (DictitemForm)actionForm;
		
        try {
        	Page.setPageSize(request, form);  
        	DictitemListVO listVO = new DictitemListVO();
        	setListVO(listVO, actionForm);     	
        	DictitemDelegate delegate = new DictitemDelegate();
        	DataPackage dp = delegate.doQuery(listVO,user);
        	
        	//form.setPage(dp.getPageNo());
            request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
        }catch(BusinessException e) {
        	 request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
        }catch(Exception e) {
        	throw e;
        } 
        return (actionMapping.findForward("list"));
	}
}
