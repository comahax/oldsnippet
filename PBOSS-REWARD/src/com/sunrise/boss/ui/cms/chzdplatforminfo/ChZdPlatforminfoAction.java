/**
* auto-generated code
* Sat May 11 16:40:18 CST 2013
*/
package com.sunrise.boss.ui.cms.chzdplatforminfo;

import com.sunrise.boss.business.cms.chzdplatforminfo.persistent.ChZdPlatforminfoVO;
import com.sunrise.boss.ui.base.BaseAction;

/**
 * <p>Title: ChZdPlatforminfoAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Qiu Zhi
 * @version 1.0
 */
public class ChZdPlatforminfoAction extends BaseAction {
    public ChZdPlatforminfoAction() {
            setVoClass(ChZdPlatforminfoVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[4]; 
           pkNameArray[0] = "batchno"; 
           pkNameArray[1] = "productid"; 
           pkNameArray[2] = "producttype"; 
           pkNameArray[3] = "zd_platform"; 
    }
}
