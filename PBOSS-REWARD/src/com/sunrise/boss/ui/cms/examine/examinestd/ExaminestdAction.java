/**
* auto-generated code
* Tue Nov 17 16:06:35 CST 2009
*/
package com.sunrise.boss.ui.cms.examine.examinestd;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.examine.examinestd.persistent.ExaminestdListVO;
import com.sunrise.boss.business.cms.examine.examinestd.persistent.ExaminestdVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.cms.examine.examinestd.ExaminestdDelegate;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.cms.examine.Examine;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: ExaminestdAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ExaminestdAction extends BaseDelegateAction {
    public ExaminestdAction() {
            setVoClass(ExaminestdVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "exmnstdid"; 
    }
	/**
	 * AJAX验证页面输入的系统考核逻辑合法性
	 */
    public ActionForward doValidatesyslogic(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
    	PrintWriter writer  = null;
		try{
			writer = response.getWriter();
			ExaminestdDelegate delegate=new ExaminestdDelegate();
			String syslogic=request.getParameter("syslogic");
			//
			if("SQL".equals(syslogic.substring(0, 3))){
				String sql=syslogic.substring(4,syslogic.length());
				sql=sql.replaceAll("@STARTTIME@", "20090101000000");
				sql=sql.replaceAll("@ENDTIME@", "20090102000000");
				//sql=sql.replaceAll("@QTFKNPARAM@", "1");
				int count=delegate.doValidateSQL(sql,user);
				/*if(count>0){
					writer.write("YES");
					return null;
				}else{
					writer.write("NOone");
				}*/
				writer.write("YES");
			}
			if("PGM".equals(syslogic.substring(0, 3))){
				String className=syslogic.substring(4,syslogic.length());
				Examine examine = (Examine)Class.forName(className).newInstance();
				writer.write("YES");
				return null;
			}
			writer.write("NO");
		}catch(Exception e){
			writer.write("NO");
			//e.printStackTrace();
			
		}
    	return null;
    }
    public ActionForward doExaminestdlist(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		ExaminestdDelegate delegate = new ExaminestdDelegate();
		Page.setPageSize(request, (ExaminestdForm) actionForm);
		ExaminestdListVO listVO = (ExaminestdListVO)getListVO(); 
		setListVO(listVO, actionForm); 
		DataPackage pack =delegate.doQueryExaminestdList(((ExaminestdForm) actionForm).getExmnid(),listVO, user);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, pack);
		return (actionMapping.findForward("listForItemgraded"));
    }
    
}
