/**
* auto-generated code
* Sat Nov 28 17:48:48 CST 2009
*/
package com.sunrise.boss.ui.cms.examine.mapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.examine.examine.persistent.ExamineVO;
import com.sunrise.boss.business.cms.examine.mapping.persistent.MappingListVO;
import com.sunrise.boss.business.cms.examine.mapping.persistent.MappingVO;
import com.sunrise.boss.business.cms.provincialright.persistent.ProvincialrightListVO;
import com.sunrise.boss.business.cms.provincialright.persistent.ProvincialrightVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.delegate.cms.examine.examine.ExamineDelegate;
import com.sunrise.boss.delegate.cms.examine.mapping.MappingDelegate;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: MappingAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class MappingAction extends BaseDelegateAction {
    public MappingAction() {
            setVoClass(MappingVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "seqid"; 
    }

	protected ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		// TODO Auto-generated method stub
		CommonDelegate comdelegate = new CommonDelegate(ProvincialrightVO.class);
        ProvincialrightListVO provincialrightList=new ProvincialrightListVO();
        provincialrightList.set_se_proopr(user.getOpercode());
        provincialrightList.set_se_rightid("CH_PROFOREXAMINE");
        MappingDelegate delegate = (MappingDelegate)getDelegate();
        MappingForm form =(MappingForm) actionForm;
        MappingListVO params=new MappingListVO();
        setListVO(params, form);
        DataPackage pack=null;
        if(comdelegate.doQuery(provincialrightList, user).getDatas().size()>0){
        	request.setAttribute("provincialright", "YES");
        	pack=delegate.doQuery(params, user);
        	
        }else{
        	pack=delegate.doQueryMappingList(params, user);
        }
        request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, pack);
        return (actionMapping.findForward("list"));
	}

	protected ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		MappingDelegate delegate = (MappingDelegate)getDelegate();
		MappingForm form =(MappingForm) actionForm;
		CommonDelegate comdelegate = new CommonDelegate(ProvincialrightVO.class);
        ProvincialrightListVO provincialrightList=new ProvincialrightListVO();
        provincialrightList.set_se_proopr(user.getOpercode());
        provincialrightList.set_se_rightid("CH_PROFOREXAMINE");
        if(comdelegate.doQuery(provincialrightList, user).getDatas().size()>0){
        	request.setAttribute("provincialright", "YES");
        	((MappingForm)actionForm).setCityid("GD");
        }else{
        	((MappingForm)actionForm).setCityid(SessionFactoryRouter.conversionCityid(user.getCityid()));
        }
       // if("0".equals(form.getMmode())){
        	MappingVO vo =new MappingVO();
        	 BeanUtils.copyProperties(vo, form);
        	if(delegate.doCheckBeingMark(vo, user)){//存在分数区间的交集
    			request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
    			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "该范围内的分数区间已存在");
    			return (actionMapping.findForward("content"));
    		}
     /*   }
        else{
        	MappingListVO listVO=new MappingListVO();
        	if(form.getSeqid()!=null && !"".equals(form.getSeqid())){
        		listVO.set_nne_seqid(String.valueOf(form.getSeqid()));
        	}
        	listVO.set_ne_exmnid(String.valueOf(form.getExmnid()));
        	if(delegate.doQuery(listVO, user).getDatas().size()>0){
        		request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
    			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "当映射方式为基数时，同考核标识下只允许存在一条映射记录");
    			return (actionMapping.findForward("content"));
        	}
        }*/
		return super.doSave(actionMapping, actionForm, request, response, user);
	}

	protected ActionForward doEdit(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		CommonDelegate comdelegate = new CommonDelegate(ProvincialrightVO.class);
        ProvincialrightListVO provincialrightList=new ProvincialrightListVO();
        provincialrightList.set_se_proopr(user.getOpercode());
        provincialrightList.set_se_rightid("CH_PROFOREXAMINE");
        if(comdelegate.doQuery(provincialrightList, user).getDatas().size()>0){
        	request.setAttribute("provincialright", "YES");
        }
        getContentVO(request, user, actionForm);
        MappingForm form =(MappingForm) actionForm;
        ExamineDelegate examineDelegate=new ExamineDelegate();
        
        ExamineVO examineVO=examineDelegate.doFindByPk(Long.valueOf(form.getExmnid()+""), user) ;
        request.setAttribute("exmncityid", examineVO.getCityid());
		String command = getCommandString(request);
		((BaseActionForm) actionForm).setCmdState(command);
		request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
		return (actionMapping.findForward("content"));
		//return super.doEdit(actionMapping, actionForm, request, response, user);
	}
	public ActionForward doCheck(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try{
			MappingDelegate delegate = (MappingDelegate)getDelegate();
			MappingForm form=(MappingForm)actionForm;
			MappingListVO param = (MappingListVO) super.getListVO();
			setListVO(param, form);
			CommonDelegate comdelegate = new CommonDelegate(ProvincialrightVO.class);
	        ProvincialrightListVO provincialrightList=new ProvincialrightListVO();
	        provincialrightList.set_se_proopr(user.getOpercode());
	        provincialrightList.set_se_rightid("CH_PROFOREXAMINE");
	        if(comdelegate.doQuery(provincialrightList, user).getDatas().size()>0){
	        	param.set_se_cityid("GD");
	        }else{
	        	param.set_se_cityid(SessionFactoryRouter.conversionCityid(user.getCityid()));
	        }
			String loseArea = delegate.doQueryToCheck(param,user);
			if(!"".equals(loseArea)){
    			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "丢失区间："+loseArea);
			}
			else request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "没有丢失区间");
		}catch(Exception e){
			e.printStackTrace();
		}		
		return this.doList(actionMapping, actionForm, request, response, user);
	}
    
}
