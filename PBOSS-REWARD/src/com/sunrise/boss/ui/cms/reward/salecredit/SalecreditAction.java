/**
* auto-generated code
* Tue May 17 15:57:34 CST 2011
*/
package com.sunrise.boss.ui.cms.reward.salecredit;

import com.sunrise.boss.business.cms.reward.salecredit.persistent.SalecreditVO;
import com.sunrise.boss.ui.base.BaseAction;

/**
 * <p>Title: SalecreditAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
public class SalecreditAction extends BaseAction {
    public SalecreditAction() {
            setVoClass(SalecreditVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "seq"; 
    }
}
