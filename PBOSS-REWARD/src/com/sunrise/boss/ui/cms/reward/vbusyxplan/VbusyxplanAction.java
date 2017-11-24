/**
* auto-generated code
* Sun Aug 01 20:25:48 CST 2010
*/
package com.sunrise.boss.ui.cms.reward.vbusyxplan;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.operation.persistent.OperationListVO;
import com.sunrise.boss.business.cms.operation.persistent.OperationVO;
import com.sunrise.boss.business.cms.reward.vbusyxplan.persistent.VbusyxplanListVO;
import com.sunrise.boss.business.cms.reward.vbusyxplan.persistent.VbusyxplanVO;
import com.sunrise.boss.business.zifee.yxplan.persistent.YxPlanListVO;
import com.sunrise.boss.business.zifee.yxplan.persistent.YxPlanVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.cms.operation.OperationDelegate;
import com.sunrise.boss.delegate.cms.reward.vbusyxplan.VbusyxplanDelegate;
import com.sunrise.boss.delegate.zifee.yxplan.YxPlanDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: VbusyxplanAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimyy
 * @version 1.0
 * 
 */
public class VbusyxplanAction extends BaseAction {
	
/*
 * 
 * 	 此类为虚表类所用,值负责查询读值逻辑,如有写值逻辑,都在BusyxplanAction ,BusyxplanControlBean中
 * 
 * 
*/	
    public VbusyxplanAction() {
            setVoClass(VbusyxplanVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[2]; 
           pkNameArray[0] = "opnid"; 
           pkNameArray[1] = "yxplanid"; 
    }

    
    /**
     * 
     * @param actionMapping
     * @param actionForm
     * @param request
     * @param response
     * @param user
     * @return
     * @throws Exception
     * 显示.不查询
     */
    public ActionForward doShow(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		VbusyxplanForm form = (VbusyxplanForm) actionForm;
		form.set_se_cityid(user.getCityid());
		return actionMapping.findForward("list");
	}

    
    
    
    /**
     * 
     * @param actionMapping
     * @param actionForm
     * @param request
     * @param response
     * @param user
     * @return
     * @throws Exception
     * 外连接联合查询+显示
     */
	public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		VbusyxplanForm form = (VbusyxplanForm) actionForm;
		Page.setPageSize(request, (BaseActionForm) form);
		String isRight = request.getParameter("RIGHT");
		ArrayList yxplanlist = null;
		ArrayList opnlist = null;

		if (form.get_se_yxplanname() != null
				&& !"".equals(form.get_se_yxplanname())) {
			YxPlanListVO yxplanListVO = new YxPlanListVO();

			yxplanListVO.set_pagesize("50");
			yxplanListVO.set_sk_yxplanname(form.get_se_yxplanname());
			YxPlanDelegate yxPlanDelegate = new YxPlanDelegate();
			List yxPlantemp = (List) yxPlanDelegate.doQuery(yxplanListVO, user)
					.getDatas();
			yxplanlist = new ArrayList();
			if (!yxPlantemp.isEmpty()) {
				for (Iterator i = yxPlantemp.iterator(); i.hasNext();) {
					YxPlanVO yxPlanVO = (YxPlanVO) i.next();
					yxplanlist.add(yxPlanVO.getYxplanid());
				}
			}
		}
		if (form.get_ne_yxplanid() != null
				&& !"".equals(form.get_ne_yxplanid())) {
			if (yxplanlist == null) {
				yxplanlist = new ArrayList();
			}
			yxplanlist.add(form.get_ne_yxplanid());
		}

		if (form.get_se_opnname() != null && !"".equals(form.get_se_opnname())) {
			OperationListVO operationListVO = new OperationListVO();

			operationListVO.set_pagesize("50");
			operationListVO.set_sk_name(form.get_se_opnname());
			OperationDelegate operationDelegate = new OperationDelegate();
			List operationtemp = (List) operationDelegate.doQuery(
					operationListVO, user).getDatas();
			opnlist = new ArrayList();
			if (!operationtemp.isEmpty()) {
				for (Iterator i = operationtemp.iterator(); i.hasNext();) {
					OperationVO operationVO = (OperationVO) i.next();
					opnlist.add(operationVO.getOpnid());
				}
			}
		}

		if (form.get_se_opnid() != null && !"".equals(form.get_se_opnid())) {
			if (opnlist == null) {
				opnlist = new ArrayList();
			}
			opnlist.add(form.get_se_opnid());
		}

		VbusyxplanListVO busyxplanListVO = new VbusyxplanListVO();
		busyxplanListVO.set_nin_yxplanid(yxplanlist);
		busyxplanListVO.set_sin_opnid(opnlist);
		setListVO(busyxplanListVO, actionForm);

		if (isRight.equals("0")) {
			if (form.get_se_cityid().equals(user.getCityid())) {
				busyxplanListVO.set_se_cityid(null);
				busyxplanListVO
						.set_sql_cityid(" (cityid is null or  cityid in ('999','100','865','','"
								+ user.getCityid() + "'))  ");
				form.set_se_cityid(user.getCityid());
			}
		}

		VbusyxplanDelegate vbusyxplanDelegate = new VbusyxplanDelegate();
		DataPackage pack = vbusyxplanDelegate.doQuery(busyxplanListVO, user);

		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, pack);
		return (actionMapping.findForward("list"));
	}

}
