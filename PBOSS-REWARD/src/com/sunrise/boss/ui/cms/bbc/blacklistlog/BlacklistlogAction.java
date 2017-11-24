/**
* auto-generated code
* Wed Dec 07 09:31:25 CST 2011
*/
package com.sunrise.boss.ui.cms.bbc.blacklistlog;

import com.sunrise.boss.business.cms.bbc.blacklistlog.persistent.BlacklistlogVO;
import com.sunrise.boss.ui.base.BaseAction;

/**
 * <p>Title: BlacklistlogAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class BlacklistlogAction extends BaseAction {
    public BlacklistlogAction() {
            setVoClass(BlacklistlogVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "logid"; 
    }
}
