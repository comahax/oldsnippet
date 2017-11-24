/**
* auto-generated code
* Fri Dec 08 11:45:12 CST 2006
*/
package com.sunrise.boss.ui.cms.fee.yxfeaprv;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.fee.yxfeaprv.persistent.YxfeaprvVO;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.ui.cms.fee.yxfeaprv.YxfeaprvForm;

/**
 * <p>Title: YxfeaprvAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
public class YxfeaprvAction extends BaseDelegateAction {
    public YxfeaprvAction() {
        this.voClass = YxfeaprvVO.class;
        // TODO: 给出主键的名字数组
        this.pkNameArray=new String[1];
        pkNameArray[0] = "seq"; 
    }
 
    
	/**
	 * 设置默认值
	 */
	public ActionForward doShow(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		YxfeaprvForm form = (YxfeaprvForm)actionForm;
		//设置默认值
	    if (StringUtils.isEmpty(form.get_se_appoprcode())) {
			form.set_se_appoprcode(user.getOpercode());
		} else {
			form.set_se_appoprcode(form.get_se_appoprcode());
		}
	    if (StringUtils.isEmpty(form.get_se_state())) {
			form.set_se_state("0");
		} else {
			form.set_se_state(form.get_se_state());
		}
	    return super.doList(actionMapping,actionForm,request,response, user);
	}
	
    public ActionForward doNew(ActionMapping actionMapping,ActionForm actionForm,HttpServletRequest request,HttpServletResponse response, User user) throws Exception {
		
    	YxfeaprvForm form = (YxfeaprvForm)actionForm;
    	form.setWayid(user.getWayid());
    	form.setAppoprcode(user.getOpercode());
    	form.setState(new Short("0"));
    	return super.doNew(actionMapping,actionForm,request,response, user);
		}
    /*
    public ActionForward doEdit(ActionMapping actionMapping,ActionForm actionForm,HttpServletRequest request,HttpServletResponse response, User user) throws Exception {
		
    	YxfeaprvForm form = (YxfeaprvForm)actionForm;
    	request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
    	request.setAttribute("state", form.getState());
    	return super.doEdit(actionMapping,actionForm,request,response, user);
		}
	*/	
    /**
     * 保存
     */
    public ActionForward doSave(ActionMapping actionMapping,
            ActionForm actionForm,
            HttpServletRequest request,
            HttpServletResponse response, User user) throws
            Exception {
    		YxfeaprvForm form = (YxfeaprvForm)actionForm;
    	   String cmdState = ((BaseActionForm)actionForm).getCmdState();
    	   if(cmdState!=null && WebConstant.COMMAND_STRING_NEW.equals(cmdState)){
    		   	form.setApptime(new java.sql.Timestamp(System.currentTimeMillis()));
    	        form.setAppoprcode(user.getOpercode()); 
    	        form.setState(new Short("0"));
    	   }
    	   if(cmdState!=null && WebConstant.COMMAND_STRING_EDIT.equals(cmdState) && !form.getAppoprcode().equals(user.getOpercode())){
    		   request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);           	
	       	   request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存失败,您不是最初申请人，没有权限修改");
	       	   return (actionMapping.findForward("content"));
    	   }
       	   return super.doSave(actionMapping,actionForm,request,response, user);
    }
    
  
}
