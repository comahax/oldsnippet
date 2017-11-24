/**
* auto-generated code
* Fri Jan 04 15:56:32 CST 2008
*/
package com.sunrise.boss.ui.cms.resale;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.ui.base.*;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.resale.persistent.ResaleListVO;
import com.sunrise.boss.business.cms.resale.persistent.ResaleVO;
import com.sunrise.boss.business.common.sysparam.persistent.SysparamListVO;
import com.sunrise.boss.business.common.sysparam.persistent.SysparamVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.cms.resale.ResaleDelegate;
import com.sunrise.boss.delegate.common.sysparam.SysparamDelegate;

/**
 * <p>Title: ResaleAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ResaleAction extends BaseDelegateAction {
    public ResaleAction() {
           //以下几个方法是必须的 
           //指定VO类 
            setVoClass(ResaleVO.class);
            //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称 
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "mobile"; 
    }
    public ActionForward doShow(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		checkParameter(request, user);
		return actionMapping.findForward("list");
	}

	public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		checkParameter(request, user);
		return super.doList(actionMapping, actionForm, request, response, user);
	}

	protected void checkParameter(HttpServletRequest request, User user)
			throws Exception {
		SysparamDelegate delegate = new SysparamDelegate();
		SysparamListVO listVO = new SysparamListVO();
		listVO.set_ne_systemid("50");
		listVO.set_se_paramtype("channel");
		DataPackage dp = delegate.doQuery(listVO, user);
		for (Iterator it = dp.getDatas().iterator(); it.hasNext();) {
			SysparamVO vo = (SysparamVO) it.next();
			if ("0".equals(vo.getParamvalue())) {
				request.setAttribute("SHOW", "TRUE");
			}
		}
	}
}
