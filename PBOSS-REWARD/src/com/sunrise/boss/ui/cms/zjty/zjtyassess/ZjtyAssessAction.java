/**
* auto-generated code
* Thu Dec 29 14:47:31 CST 2011
*/
package com.sunrise.boss.ui.cms.zjty.zjtyassess;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.zjty.zjtyassess.persistent.ZjtyAssessVO;
import com.sunrise.boss.business.cms.zjty.zjtycompact.persistent.ZjtyCompactListVO;
import com.sunrise.boss.business.cms.zjty.zjtycompact.persistent.ZjtyCompactVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.delegate.cms.zjty.zjtycompact.ZjtyCompactDelegate;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: ZjtyAssessAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author qiuzhi
 * @version 1.0
 */
public class ZjtyAssessAction extends BaseDelegateAction {
    public ZjtyAssessAction() {
            setVoClass(ZjtyAssessVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[2]; 
           pkNameArray[0] = "calcmonth"; 
           pkNameArray[1] = "wayid"; 
    }
    
    public ActionForward doList(ActionMapping actionMapping,
    		ActionForm actionForm, HttpServletRequest request,
    		HttpServletResponse response, User user) throws Exception {
    	// TODO Auto-generated method stub
    	try{
	    	ZjtyAssessForm form = (ZjtyAssessForm)actionForm;
	    	form.set_ne_cityid(user.getCityid());
	    	request.setAttribute("cityid", form.get_ne_cityid());
	    	//request.setAttribute("cityid", SessionFactoryRouter.conversionCityid(form.get_ne_cityid()));
	    	return super.doList(actionMapping, actionForm, request, response, user);
    	}catch (Exception e) {
    		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
    		return (actionMapping.findForward("list"));
		}
    }
    
    public ActionForward doNew(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
    	// TODO Auto-generated method stub
    	ZjtyAssessForm form = (ZjtyAssessForm)actionForm;
    	form.setCoef1(1f);
    	form.setCoef2(1f);
    	form.setCoef3(1f);
    	request.setAttribute("cityid", user.getCityid());
    	return super.doNew(actionMapping, actionForm, request, response, user);
    }
    
    public ActionForward doSave(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
    	// TODO Auto-generated method stub
    	ZjtyAssessForm form = (ZjtyAssessForm)actionForm;
    	form.setCityid(new Short(user.getCityid()));
    	
    	if(null == form.getCoef1() || "".equals(form.getCoef1())){
    		form.setCoef1(1f);
    	}
    	if(null == form.getCoef2() || "".equals(form.getCoef2())){
    		form.setCoef2(1f);
    	}
    	if(null == form.getCoef3() || "".equals(form.getCoef3())){
    		form.setCoef3(1f);
    	}
    	if(null == form.getEmpnum() || "".equals(form.getEmpnum())){
	    	ZjtyCompactDelegate zjtycompactDelegate = new ZjtyCompactDelegate();
	    	ZjtyCompactListVO zjtycompactlistVO = new ZjtyCompactListVO();
	    	zjtycompactlistVO.set_se_wayid(form.getWayid());
	    	zjtycompactlistVO.set_ne_cityid(user.getCityid());
	    	DataPackage dp2 = zjtycompactDelegate.doQuery(zjtycompactlistVO, user);
	    	if(null !=dp2 && dp2.getDatas().size()>0){
	    		ZjtyCompactVO zjtycompactVO = (ZjtyCompactVO)dp2.getDatas().iterator().next();
	    		form.setEmpnum(zjtycompactVO.getFixednum());
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
