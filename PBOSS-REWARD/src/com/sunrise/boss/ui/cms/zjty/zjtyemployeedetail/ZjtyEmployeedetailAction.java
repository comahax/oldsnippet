package com.sunrise.boss.ui.cms.zjty.zjtyemployeedetail;

/**
 * auto-generated code
 * Tue Feb 13 13:34:19 CST 2009
 */

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.admin.dictitem.persistent.DictitemVO;
import com.sunrise.boss.business.cms.employee.persistent.EmployeeVO;
import com.sunrise.boss.business.cms.empmodel.persistent.EmpmodelListVO;
import com.sunrise.boss.business.cms.zjty.zjtyemployeedetail.persistent.ZjtyEmployeedetailVO;
import com.sunrise.boss.delegate.admin.dictitem.DictitemDelegate;
import com.sunrise.boss.delegate.cms.employee.EmployeeDelegate;
import com.sunrise.boss.delegate.cms.empmodel.EmpmodelDelegate;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.cms.employee.EmployeeForm;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.common.utils.export.CommonExportBean;

/**
 * <p>
 * Title: ZjtyEmployeedetailAction
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author
 * @version 1.0
 */
public class ZjtyEmployeedetailAction extends BaseDelegateAction {

	public ZjtyEmployeedetailAction() {
		// 以下几个方法是必须的
		// 指定VO类
		setVoClass(ZjtyEmployeedetailVO.class);
		// 指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
		this.pkNameArray = new String[1];
		pkNameArray[0] = "employeeid";
	}

	/**
	 * 自建他营厅人员配置明细导出Excel
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doExcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy年MM月");
		DictitemVO vo = new DictitemVO();
		DictitemDelegate delegate = new DictitemDelegate();
		vo.setDictid(user.getCityid());
		vo.setGroupid("region");
		if (delegate.doFindByPk(vo, user) != null) {
			vo.setDictname(vo.getDictname());
		}

		export.setFileName(format2.format(new Date()) + "" + vo.getDictname()
				+ "市公司自建他营厅人员配置明细");
		export.addOutputProperty("chainhead", "<b>所属合作商</b>",
				CommonExportBean.CODE2NAME, "#WAY");
		export.addOutputProperty("cityid", "<b>市公司</b>",
				CommonExportBean.CODE2NAME, "#CITYCOMPANY");

		export.addOutputProperty("wayid", "<b>渠道编码</b>");
		export.addOutputProperty("wayname", "<b>渠道名称</b>");
		export.addOutputProperty("employeename", "<b>姓名</b>");

		export.addOutputProperty("station", "<b>职位</b>",
				CommonExportBean.CODE2NAME, "#CH_POSTINFO");
		export.addOutputProperty("oprcode", "<b>BOSS工号</b>");
		export.addOutputProperty("start_using_time", "<b>工号开通时间</b>");

		export.appendEndLine(new String[] { "导出工号:", user.getOpercode(),
				"导出时间", format.format(new Date()), "导出渠道:", user.getWayid() });

		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super
				.doExcel(actionMapping, actionForm, request, response, user);
	}

	/**
	 * 查看社会渠道人员明细
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doEdit(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		ZjtyEmployeedetailForm emform = (ZjtyEmployeedetailForm) actionForm;

		EmployeeDelegate delegate = new EmployeeDelegate();
		EmployeeVO vo = delegate.doFindByPk(request.getParameter("PK"), user);

		BeanUtils.copyProperties(emform, vo);
		EmpmodelDelegate empDelegate = new EmpmodelDelegate();
		EmpmodelListVO empListvo = new EmpmodelListVO();
		empListvo.set_se_employeeid(emform.getEmployeeid());
		empListvo.set_se_model("3");
		empListvo.set_ne_state("0");
		DataPackage empDp = empDelegate.doQuery(empListvo, user);
		if(empDp.getDatas() != null && empDp.getDatas().size() != 0){
			emform.setIsunpb(true);
		}else{
			emform.setIsunpb(false);
		}
		request.setAttribute("/cms/zjty/ZjtyEmployeedetailForm", emform);
		return actionMapping.findForward("content");

	}
}
