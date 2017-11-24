/**
* auto-generated code
* Tue Dec 20 12:00:28 CST 2011
*/
package com.sunrise.boss.ui.cms.chadtbusitoapprove;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.chadtbusitoapprove.persistent.ChAdtBusitoapproveListVO;
import com.sunrise.boss.business.cms.chadtbusitoapprove.persistent.ChAdtBusitoapproveVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.cms.chadtbusitoapprove.ChAdtBusitoapproveDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.ui.commons.taglib.code2name.Code2NameConfiger;

/**
 * <p>Title: ChAdtBusitoapproveAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author limin
 * @version 1.0
 */
public class ChAdtBusitoapproveAction extends BaseAction {
    public ChAdtBusitoapproveAction() {
            setVoClass(ChAdtBusitoapproveVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "approveid"; 
    }

	@Override
	protected ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		
		ChAdtBusitoapproveListVO listVO = new ChAdtBusitoapproveListVO();
    	setListVO(listVO, actionForm);    
    	listVO.set_orderby("apptime");
    	listVO.set_desc("1");
    	listVO.set_se_region(user.getCityid());
    	
    	String s = (String) Code2NameConfiger.getName(
				"CITYIDNUM2NMAME", user.getCityid(), null);
        
    	request.getSession().setAttribute("chadtregion", s);
    	
		ChAdtBusitoapproveDelegate chAdtBusitoapproveDelegate = new ChAdtBusitoapproveDelegate();
		DataPackage dp = chAdtBusitoapproveDelegate.doQuery(listVO, user);
		if(((ChAdtBusitoapproveForm)actionForm).getCurrentbatchid()!=null &&((ChAdtBusitoapproveForm)actionForm).getCurrentbatchid().equals("1") ){
			List list = new ArrayList();
			if(dp != null && dp.getDatas()!=null && dp.getDatas().size()>0){
				list.add(dp.getDatas().iterator().next());	
				dp.setDatas(list);
				dp.setPageNo(1);
			}
    	}
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		
		return (actionMapping.findForward("list"));
	}
    
    
}
