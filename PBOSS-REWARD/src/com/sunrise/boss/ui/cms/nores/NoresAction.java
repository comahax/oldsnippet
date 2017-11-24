/**
* auto-generated code
* Wed Nov 16 16:25:57 CST 2011
*/
package com.sunrise.boss.ui.cms.nores;

import com.sunrise.boss.business.cms.nores.persistent.NoresVO;
import com.sunrise.boss.ui.base.BaseAction;

/**
 * <p>Title: NoresAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class NoresAction extends BaseAction {
    public NoresAction() {
            setVoClass(NoresVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "mobileno"; 
    }
}
