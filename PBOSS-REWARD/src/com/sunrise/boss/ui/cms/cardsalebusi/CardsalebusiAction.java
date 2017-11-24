/**
* auto-generated code
* Fri Aug 03 11:10:45 CST 2007
*/
package com.sunrise.boss.ui.cms.cardsalebusi;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.ui.base.*;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.cardsalebusi.persistent.CardsalebusiListVO;
import com.sunrise.boss.business.cms.cardsalebusi.persistent.CardsalebusiVO;
import com.sunrise.boss.delegate.cms.cardsalebusi.CardsalebusiDelegate;

/**
 * <p>Title: CardsalebusiAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class CardsalebusiAction extends BaseDelegateAction {
    public CardsalebusiAction() {
           //以下几个方法是必须的 
           //指定VO类 
            setVoClass(CardsalebusiVO.class);
            //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称 
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "itemid"; 
    }
    public ActionForward doImport(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		return actionMapping.findForward("batch");
	}
}
