/**
 * auto-generated code
 * Tue Jul 14 16:42:23 CST 2009
 */
package com.sunrise.boss.ui.cms.reward.waysnpt;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.admin.dictitem.persistent.DictitemVO;
import com.sunrise.boss.business.cms.reward.waysnpt.persistent.WaysnptListVO;
import com.sunrise.boss.business.cms.reward.waysnpt.persistent.WaysnptVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.admin.dictitem.DictitemDelegate;
import com.sunrise.boss.delegate.cms.reward.waysnpt.WaysnptDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.ui.commons.taglib.code2name.Node;

/**
 * <p>
 * Title: WaysnptAction
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author LiZhaoLiang
 * @version 1.0
 */
public class WaysnptAction extends BaseAction {
	public WaysnptAction() {
		setVoClass(WaysnptVO.class);
		// TODO: 给出主键的名字数组
		this.pkNameArray = new String[2];
		pkNameArray[0] = "calcmonth";
		pkNameArray[1] = "wayid";
	}

	private static Date getDefaultDate(int i) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, i);
		return c.getTime();
	}

	/**
	 * 预设备份月份为上一个结算月
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doShow(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
			WaysnptForm form = (WaysnptForm) actionForm;
			String waysnptpremonth = format.format(WaysnptAction
					.getDefaultDate(-1));
			form.set_se_calcmonth(waysnptpremonth);
			return doList(actionMapping, form, request, response, user);
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
			return (actionMapping.findForward("list"));
		}
	}
	
	/**
	 * 社会渠道月初备份信息导出查询
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		WaysnptForm form = (WaysnptForm) actionForm;
		Page.setPageSize(request, form);
		WaysnptListVO listvo = new WaysnptListVO();
		WaysnptDelegate delegate = new WaysnptDelegate();
		setListVO(listvo, actionForm);
		try {
			listvo.set_se_calcmonth(form.get_se_calcmonth());
			listvo.set_se_cityid(SessionFactoryRouter.conversionCityid(user.getCityid()));
			DataPackage dp = delegate.doQuery(listvo, user);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
			setRuleType(request, user, form.get_se_calcmonth());
			return (actionMapping.findForward("list"));
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
			return (actionMapping.findForward("list"));
		}
	}
	
	/**
	 * 设置历史结算月
	 * @param request
	 * @param user
	 * @param month
	 * @throws Exception
	 */
	public void setRuleType(HttpServletRequest request, User user, String month)
			throws Exception {
		LinkedList calcmonthset = null;
		calcmonthset = getRuleTypeSet(month);
		if (calcmonthset == null)
			calcmonthset = new LinkedList();
		request.setAttribute("calcmonthset", calcmonthset);
	}
	
	/**
	 * 获取历史结算月
	 * @param month
	 * @return
	 * @throws Exception
	 */
	public LinkedList getRuleTypeSet(String month) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		String calmonth = format.format(WaysnptAction.getDefaultDate(-1));
		LinkedList calcmonthset = new LinkedList();
		Node node = null;
		for (int i = 2; i < 5; i++) {
			node = new Node();
			node.setCode(calmonth);
			node.setName(calmonth);
			calmonth = format.format(WaysnptAction.getDefaultDate(-i));
			calcmonthset.add(node);
		}
		return calcmonthset;
	}

	public ActionForward doExcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		CommonExportBean export = new CommonExportBean(user);
		DictitemVO vo = new DictitemVO();
		DictitemDelegate delegate = new DictitemDelegate();
		vo.setDictid(user.getCityid());
		vo.setGroupid("region");
		if (delegate.doFindByPk(vo, user) != null) {
			vo.setDictname(vo.getDictname());
		}
		export.setFileName(vo.getDictname() + "社会渠道月初信息备份文件");
		export.addOutputProperty("wayid");
		export.addOutputProperty("wayname");
		export.addOutputProperty("countyid");
		export.addOutputProperty("countyid", CommonExportBean.CODE2NAME,
				"#CNTYCOMPANY");
		export.addOutputProperty("adtypecode", CommonExportBean.CODE2NAME,
				"$CH_ADTYPE");
		export.addOutputProperty("starttime",CommonExportBean.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("createtime",CommonExportBean.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("waystate", CommonExportBean.CODE2NAME,
				"$CH_VALIDFLAG");
		export.addOutputProperty("starlevel", CommonExportBean.CODE2NAME,
				"$CH_STARLEVEL");
		export.addOutputProperty("chainhead");
		export.addOutputProperty("chainhead", CommonExportBean.CODE2NAME,
				"#WAY");
		export.addOutputProperty("calcmonth");

		export.addOutputProperty("shortname");
		export.addOutputProperty("svbrchcode");
		export.addOutputProperty("svccode");
		export.addOutputProperty("mareacode");
		export.addOutputProperty("buztypecode",CommonExportBean.CODE2NAME,
				"$CH_BUZTYPE");
		export.addOutputProperty("address");
		export.addOutputProperty("logiscode");
		export.addOutputProperty("latitude");
		export.addOutputProperty("longtitude");
		export.addOutputProperty("adacode");
		export.addOutputProperty("waymagcode");
		export.addOutputProperty("catetype", CommonExportBean.CODE2NAME,
				"$CH_CATETYPE");
		export.addOutputProperty("formtype", CommonExportBean.CODE2NAME,
				"$CH_FORMTYPE");
		export.addOutputProperty("buzarea");
		export.addOutputProperty("mainlayer", CommonExportBean.CODE2NAME,
				"$CH_MAINLAYER");
		export.addOutputProperty("sublayer",CommonExportBean.CODE2NAME,
				"$CH_SUBLAYER");
		export.addOutputProperty("buzphoneno");
		export.addOutputProperty("cooperator");
		export.addOutputProperty("waytype", CommonExportBean.CODE2NAME,
				"#WAYTYPE");
		export.addOutputProperty("waysubtype", CommonExportBean.CODE2NAME,
				"#WAYTYPE");
		export.addOutputProperty("custtype", CommonExportBean.CODE2NAME,
				"#CUSTWAYTYPE");
		export.addOutputProperty("upperwayid");
		export.addOutputProperty("busicode");
		export.addOutputProperty("cityid");
		export.addOutputProperty("centerid");
		export.addOutputProperty("citylevel", CommonExportBean.CODE2NAME,
				"$CH_CITYLEVEL");
		export.addOutputProperty("waylevel", CommonExportBean.CODE2NAME,
				"$CH_WAYLEVEL");
		export.addOutputProperty("bchlevel", CommonExportBean.CODE2NAME,
				"$CH_BCHLEVEL");
		export.addOutputProperty("function");
		export.addOutputProperty("miscode");
		export.addOutputProperty("disabletime",CommonExportBean.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("runbyself");
		export.addOutputProperty("depotdet");
		export.addOutputProperty("isshare");
		export.addOutputProperty("alarmbizamount");
		export.addOutputProperty("prtsource", CommonExportBean.CODE2NAME,
				"$CH_PRTSOURCE");
		export.addOutputProperty("isshare");
		export.addOutputProperty("isconnected", CommonExportBean.CODE2NAME,
				"$CH_ISCONNECTED");
		export.addOutputProperty("connecttype", CommonExportBean.CODE2NAME,
				"$CH_CONNECTTYPE");
		export.addOutputProperty("runmode", CommonExportBean.CODE2NAME,
				"$CH_RUNMODE");
		export.addOutputProperty("iscoreway", CommonExportBean.CODE2NAME,
				"$CH_ISCOREWAY");
		export.addOutputProperty("pt");
		export.addOutputProperty("signstatus");
		export.addOutputProperty("empnumber");
		export.addOutputProperty("magnumber");
		export.addOutputProperty("terminumber");
		export.addOutputProperty("updatedate",CommonExportBean.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("isstraitprd");
		export.addOutputProperty("taxtype", CommonExportBean.CODE2NAME,
				"$CH_STTAXTYPE");

		export.voClassArray = new Class[] { WaysnptVO.class };
		response.setHeader("pragma", "no-cache");
		response.setHeader("Cache-control", "public");
		response.setHeader("Expires", "01 Apr 1995 01:10:10 GMT");
		String fn = "attachment; filename=" + export.getFileName() + ".txt";
		response.setHeader("Content-Disposition", new String(
				fn.getBytes("GBK"), "ISO-8859-1"));
		response.setContentType("text/plain");
		export.writeTxtTitle(response.getOutputStream(), new String[] { "渠道编码",
				"渠道名称", "分公司编码", "分公司名称", "区域类型", "合作开始时间", "创建时间", "渠道状态",
				"星级", "所属分销商编码", "所属分销商名称", "结算月份", "渠道简称", "服务厅类别",
				"服务销售中心编码", "微区域编码", "商圈类型编码", "详细地址", "二期发放月份", "所属物流商编码",
				"办公地点纬度", "办公地点经度", "行政区划编码", "渠道经理工号", "连锁性质", "业态类型", "营业面积",
				"主分层", "子分层", "业务手机号", "合作方", "渠道类别", "渠道子类别", "分公司自定义类别",
				"上级渠道", "营业点标识", "市公司编码", "区域中心标识", "城市级别", "渠道级别", "渠道等级",
				"职能描述", "渠道MIS编码", "停用时间", "自营标志", "渠道中间代码", "是否共享", "业务预警量",
				"物业来源分类", "是否联网", "联网方式", "经营模式", "是否中心渠道", "排他性", "签约状态",
				"营业人员数量", "管理人员数量", "终端数量", "信息更新时间", "是否直供", "扣税方式" });
		super.ExportQuery(actionMapping, actionForm, request, response, user,
				export);
		return actionMapping.findForward(null);
	}
}
