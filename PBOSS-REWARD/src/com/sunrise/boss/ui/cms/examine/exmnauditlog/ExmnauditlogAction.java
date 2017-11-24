/**
* auto-generated code
* Sat Nov 28 17:58:40 CST 2009
*/
package com.sunrise.boss.ui.cms.examine.exmnauditlog;

import com.sunrise.boss.business.cms.examine.exmnauditlog.persistent.ExmnauditlogVO;
import com.sunrise.boss.ui.base.BaseAction;

/**
 * <p>Title: ExmnauditlogAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ExmnauditlogAction extends BaseAction {
    public ExmnauditlogAction() {
            setVoClass(ExmnauditlogVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "logid"; 
    }
}
