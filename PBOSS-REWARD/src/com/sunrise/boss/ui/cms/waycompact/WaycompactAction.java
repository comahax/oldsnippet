/**
* auto-generated code
* Fri Aug 25 11:29:29 CST 2006
*/
package com.sunrise.boss.ui.cms.waycompact;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.ui.base.*;

import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.business.cms.waycompact.persistent.WaycompactListVO;
import com.sunrise.boss.business.cms.waycompact.persistent.WaycompactVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.cms.waycompact.WaycompactDelegate;

/**
 * <p>Title: WaycompactAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author yjr
 * @version 1.0
 */
public class WaycompactAction extends BaseDelegateAction {
    public WaycompactAction() {
           //以下几个方法是必须的 
           //指定VO类 
            setVoClass(WaycompactVO.class);
            //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称 
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "wayid"; 
    }
    
	public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		
		Page.setPageSize(request, (WaycompactForm) actionForm);
		WaycompactListVO listVO = new WaycompactListVO();
		//((WaycompactForm)actionForm).set_se_wayid("GZWAY");   //测试值，假设为广州渠道
		//((WaycompactForm)actionForm).setWayid("GZWAY");   //测试值，假设为广州渠道
		
		setListVO(listVO, actionForm); // 设置好listVO，作Ordinary为查询条件

		WaycompactDelegate delegate = new WaycompactDelegate();
		DataPackage dp = delegate.doQuery(listVO, user);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		return (actionMapping.findForward("list"));
	}
}
