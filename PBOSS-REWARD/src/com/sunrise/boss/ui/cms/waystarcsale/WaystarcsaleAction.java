/**
* auto-generated code
* Wed Feb 24 11:50:56 CST 2010
*/
package com.sunrise.boss.ui.cms.waystarcsale;

import com.sunrise.boss.business.cms.waystarcsale.persistent.WaystarcsaleVO;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.base.BaseDelegateAction;

/**
 * <p>Title: WaystarcsaleAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Canigar
 * @version 1.0
 */
public class WaystarcsaleAction extends BaseDelegateAction {
    public WaystarcsaleAction() {
            setVoClass(WaystarcsaleVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[2]; 
           pkNameArray[0] = "cityid"; 
           pkNameArray[1] = "slv"; 
    }
}
