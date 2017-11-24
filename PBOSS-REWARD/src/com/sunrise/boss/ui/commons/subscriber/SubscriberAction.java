package com.sunrise.boss.ui.commons.subscriber;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.common.subscriber.persistent.SubscriberListVO;
import com.sunrise.boss.business.common.subscriber.persistent.SubscriberVO;
import com.sunrise.boss.business.fee.acccounting.control.AccountingUtils;
import com.sunrise.boss.business.fee.common.FEEUtils;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.delegate.common.subscriber.SubscriberDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * 
 * A Demo Action:SubscriberAction <br>
 * Description: class CompanyAction <br>
 * Company: sunrise,Guangzhou</br>
 * 
 * @author mys
 * @since 1.0
 * @version 1.0 2006-7-31
 */
public class SubscriberAction extends BaseAction {

	public SubscriberAction() {
		// 以下几个方法是必须的
		// 指定VO类
		setVoClass(SubscriberVO.class);
		this.pkNameArray = new String[1];
		pkNameArray[0] = "subsid";

	}

	
	public ActionForward doSelect(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		
		String isNull = "FLASE";
		try{
			/**  全省出帐平台过来的请求处理 add by mys 20071214 **/
			chkPurview(actionForm, request, user);
		
			String mobileno = request.getParameter("mobileno");		
			if (null != mobileno && !"".equals(mobileno)) {

				SubscriberListVO listvo = new SubscriberListVO();
				Page.setPageSize(request, (BaseActionForm)actionForm);
				((BaseActionForm)actionForm).set_pagesize("8");
				setListVO(listvo, actionForm); 
				listvo.set_se_servnumber(mobileno);			
				
				SubscriberDelegate delegate = new SubscriberDelegate();
				DataPackage dp = delegate.doQueryByNo(listvo, user);	
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST,dp);
				BeanUtils.copyProperties(actionForm, listvo);
				if(null != dp && null != dp.getDatas() && dp.getDatas().size() > 0){
					isNull = "TRUE";
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex.getMessage());
		}
		request.setAttribute("isNull",isNull);
		
		return (actionMapping.findForward("subscriber"));
	}
	
	
	public ActionForward doList1(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		
		String isNull = "FLASE";
		
		try{
			/**  全省出帐平台过来的请求处理 add by mys 20071214 **/
			chkPurview(actionForm, request, user);
			
			Page.setPageSize(request, (BaseActionForm)actionForm);
			SubscriberListVO listvo = new SubscriberListVO();
			setListVO(listvo, actionForm);		
			listvo.set_pagesize("8");
			
			if (null != listvo.get_se_servnumber()	 && !"".equals(listvo.get_se_servnumber())) {
				
				SubscriberDelegate delegate = new SubscriberDelegate();
				DataPackage dp = delegate.doQueryByNo(listvo, user);	
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST,dp);
				BeanUtils.copyProperties(actionForm, listvo);
				if(null != dp && null != dp.getDatas() && dp.getDatas().size() > 0){
					isNull = "TRUE";
				}
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex.getMessage());
		}
		request.setAttribute("isNull",isNull);
		
		return (actionMapping.findForward("subscriber"));
	}
	
	
	/****** 全省出帐平台 ******/	
	
	private void chkPurview(ActionForm actionForm, HttpServletRequest request, User user) throws Exception{
		
		/**  全省出帐平台过来的请求处理 add by mys 20071214 -start**/
		SubscriberForm form = (SubscriberForm) actionForm;
		String accounting = request.getParameter("_ACCOUNTING");	
		if("ACCOUNTING".equals(accounting)){
			form.setAccounting(accounting);
		}				
		if("ACCOUNTING".equals(form.getAccounting())){				
			
			String cityid = AccountingUtils.getCityid(request.getParameter("_CITYID"));
			if(cityid == null || "".equals(cityid)){
				cityid = form.getCityid();				
			}else{
				form.setCityid(cityid);
			}
			
			if(cityid == null || "".equals(cityid)){
				throw new Exception("市标识错误:null!");
			}			
			
			if (FEEUtils.chkPurView("ACCOUNTING",user) || FEEUtils.chkPurView(user, cityid)) {				
				user = FEEUtils.getNewUser(user,cityid);			
			}else {
				throw new Exception(cityid + "您没权限操作!");		
			}	
		}
		/** -end **/		
		
	}
	
	
	
}
