/**
* auto-generated code
* Sun Nov 29 14:14:27 CST 2009
*/
package com.sunrise.boss.ui.cms.examine.exmnrslt;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.examine.exmnrslt.persistent.ExmnrsltListVO;
import com.sunrise.boss.business.cms.examine.exmnrslt.persistent.ExmnrsltVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.cms.examine.exmnrslt.ExmnrsltDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: ExmnrsltAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ExmnrsltAction extends BaseAction {
    public ExmnrsltAction() {
            setVoClass(ExmnrsltVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[3]; 
           pkNameArray[0] = "exmnid"; 
           pkNameArray[1] = "exmnperiod"; 
           pkNameArray[2] = "wayid"; 
    }
    /**
	 * 查看信息
	 */
	public ActionForward doInfolist(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		ExmnrsltListVO listVO =new  ExmnrsltListVO();
		setListVO(listVO, actionForm);
		ExmnrsltDelegate delegate=new ExmnrsltDelegate();
		DataPackage pack =delegate.doQueryExmnrsltInfo(listVO, user);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, pack);
		return (actionMapping.findForward("infolist"));
	}
	
    
}
