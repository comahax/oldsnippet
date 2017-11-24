/**
* auto-generated code
* Mon Aug 11 11:30:37 CST 2014
*/
package com.sunrise.boss.ui.cms.chbbcmarketact;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.sunrise.boss.business.admin.dictitem.persistent.DictitemListVO;
import com.sunrise.boss.business.cms.bbc.operation.persistent.BBCoperationListVO;
import com.sunrise.boss.business.cms.chbbcmarketact.persistent.ChBbcMarketactVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.delegate.admin.dictitem.DictitemDelegate;
import com.sunrise.boss.delegate.cms.bbc.operation.BBCoperationDelegate;
import com.sunrise.boss.delegate.cms.chbbcmarketact.ChBbcMarketactDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: ChBbcMarketactAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public class ChBbcMarketactAction extends BaseAction {
    public ChBbcMarketactAction() {
            setVoClass(ChBbcMarketactVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[3];
           pkNameArray[0] = "cityid";
           pkNameArray[1] = "opnid";
           pkNameArray[2] = "rewardmonth";
    }

	protected ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		ChBbcMarketactForm form = (ChBbcMarketactForm) actionForm;
		form.set_sne_opnid("0000");
		form.set_se_cityid(SessionFactoryRouter.conversionCityid(user.getCityid()));
		if (form.get_se_rewardmonth() == null || "".equals(form.get_se_rewardmonth())) {
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.MONTH, -1);
			DateFormat format = new SimpleDateFormat("yyyyMM");
			form.set_se_rewardmonth(format.format(calendar.getTime()));
		}
		return super.doList(actionMapping, form, request, response, user);
	}

	protected ActionForward doDelete(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		ChBbcMarketactForm form = (ChBbcMarketactForm) actionForm;
		String pk = form.get_selectitem()[0];
		form.set_se_rewardmonth(pk.split("\\|")[2]);
		if (!checked(form.get_se_rewardmonth(), user)) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "该月份（"
					+ form.get_se_rewardmonth() + "）设置已锁定，仅允许查询！");
			return doList(actionMapping, form, request, response, user);
		}
		
		return super.doDelete(actionMapping, form, request, response, user);
	}

	protected ActionForward doEdit(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		String pk = request.getParameter(WebConstant.REQUEST_ATTRIBUTE_PK);
		ChBbcMarketactForm form = (ChBbcMarketactForm) actionForm;
		form.set_se_rewardmonth(pk.split("\\|")[2]);
		if (!checked(form.get_se_rewardmonth(), user)) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "该月份（"
					+ form.get_se_rewardmonth() + "）设置已锁定，仅允许查询！");
			return doList(actionMapping, form, request, response, user);
		}
		
		return super.doEdit(actionMapping, actionForm, request, response, user);
	}

	protected ActionForward doNew(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		ChBbcMarketactForm form = (ChBbcMarketactForm) actionForm;
		if (!checked(form.get_se_rewardmonth(), user)) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "该月份（"
					+ form.get_se_rewardmonth() + "）设置已锁定，仅允许查询！");
			return doList(actionMapping, form, request, response, user);
		}
		form.setRewardmonth(form.get_se_rewardmonth());
		return super.doNew(actionMapping, form, request, response, user);
	}

	protected ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		ChBbcMarketactForm form = (ChBbcMarketactForm) actionForm;
		form.setCityid(SessionFactoryRouter.conversionCityid(user.getCityid()));
		form.setUpdatetime(new Date());
		return super.doSave(actionMapping, form, request, response, user);
	}

	public ActionForward doBatchnew(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		ChBbcMarketactForm form = (ChBbcMarketactForm) actionForm;
		if (!checked(form.get_se_rewardmonth(), user)) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "该月份（"
					+ form.get_se_rewardmonth() + "）设置已锁定，仅允许查询！");
			return doList(actionMapping, form, request, response, user);
		}
		form.setRewardmonth(form.get_se_rewardmonth());
		
		DictitemDelegate dicDelegate = new DictitemDelegate();
		DictitemListVO dicparams = new DictitemListVO();
		dicparams.set_se_groupid("BBC_MARKETACT");
		DataPackage dicDp = dicDelegate.doQuery(dicparams, user);
		request.setAttribute("dicDp", dicDp);
		
		BBCoperationDelegate operDelegate = new BBCoperationDelegate();
		BBCoperationListVO operParams = new BBCoperationListVO();
		operParams.set_se_busibelong("LL_V2");
		operParams.set_ne_state("1");
		operParams.set_ne_isbusi("1");
		operParams.set_pagesize("1000");
		DataPackage opnDp = operDelegate.doQuery(operParams, user);
		request.setAttribute("opnDp", opnDp);
		
		return (actionMapping.findForward("batchcontent"));
	}

	public ActionForward doBatchsave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		ChBbcMarketactDelegate delegate = new ChBbcMarketactDelegate();
		
		ChBbcMarketactForm form = (ChBbcMarketactForm) actionForm;
		String cityid = SessionFactoryRouter.conversionCityid(user.getCityid());
		String acttype = form.getActtype();
		String rewardmonth = form.getRewardmonth();
		String[] opnids = form.get_selectopnid();
		
		String pk = "";
		ChBbcMarketactVO vo = null;
		for (int i = 0; i < opnids.length; i++) {
			pk = cityid + "|" + opnids[i] + "|" + rewardmonth;
			vo = delegate.doFindByPk(getDeletePkVO(pk), user);
			if (vo == null) {
				vo = new ChBbcMarketactVO();
				vo.setOpnid(opnids[i]);
				vo.setCityid(cityid);
				vo.setRewardmonth(rewardmonth);
				vo.setActtype(acttype);
				vo.setUpdatetime(new Date());
				delegate.doCreate(vo, user);
			} else {
				vo.setActtype(acttype);
				vo.setUpdatetime(new Date());
				delegate.doUpdate(vo, user);
			}
		}
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存成功");
		return doBatchnew(actionMapping, actionForm, request, response, user);
	}

	/**
	 * 根据【系统锁定标志记录】来判断是否新增、修改、删除
	 * 【系统锁定标志记录】：根据月份，地市编码（GD），业务编码（0000）判断
	 * @param rewardmonth
	 * @param user
	 * @return
	 * @throws Exception
	 */
	private boolean checked(String rewardmonth, User user) throws Exception {
		String pk = "GD|0000|" + rewardmonth;
		ChBbcMarketactDelegate delegate = new ChBbcMarketactDelegate();
		ChBbcMarketactVO vo = delegate.doFindByPk(getDeletePkVO(pk), user);
		if (vo != null) {
			return false;
		}
		return true;
	}
}
