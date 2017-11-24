/**
* auto-generated code
* Fri Feb 13 16:59:53 CST 2009
*/
package com.sunrise.boss.ui.cms.zjty.chzjtyoprtcost;

import com.sunrise.boss.business.cms.zjty.chzjtyoprtcost.persistent.ChZjtyOprtcostVO;
import com.sunrise.boss.ui.base.BaseDelegateAction;

/**
 * <p>Title: ChZjtyOprtcostAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wanghua
 * @version 1.0
 */
public class ChZjtyOprtcostAction extends BaseDelegateAction {
    public ChZjtyOprtcostAction() {
            setVoClass(ChZjtyOprtcostVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[2]; 
           pkNameArray[0] = "citylevel"; 
           pkNameArray[1] = "ctype"; 
    }
}
