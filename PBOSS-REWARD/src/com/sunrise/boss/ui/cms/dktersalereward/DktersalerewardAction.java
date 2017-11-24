/**
* auto-generated code
* Fri May 03 16:45:00 CST 2013
*/
package com.sunrise.boss.ui.cms.dktersalereward;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.sunrise.boss.business.cms.dktersalereward.persistent.DktersalerewardListVO;
import com.sunrise.boss.business.cms.dktersalereward.persistent.DktersalerewardVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.cms.dktersalereward.DktersalerewardDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: DktersalerewardAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public class DktersalerewardAction extends BaseAction {
    public DktersalerewardAction() {
            setVoClass(DktersalerewardVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "recid"; 
    }

    /**
	 * 代客下单终端销售酬金明细
	 */
	@Override
	protected ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		DktersalerewardForm form = (DktersalerewardForm) actionForm;
		if (form.isQuery()) {
			form.set_ne_cityid(user.getCityid());
			DktersalerewardListVO listVO = new DktersalerewardListVO();
			BeanUtils.copyProperties(listVO, form);
			DktersalerewardDelegate delegate = new DktersalerewardDelegate();
			DataPackage dp = delegate.doQuery(listVO, user);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		}
    	return actionMapping.findForward("list");
	}

	/**
	 * 代客下单终端销售酬金明细查询导出
	 */
	public ActionForward doExcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("代客下单终端销售酬金明细");
		export.appendHeadLine(new String[] { "导出工号:", user.getOpercode() });
		export.appendHeadLine(new String[] { "导出时间:", format.format(new Date()) });
		export.addOutputProperty("ecpoperator", "ECP工号");
		export.addOutputProperty("wayname", "网点名称");
		export.addOutputProperty("salesuc", "销售成功量(T-1销售)");
		export.addOutputProperty("examinesuc", "考核成功量(T-4销售)");
		export.addOutputProperty("foundreward", "基础酬金");
		export.addOutputProperty("examinereward", "考核酬金");
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		export.voClassArray = new Class[] {voClass};
		export.queryMethodName = "doList";
		if (export.headtitle == null) {
			export.headtitle = export.getFileName();
		}
		export.buildExcelPage(actionMapping, actionForm, request, response, user, this);
    	return null;
	}

	/**
	 * 代客下单终端销售酬金统计
	 */
	public ActionForward doRewardtotal(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		DktersalerewardForm form = (DktersalerewardForm) actionForm;
		if (form.isQuery()) {
			DktersalerewardListVO listVO = new DktersalerewardListVO();
			BeanUtils.copyProperties(listVO, form);
			DktersalerewardDelegate delegate = new DktersalerewardDelegate();
			DataPackage dp = delegate.doQueryRewardTotal(listVO, user);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		}
		return actionMapping.findForward("rewardtotal");
	}

	/**
	 * 代客下单终端销售酬金统计查询导出
	 */
	public ActionForward doExcelrewardtotal(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("代客下单终端销售酬金统计");
		export.appendHeadLine(new String[] { "导出工号:", user.getOpercode() });
		export.appendHeadLine(new String[] { "导出时间:", format.format(new Date()) });
		export.addOutputProperty("cityid", "地市", CommonExportBean.CODE2NAME, "#CITYCOMPANY_AREA");
		export.addOutputProperty("salesuc", "销售成功量(T-1销售)");
		export.addOutputProperty("examinesuc", "考核成功量(T-4销售)");
		export.addOutputProperty("foundreward", "基础酬金");
		export.addOutputProperty("examinereward", "考核酬金");
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		export.voClassArray = new Class[] {voClass};
		export.queryMethodName = "doRewardtotal";
		if (export.headtitle == null) {
			export.headtitle = export.getFileName();
		}
		export.buildExcelPage(actionMapping, actionForm, request, response, user, this);
    	return null;
	}

	public ActionForward doImport(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		return actionMapping.findForward("import");
	}
}
