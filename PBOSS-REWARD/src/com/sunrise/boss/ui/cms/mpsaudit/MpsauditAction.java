/**
* auto-generated code
* Thu Oct 09 16:10:24 CST 2008
*/
package com.sunrise.boss.ui.cms.mpsaudit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.ui.base.*;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.iodaudit.persistent.IodauditVO;
import com.sunrise.boss.business.cms.mpsaudit.persistent.MpsauditListVO;
import com.sunrise.boss.business.cms.mpsaudit.persistent.MpsauditVO;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.cms.mpsaudit.MpsauditDelegate;

/**
 * <p>Title: MpsauditAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public class MpsauditAction extends BaseDelegateAction {
    public MpsauditAction() {
           //以下几个方法是必须的 
           //指定VO类 
            setVoClass(MpsauditVO.class);
            //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称 
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "adtdate"; 
    }
    
    public ActionForward doExcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		CommonExportBean export = new CommonExportBean(user);
		export.setFileName("采集平台短信稽核查询");
		export.addOutputProperty("adtdate");
		export.addOutputProperty("iodnum");
		export.addOutputProperty("mpsnum");
		export.addOutputProperty("mpsvalid");
		export.addOutputProperty("percent");
		export.addOutputProperty("successFlag",CommonExportBean.CODE2NAME, "#SUCCESSFLAG");

		export.voClassArray = new Class[] { MpsauditVO.class };
		
		response.setCharacterEncoding("GBK");
		response.setHeader("pragma", "no-cache");
		response.setHeader("Cache-control", "public");
		response.setHeader("Expires", "01 Apr 1995 01:10:10 GMT");
		String fn = "attachment; filename=" + export.getFileName() + ".txt";
		response.setHeader("Content-Disposition", new String(
				fn.getBytes("GBK"), "ISO-8859-1"));
		response.setContentType("text/plain;charset=gbk");
		export.writeTxtTitle(response.getOutputStream(), new String[] {
				"日期", "IOD有效套卡数", "采集平台有效套卡数", "采集平台成功匹配iod数", "匹配成功率", "是否通过"});
		super.ExportQuery(actionMapping, actionForm, request, response, user,
				export);
		return actionMapping.findForward(null);
	}
}
