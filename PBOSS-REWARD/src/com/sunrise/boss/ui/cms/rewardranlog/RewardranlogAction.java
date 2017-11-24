/**
* auto-generated code
* Thu Jul 28 20:52:00 CST 2011
*/
package com.sunrise.boss.ui.cms.rewardranlog;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.rewardranlog.persistent.RewardranlogVO;
import com.sunrise.boss.business.cms.rewardreport.persistent.RewardreportListVO;
import com.sunrise.boss.business.cms.rewardsms.persistent.RewardsmsListVO;
import com.sunrise.boss.business.cms.rewardsms.persistent.RewardsmsVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.delegate.cms.rewardranlog.RewardranlogDelegate;
import com.sunrise.boss.delegate.cms.rewardreport.RewardreportDelegate;
import com.sunrise.boss.delegate.cms.rewardsms.RewardsmsDelegate;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.cms.rewardreport.RewardreportForm;
import com.sunrise.boss.ui.cms.rewardsms.RewardsmsForm;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: RewardranlogAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
public class RewardranlogAction extends BaseDelegateAction {
    public RewardranlogAction() {
            setVoClass(RewardranlogVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "seq"; 
    }
    
	public ActionForward doShow(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		request.setAttribute("cityid", SessionFactoryRouter.conversionCityid(user.getCityid()));
		return (actionMapping.findForward("list"));
	}
	
	/**
	 * 保存
	 */
	public ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		RewardranlogForm form = (RewardranlogForm) actionForm;
		RewardranlogVO contentVO = new RewardranlogVO();
		setSaveVO(contentVO, form);

		RewardranlogDelegate delegate = new RewardranlogDelegate();

		try {
			String cmdState = form.getCmdState();
			if (WebConstant.COMMAND_STRING_EDIT.equals(cmdState)) {
				RewardranlogVO existObj = delegate.doFindByPk(contentVO.getSeq(),
						user);
				if (existObj != null) {
					org.apache.commons.beanutils.BeanUtils.copyProperties(existObj,
							contentVO);
					contentVO = existObj;
				}
				// 设置操作类型为更新
				contentVO.setOpertype("U");
				// 设置操作日期为当天
				contentVO.setOpertime(new Date());
				// 设置操作工号为登录工号
				contentVO.setOpercode(user.getOpercode());
				contentVO = delegate.doUpdate(contentVO, user);
			} else {
				// 没有新增
			}
			BeanUtils.copyProperties(actionForm, contentVO);
			((BaseActionForm) actionForm)
					.setCmdState(WebConstant.COMMAND_STRING_EDIT);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存成功");
		} catch (BusinessException e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.toString());
		} catch (Exception e) {
			throw e;
		}

		return (actionMapping.findForward("content"));
	}
}
