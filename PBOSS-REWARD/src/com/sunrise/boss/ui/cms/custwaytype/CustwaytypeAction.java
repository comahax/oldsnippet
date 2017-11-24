/**
* auto-generated code
* Fri Aug 25 11:25:35 CST 2006
*/
package com.sunrise.boss.ui.cms.custwaytype;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.ui.base.*;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.business.cms.custwaytype.persistent.CustwaytypeVO;

/**
 * <p>Title: CustwaytypeAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author yjr
 * @version 1.0
 */
public class CustwaytypeAction extends BaseDelegateAction {
    public CustwaytypeAction() {
           //以下几个方法是必须的 
           //指定VO类 
            setVoClass(CustwaytypeVO.class);
            //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称 
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "custwaytypecode"; 
    }
    
	public void onDuplicatePk(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) {
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
				"相同编码的分公司自定义类别已经存在, 请输入其他编码");

	}
}
