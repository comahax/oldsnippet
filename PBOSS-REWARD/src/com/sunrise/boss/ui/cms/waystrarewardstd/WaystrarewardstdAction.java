/**
* auto-generated code
* Fri Jul 08 11:36:28 CST 2011
*/
package com.sunrise.boss.ui.cms.waystrarewardstd;

import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.salereward.persistent.SalerewardListVO;
import com.sunrise.boss.business.cms.waystrarewardstd.persistent.WaystrarewardstdListVO;
import com.sunrise.boss.business.cms.waystrarewardstd.persistent.WaystrarewardstdVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.cms.salereward.SalerewardDelegate;
import com.sunrise.boss.delegate.cms.waystrarewardstd.WaystrarewardstdDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.cms.salereward.SalerewardForm;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: WaystrarewardstdAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class WaystrarewardstdAction extends BaseAction {
    public WaystrarewardstdAction() {
            setVoClass(WaystrarewardstdVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "seq"; 
    }
    
    public ActionForward doImport(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		
		return actionMapping.findForward("batch");
	}
    
    public ActionForward doList(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception{		
//    	WaystrarewardstdDelegate delegate=new WaystrarewardstdDelegate();
//    	WaystrarewardstdListVO listVO=new WaystrarewardstdListVO() ;
//    	WaystrarewardstdForm
//    	listVO.set_ne_cityid(user.getCityid());
//    	DataPackage dp=delegate.doQuery(listVO, user);
//    	request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
//		return (actionMapping.findForward("list"));
    	
    	WaystrarewardstdForm form = (WaystrarewardstdForm)actionForm;
    	form.set_ne_cityid(user.getCityid());
    	return super.doList(actionMapping, actionForm, request, response, user);
    	
    	
    }
    
 // 保存
	public ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		
		// 设定更新时间
		WaystrarewardstdForm form = (WaystrarewardstdForm)actionForm;
		form.setOpercode(user.getOpercode());
		form.setOpertime(new Date());
		// 设定地市
		String cmdState = form.getCmdState();
		if (WebConstant.COMMAND_STRING_NEW.equals(cmdState)) {
			form.setOpertype("I");
			
			form.setCityid(Short.valueOf(user.getCityid()));
			
			// 每个地市同个业务类型只能有一个
			WaystrarewardstdDelegate delegate = new WaystrarewardstdDelegate();
			WaystrarewardstdListVO listvo = new WaystrarewardstdListVO();
			listvo.set_ne_cityid(user.getCityid());
			listvo.set_ne_rewardstd(form.getRewardstd().toString());
			listvo.set_se_wayid(form.getWayid());
			listvo.set_ne_rewardtype(form.get_ne_rewardtype());
			DataPackage dp = delegate.doQuery(listvo, user);
			if (dp != null && dp.getDatas().size() > 0) {
				request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
           		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "同一个地市同一个渠道同一个酬金类型，只能有一个酬金标准。"); 
           		return (actionMapping.findForward("content"));
			}
		}else{
			form.setOpertype("U");
			
			form.setCityid(Short.valueOf(user.getCityid()));
			
			// 每个地市同个业务类型只能有一个
			WaystrarewardstdDelegate delegate = new WaystrarewardstdDelegate();
			WaystrarewardstdListVO listvo = new WaystrarewardstdListVO();
			listvo.set_ne_cityid(user.getCityid());
			listvo.set_ne_rewardstd(form.getRewardstd().toString());
			listvo.set_se_wayid(form.getWayid());
			listvo.set_ne_rewardtype(form.get_ne_rewardtype());
			DataPackage dp = delegate.doQuery(listvo, user);
			Iterator it = dp.getDatas().iterator();
			if(it.hasNext()){
				WaystrarewardstdVO waystrarewardstdVO=(WaystrarewardstdVO)it.next();
				if(!waystrarewardstdVO.getSeq().toString().equals(form.getSeq().toString())){
					request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "同一个地市同一个渠道同一个酬金类型，只能有一个酬金标准。"); 
					return (actionMapping.findForward("content"));
				}
			}
			
		}
		return super.doSave(actionMapping, actionForm, request, response, user);
		
	}
    
}
