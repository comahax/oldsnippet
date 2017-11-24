/**
* auto-generated code
* Sat Feb 02 15:15:28 CST 2008
*/
package com.sunrise.boss.ui.cms.reward.busyxplanlog;

import com.sunrise.boss.ui.base.*;
import com.sunrise.boss.business.cms.reward.busyxplanlog.persistent.BusyxplanlogListVO;
import com.sunrise.boss.business.cms.reward.busyxplanlog.persistent.BusyxplanlogVO;
import com.sunrise.boss.delegate.cms.reward.busyxplanlog.BusyxplanlogDelegate;

/**
 * <p>Title: BusyxplanlogAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class BusyxplanlogAction extends BaseDelegateAction {
    public BusyxplanlogAction() {
           //以下几个方法是必须的 
           //指定VO类 
            setVoClass(BusyxplanlogVO.class);
            //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称 
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "logid"; 
    }
}
