/**
* auto-generated code
* Tue Dec 26 19:35:31 CST 2006
*/
package com.sunrise.boss.ui.cms.distribute.cooperator;

import java.io.Serializable;
import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.ajaxanywhere.AAUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.distribute.cooperator.persistent.CooperatorListVO;
import com.sunrise.boss.business.cms.distribute.cooperator.persistent.CooperatorVO;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.business.common.utils.PWDHandle;
import com.sunrise.boss.common.base.db.BaseListVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.distribute.cooperator.CooperatorDelegate;
import com.sunrise.boss.delegate.cms.way.WayDelegate;

import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;



/**
 * <p>Title: CooperatorAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class CooperatorAction extends BaseDelegateAction {
    public CooperatorAction() {
        this.voClass = CooperatorVO.class;
        // TODO: ������������������
        this.pkNameArray=new String[]{null};
        pkNameArray[0] = "cooperauid";  
    }
    
     public ActionForward doSave(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
    	String newpassword="";
    	String oldpassword="";
    	String servpwd="";
        CooperatorForm cooperator=(CooperatorForm)actionForm;
        if(isEditpwd(request)){     //�����޸�
        	try{
        		newpassword=StringUtils.defaultString(request.getParameter("newpassword"));
        		oldpassword=StringUtils.defaultString(request.getParameter("oldpassword"));
        		newpassword=PWDHandle.encrypt(newpassword);      //����
        		oldpassword=PWDHandle.encrypt(oldpassword);
        		//servpwd=StringUtils.defaultString(request.getParameter("oldpassword"));
        		Object vo=getContentVO(request, user);
        		servpwd=BeanUtils.getProperty(vo, "servpwd");     //ԭʼ����
        		if(!servpwd.equals(oldpassword)){
        			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "ԭҵ�����벻��ȷ");
        			return (actionMapping.findForward("editpassword"));
        		}
        		cooperator.setServpwd(newpassword);
        		super.doSave(actionMapping,cooperator,request,response,user);
        		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "�����޸ĳɹ�");
        	}catch(Exception e){
        		e.printStackTrace();
        		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "�����޸�ʧ��");
        	}
        	return (actionMapping.findForward("editpassword"));
        }
        //������Ϣ�޸�
        cooperator.setDistrictid(user.getCityid());
        return super.doSave(actionMapping,cooperator,request,response,user);
 	}
     protected ActionForward doList(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
    	 CooperatorForm cooperator=(CooperatorForm)actionForm;
    	 cooperator.set_se_districtid(user.getCityid());
    	 return super.doList(actionMapping, cooperator, request, response, user);
 	}
   /*  public ActionForward doDelete(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
    	 CooperatorDelegate delegate = new CooperatorDelegate();
    	 String[] selectArray = ((BaseActionForm) actionForm).get_selectitem();
 			try {
 				//StringBuffer buffer=new StringBuffer();
 			   for (int i = 0; i < selectArray.length; i++) {
 				   boolean relflg=false;
 				   Object vo = null;
 				   
 				   //if(relflg){
 					 // request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, buffer.toString());
 					//   break;
 				 //  }
 				   vo=delegate.doFindByPk(selectArray[i],user);
 				   delegate.doRemove((CooperatorVO)vo,user);
 		            //if (selectArray[0].indexOf('|') == -1) { //��һ����
 		            	//vo = invokeDelegateMethod(delegate,findByPK,new Object[]{getDeletePK(selectArray[i]), user});
 		            //} else { //��������
 		            	//vo = invokeDelegateMethod(delegate,findByPK,new Object[]{getDeletePkVO(selectArray[i]), user});
 		            //}
 				   
 				  // Object ret = invokeDelegateMethod(delegate,methodName,new Object[]{vo, user});
 			   }
 			}catch(BusinessException e) {
 				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.toString());
 			}catch(Exception e) {
 				throw e;
 			}
 			
 			return doList(actionMapping, actionForm, request, response, user);
    	    
     }*/
//   ������ѡ��
 	public ActionForward doGetcountid(ActionMapping actionMapping,
 			ActionForm actionForm, HttpServletRequest request,
 			HttpServletResponse response, User user) throws Exception {
 		CooperatorForm form = (CooperatorForm) actionForm;
 		form.setCmdState(request.getParameter("cmdstates"));
 		String cmdvalue = request.getParameter("cmdvalue");
 		if ("cityid".equals(cmdvalue)) {
 			form.setCountyid("");
 			form.setSvccode("");
 			form.setMareacode("");
 		} else if ("citycompid".equals(cmdvalue)) {
 			form.setSvccode("");
 			form.setMareacode("");
 		}
 		if (AAUtils.isAjaxRequest(request)) {
 			AAUtils.addZonesToRefresh(request, "getcountyid");
 			AAUtils.addZonesToRefresh(request, "getsvccode");
 			AAUtils.addZonesToRefresh(request, "getmareacode");

 		}

 		return actionMapping.findForward("content");
 	}
 	/**
 	 * ������ѡ�ۿ�<br>
 	 * 
 	 * @param actionMapping
 	 * @param actionForm
 	 * @param request
 	 * @param response
 	 * @param user
 	 * @return
 	 * @throws Exception
 	 */ 
    public ActionForward doSelectcooperator(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
    	CooperatorForm cooperator=(CooperatorForm)actionForm;
		try {
			Page.setPageSize(request, cooperator);
			cooperator.set_se_districtid(user.getCityid());
			CooperatorListVO listVO = new CooperatorListVO();
			setListVO(listVO, actionForm); // ���ú�listVO����Ϊ��ѯ����
//			0	ͣ��
//			1	����
//			2	Ƿ��
			//listVO.set_nne_state("0"); 
			CooperatorDelegate delegate = new CooperatorDelegate();
			DataPackage dp = delegate.doQuery(listVO, user);
			// form.setPage(dp.getPageNo());
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
		}
		return (actionMapping.findForward("selectcooperator"));

 	}
	/**
	 * ��ʾָ����¼������,<br>
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */                     
	public ActionForward doEditpassword(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		getContentVO(request, user, actionForm);
		((BaseActionForm) actionForm).setCmdState(WebConstant.COMMAND_STRING_EDIT);
		request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
				WebConstant.COMMAND_STRING_EDIT);
		return (actionMapping.findForward("editpassword"));
	}
	
	
	protected void onDuplicatePk(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) {

		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
				"�����̱���Ѿ�����, ��������������");
	}
	private boolean isEditpwd(HttpServletRequest request){
		String parameName="";
		Enumeration parameNames=request.getParameterNames();
		while(parameNames.hasMoreElements()){
			parameName=(String)parameNames.nextElement();
			if(parameName.equals("againpassword") || parameName.equals("newpassword"))
			return true;
		}
		return false;
	}

}
