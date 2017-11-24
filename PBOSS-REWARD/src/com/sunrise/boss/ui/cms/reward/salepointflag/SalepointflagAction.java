/**
* auto-generated code
* Thu Feb 16 10:30:46 CST 2012
*/
package com.sunrise.boss.ui.cms.reward.salepointflag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.reward.salepointflag.persistent.SalepointflagListVO;
import com.sunrise.boss.business.cms.reward.salepointflag.persistent.SalepointflagVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.cms.reward.salepointflag.SalepointflagDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: SalepointflagAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class SalepointflagAction extends BaseAction {
    public SalepointflagAction() {
            setVoClass(SalepointflagVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[2]; 
           pkNameArray[0] = "cityid"; 
           pkNameArray[1] = "flag"; 
    }
    public ActionForward doList(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception{		
    	SalepointflagForm salepointflagForm =(SalepointflagForm)actionForm;
    	SalepointflagListVO listVO=new SalepointflagListVO();
    	setListVO(listVO, salepointflagForm); // 设置好listVO，作为查询条件
    	listVO.set_se_cityid("GD");
    	SalepointflagDelegate delegate=new SalepointflagDelegate();
    	DataPackage dp=delegate.doQuery(listVO, user);
    	request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		return (actionMapping.findForward("list"));
    	
    }
}
