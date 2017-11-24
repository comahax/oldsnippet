/**
* auto-generated code
* Wed Nov 25 11:12:10 CST 2009
*/
package com.sunrise.boss.ui.cms.examine.exmnitem;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.examine.examine.persistent.ExamineVO;
import com.sunrise.boss.business.cms.examine.exmnitem.persistent.ExmnitemListVO;
import com.sunrise.boss.business.cms.examine.exmnitem.persistent.ExmnitemVO;
import com.sunrise.boss.business.cms.provincialright.persistent.ProvincialrightListVO;
import com.sunrise.boss.business.cms.provincialright.persistent.ProvincialrightVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.examine.examine.ExamineDelegate;
import com.sunrise.boss.delegate.cms.examine.exmnitem.ExmnitemDelegate;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: ExmnitemAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ExmnitemAction extends BaseDelegateAction {
    public ExmnitemAction() {
            setVoClass(ExmnitemVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[2]; 
           pkNameArray[0] = "exmnid"; 
           pkNameArray[1] = "exmnstdid"; 
    }
    protected ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		 try {
	        	Page.setPageSize(request, (ExmnitemForm) actionForm);        	
	        	ExmnitemListVO listVO = (ExmnitemListVO)getListVO(); 
	        	setListVO(listVO, actionForm); //设置好listVO，作为查询条件
	        	//查询列表内容
	        	ExmnitemDelegate delegate = (ExmnitemDelegate)getDelegate();
		        DataPackage pack = delegate.doQueryExmnitemList(listVO, user);
		        request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, pack);
		        //查询考核信息
	        	ExamineDelegate examinedelegate = new ExamineDelegate();
	        	ExamineVO examineVO=examinedelegate.doFindByPk(Long.valueOf(listVO.get_ne_exmnid()), user);
	        	request.setAttribute("examineVO", examineVO);
	        	
	        	CommonDelegate comdelegate = new CommonDelegate(ProvincialrightVO.class);
	            ProvincialrightListVO provincialrightList=new ProvincialrightListVO();
	            provincialrightList.set_se_proopr(user.getOpercode());
	            provincialrightList.set_se_rightid("CH_PROFOREXAMINE");
	            if(comdelegate.doQuery(provincialrightList, user).getDatas().size()>0){
	            	request.setAttribute("provincialright", "YES");
	            }
	        }catch(BusinessException e) {
	        	 request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
	        }catch(Exception e) {
	        	throw e;
	        } 
	        return (actionMapping.findForward("list"));
	}
    
	protected ActionForward doEdit(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
    	CommonDelegate comdelegate = new CommonDelegate(ProvincialrightVO.class);
        ProvincialrightListVO provincialrightList=new ProvincialrightListVO();
        provincialrightList.set_se_proopr(user.getOpercode());
        provincialrightList.set_se_rightid("CH_PROFOREXAMINE");
        if(comdelegate.doQuery(provincialrightList, user).getDatas().size()>0){
        	request.setAttribute("provincialright", "YES");
        }
        getContentVO(request, user, actionForm);
        ExmnitemForm form =(ExmnitemForm) actionForm;
        ExamineDelegate examineDelegate=new ExamineDelegate();
        
        ExamineVO examineVO=examineDelegate.doFindByPk(Long.valueOf(form.get_ne_exmnid()+""), user) ;
        request.setAttribute("exmncityid", examineVO.getCityid());
		return super.doEdit(actionMapping, actionForm, request, response, user);
	}
	protected ActionForward doDelete(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		String[] selectArray = ((ExmnitemForm) actionForm).get_selectitem();
		try {
			ExmnitemDelegate delegate =(ExmnitemDelegate) getDelegate();		
			String[] pks=null;
			Serializable pkVO=null;
			String cityid=request.getParameter("cityid");
			for (int i = 0; i < selectArray.length; i++) {
			   pks=StringUtils.splitPreserveAllTokens(selectArray[i],"|");
			   pkVO=new ExmnitemVO();
			   BeanUtils.setProperty(pkVO, "exmnid",pks[0]);
			   BeanUtils.setProperty(pkVO, "exmnstdid",pks[1]);
			   delegate.doRemoveItem(pkVO,cityid, user);
		   }
			
		}catch(BusinessException e) {
        	 request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.toString());
        }catch(Exception e) {
        	throw e;
        } 
	   
	    return doList(actionMapping, actionForm, request, response, user);// TODO Auto-generated method stub
	}
}
