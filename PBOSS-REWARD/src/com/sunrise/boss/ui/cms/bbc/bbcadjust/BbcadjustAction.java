/**
 * auto-generated code
 * Wed Aug 26 15:42:00 CST 2009
 */
package com.sunrise.boss.ui.cms.bbc.bbcadjust;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.admin.dictitem.persistent.DictitemListVO;
import com.sunrise.boss.business.cms.bbc.bbcadjust.persistent.BbcadjustVO;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.admin.dictitem.DictitemDelegate;
import com.sunrise.boss.delegate.cms.bbc.bbcadjust.BbcadjustDelegate;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: BbcadjustAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class BbcadjustAction extends BaseDelegateAction {
	public BbcadjustAction() {
		setVoClass(BbcadjustVO.class);
		// TODO: 给出主键的名字数组
		this.pkNameArray = new String[1];
		pkNameArray[0] = "seq";
	}

	public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		BbcadjustForm form = (BbcadjustForm) actionForm;
		String adjusttype = form.get_se_adjustkind();
		if (adjusttype == null || "".equals(adjusttype)) {
			form.setDictid("");
		} else if ("PUNISH".equals(adjusttype)) {
			form.setDictid("P-");
		} else if ("RETURN".equals(adjusttype)) {
			form.setDictid("R-");
			form.setDictid2("EFTCURMONTH");
		}
		if (form.get_sk_reasontype() != null
				&& !"".equals(form.get_sk_reasontype())) {
			form.set_sk_reasontype(form.get_sk_reasontype() + ",");
		}
		form.set_sql_ossrc("(ossrc <> 3 or ossrc is null)");
		super.doList(actionMapping, actionForm, request, response, user);
		if (form.get_sk_reasontype() != null
				&& !"".equals(form.get_sk_reasontype())) {
			form.set_sk_reasontype(form.get_sk_reasontype().substring(0,
					form.get_sk_reasontype().length() - 1));
		}
		return actionMapping.findForward("list");
	}

	public ActionForward doUnpblist(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		BbcadjustForm form = (BbcadjustForm) actionForm;
		String adjusttype = form.get_se_adjustkind();
		if (adjusttype == null || "".equals(adjusttype)) {
			form.setDictid("");
		} else if ("PUNISH".equals(adjusttype)
				|| "EMPPUNISH".equals(adjusttype)) {
			form.setDictid("P-");
		} else if ("RETURN".equals(adjusttype)
				|| "EMPRETURN".equals(adjusttype)) {
			form.setDictid("R-");
			form.setDictid2("EFTCURMONTH");
		}
		if (form.get_sk_reasontype() != null
				&& !"".equals(form.get_sk_reasontype())) {
			form.set_sk_reasontype(form.get_sk_reasontype() + ",");
		}
		form.set_ne_ossrc("3");
		super.doList(actionMapping, actionForm, request, response, user);
		if (form.get_sk_reasontype() != null
				&& !"".equals(form.get_sk_reasontype())) {
			form.set_sk_reasontype(form.get_sk_reasontype().substring(0,
					form.get_sk_reasontype().length() - 1));
		}
		return actionMapping.findForward("unpblist");
	}

	public ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		BbcadjustForm form = (BbcadjustForm) actionForm;
		String[] sel = form.get_selecttype();
		String[] sel2 = sel;

		String adjusttype = form.getAdjustkind();
		if (adjusttype == null || "".equals(adjusttype)) {
			form.setDictid2("");
			form.setDictid("");
		} else if ("PUNISH".equals(adjusttype)) {
			form.setDictid("P-");
		} else if ("RETURN".equals(adjusttype)) {
			form.setDictid("R-");
			form.setDictid2("EFTCURMONTH");
		}
		DictitemListVO ditlistvo = new DictitemListVO();
		DictitemDelegate dd = new DictitemDelegate();
		ditlistvo.set_pagesize("0");
		ditlistvo.set_sk_dictid(form.getDictid());
		ditlistvo.set_se_groupid("CH_RWADJUSTREASON");
		DataPackage ddp = dd.doQuery(ditlistvo, user);

		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, ddp);
		request.setAttribute("SEL", sel2);

		if (sel == null || sel.length == 0) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
					"要选择一个调整原因类型！");
			return actionMapping.findForward("content");
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < sel.length; i++) {
			sb.append(sel[i]).append(",");
		}
		form.setReasontype(sb.toString());
		WayDelegate waydelegate = new WayDelegate();
		WayVO wayvo = waydelegate.doFindByPk(form.getWayid(), user);
		if (wayvo == null) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "网点代码不存在");
			return actionMapping.findForward("content");
		}
		if (form.getCreateoprcode() != null
				&& "REWARD-SYSTEM".equals(form.getCreateoprcode())) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
					"该记录为系统创建记录，不允许修改!");
			return actionMapping.findForward("content");
		}
		form.setUpdatetime(new Date());
		form.setUpdateoprcode(user.getOpercode());

		super.doSave(actionMapping, form, request, response, user);

		return actionMapping.findForward("content");
	}

	public ActionForward doUnpbdelete(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		// TODO Auto-generated method stub
		try {
			String[] selectArray = ((BaseActionForm) actionForm)
					.get_selectitem();
			BbcadjustDelegate delegate = new BbcadjustDelegate();
			BbcadjustVO vo = new BbcadjustVO();
			if (selectArray != null) {
				for (int i = 0; i < selectArray.length; i++) {
					vo = delegate.doFindByPk(new Long(selectArray[i]), user);
					delegate.doRemove(vo, user);
				}
			}
		} catch (Exception ex) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex
					.getMessage());
		}
		return doUnpblist(actionMapping, actionForm, request, response, user);
	}
}
