/**
* auto-generated code
* Mon Dec 28 10:41:51 CST 2009
*/
package com.sunrise.boss.ui.cms.zjty.zjtybusyxplan;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.zjty.zjtybusyxplan.persistent.ZjtyBusyxplanListVO;
import com.sunrise.boss.business.cms.zjty.zjtybusyxplan.persistent.ZjtyBusyxplanVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.delegate.cms.zjty.zjtybusyxplan.ZjtyBusyxplanDelegate;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: ZjtyBusyxplanAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class ZjtyBusyxplanAction extends BaseDelegateAction {
    public ZjtyBusyxplanAction() {
            setVoClass(ZjtyBusyxplanVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[3]; 
           pkNameArray[0] = "opnid"; 
           pkNameArray[1] = "prodid"; 
           pkNameArray[2] = "cityid";
    }
    
    public ActionForward doList(ActionMapping actionMapping,
    		ActionForm actionForm, HttpServletRequest request,
    		HttpServletResponse response, User user) throws Exception {
    	// TODO Auto-generated method stub
    	try{
	    	ZjtyBusyxplanForm form = (ZjtyBusyxplanForm)actionForm;
//	    	form.set_se_planbusitype("HAPPYONLINE");
	    	if (form.get_se_cityid() == null || "".equals(form.get_se_cityid())) {
	    		form.set_se_cityid(user.getCityid());
	    	}
	    	request.setAttribute("cityid", form.get_se_cityid());
	    	return super.doList(actionMapping, actionForm, request, response, user);
    	}catch (Exception e) {
    		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
    		return (actionMapping.findForward("list"));
			// TODO: handle exception
		}
    }
    
    public ActionForward doNew(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
    	// TODO Auto-generated method stub
    	request.setAttribute("cityid", user.getCityid());
    	return super.doNew(actionMapping, actionForm, request, response, user);
    }
    
    public ActionForward doSave(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
    	// TODO Auto-generated method stub
    	ZjtyBusyxplanForm form = (ZjtyBusyxplanForm)actionForm;
    	form.setCityid(user.getCityid());
    	String cmdState = ((BaseActionForm)actionForm).getCmdState();
    	if (WebConstant.COMMAND_STRING_NEW.equals(cmdState)) {
    		ZjtyBusyxplanDelegate delegate = new ZjtyBusyxplanDelegate();
    		ZjtyBusyxplanVO vo = new ZjtyBusyxplanVO();
    		BeanUtils.copyProperties(vo, form);
    		ZjtyBusyxplanVO zjtyBusyxplanVO = delegate.doFindByPk(vo, user);
    		if (zjtyBusyxplanVO != null) {
    			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存失败,已存在相同的产品编码与业务编码设置");
           		return (actionMapping.findForward("content"));
    		}
    	}
    	return super.doSave(actionMapping, actionForm, request, response, user);
    }
    
    public ActionForward doImport(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		return actionMapping.findForward("batch");
	}
}

