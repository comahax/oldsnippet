/**
 * auto-generated code
 * Sun Aug 01 10:50:04 CST 2010
 */
package com.sunrise.boss.ui.cms.bbc.bbcwaylevel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.bbc.bbcwaylevel.persistent.BbcWaylevelVO;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: BbcWaylevelAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: SUNRISE Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class BbcWaylevelAction extends BaseDelegateAction {
	public BbcWaylevelAction() {
		//以下几个方法是必须的 
		//指定VO类 
		setVoClass(BbcWaylevelVO.class);
		//指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称 
		this.pkNameArray = new String[1];
		pkNameArray[0] = "wayid";
	}

	public ActionForward doExcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		// TODO Auto-generated method stub
		CommonExportBean export = new CommonExportBean(user);
		export.setFileName("代理商层级信息导出");
		export.addOutputProperty("wayid");
		export.addOutputProperty("waylevel",CommonExportBean.CODE2NAME,
				"$CH_BBCUNPBLEVEL");
		export.addOutputProperty("chagtime",CommonExportBean.DATE,
				"yyyy-MM-dd HH:mm:ss");
		export.voClassArray = new Class[] { BbcWaylevelVO.class };
		response.setHeader("pragma", "no-cache");
		response.setHeader("Cache-control", "public");
		response.setHeader("Expires", "01 Apr 1995 01:10:10 GMT");
		String fn = "attachment; filename=" + export.getFileName() + ".txt";
		response.setHeader("Content-Disposition", new String(
				fn.getBytes("GBK"), "ISO-8859-1"));
		response.setContentType("text/plain");
		export.writeTxtTitle(response.getOutputStream(), new String[] { "代理商编码",
				"层级", "变更时间"});
		super.ExportQuery(actionMapping, actionForm, request, response, user,
				export);
		return actionMapping.findForward(null);
	}
}