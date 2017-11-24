/**
* auto-generated code
* Wed Oct 18 14:48:22 CST 2006
*/
package com.sunrise.boss.ui.cms.waylog;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.ui.base.*;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.business.cms.waylog.persistent.WaylogListVO;
import com.sunrise.boss.business.cms.waylog.persistent.WaylogVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.waylog.WaylogDelegate;

/**
 * <p>Title: WaylogAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public class WaylogAction extends BaseDelegateAction {
    public WaylogAction() {
           //以下几个方法是必须的 
           //指定VO类 
            setVoClass(WaylogVO.class);
            //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称 
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "logid"; 
    }
    
	protected void setListVO(Object listVO, final ActionForm listForm) {
		try {
			BeanUtils.copyProperties(listVO, listForm);
			String _desc=((BaseActionForm)listForm).get_desc();
			String _orderby=((BaseActionForm)listForm).get_orderby();
			if("".equals(_desc) && "".equals(_orderby) || _desc==null && _orderby==null)
			{
				((WaylogListVO)listVO).set_desc("1");
				((WaylogListVO)listVO).set_orderby("logid");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    /**
     * 合作商渠道日志查询
     */
    public ActionForward doDislist(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {   
        try {
            WaylogForm form = (WaylogForm) actionForm;
            Page.setPageSize(request, form);      

            WaylogListVO listVO = new WaylogListVO(); 
            setListVO(listVO, actionForm);
            listVO.set_se_waytype("AG");
            listVO.set_se_waysubtype("DIS");
            
            WaylogDelegate delegate = new WaylogDelegate();
            
            DataPackage dp = delegate.doQuery(listVO,user);
            request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
        }catch(BusinessException e) {
             request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
        }catch(Exception e) {
            throw e;
        } 
        return (actionMapping.findForward("dislist"));
    }
    
    /**
     * 经销商渠道日志查询
     */
    public ActionForward doStrtlist(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {   
        try {
            WaylogForm form = (WaylogForm) actionForm;
            Page.setPageSize(request, form);      

            WaylogListVO listVO = new WaylogListVO(); 
            setListVO(listVO, actionForm);
            listVO.set_se_waytype("AG");
            listVO.set_se_waysubtype("STRT");
            
            WaylogDelegate delegate = new WaylogDelegate();
            
            DataPackage dp = delegate.doQuery(listVO,user);
            request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
        }catch(BusinessException e) {
             request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
        }catch(Exception e) {
            throw e;
        } 
        return (actionMapping.findForward("strtlist"));
    }
    
    /**
     * 物流商渠道日志查询
     */
    public ActionForward doLogislist(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {   
        try {
            WaylogForm form = (WaylogForm) actionForm;
            Page.setPageSize(request, form);      

            WaylogListVO listVO = new WaylogListVO(); 
            setListVO(listVO, actionForm);
            listVO.set_se_waytype("AG");
            listVO.set_se_waysubtype("LOGS");
            
            WaylogDelegate delegate = new WaylogDelegate();
            
            DataPackage dp = delegate.doQuery(listVO,user);
            request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
        }catch(BusinessException e) {
             request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
        }catch(Exception e) {
            throw e;
        } 
        return (actionMapping.findForward("logislist"));
    }
    
    /**
     * 零售渠道日志查询
     * @param actionMapping
     * @param actionForm
     * @param request
     * @param response
     * @param user
     * @return
     * @throws Exception
     */
    public ActionForward doSalewaylist(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {   
        try {
            WaylogForm form = (WaylogForm) actionForm;
            Page.setPageSize(request, form);      

            WaylogListVO listVO = new WaylogListVO(); 
            setListVO(listVO, actionForm);
            listVO.set_sql_waystate(" waysubtype = 'PSAL' or waysubtype = 'STRB' or waysubtype = 'SAGT'");
            
            WaylogDelegate delegate = new WaylogDelegate();
            
            DataPackage dp = delegate.doQuery(listVO,user);
            request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
        }catch(BusinessException e) {
             request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
        }catch(Exception e) {
            throw e;
        } 
        return (actionMapping.findForward("salewaylist"));
    }
}
