/**
* auto-generated code
* Tue Jan 12 09:53:03 CST 2010
*/
package com.sunrise.boss.ui.cms.zjty.zjtybusyxplanlog;

import com.sunrise.boss.business.cms.zjty.zjtybusyxplanlog.persistent.ZjtyBusyxplanlogVO;
import com.sunrise.boss.ui.base.BaseAction;

/**
 * <p>Title: ZjtyBusyxplanlogAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class ZjtyBusyxplanlogAction extends BaseAction {
    public ZjtyBusyxplanlogAction() {
            setVoClass(ZjtyBusyxplanlogVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "logid"; 
    }
}
