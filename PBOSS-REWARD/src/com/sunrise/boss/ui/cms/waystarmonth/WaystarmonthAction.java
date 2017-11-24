/**
 * auto-generated code
 * Wed Feb 24 14:10:39 CST 2010
 */
package com.sunrise.boss.ui.cms.waystarmonth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.waystarmonth.persistent.WaystarmonthListVO;
import com.sunrise.boss.business.cms.waystarmonth.persistent.WaystarmonthVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.cms.waystarmonth.WaystarmonthDelegate;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: WaystarmonthAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Canigar
 * @version 1.0
 */
public class WaystarmonthAction extends BaseDelegateAction {
	public WaystarmonthAction() {
		setVoClass(WaystarmonthVO.class);
		// TODO: 给出主键的名字数组
		this.pkNameArray = new String[2];
		pkNameArray[0] = "eftmonth";
		pkNameArray[1] = "wayid";
	}

	public ActionForward doTxt(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		// TODO Auto-generated method stub
		CommonExportBean export = new CommonExportBean(user);
		export.setFileName("关联套卡销量考核管理查询");

		export.addOutputProperty("wayid");
		export.addOutputProperty("wayid", CommonExportBean.CODE2NAME, "#WAY");
		export.addOutputProperty("eftmonth");
		export.addOutputProperty("slv", CommonExportBean.CODE2NAME,
				"$CH_STARLEVEL");
		export.addOutputProperty("busivalue");
		export.addOutputProperty("opcode");
		export.addOutputProperty("oprtime", CommonExportBean.DATE,
				"yyyy-MM-dd HH:mm:ss");

		export.voClassArray = new Class[] { WaystarmonthVO.class };
		response.setHeader("pragma", "no-cache");
		response.setHeader("Cache-control", "public");
		response.setHeader("Expires", "01 Apr 1995 01:10:10 GMT");
		String fn = "attachment; filename=" + export.getFileName() + ".txt";
		response.setHeader("Content-Disposition", new String(
				fn.getBytes("GBK"), "ISO-8859-1"));
		response.setContentType("text/plain");
		export.writeTxtTitle(response.getOutputStream(), new String[] { "渠道编码",
				"渠道名称", "月份", "星级", "销售业务量", "操作员", "操作时间" });
		super.ExportQuery(actionMapping, actionForm, request, response, user,
				export);
		return actionMapping.findForward(null);
	}

	/**
	 * 星级奖励酬金管理查询
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doStarlist(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			Page.setPageSize(request, (BaseActionForm) actionForm);
			WaystarmonthDelegate delegate = new WaystarmonthDelegate();
			WaystarmonthForm form = (WaystarmonthForm) actionForm;
			WaystarmonthListVO listvo = new WaystarmonthListVO();
			setListVO(listvo, form);
			String eftmonthtype = delegate.queryEftmonthtype(user);
			DataPackage dp = delegate.doQuery(listvo, user);
			request.setAttribute("eftmonthtype", eftmonthtype);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		} catch (Exception ex) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex
					.getMessage());
		}
		return actionMapping.findForward("starlist");
	}

	/**
	 * 星级奖励酬金管理导入
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doBatch(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			WaystarmonthDelegate delegate = new WaystarmonthDelegate();
			//eftmonthtype获取系统参数表systemid='52'和paramtype='channel'的参数值
			String eftmonthtype = delegate.queryEftmonthtype(user);
			request.setAttribute("eftmonthtype", eftmonthtype);
		} catch (Exception ex) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex
					.getMessage());
		}
		return actionMapping.findForward("starbatch");
	}
}
