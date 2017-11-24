/**
* auto-generated code
* Tue Sep 18 15:04:18 CST 2012
*/
package com.sunrise.boss.ui.kdkhzld.chpwbroadlistlog;

import com.sunrise.boss.business.kdkhzld.chpwbroadlistlog.persistent.ChPwBroadlistlogVO;
import com.sunrise.boss.ui.base.BaseAction;

/**
 * <p>Title: ChPwBroadlistlogAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxx
 * @version 1.0
 */
public class ChPwBroadlistlogAction extends BaseAction {
    public ChPwBroadlistlogAction() {
            setVoClass(ChPwBroadlistlogVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "logid"; 
    }
}
