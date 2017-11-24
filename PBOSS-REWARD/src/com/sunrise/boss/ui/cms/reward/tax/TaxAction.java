/**
* auto-generated code
* Fri May 27 12:04:23 CST 2011
*/
package com.sunrise.boss.ui.cms.reward.tax;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.reward.tax.persistent.TaxListVO;
import com.sunrise.boss.business.cms.reward.tax.persistent.TaxVO;
import com.sunrise.boss.business.common.sysparam.persistent.SysparamVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.delegate.cms.reward.tax.TaxDelegate;
import com.sunrise.boss.delegate.common.sysparam.SysparamDelegate;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: TaxAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
public class TaxAction extends BaseDelegateAction {
    public TaxAction() {
            setVoClass(TaxVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "seq"; 
    }
    
    public ActionForward doList(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
    	String cityid = SessionFactoryRouter.conversionCityid(user.getCityid());
    	request.setAttribute("cityid", cityid);
    	// 取得系统参数数据
    	SysparamDelegate delegate = new SysparamDelegate();
    	SysparamVO sysvo = new SysparamVO();
    	sysvo.setSystemid(new Long(90));
    	sysvo.setParamtype("taxrule");
    	SysparamVO newvo = delegate.doFindByPk(sysvo, user);
    	((TaxForm)actionForm).set_ne_taxtype(newvo.getParamvalue());
    	// 设置地市条件
    	((TaxForm)actionForm).set_ne_cityid(user.getCityid());
    	
    	return super.doList(actionMapping, actionForm, request, response, user);
    }
    
	/**
	 * 编辑
	 */
	protected ActionForward doEdit(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		String cityid = SessionFactoryRouter.conversionCityid(user.getCityid());
    	request.setAttribute("cityid", cityid);
    	
    	// 取得数据
    	TaxDelegate delegate = new TaxDelegate();
    	String pk = request.getParameter(WebConstant.REQUEST_ATTRIBUTE_PK);
		if (pk == null)
			throw new NullPointerException("pk is required.");
		TaxVO contentVO = delegate.doFindByPk2(new Long(pk), user);
    	BeanUtils.copyProperties(actionForm, contentVO);
    	((TaxForm) actionForm).setValue2(contentVO.getValue().intValue());
    	
    	String command = getCommandString(request);
		((BaseActionForm) actionForm).setCmdState(command);
		request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
		return (actionMapping.findForward("content"));
	}
	
	/**
	 * 新建
	 */
	protected ActionForward doNew(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		String cityid = SessionFactoryRouter.conversionCityid(user.getCityid());
    	request.setAttribute("cityid", cityid);
		
		return super.doNew(actionMapping, actionForm, request, response, user);
	}
	
	/**
	 * 保存
	 */
	protected ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		TaxForm form = (TaxForm)actionForm;
		if (form.getCityid() == null || "".equals(form.getCityid())) {
			form.setCityid(Short.valueOf(user.getCityid()));
		}
		if (form.getValue2() != null) {
			form.setValue(form.getValue2().floatValue());
		}
		
		String cityid = SessionFactoryRouter.conversionCityid(user.getCityid());
    	request.setAttribute("cityid", cityid);
		// 每个地市同个分公司,每一个税率结算方式，只能有一个税率值
		TaxDelegate delegate = new TaxDelegate();
		TaxListVO listvo = new TaxListVO();
		listvo.set_se_parameter(form.getParameter());
		listvo.set_ne_taxtype(form.getTaxtype().toString());
		listvo.set_ne_cityid(user.getCityid());
		DataPackage dp = delegate.doQuery(listvo, user);
		if (dp != null && dp.getDatas().size() > 0) {
			request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
       		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "每个地市同个分公司,每一个税率结算方式，只能有一个税率值。"); 
       		return (actionMapping.findForward("content"));
		}
		
		return super.doSave(actionMapping, actionForm, request, response, user);
	}
}
