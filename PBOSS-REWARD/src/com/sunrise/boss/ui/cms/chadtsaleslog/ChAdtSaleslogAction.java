/**
* auto-generated code
* Mon Jan 14 11:41:04 CST 2013
*/
package com.sunrise.boss.ui.cms.chadtsaleslog;

import com.sunrise.boss.business.cms.chadtsaleslog.persistent.ChAdtSaleslogVO;
import com.sunrise.boss.ui.base.BaseAction;

/**
 * <p>Title: ChAdtSaleslogAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author limin
 * @version 1.0
 */
public class ChAdtSaleslogAction extends BaseAction {
    public ChAdtSaleslogAction() {
            setVoClass(ChAdtSaleslogVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "logid"; 
    }
}
