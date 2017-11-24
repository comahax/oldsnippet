/**
* auto-generated code
* Wed Dec 31 13:51:34 CST 2008
*/
package com.sunrise.boss.ui.cms.opntree;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.ui.base.*;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.opntree.persistent.OpnTreeListVO;
import com.sunrise.boss.business.cms.opntree.persistent.OpnTreeVO;
import com.sunrise.boss.delegate.cms.opntree.OpnTreeDelegate;

/**
 * <p>Title: OpnTreeAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class OpnTreeAction extends BaseDelegateAction {
    public OpnTreeAction() {
           //以下几个方法是必须的 
           //指定VO类 
            setVoClass(OpnTreeVO.class);
            //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称 
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "opnid"; 
    }
    
    public ActionForward doTree(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
    	try{
    		OpnTreeForm form = (OpnTreeForm)actionForm;
    		String contextPath = request.getContextPath();
    		String isLeaf = request.getParameter("isLeaf");
    		String treeType = OpnTreeType.getTreeType(request.getParameter("treeType"));
    		String rootId = request.getParameter("rootId");
    		String opnid = "0";
    		if(!StringUtils.isEmpty(rootId)){
    			opnid = rootId;
    			form.setRootid(rootId);
    		}
			String topChildrenURI = "selectOpnXml.jsp";
			String rootName = "业务类型";
			String rootAdaId = "0";
			
			String topAction = "\"javascript:selectOpn('0','','opn') \"";
			String topChildrenURL = null;
			
			StringBuffer topChildrenURLBuffer = new StringBuffer("");
			topChildrenURLBuffer.append(contextPath).append("/cms/opntree/").append(topChildrenURI)
									.append("?parentid=").append(opnid)
									.append("&parenttype=").append(treeType)
									.append("&function=selectOpn")
									.append("&childrenURL=").append(contextPath).append("/cms/opntree/").append(topChildrenURI)
									.append("&isLeaf=").append(isLeaf)
									.append("&showDisabled=").append(form.getShowdisabled()==null||form.getShowdisabled().equals("null")?"false":"true")
									.append("&times=").append((new Date()).getTime());
			request.getSession().setAttribute("_sk_name",
					form.get_sk_name() == null ? "" : form.get_sk_name());
			request.getSession().setAttribute("_ne_opnid",
					form.get_se_opnid() == null ? "" : form.get_se_opnid());
			request.getSession().setAttribute("showDisabled",
					form.getShowdisabled()==null||form.getShowdisabled().equals("null")?"false":"true");
			
			topChildrenURL = topChildrenURLBuffer.toString();
			
			request.setAttribute("rootAdaId", rootAdaId);
			request.setAttribute("parentType", treeType);
			request.setAttribute("rootName", rootName);
			request.setAttribute("topChildrenURL", topChildrenURL);
			request.setAttribute("topAction", topAction);
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
    	return actionMapping.findForward("tree");
    }
}
