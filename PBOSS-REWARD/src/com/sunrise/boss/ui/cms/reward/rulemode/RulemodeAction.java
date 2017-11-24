/**
* auto-generated code
* Tue Jul 14 09:24:12 CST 2009
*/
package com.sunrise.boss.ui.cms.reward.rulemode;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ajaxanywhere.AAUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.reward.rulemode.persistent.RulemodeListVO;
import com.sunrise.boss.business.cms.reward.rulemode.persistent.RulemodeVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.reward.rulemode.RulemodeDelegate;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.pub.tools.PublicUtils;

/**
 * <p>Title: RulemodeAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class RulemodeAction extends BaseDelegateAction {
	
	private String errorMsg = "";
	
    public RulemodeAction() {
            setVoClass(RulemodeVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "rulemodeid"; 
    }
    
	public ActionForward doCheckdate(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		RulemodeForm form = (RulemodeForm)actionForm;
		RulemodeListVO listvo = new RulemodeListVO();
		super.setListVO(listvo, form);
		RulemodeDelegate delegate = new RulemodeDelegate();
		DataPackage dp = delegate.doQuery(listvo, user); 
		Iterator itt = dp.getDatas().iterator();
		Date startDate = form.getStartdate();
		Date endDate = form.getEnddate();
		
		errorMsg = "";
		while(itt.hasNext()){
			RulemodeVO vo = (RulemodeVO)itt.next();
			if(form.getRulemodeid()== null || vo.getRulemodeid().longValue() != form.getRulemodeid().longValue()){
				if(	startDate.after(vo.getEnddate()) || endDate.before(vo.getStartdate()) ){
					;
				}else{
					errorMsg = "该时间区间与校验规则模式编码为["+vo.getRulemodeid()+"]存在交集:["+PublicUtils.utilDateToStr(vo.getStartdate())+"]-["+PublicUtils.utilDateToStr(vo.getEnddate())+"]";
					break;
				}
			}
		}
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, errorMsg);
		AAUtils.addZonesToRefresh(request, "errorZone");
		return actionMapping.findForward("content");
	}
	
	public ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,	
			HttpServletResponse response, User user) throws Exception {
		if(StringUtils.isEmpty(errorMsg)){
			return super.doSave(actionMapping, actionForm, request, response, user);
		}else{
			return this.doCheckdate(actionMapping, actionForm, request, response, user);
		}
	}
	
	public ActionForward doNew(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,	
			HttpServletResponse response, User user) throws Exception {
		RulemodeForm form = (RulemodeForm)actionForm;
		RulemodeListVO listvo = new RulemodeListVO();
		super.setListVO(listvo, form);
		RulemodeDelegate delegate = new RulemodeDelegate();
		DataPackage dp = delegate.doQuery(listvo, user); 
		Iterator itt = dp.getDatas().iterator();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		String nowDate = sdf.format(new Date());
		
		Date date = new Date();
		while(itt.hasNext()){
			RulemodeVO vo = (RulemodeVO) itt.next();
			if(vo.getEnddate().after(date)){
				date = vo.getEnddate();
			}
		}
		String maxDate = sdf.format(date);
		if(nowDate.compareTo(maxDate) >= 0){
			form.setStartdate(PublicUtils.UtilStrToDate(nowDate, "yyyyMM"));
		}else{
			form.setStartdate(PublicUtils.UtilStrToDate(String.valueOf(Integer.valueOf(maxDate).intValue()+1), "yyyyMM"));
		}
		String command = getCommandString(request);
		form.setCmdState(command);
		request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
		return (actionMapping.findForward("content"));
	}
	
}
