/**
* auto-generated code
* Wed Nov 25 11:17:17 CST 2009
*/
package com.sunrise.boss.ui.cms.examine.exmnitemdtllog;

import com.sunrise.boss.business.cms.examine.exmnitemdtllog.persistent.ExmnitemdtllogVO;
import com.sunrise.boss.ui.base.BaseAction;

/**
 * <p>Title: ExmnitemdtllogAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ExmnitemdtllogAction extends BaseAction {
    public ExmnitemdtllogAction() {
            setVoClass(ExmnitemdtllogVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "logid"; 
    }
}
