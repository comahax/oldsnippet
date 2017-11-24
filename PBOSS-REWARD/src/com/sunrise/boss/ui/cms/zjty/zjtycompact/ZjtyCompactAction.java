/**
* auto-generated code
* Wed Dec 28 14:39:42 CST 2011
*/
package com.sunrise.boss.ui.cms.zjty.zjtycompact;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.zjty.zjtycompact.persistent.ZjtyCompactVO;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.zjty.zjtycompact.ZjtyCompactDelegate;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: ZjtyCompactAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author qiuzhi
 * @version 1.0
 */
public class ZjtyCompactAction extends BaseDelegateAction {
    public ZjtyCompactAction() {
            setVoClass(ZjtyCompactVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "wayid"; 
    }
    
    public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			ZjtyCompactForm form = (ZjtyCompactForm) actionForm;
			form.set_pagesize("");
			form.set_ne_cityid(user.getCityid());
	    	return super.doList(actionMapping, actionForm, request, response, user);
		} catch (BusinessException e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
			return (actionMapping.findForward("list"));
		}
	}
    
    public ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		// TODO Auto-generated method stub
			ZjtyCompactForm form = (ZjtyCompactForm) actionForm;
//			SimpleDateFormat sd =new SimpleDateFormat("yyyy-MM-dd");
			form.setOpertime(new Date());
			form.setOpercode(user.getOpercode());
			form.setCityid(new Short(user.getCityid()));
			return super.doSave(actionMapping, actionForm, request, response, user);	
    }
}
