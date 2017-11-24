/**
* auto-generated code
* Thu May 19 16:35:38 CST 2011
*/
package com.sunrise.boss.ui.cms.rewardreport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.rewardreport.persistent.RewardreportListVO;
import com.sunrise.boss.business.cms.rewardreport.persistent.RewardreportVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.delegate.cms.rewardreport.RewardreportDelegate;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: RewardreportAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
public class RewardreportAction extends BaseDelegateAction {
    public RewardreportAction() {
            setVoClass(RewardreportVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "seq"; 
    }
    
	public ActionForward doShow(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		request.setAttribute("type","0");
		request.setAttribute("cityid", SessionFactoryRouter.conversionCityid(user.getCityid()));
		return (actionMapping.findForward("list"));
	}
	
    /**
     * 查询
     */
    public ActionForward doList(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception{
    	
    	RewardreportForm param = (RewardreportForm)actionForm;
    	RewardreportDelegate delegate = new RewardreportDelegate();
    	RewardreportListVO listvo = new RewardreportListVO();
    	setListVO(listvo,param);
    	DataPackage dp = delegate.doQuery2(listvo, user);
    	
    	String type = param.getAudittype();
    	request.setAttribute("type",type);
    	request.setAttribute("cityid", SessionFactoryRouter.conversionCityid(user.getCityid()));
        request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST,dp);
    	return (actionMapping.findForward("list"));
    }
}
