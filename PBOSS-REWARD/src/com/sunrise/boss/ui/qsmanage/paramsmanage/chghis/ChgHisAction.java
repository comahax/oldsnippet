/**
* auto-generated code
* Fri Jul 11 10:06:27 CST 2008
*/
package com.sunrise.boss.ui.qsmanage.paramsmanage.chghis;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.fee.qsmanage.common.utils.QsUtils;
import com.sunrise.boss.business.qsmanage.paramrules.tabdefine.persistent.TabDefineVO;
import com.sunrise.boss.business.qsmanage.paramsmanage.chghis.persistent.ChgHisVO;
import com.sunrise.boss.common.utils.export.ExcelCodeToName;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.pub.tools.StringSplit;

/**
 * <p>Title: ChgHisAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ChgHisAction extends BaseAction {
    public ChgHisAction() {
        this.voClass = ChgHisVO.class;
        // TODO: 给出主键的名字数组
        this.pkNameArray=new String[]{"reqid"};
    }
    
    public ActionForward doShowdeta(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		Page.setPageSize(request, (BaseActionForm) actionForm);
		
		Long logid = new Long(request.getParameter("logid"));
		CommonDelegate delegate = new CommonDelegate(voClass);
		ChgHisVO vo = (ChgHisVO) delegate.doFindByPk(logid, user);
		List list = QsUtils.getDetaList(vo, user);
		request.setAttribute("tabname", vo.getTabname());
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, list);
		return (actionMapping.findForward("listdeta"));
	}
}
