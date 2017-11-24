/**
* auto-generated code
* Thu Jul 26 17:37:14 CST 2007
*/
package com.sunrise.boss.ui.cms.fdauditdef;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.fdauditdef.persistent.FdauditdefListVO;
import com.sunrise.boss.business.cms.fdauditdef.persistent.FdauditdefVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.fdauditdef.FdauditdefDelegate;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: FdauditdefAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class FdauditdefAction extends BaseDelegateAction {
    public FdauditdefAction() {
           //以下几个方法是必须的 
           //指定VO类 
            setVoClass(FdauditdefVO.class);
            //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称 
           this.pkNameArray = new String[3]; 
           pkNameArray[0] = "field"; 
           pkNameArray[1] = "tablename"; 
           pkNameArray[2] = "typename";
    }
	
    public ActionForward doList(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
//	    Page.setPageSize(request, (BaseActionForm) actionForm);                     
        try {
        	Page.setPageSize(request, (BaseActionForm) actionForm);        	
        	FdauditdefListVO listVO = new FdauditdefListVO();        	
        	setListVO(listVO, actionForm); //设置好listVO，作为查询条件
        	if(listVO.get_ne_state() == null)
        	listVO.set_ne_state(new Short((short) 0));
        	Object delegate = getDelegate();
            
            String methodName = "doQuery";
            DataPackage pack = (DataPackage)invokeDelegateMethod(delegate,methodName,new Object[]{listVO, user});
            request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, pack);
        }catch(BusinessException e) {
        	 request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
        }catch(Exception e) {
        	throw e;
        } 
        return (actionMapping.findForward("list"));
	}
    
    
    /**
	 * 启用
	 */
	public ActionForward doStart(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		String[] selectArray = ((BaseActionForm) actionForm).get_selectitem();
		try {
			   FdauditdefDelegate fdauditdefDelegate = new FdauditdefDelegate();
			   
			   for (int i = 0; i < selectArray.length; i++) {
				   FdauditdefVO vo = new FdauditdefVO();
				   FdauditdefVO fdauditdefVO = new FdauditdefVO();
				   String[] pkValueArray = selectArray[i].split("\\|");
				   vo.setField(pkValueArray[0]);
				   vo.setTablename(pkValueArray[1]);
				   vo.setTypename(pkValueArray[2]);
				   fdauditdefVO =(FdauditdefVO)fdauditdefDelegate.doFindByPk(vo, user);
				   fdauditdefVO.setState(new Short((short) 1)); 
		           fdauditdefDelegate.doUpdate(fdauditdefVO, user);
		            
			   }
			   
		}catch(BusinessException e) {
        	 request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.toString());
        }catch(Exception e) {
        	e.printStackTrace();
        	throw e;
        } 
	   
	    return doList(actionMapping, actionForm, request, response, user);
	}
	/**
	 * 不启用
	 */
	public ActionForward doStartno(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		String[] selectArray = ((BaseActionForm) actionForm).get_selectitem();
		try {
			 FdauditdefDelegate fdauditdefDelegate = new FdauditdefDelegate();
			   for (int i = 0; i < selectArray.length; i++) {
				   FdauditdefVO vo = new FdauditdefVO();
				   FdauditdefVO fdauditdefVO = new FdauditdefVO();
				   String[] pkValueArray = selectArray[i].split("\\|");
				   vo.setField(pkValueArray[0]);
				   vo.setTablename(pkValueArray[1]);
				   vo.setTypename(pkValueArray[2]);
				   fdauditdefVO =(FdauditdefVO)fdauditdefDelegate.doFindByPk(vo, user);
				   fdauditdefVO.setState(new Short((short) 0));
		           fdauditdefDelegate.doUpdate(fdauditdefVO, user);   
			   }
		}catch(BusinessException e) {
        	 request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.toString());
        }catch(Exception e) {
        	throw e;
        } 
	   
	    return doList(actionMapping, actionForm, request, response, user);
	}
	
    
    public void onDuplicatePk(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) {
    	
    	request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "相同表名已经存在, 请输入其他表名");
    }
    
    public ActionForward doSelectfdauditdeftree(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			String contextPath = request.getContextPath();
			String audittype=request.getParameter("audittype");
			String topChildrenURI = "selectTreeXml.jsp";
			StringBuffer topChildrenURLBuffer=new StringBuffer();
			
				if (!"&".equals(topChildrenURLBuffer.toString()))
					topChildrenURLBuffer.append(contextPath)
							.append("/cms/fdauditdef/").append(topChildrenURI).append(
									"?parentid=").append("root").append(
									"&parenttype=").append("audit").append(
									"&function=selectTree&childrenURL=").append(
									contextPath).append("/cms/fdauditdef/").append(
									"selectTreeXml.jsp").append("&queryText=root").append("&time=").append(new Date().getTime());


				// if(StringUtils.isNotBlank(queryText))
				// topChildrenURLBuffer.append("&queryText=").append(queryText);
				String topAction="\"\"";
				String rootName = "字段审批定义";
				String topChildrenURL = topChildrenURLBuffer
						.toString();


			request.setAttribute("rootWayId", "0");

			request.setAttribute("rootName", rootName);
			request.setAttribute("parentType", "audit");
			request.setAttribute("topChildrenURL", topChildrenURL);
			//request.setAttribute("queryText", queryText);
			request.setAttribute("topAction", topAction);

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
			request.setAttribute("rootName", "非法数据");
		}
		return actionMapping.findForward("selectTree");
	}
}

