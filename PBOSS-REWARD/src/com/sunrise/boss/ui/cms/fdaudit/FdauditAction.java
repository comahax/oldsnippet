/**
* auto-generated code
* Thu Jul 26 16:12:39 CST 2007
*/
package com.sunrise.boss.ui.cms.fdaudit;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.ui.base.*;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.business.cms.fdaudit.persistent.FdauditDAO;
import com.sunrise.boss.business.cms.fdaudit.persistent.FdauditListVO;
import com.sunrise.boss.business.cms.fdaudit.persistent.FdauditVO;
import com.sunrise.boss.business.cms.fdauditdef.persistent.FdauditdefListVO;
import com.sunrise.boss.business.cms.fdauditdef.persistent.FdauditdefVO;
import com.sunrise.boss.common.base.db.BaseListVO;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.fdaudit.FdauditDelegate;
import com.sunrise.boss.delegate.cms.fdauditdef.FdauditdefDelegate;

/**
 * <p>Title: FdauditAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author yuanweihai
 * @version 1.0
 */
public class FdauditAction extends BaseDelegateAction {
    public FdauditAction() {
           //以下几个方法是必须的 
           //指定VO类 
            setVoClass(FdauditVO.class);
            //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称 
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "recno"; 
    }

    public ActionForward doAudit(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		FdauditForm auditform=(FdauditForm) actionForm;
		
		String[] selectArray = auditform.get_selectitem();
		String auditopr=request.getParameter("auditopr");
		try {
			FdauditDelegate delegate=new FdauditDelegate();
			   for (int i = 0; i < selectArray.length; i++) {
				   FdauditVO vo = delegate.doFindByPk(new Long(selectArray[i]),user);
				   if(auditopr!=null && !auditopr.equals(""))
					   vo.setAuditstatus(new Short(auditopr));
				   vo.setAuditoperid(user.getOpercode());
				   vo.setAudittime(new Date());
				   if(vo.getAuditstatus().intValue()==-1){
					   delegate.doUpdate(vo,user);
				   }else{
				   FdauditdefListVO fdauditdeflist=new FdauditdefListVO();
				   fdauditdeflist.set_se_tablename(vo.getTablename());
				   fdauditdeflist.set_se_typename(vo.getTypename());
				   FdauditdefVO fdauditdefvo=doFindPKField(fdauditdeflist,user);
				   delegate.fieldBackfill(vo,fdauditdefvo,user);
				   }
				   //if(fdauditdefvo!=null){
					//   try{
					//	   delegate.fieldBackfill(fieldBackfillSQL(vo,fdauditdefvo),user);
					//   }catch(Exception e) {
					//	   request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "回填失败，后台SQL "
					//			   +fieldBackfillSQL(vo,fdauditdefvo));
					//	   System.out.println("回填失败，后台SQL:"
					//			   +fieldBackfillSQL(vo,fdauditdefvo)
					//			   +"错误信息:"
					//			   +e.getMessage());
					//	   e.printStackTrace();
					//	   return doList(actionMapping, actionForm, request, response, user);
					 //  }
				 //  }   
				   
			   }
        	 
        }catch(Exception e) {
        	request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
        } 
	   
	    return doList(actionMapping, actionForm, request, response, user);
	}
    /**
	 * 查询
	 */
	protected ActionForward doList(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {   
        try {
        	FdauditForm auditform=(FdauditForm) actionForm;
        	Page.setPageSize(request, auditform);
        	
        	String type=request.getParameter("TYPE");
        	String pk=request.getParameter("PK");
        	String pk2=request.getParameter("PK2");
        	//String fromURL=request.getParameter("fromURL");
        	
        	FdauditListVO listVO = new FdauditListVO();
        	setListVO(listVO, auditform);
        	if(type!=null && !type.equals("")){
        		auditform.set_se_typename(type);
        	}
        	if(pk!=null && !pk.equals("")){
        		auditform.set_se_pkvalue(pk);
        	}
        	if(pk2!=null && !pk2.equals("")){
        		auditform.set_se_pkvalue2(pk2);
        	}
        	listVO.set_se_typename(auditform.get_se_typename());
        	listVO.set_se_pkvalue2(auditform.get_se_pkvalue2());
        	listVO.set_se_pkvalue(auditform.get_se_pkvalue());
        	listVO.set_ne_auditstatus(auditform.get_ne_auditstatus());
        	
        	String purview=auditform.get_se_typename()+"_AUDIT";
        	FdauditDelegate delegate = new FdauditDelegate();
            DataPackage pack = delegate.doQuery(listVO,user);
            request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, pack);
            auditform.set_pageno(pack.getPageNo() + "");
            auditform.set_pagesize(pack.getPageSize() + "");
    		
            if(delegate.businessPurview(purview,user)){
            	request.setAttribute("businessPurview", "true");
            }else{
            	request.setAttribute("businessPurview", "false");
            }
        }catch(BusinessException e) {
        	 request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
        }catch(Exception e) {
        	throw e;
        } 
        return (actionMapping.findForward("list"));
	}
	/**
	 * 查找主键
	 * @param params
	 * @param user
	 * @return
	 * @throws Exception
	 */
    private FdauditdefVO doFindPKField(FdauditdefListVO params, User user )
    throws Exception {
    	FdauditdefDelegate fdauditdef=new FdauditdefDelegate();
 	   	DataPackage pack=fdauditdef.doQuery(params,user);
 	   	if(pack==null || pack.getDatas().isEmpty())
 	   		return null;
 	   	List list=(List)pack.getDatas();
 	   	return (FdauditdefVO)list.get(0);
    }
    
    
}
