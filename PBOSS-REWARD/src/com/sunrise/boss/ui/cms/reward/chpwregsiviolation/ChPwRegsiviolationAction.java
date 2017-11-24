/**
* auto-generated code
* Fri Oct 18 14:59:15 CST 2013
*/
package com.sunrise.boss.ui.cms.reward.chpwregsiviolation;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.sunrise.boss.business.cms.reward.chpwregsiviolation.persistent.ChPwRegsiviolationVO;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: ChPwRegsiviolationAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public class ChPwRegsiviolationAction extends BaseDelegateAction {
    public ChPwRegsiviolationAction() {
            setVoClass(ChPwRegsiviolationVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[2];
           pkNameArray[0] = "mobile";
           pkNameArray[1] = "vmonth";
    }

	/**
	 * 导出套卡真实身份信息违规登记
	 */
	public ActionForward doExcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("套卡真实身份信息违规登记");
		export.appendHeadLine(new String[] { "导出工号:", user.getOpercode() });
		export.appendHeadLine(new String[] { "导出时间:", format.format(new Date()) });
		export.addOutputProperty("mobile", "号码");
		export.addOutputProperty("vmonth", "违规月份");
		export.addOutputProperty("remark", "备注");
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		export.voClassArray = new Class[] {voClass};
		export.queryMethodName = "doList";
		if (export.headtitle == null) {
			export.headtitle = export.getFileName();
		}
		export.buildExcelPage(actionMapping, actionForm, request, response, user, this);
    	return null;
	}
}
