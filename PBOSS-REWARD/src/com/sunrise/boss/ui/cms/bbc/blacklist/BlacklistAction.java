/**
* auto-generated code
* Wed Dec 07 09:27:39 CST 2011
*/
package com.sunrise.boss.ui.cms.bbc.blacklist;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.bbc.blacklist.persistent.BlacklistVO;
import com.sunrise.boss.business.cms.nores.persistent.NoresListVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.cms.nores.NoresDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: BlacklistAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class BlacklistAction extends BaseDelegateAction {
    public BlacklistAction() {
            setVoClass(BlacklistVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "mobile"; 
    }
    
    protected ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
    	BlacklistForm blacklistForm=(BlacklistForm)actionForm;
//    	NoresDelegate noresDelegate=new NoresDelegate();
//    	NoresListVO noresListVO=new NoresListVO();
//    	noresListVO.set_se_mobileno(blacklistForm.getMobile());
//    	DataPackage dataPackage=noresDelegate.doQuery(noresListVO, user);
//    	if(dataPackage.getRowCount()==0){
//    		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,"手机号码不正确");
//			return (actionMapping.findForward("content"));
//    	}
    	
    	return super.doSave(actionMapping,blacklistForm , request, response, user);
    }
    
}
