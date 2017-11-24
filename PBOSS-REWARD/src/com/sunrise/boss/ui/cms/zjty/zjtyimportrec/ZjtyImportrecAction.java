/**
* auto-generated code
* Mon Mar 05 15:38:35 CST 2012
*/
package com.sunrise.boss.ui.cms.zjty.zjtyimportrec;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.zjty.zjtyimportrec.persistent.ZjtyImportrecVO;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: ZjtyImportrecAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author qiuzhi
 * @version 1.0
 */
public class ZjtyImportrecAction extends BaseAction {
    public ZjtyImportrecAction() {
            setVoClass(ZjtyImportrecVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "seq"; 
    }
    
    public ActionForward doImport(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		return actionMapping.findForward("batch");
	}
}
