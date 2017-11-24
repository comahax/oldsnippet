/**
* auto-generated code
* Sat Jun 25 17:13:50 CST 2011
*/
package com.sunrise.boss.ui.cms.reward.assess;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.beans.BeanUtils;
import com.sunrise.boss.business.cms.reward.assess.persistent.AssessListVO;
import com.sunrise.boss.business.cms.reward.assess.persistent.AssessVO;
import com.sunrise.boss.business.cms.reward.assessinfo.persistent.AssessinfoListVO;
import com.sunrise.boss.business.cms.reward.assessinfo.persistent.AssessinfoVO;
import com.sunrise.boss.business.cms.reward.typeinfo.persistent.TypeinfoVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.reward.assess.AssessDelegate;
import com.sunrise.boss.delegate.cms.reward.assessinfo.AssessinfoDelegate;
import com.sunrise.boss.delegate.cms.reward.typeinfo.TypeinfoDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: AssessAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class AssessAction extends BaseAction {
    public AssessAction() {
            setVoClass(AssessVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "seq"; 
    }
    
    public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
    	try {
    		AssessDelegate assessDelegate = new AssessDelegate();
    		AssessListVO assessListVO = new AssessListVO();
    		setListVO(assessListVO, actionForm);
    		assessListVO.set_pagesize("20");
    		DataPackage dp = (DataPackage)assessDelegate.doQuery(assessListVO, user);
    		if(dp != null && dp.getDatas() != null){
    			List<AssessForm> list = new ArrayList<AssessForm>();
	    		for(AssessVO assessVO :(List<AssessVO>)dp.getDatas()){
	    			AssessForm form = new AssessForm();
					BeanUtils.copyProperties(assessVO, form);
					if(form.getAssesstype()!=null && !"".equals(form.getAssesstype().toString())){
						TypeinfoDelegate typeinfoDelegate = new TypeinfoDelegate();
						TypeinfoVO typeinfoVO = new TypeinfoVO();
						typeinfoVO.setFacetype(new Short("1"));
						typeinfoVO.setCityid(SessionFactoryRouter.conversionCityid(user.getCityid()));
						typeinfoVO.setType(form.getAssesstype().toString());
						typeinfoVO = (TypeinfoVO)typeinfoDelegate.doFindByPk(typeinfoVO, user);
						if(typeinfoVO!=null && typeinfoVO.getTypename()!=null && !"".equals(typeinfoVO.getTypename())){
							form.setAssesstypename(typeinfoVO.getTypename());
						}else{
							form.setAssesstypename(form.getAssesstype().toString());
						}
					}
					list.add(form);
	    		}
	    		dp.setDatas(list);
    		}
    		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
    	}catch (BusinessException e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
		}catch (Exception e) {
			throw e;
		}
		return actionMapping.findForward("list");
	}
    
	protected ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
    	AssessForm form = (AssessForm) actionForm;
    	String cmdState = form.getCmdState();
		if (WebConstant.COMMAND_STRING_EDIT.equals(cmdState)) {// 更新
			form.setOpercode(user.getOpercode());
			form.setOpertype("U");
			form.setOprtime(new Date());
		} else {
			form.setOpercode(user.getOpercode());
			form.setOpertype("I");
			form.setOprtime(new Date());
		}
		return super.doSave(actionMapping, form, request, response, user);
	}

	public ActionForward doImport(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		AssessinfoDelegate assessinfoDelegate=new AssessinfoDelegate();
		AssessinfoListVO assessinfoListVO=new AssessinfoListVO();
		assessinfoListVO.set_se_cityid(SessionFactoryRouter.conversionCityid(user.getCityid()));
		assessinfoListVO.set_ne_type("1");
    	DataPackage dp=assessinfoDelegate.doQuery(assessinfoListVO, user);
    	String assessinfostr="";
    	if(dp!=null && dp.getDatas().size()>0){
    		Iterator it = dp.getDatas().iterator();
			if(it.hasNext()) {
				AssessinfoVO VO=(AssessinfoVO)it.next();
				assessinfostr=VO.getAsseremark();
			}
    	}
    	// 如果登录的工号是茂名的工号668
    	if ("668".equals(user.getCityid())) {
//    		request.getSession().setAttribute("flag", "yes");
    		request.getSession().setAttribute("flag", "");
    	} else {
    		request.getSession().setAttribute("flag", "");
    	}
    	request.getSession().setAttribute("assessinfostr", assessinfostr);
		return actionMapping.findForward("batch");
	}
    
}
