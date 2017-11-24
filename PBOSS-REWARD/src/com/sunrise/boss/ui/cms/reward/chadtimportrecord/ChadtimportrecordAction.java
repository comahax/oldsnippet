/**
* auto-generated code
* Fri Jun 24 11:00:35 CST 2011
*/
package com.sunrise.boss.ui.cms.reward.chadtimportrecord;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.beans.BeanUtils;

import com.sunrise.boss.business.cms.operation.persistent.OperationVO;
import com.sunrise.boss.business.cms.reward.assessinfo.persistent.AssessinfoListVO;
import com.sunrise.boss.business.cms.reward.assessinfo.persistent.AssessinfoVO;
import com.sunrise.boss.business.cms.reward.chadtimportrecord.persistent.ChadtimportrecordListVO;
import com.sunrise.boss.business.cms.reward.chadtimportrecord.persistent.ChadtimportrecordVO;
import com.sunrise.boss.business.cms.reward.typeinfo.persistent.TypeinfoVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.operation.OperationDelegate;
import com.sunrise.boss.delegate.cms.reward.assessinfo.AssessinfoDelegate;
import com.sunrise.boss.delegate.cms.reward.chadtimportrecord.ChadtimportrecordDelegate;
import com.sunrise.boss.delegate.cms.reward.typeinfo.TypeinfoDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: ChAdtImportrecordAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class ChadtimportrecordAction extends BaseDelegateAction {
    public ChadtimportrecordAction() {
            setVoClass(ChadtimportrecordVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "seq"; 
    }
    
    public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
    	Page.setPageSize(request, (BaseActionForm) actionForm);
    	try {
    		ChadtimportrecordForm form = (ChadtimportrecordForm)actionForm;
	    	ChadtimportrecordDelegate chadtimportrecordDelegate = new ChadtimportrecordDelegate();
	    	ChadtimportrecordListVO chadtimportrecordListVO = new ChadtimportrecordListVO();
	    	setListVO(chadtimportrecordListVO, form);
	    	if(chadtimportrecordListVO.get_ne_importtype()!=null && !"".equals(chadtimportrecordListVO.get_ne_importtype())){
	    		chadtimportrecordListVO.set_sql_importtype(" (IMPORTTYPE = '" + chadtimportrecordListVO.get_ne_importtype() +"' OR OPNID = '"+ chadtimportrecordListVO.get_ne_importtype() + "')");
	    	}
	    	chadtimportrecordListVO.set_ne_importtype(null);
	    	DataPackage dp = (DataPackage)chadtimportrecordDelegate.doQuery(chadtimportrecordListVO, user);
	    	if(dp != null && dp.getDatas() != null){
	    		List<ChadtimportrecordForm> list = new ArrayList<ChadtimportrecordForm>();
	    		for(ChadtimportrecordVO chadtimportrecordVO :(List<ChadtimportrecordVO>)dp.getDatas()){
	    			ChadtimportrecordForm form1 = new ChadtimportrecordForm();
					BeanUtils.copyProperties(chadtimportrecordVO, form1);
					if(form1.getImporttype()!=null && !"".equals(form1.getImporttype().toString())){
						TypeinfoDelegate typeinfoDelegate = new TypeinfoDelegate();
						TypeinfoVO typeinfoVO = new TypeinfoVO();
						typeinfoVO.setFacetype(new Short("2"));
						typeinfoVO.setCityid(SessionFactoryRouter.conversionCityid(user.getCityid()));
						typeinfoVO.setType(form1.getImporttype().toString());
						typeinfoVO = (TypeinfoVO)typeinfoDelegate.doFindByPk(typeinfoVO, user);
						if(typeinfoVO!=null && typeinfoVO.getTypename()!=null && !"".equals(typeinfoVO.getTypename())){
							form1.setTypename(typeinfoVO.getTypename());
						}else{
							form1.setTypename(form1.getImporttype().toString());
						}
					}
					if(form1.getOpnid()!=null && !"".equals(form1.getOpnid())){
						TypeinfoDelegate typeinfoDelegate = new TypeinfoDelegate();
						TypeinfoVO typeinfoVO = new TypeinfoVO();
						typeinfoVO.setFacetype(new Short("2"));
						typeinfoVO.setCityid(SessionFactoryRouter.conversionCityid(user.getCityid()));
						typeinfoVO.setType(form1.getOpnid());
						typeinfoVO = (TypeinfoVO)typeinfoDelegate.doFindByPk(typeinfoVO, user);
						if(typeinfoVO!=null){
							form1.setOpnname(typeinfoVO.getTypename());
						}else{
							OperationDelegate operationDelegate = new OperationDelegate();
							OperationVO operationVO = new OperationVO();
							operationVO = operationDelegate.doFindByPk(form1.getOpnid(), user);
							if(operationVO!=null){
								form1.setOpnname(operationVO.getName());
							}else{
								form1.setOpnname(form1.getOpnid());
							}
						}
					}
					list.add(form1);
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
    
    public ActionForward doImport(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
    	AssessinfoDelegate assessinfoDelegate=new AssessinfoDelegate();
		AssessinfoListVO assessinfoListVO=new AssessinfoListVO();
		assessinfoListVO.set_se_cityid(SessionFactoryRouter.conversionCityid(user.getCityid()));
		assessinfoListVO.set_ne_type("2");
    	DataPackage dp=assessinfoDelegate.doQuery(assessinfoListVO, user);
    	String assessinfostr="";
    	if(dp!=null && dp.getDatas().size()>0){
    		Iterator it = dp.getDatas().iterator();
			if(it.hasNext()) {
				AssessinfoVO VO=(AssessinfoVO)it.next();
				assessinfostr=VO.getAsseremark();
			}
    	}
    	request.getSession().setAttribute("assessinfostr", assessinfostr);
		return actionMapping.findForward("batch");
	}
    
    public ActionForward doExport(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		
		return actionMapping.findForward("exportbatch");
	}
    
}
