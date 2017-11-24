/**
* auto-generated code
* Mon Jan 04 11:40:46 CST 2010
*/
package com.sunrise.boss.ui.cms.reward.busitosmp;

import com.sunrise.boss.business.cms.reward.busitosmp.persistent.BusitosmpVO;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.base.BaseDelegateAction;

/**
 * <p>Title: BusitosmpAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Canigar
 * @version 1.0
 */
public class BusitosmpAction extends BaseDelegateAction {
    public BusitosmpAction() {
            setVoClass(BusitosmpVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[4]; 
           pkNameArray[0] = "cityid"; 
           pkNameArray[1] = "comclassid"; 
           pkNameArray[2] = "comprice"; 
           pkNameArray[3] = "opnid"; 
    }
}
