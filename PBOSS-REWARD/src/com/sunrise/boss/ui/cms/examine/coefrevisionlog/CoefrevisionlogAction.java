/**
* auto-generated code
* Sun Nov 29 14:17:13 CST 2009
*/
package com.sunrise.boss.ui.cms.examine.coefrevisionlog;

import com.sunrise.boss.business.cms.examine.coefrevisionlog.persistent.CoefrevisionlogVO;
import com.sunrise.boss.ui.base.BaseAction;

/**
 * <p>Title: CoefrevisionlogAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class CoefrevisionlogAction extends BaseAction {
    public CoefrevisionlogAction() {
            setVoClass(CoefrevisionlogVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "logid"; 
    }
}
